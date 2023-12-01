/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package org.itson.appweb;

import Clases.FabricaLogica;
import Clases.ILogica;
import ObjNegocio.Admor;
import ObjNegocio.Comun;
import ObjNegocio.Normal;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author eruma
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

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
            out.println("<title>Servlet Login</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Login at " + request.getContextPath() + "</h1>");
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
        if (action != null && action.equalsIgnoreCase("login")) {
            processLogin(request, response);
            return;
        }
        if (action != null && action.equalsIgnoreCase("logout")) {
            processLogout(request, response);
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

    private void processLogin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String correo = request.getParameter("corrNum");
        String pass = request.getParameter("pass");
        ILogica registerNegocio = FabricaLogica.crearInstancia();
        List<Admor> admin = registerNegocio.listaAdmor();
        List<Normal> normal = registerNegocio.listaNormal();

        //validacion de datos
        if (correo == null
                || correo.isBlank()
                || pass == null
                || pass.isBlank()) {
            // regresamos a las paginas
            getServletContext().getRequestDispatcher("/loginCampoIncom.jsp").forward(request, response);
        }

        for (Admor adm : admin) {
            try {
                if (adm.getCorreo() != null && adm.getContrasenia() != null
                        && adm.getCorreo().equalsIgnoreCase(correo) && hashPassword(pass).equalsIgnoreCase(adm.getContrasenia())) {
                    HttpSession sesion = request.getSession();
                    ArrayList<Comun> comunesYAncladosDeAdmor = registerNegocio.getComunesYAncDeAdmor(adm);
                    sesion.setAttribute("usuario", adm);
                    sesion.setAttribute("id", "uploads/" + adm.getId() + ".png");
                    sesion.setAttribute("tipo", "admor");
                    sesion.setAttribute("listPostUser", comunesYAncladosDeAdmor);
                    getServletContext().getRequestDispatcher("/perfilUsuario.jsp").forward(request, response);
                    return;
                }
            } catch (Exception ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        for (Normal nrm : normal) {
            try {
                if (nrm.getCorreo() != null && nrm.getContrasenia() != null
                        && nrm.getCorreo().equalsIgnoreCase(correo) && hashPassword(pass).equalsIgnoreCase(nrm.getContrasenia())) {
                    HttpSession sesion = request.getSession();
                    //    sesion.setAttribute("listaPostsComun", registerNegocio.getComunesDeNormal(nrm));
                    List<Comun> comunesDeNormal = registerNegocio.getComunesDeNormal(nrm);
                    sesion.setAttribute("usuario", nrm);
                    sesion.setAttribute("id", "uploads/" + nrm.getId() + ".png");
                    sesion.setAttribute("tipo", "normal");
                    sesion.setAttribute("listPostUser", comunesDeNormal);
                    getServletContext().getRequestDispatcher("/perfilUsuario_1.jsp").forward(request, response);
                    return;
                }
            } catch (Exception ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        getServletContext().getRequestDispatcher("/loginCredenInco.jsp").forward(request, response);
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

    protected void processLogout(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        sesion.invalidate();
        getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
    }

}
