/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package org.itson.appweb;

import Clases.*;
import ObjNegocio.Usuario;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author hoshi
 */
@MultipartConfig
@WebServlet(name = "Register", urlPatterns = {"/Register"})
public class Register extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Register</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Register at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        if (action != null && action.equalsIgnoreCase("register")) {
            request.setAttribute("avatar", processUpload(request, response));
            proccessCreate(request, response);
            return;
        }
    }

    private void proccessCreate(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("mail-phone");
        String nombre = request.getParameter("user-name");
        String contra = request.getParameter("password");
        String contraConfirmacion = request.getParameter("password-confirmation");
        String fechaNacimiento = request.getParameter("birthdate");
//        String telefono = request.getParameter("telephone");
//        String avatar = request.getParameter("avatar");
//        String 

        if (email == null
                || email.isBlank()
                || nombre == null
                || nombre.isBlank()
                || contra == null
                || contra.isBlank()
                || contraConfirmacion == null
                || contraConfirmacion.isBlank()
                || fechaNacimiento == null) {
            // regresamos a las paginas
            getServletContext().getRequestDispatcher("/register.jsp").forward(request, response);
            return;
        }
        //Objeto usuario
        ILogica registerNegocio = FabricaLogica.crearInstancia();
        Usuario usuario = new Usuario();
        usuario.setCorreo(email);
        usuario.setNombreCompleto(nombre);
        usuario.setContrasenia(contra);
        usuario.setTelefono("7777777");
        usuario.setCiudad("obregones");
        usuario.setAvatar(request.getParameter("avatar"));
        try {
            Usuario usuarioCreado = registerNegocio.guardarUsuario(usuario);
            request.setAttribute("usuario", usuarioCreado);
            getServletContext().getRequestDispatcher("/login.jsp")
                    .forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("error", ex.getMessage());
            getServletContext().getRequestDispatcher("/errorExterno.jsp")
                    .forward(request, response);
            return;
        }
    }

    private String processUpload(HttpServletRequest request, HttpServletResponse response) throws IOException {
        boolean isMultiPart = ServletFileUpload.isMultipartContent(request);
        if (isMultiPart) {
            ServletFileUpload upload = new ServletFileUpload();
            try {
                FileItemIterator itr = upload.getItemIterator(request);
                while (itr.hasNext()) {
                    FileItemStream item = itr.next();
                    if (item.isFormField()) {
                        String fieldName = item.getFieldName();
                        InputStream is = item.openStream();
                        byte[] b = new byte[is.available()];
                        is.read(b);
                        String value = new String(b);
                        response.getWriter().println(fieldName + ":" + value + "<br/>");
                    } else {
                        String path = getServletContext().getRealPath("/");
                        return path;
                    }
                }
            } catch (FileUploadException ex) {
                ex.printStackTrace();
            }
        }
        return null;
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
