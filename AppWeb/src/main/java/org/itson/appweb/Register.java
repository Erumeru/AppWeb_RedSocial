/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package org.itson.appweb;

import Clases.*;
import ObjNegocio.Admor;
import ObjNegocio.Normal;
import ObjNegocio.Usuario;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
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
        String telefono = request.getParameter("telephone");
        String ciudad = request.getParameter("ciudad");
        String tipo = request.getParameter("tipo");
        String sexo = request.getParameter("sexo");

//        String avatar = request.getParameter("avatar");
//        String 
        //preguntar kim
        if (email == null
                || email.isBlank()
                || email.trim().length() > 50
                || nombre == null
                || nombre.isBlank()
                || nombre.trim().length() > 50
                || contra == null
                || contra.isBlank()
                || contra.trim().length() > 100
                || contraConfirmacion == null
                || contraConfirmacion.isBlank()
                || contraConfirmacion.trim().length() > 100
                || fechaNacimiento == null
                || fechaNacimiento.isBlank()
                || fechaNacimiento.trim().length() > 10
                || sexo.isBlank()
                || sexo==null) {
            String mensaje = "Lo sentimos, no puedes dejar espacios en blanco ):";
            request.setAttribute("mensaje", mensaje);
            request.getRequestDispatcher("/register.jsp").forward(request, response);
            return;
        }
        if (!contraConfirmacion.equals(contra)) {
            String mensaje = "Asegurate de que las contraseñas coincidan.";
            request.setAttribute("mensaje", mensaje);
            request.getRequestDispatcher("/register.jsp").forward(request, response);
        }
        
        //Objeto usuario
        ILogica registerNegocio = FabricaLogica.crearInstancia();

        String pattern = "yyyy-MM-dd";
        SimpleDateFormat pasar = new SimpleDateFormat(pattern);
        Date date = null;
        LocalDate fechaActualLocal = LocalDate.now();
        //Validaciones fecha
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fechaNacimientoTrans = LocalDate.parse(fechaNacimiento, formatter);
        
        if(fechaNacimientoTrans.isAfter(fechaActualLocal)){
            String mensaje = "Esa fecha aún no existe!";
            request.setAttribute("mensaje", mensaje);
            request.getRequestDispatcher("/register.jsp").forward(request, response);
            return;
        }
        
        Period periodo = Period.between(fechaNacimientoTrans, fechaActualLocal);
        int edad = periodo.getYears();
        
        if(edad < 18){
            String mensaje = "Lo sentimos, no tiene edad adecuada para una cuenta ):";
            request.setAttribute("mensaje", mensaje);
            request.getRequestDispatcher("/register.jsp").forward(request, response);
            return;
        }
        
        
        try {
            date = pasar.parse(fechaNacimiento);
        } catch (ParseException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (tipo != null && tipo.equalsIgnoreCase("true")) {
            try {
                Admor admin = new Admor();
                admin.setCorreo(email);
                admin.setNombreCompleto(nombre);
                admin.setContrasenia(contra);
                admin.setTelefono(telefono);
                admin.setCiudad(ciudad);
                admin.setFechaNacimiento(date);
                admin.setGenero(sexo);
                Admor usuarioCreado = registerNegocio.guardarAdmor(admin);
                request.getSession().setAttribute("id", usuarioCreado.getId().toString());
                request.getSession().setAttribute("tipo", "admin");
                getServletContext().getRequestDispatcher("/prueba.jsp")
                        .forward(request, response);
            } catch (Exception ex) {
                request.setAttribute("error", "Ha ocurrido un error al registrar usuario 🤣");
                getServletContext().getRequestDispatcher("/errorExterno.jsp")
                        .forward(request, response);
                return;
            }
            return;
        }
        try {
            Normal normalUser = new Normal();
            normalUser.setCorreo(email);
            normalUser.setNombreCompleto(nombre);
            normalUser.setContrasenia(contra);
            normalUser.setTelefono(telefono);
            normalUser.setCiudad(ciudad);
            normalUser.setFechaNacimiento(date);
            normalUser.setGenero(sexo);
            Normal usuarioCreado = registerNegocio.guardarNormal(normalUser);
            request.getSession().setAttribute("id", usuarioCreado.getId().toString());
            request.getSession().setAttribute("tipo", "normal");

            getServletContext().getRequestDispatcher("/prueba.jsp")
                    .forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("error", ex.getMessage());
            getServletContext().getRequestDispatcher("/errorExterno.jsp")
                    .forward(request, response);
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
