/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package org.itson.appweb;

import Clases.*;
import ObjNegocio.Admor;
import ObjNegocio.Estado;
import ObjNegocio.Municipio;
import ObjNegocio.Normal;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
        try ( PrintWriter out = response.getWriter()) {
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
                || sexo == null) {
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

        if (fechaNacimientoTrans.isAfter(fechaActualLocal)) {
            String mensaje = "Esa fecha aún no existe!";
            request.setAttribute("mensaje", mensaje);
            request.getRequestDispatcher("/register.jsp").forward(request, response);
            return;
        }

        Period periodo = Period.between(fechaNacimientoTrans, fechaActualLocal);
        int edad = periodo.getYears();

        if (edad < 18) {
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
        
        //No se permite el correo para regiustrar mas de una cuenta
        List<Admor> listaDeAdmors= registerNegocio.listaAdmor();
        for(Admor adr:listaDeAdmors){
            if(adr.getCorreo().equalsIgnoreCase(email)){
                request.setAttribute("error", "Ha ocurrido un error al registrar usuario 🤣");
                getServletContext().getRequestDispatcher("/errorExterno.jsp")
                        .forward(request, response);
                return;
            }
        }
        List<Normal> listaDeNormals= registerNegocio.listaNormal();
        for(Normal nrm:listaDeNormals){
            if(nrm.getCorreo().equalsIgnoreCase(email)){
                request.setAttribute("error", "Ha ocurrido un error al registrar usuario 🤣");
                getServletContext().getRequestDispatcher("/errorExterno.jsp")
                        .forward(request, response);
                return;
            }
        }

        if (tipo != null && tipo.equalsIgnoreCase("true")) {
            try {
                Admor admin = new Admor();
                admin.setCorreo(email);
                admin.setNombreCompleto(nombre);
                admin.setContrasenia(hashPassword(contra));
                admin.setTelefono(telefono);
                admin.setCiudad(ciudad);

                Municipio municipio = new Municipio();
                Estado estado = new Estado();

                if ("cd_obregon".equals(admin.getCiudad())) {
                    estado.setNombre("Sonora");
                    municipio.setNombre("Cajeme");
                } else if ("hermosillo".equals(admin.getCiudad())) {
                    estado.setNombre("Sonora");
                    municipio.setNombre("Hermosillo");
                } else if ("culiacan".equals(admin.getCiudad())) {
                    estado.setNombre("Sinaloa");
                    municipio.setNombre("Culiacan");
                } else if ("mazatlan".equals(admin.getCiudad())) {
                    estado.setNombre("Sinaloa");
                    municipio.setNombre("Mazatlan");
                }

                municipio.setEstado(estado);
                admin.setMunicipio(municipio);

                Estado estadoExistente = registerNegocio.buscarEstado(estado);

                if (estadoExistente == null) {
                    registerNegocio.guardarEstado(estado);
                }

                Municipio municipioExistente = registerNegocio.buscarMunicipio(municipio);

                if (municipioExistente == null) {
                    registerNegocio.guardarMunicipio(municipio);
                }

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
            normalUser.setContrasenia(hashPassword(contra));
            normalUser.setTelefono(telefono);

            normalUser.setCiudad(ciudad);

            Municipio municipio = new Municipio();
            Estado estado = new Estado();

            if ("cd_obregon".equals(normalUser.getCiudad())) {
                estado.setNombre("Sonora");
                municipio.setNombre("Cajeme");
            } else if ("hermosillo".equals(normalUser.getCiudad())) {
                estado.setNombre("Sonora");
                municipio.setNombre("Hermosillo");
            } else if ("culiacan".equals(normalUser.getCiudad())) {
                estado.setNombre("Sinaloa");
                municipio.setNombre("Culiacan");
            } else if ("mazatlan".equals(normalUser.getCiudad())) {
                estado.setNombre("Sinaloa");
                municipio.setNombre("Mazatlan");
            }

            municipio.setEstado(estado);
            normalUser.setMunicipio(municipio);

            Estado estadoExistente = registerNegocio.buscarEstado(estado);

            if (estadoExistente == null) {
                registerNegocio.guardarEstado(estado);
            }

            Municipio municipioExistente = registerNegocio.buscarMunicipio(municipio);

            if (municipioExistente == null) {
                registerNegocio.guardarMunicipio(municipio);
            }

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

     public static String hashPassword(String password) {
        try {
            // Crear un objeto MessageDigest con el algoritmo SHA-256
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            // Convertir la contraseña a bytes y aplicar el hash
            byte[] hashedBytes = digest.digest(password.getBytes());

            // Convertir el hash a una representación hexadecimal
            StringBuilder hexString = new StringBuilder();
            for (byte hashedByte : hashedBytes) {
                String hex = Integer.toHexString(0xff & hashedByte);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            // Manejar la excepción NoSuchAlgorithmException
            e.printStackTrace();
            return null;
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
