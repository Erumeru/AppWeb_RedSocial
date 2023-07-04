/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package org.itson.appweb;

import Clases.FabricaLogica;
import Clases.ILogica;
import ObjNegocio.Comun;
import ObjNegocio.Post;
import ObjNegocio.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author hoshi
 */
@WebServlet(name = "Administrador", urlPatterns = {"/Administrador"})
public class Administrador extends HttpServlet {

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
            out.println("<title>Servlet Administrador</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Administrador at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);
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
        if (action != null && action.equalsIgnoreCase("details")) {
            proccessViewPosts(request, response);
            return;
        }
    }

    private void proccessViewPosts(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtén la instancia de ILogica para consultar los posts
        ILogica viewPosts = FabricaLogica.crearInstancia();
//
//        // Consulta la lista de posts
//      
        HttpSession sesion = request.getSession(false);
        if (sesion != null && sesion.getAttribute("usuario") != null) {
            Usuario usuario = new Usuario();
            Usuario usuarioLista = viewPosts.buscarUsuario(usuario);

            // Construye el contenido HTML para la etiqueta <p>
            if (usuarioLista == null) {
                request.setAttribute("mensaje", "No hay posts disponibles");
            }
            // Establece el contenido HTML en el atributo de la solicitud (request)
            request.setAttribute("usuario", usuarioLista);
            getServletContext().getRequestDispatcher("/tablaAdministradores.jsp").forward(request, response);

        } else {
            getServletContext().getRequestDispatcher("/errorInterno.jsp").forward(request, response);
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
