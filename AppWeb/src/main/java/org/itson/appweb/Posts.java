/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package org.itson.appweb;

import Clases.FabricaLogica;
import Clases.ILogica;
import ObjNegocio.Admor;
import ObjNegocio.Anclado;
import ObjNegocio.Comentario;
import ObjNegocio.Comun;
import ObjNegocio.Normal;
import com.google.gson.Gson;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;
import org.bson.types.ObjectId;
import org.itson.appweb.dtos.ComentariosDTO;
import org.itson.appweb.dtos.ComunDTO;
import org.itson.appweb.dtos.ComunEliminarDTO;

/**
 *
 * @author hoshi
 */
@WebServlet(name = "Posts", urlPatterns = {"/Posts"})
public class Posts extends HttpServlet {

    private void proccessEliminarComun(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        String datosTextoJSON = IOUtils.toString(request.getInputStream(), "utf-8");
        Gson serializadorJSON = new Gson();
        String parametroId = request.getParameter("id");

        //CREAR COMENTARIODTO
        ComunEliminarDTO comentarioDTO = serializadorJSON.fromJson(datosTextoJSON, ComunEliminarDTO.class);

        ILogica EliminarComun = FabricaLogica.crearInstancia();
        Comun comunNuevo = new Comun();
        comunNuevo.setIdComun(new ObjectId(comentarioDTO.getId()));
        EliminarComun.eliminarComun(comunNuevo);
        response.setContentType(
                "application/json;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            String salida = serializadorJSON.toJson(comunNuevo);
            out.println(salida);
            out.flush();
        }
    }

    private void proccessEliminarAnclado(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        String datosTextoJSON = IOUtils.toString(request.getInputStream(), "utf-8");
        Gson serializadorJSON = new Gson();
        String parametroId = request.getParameter("id");

        //CREAR COMENTARIODTO
        ComunEliminarDTO comentarioDTO = serializadorJSON.fromJson(datosTextoJSON, ComunEliminarDTO.class);

        ILogica EliminarComun = FabricaLogica.crearInstancia();
        Anclado ancladoNuevo = new Anclado();
        ancladoNuevo.setIdAnclado(new ObjectId(comentarioDTO.getId()));
        EliminarComun.eliminarAnclado(ancladoNuevo);
        response.setContentType(
                "application/json;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            String salida = serializadorJSON.toJson(ancladoNuevo);
            out.println(salida);
            out.flush();
        }
    }

    private void proccessSubirComun(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {

        //     String datosTextoJSON = IOUtils.toString(request.getInputStream(), "utf-8");
        Gson serializadorJSON = new Gson();
        ComunDTO comunDTO = new ComunDTO();
        comunDTO.setFechaHoraCreacion(new Date());
        comunDTO.setFechaHoraEdicion(new Date());

//        String fechaCreacion = request.getParameter("fechaHoraCreacion");
//        if (fechaCreacion != null) {
//            try {
//                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//                Date fechaHoraCreacion = sdf.parse(fechaCreacion);
//                comunDTO.setFechaHoraCreacion(fechaHoraCreacion);
//            } catch (ParseException ex) {
//                Logger.getLogger(Posts.class.getName()).log(Level.SEVERE, null, ex);
//            }
//    }
        //   comunDTO.setTitulo(request.getParameter("titulo"));
        ServletFileUpload fileUp = new ServletFileUpload();

        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload sfu = new ServletFileUpload(factory);

        String path = getServletContext().getRealPath("/");

        Path pathAbsoluto = Paths.get(path);
        Path rutaPadre = pathAbsoluto.getParent().getParent();
        String rutaFinal = rutaPadre.toString() + "\\src\\main\\webapp\\imgPost";

        ILogica SubirComun = FabricaLogica.crearInstancia();
        Comun comunNuevo = new Comun();

        comunNuevo.setFechaHoraCreacion(comunDTO.getFechaHoraCreacion());
        comunNuevo.setTitulo("default");

//        try ( FileOutputStream fos = new FileOutputStream("pathname")) {
//            fos.write(comunDTO.getContenido());
//            //fos.close(); There is no more need for this line since you had created the instance of "fos" inside the try. And this will automatically close the OutputStream
//        }
        comunNuevo.setContenido("default");

        HttpSession session = request.getSession();
        String tipoUsuario = session.getAttribute("tipo").toString();

        if (tipoUsuario.equalsIgnoreCase("normal")) {
            Normal usuarioNormal = regresarNormal(request, response);
            comunNuevo.setUsuario(usuarioNormal);
        } else {
            Admor usuarioAdmor = regresarAdmor(request, response);
            comunNuevo.setUsuario(usuarioAdmor);
        }

        comunNuevo = SubirComun.guardarComun(comunNuevo);

        String pathConId = comunNuevo.getContenido() + comunNuevo.getIdComun().toString() + ".png";
        comunNuevo.setContenido("imgPost/" + comunNuevo.getIdComun().toString() + ".png");

        try {
            List list = sfu.parseRequest(request);
            for (Object o : list) {
                FileItem item = (FileItem) o;
                if (!item.isFormField()) {
                    File file = new File(item.getName());
                    try {
                        String dirPath = "contenido";
                        String filePath = rutaFinal + File.separator + comunNuevo.getIdComun().toString() + ".png";
                        item.write(new File(filePath));
                    } catch (Exception e) {
                        throw e;
                        // e.printStackTrace();
                    }
                } else {
                    String fieldName = item.getFieldName();
                    String value = item.getString();
                    if (fieldName.equals("titulo")) {
                        comunDTO.setTitulo(value);
                    }
                }
            }
        } catch (FileUploadException e) {
            throw e;
            //  e.printStackTrace();
        }
        comunNuevo.setTitulo(comunDTO.getTitulo());
        SubirComun.actualizarComun(comunNuevo, comunNuevo);
//    String fechaEdicion = request.getParameter("fechaHoraEdicion");
//    if (fechaEdicion
//
//    
//        != null) {
//            try {
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//            Date fechaHoraEdicion = sdf.parse(fechaEdicion);
//            comunDTO.setFechaHoraEdicion(fechaHoraEdicion);
//        } catch (ParseException ex) {
//            Logger.getLogger(Posts.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
        //   ComunDTO comunDTO = serializadorJSON.fromJson(datosTextoJSON, ComunDTO.class);
        response.setContentType(
                "application/json;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            String salida = serializadorJSON.toJson(comunNuevo);
            out.println(salida);
            out.flush();
        }

        getServletContext()
                .getRequestDispatcher("/mainPublicaciones.jsp").forward(request, response);
    }

    private Normal regresarNormal(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Normal usuario = (Normal) session.getAttribute("usuario");
        return usuario;
    }

    private Admor regresarAdmor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Admor usuario = (Admor) session.getAttribute("usuario");
        return usuario;
    }

    private void proccessSubirComentario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //FLUJO DE DATOS (BYTES) A TEXTO FORMATO JSON
        String datosTextoJSON = IOUtils.toString(request.getInputStream(), "utf-8");
        Comun com = new Comun();
        Gson serializadorJSON = new Gson();

        //CREAR COMENTARIODTO
        ComentariosDTO comentarioDTO = serializadorJSON.fromJson(datosTextoJSON, ComentariosDTO.class
        );
        ILogica subirComentario = FabricaLogica.crearInstancia();
        Comentario comentarioNuevo = new Comentario();
        com.setIdComun(new ObjectId(comentarioDTO.getComun()));
        Comun comunPubli = subirComentario.buscarComun(com);
        comentarioNuevo.setFechaHora(comentarioDTO.getFechaHora());
        comentarioNuevo.setContenido(comentarioDTO.getContenido());
        comentarioNuevo.setComun(comunPubli);
        HttpSession session = request.getSession();
        String tipoUsuario = session.getAttribute("tipo").toString();

        if (tipoUsuario.equalsIgnoreCase("normal")) {
            Normal usuarioNormal = regresarNormal(request, response);
            comentarioNuevo.setNormal(usuarioNormal);
        } else {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }
        //Normal usuarioNormal = regresarNormal(request, response);

        comentarioNuevo = subirComentario.guardarComentario(comentarioNuevo);

        response.setContentType("application/json;charset=UTF-8");

        try ( PrintWriter out = response.getWriter()) {
            String salida = serializadorJSON.toJson(comentarioNuevo);
            out.println(salida);
            out.flush();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null && action.equalsIgnoreCase("subirAnclado")) {
            try {
                //proccessViewPosts(request, response);
                proccessSubirAnclado(request, response);
            } catch (Exception ex) {
                Logger.getLogger(Posts.class.getName()).log(Level.SEVERE, null, ex);
            }
            return;
        }
        if (action != null && action.equalsIgnoreCase("subirComun")) {
            try {
                //proccessViewPosts(request, response);
                proccessSubirComun(request, response);
            } catch (Exception ex) {
                Logger.getLogger(Posts.class.getName()).log(Level.SEVERE, null, ex);
            }
            return;
        }
        if (action != null && action.equalsIgnoreCase("subirComentario")) {
            //proccessViewPosts(request, response);
            proccessSubirComentario(request, response);
            return;
        }
        if (action != null && action.equalsIgnoreCase("eliminarComun")) {
            try {
                //proccessViewPosts(request, response);
                proccessEliminarComun(request, response);
                return;
            } catch (Exception ex) {
                //Logger.getLogger(Posts.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (action != null && action.equalsIgnoreCase("eliminarAnclado")) {
            try {
                //proccessViewPosts(request, response);
                proccessEliminarAnclado(request, response);
                return;
            } catch (Exception ex) {
                //Logger.getLogger(Posts.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void proccessSubirAnclado(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {

        //     String datosTextoJSON = IOUtils.toString(request.getInputStream(), "utf-8");
        Gson serializadorJSON = new Gson();
        ComunDTO comunDTO = new ComunDTO();
        comunDTO.setFechaHoraCreacion(new Date());
        comunDTO.setFechaHoraEdicion(new Date());

//        String fechaCreacion = request.getParameter("fechaHoraCreacion");
//        if (fechaCreacion != null) {
//            try {
//                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//                Date fechaHoraCreacion = sdf.parse(fechaCreacion);
//                comunDTO.setFechaHoraCreacion(fechaHoraCreacion);
//            } catch (ParseException ex) {
//                Logger.getLogger(Posts.class.getName()).log(Level.SEVERE, null, ex);
//            }
//    }
        //   comunDTO.setTitulo(request.getParameter("titulo"));
        ServletFileUpload fileUp = new ServletFileUpload();

        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload sfu = new ServletFileUpload(factory);

        String path = getServletContext().getRealPath("/");

        Path pathAbsoluto = Paths.get(path);
        Path rutaPadre = pathAbsoluto.getParent().getParent();
        String rutaFinal = rutaPadre.toString() + "\\src\\main\\webapp\\imgPost";

        ILogica SubirComun = FabricaLogica.crearInstancia();
        Anclado ancladoNuevo = new Anclado();

        ancladoNuevo.setFechaHoraCreacion(comunDTO.getFechaHoraCreacion());
        ancladoNuevo.setTitulo("default");

//        try ( FileOutputStream fos = new FileOutputStream("pathname")) {
//            fos.write(comunDTO.getContenido());
//            //fos.close(); There is no more need for this line since you had created the instance of "fos" inside the try. And this will automatically close the OutputStream
//        }
        ancladoNuevo.setContenido("default");

        Admor usuarioNormal = SubirComun.buscarAdmor(regresarAdmor(request, response));

        ancladoNuevo.setAdmor(SubirComun.buscarAdmor(regresarAdmor(request, response)));

        ancladoNuevo = SubirComun.guardarAnclado(ancladoNuevo);

        String pathConId = ancladoNuevo.getContenido() + ancladoNuevo.getIdAnclador().toString() + ".png";
        ancladoNuevo.setContenido("imgPost/" + ancladoNuevo.getIdAnclador().toString() + ".png");

        try {
            List list = sfu.parseRequest(request);
            for (Object o : list) {
                FileItem item = (FileItem) o;
                if (!item.isFormField()) {
                    File file = new File(item.getName());
                    try {
                        String dirPath = "contenido";
                        String filePath = rutaFinal + File.separator + ancladoNuevo.getIdAnclador().toString() + ".png";
                        item.write(new File(filePath));
                    } catch (Exception e) {
                        throw e;
                        // e.printStackTrace();
                    }
                } else {
                    String fieldName = item.getFieldName();
                    String value = item.getString();
                    if (fieldName.equals("titulo")) {
                        comunDTO.setTitulo(value);
                    }
                }
            }
        } catch (FileUploadException e) {
            throw e;
            //  e.printStackTrace();
        }
        ancladoNuevo.setTitulo(comunDTO.getTitulo());
        SubirComun.actualizarAnclado(ancladoNuevo, ancladoNuevo);
//    String fechaEdicion = request.getParameter("fechaHoraEdicion");
//    if (fechaEdicion
//
//    
//        != null) {
//            try {
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//            Date fechaHoraEdicion = sdf.parse(fechaEdicion);
//            comunDTO.setFechaHoraEdicion(fechaHoraEdicion);
//        } catch (ParseException ex) {
//            Logger.getLogger(Posts.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
        //   ComunDTO comunDTO = serializadorJSON.fromJson(datosTextoJSON, ComunDTO.class);
        response.setContentType(
                "application/json;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            String salida = serializadorJSON.toJson(ancladoNuevo);
            out.println(salida);
            out.flush();
        }

        getServletContext()
                .getRequestDispatcher("/mainPublicaciones.jsp").forward(request, response);
    }

}
