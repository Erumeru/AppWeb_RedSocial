/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package org.itson.appweb;

import Clases.FabricaLogica;
import Clases.ILogica;
import ObjNegocio.Comentario;
import ObjNegocio.Comun;
import ObjNegocio.Normal;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.io.IOUtils;
import org.bson.types.ObjectId;
import org.itson.appweb.dtos.ComentariosDTO;

/**
 *
 * @author hoshi
 */
@WebServlet(name = "Posts", urlPatterns = {"/Posts"})
public class Posts extends HttpServlet {

//    /**
//     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
//     * methods.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        try ( PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet Posts</title>");
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet Posts at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
//    }
//     private void proccessSubirPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//         
//         ILogica subirPost = FabricaLogica.crearInstancia();
//         Comun comun = new Comun();
//         subirPost.guardarComun(comun);
//         
//         getServletContext().getRequestDispatcher("/mainPublicaciones.jsp").forward(request, response);
//     }
    private Normal regresarNormal(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Normal usuario = (Normal) session.getAttribute("usuario");
        return usuario;
    }

    private void proccessSubirComentario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //FLUJO DE DATOS (BYTES) A TEXTO FORMATO JSON
        String datosTextoJSON = IOUtils.toString(request.getInputStream(), "utf-8");
        Comun com = new Comun();
        //  com.setIdComun(new ObjectId(request.getParameter("comun")));
        Gson serializadorJSON = new Gson();
        //CREAR COMENTARIODTO
        ComentariosDTO comentarioDTO = serializadorJSON.fromJson(datosTextoJSON, ComentariosDTO.class);
        ILogica subirComentario = FabricaLogica.crearInstancia();
        Comentario comentarioNuevo = new Comentario();
        com.setIdComun(new ObjectId(comentarioDTO.getComun()));
        Comun comunPubli = subirComentario.buscarComun(com);
        
        comentarioNuevo.setFechaHora(comentarioDTO.getFechaHora());
        comentarioNuevo.setContenido(comentarioDTO.getContenido());
        comentarioNuevo.setComun(comunPubli);
        // comentarioNuevo.setNormal(comentarioDTO.getNormal());
        // Comentario comentario = new Comentario();
        Normal usuarioNormal = regresarNormal(request, response);
        comentarioNuevo.setNormal(usuarioNormal);
        //comentarioNuevo.setComentarios(new ArrayList<Comentario>());
        //comentarioNuevo.setComentario(new Comentario());
        comentarioNuevo = subirComentario.guardarComentario(comentarioNuevo);

        response.setContentType("application/json;charset=UTF-8");

        try ( PrintWriter out = response.getWriter()) {
            String salida = serializadorJSON.toJson(comentarioNuevo);
            out.println(salida);
            out.flush();
        }
        //CREACION COMENTARIO

//         comentarioNuevo.setNormal(comentarioDTO.getNormal());
//         comentarioNuevo.setComun(comentarioDTO.getComun());
//         comentarioNuevo.setComentario(comentarioDTO.getComentario());
//         comentarioNuevo.setComentarios(comentarioDTO.getComentarios());
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
//        if (action != null && action.equalsIgnoreCase("subirPost")) {
//            //proccessViewPosts(request, response);
//            proccessSubirPost(request, response);
//            return;
//        }
        if (action != null && action.equalsIgnoreCase("subirComentario")) {
            //proccessViewPosts(request, response);
            proccessSubirComentario(request, response);
            return;
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

}
