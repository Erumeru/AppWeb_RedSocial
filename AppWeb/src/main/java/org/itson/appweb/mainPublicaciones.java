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
import ObjNegocio.Post;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.io.IOUtils;
import org.itson.appweb.dtos.ComentariosDTO;

/**
 *
 * @author Marcos Toledo 00000234963
 */
@WebServlet(name = "mainPublicaciones", urlPatterns = {"/mainPublicaciones"})
public class mainPublicaciones extends HttpServlet {

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
            out.println("<title>Servlet mainPublicaciones</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet mainPublicaciones at " + request.getContextPath() + "</h1>");
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

    /*
    private void proccessViewPosts(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtén la instancia de ILogica para consultar los posts
        ILogica viewPosts = FabricaLogica.crearInstancia();

        // Consulta la lista de posts
        List<Comun> listaPosts = viewPosts.listaComun();

        // Construye el contenido HTML para la etiqueta <p>
        if (listaPosts == null || listaPosts.isEmpty()) {
            request.getSession().setAttribute("mensaje", "No hay posts disponibles");
        }
        // Establece el contenido HTML en el atributo de la solicitud (request)
        request.getSession().setAttribute("posts", listaPosts);
        getServletContext().getRequestDispatcher("/mainPublicaciones.jsp").forward(request, response);
    }*/
//    private void proccessViewAnclados(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        // Obtén la instancia de ILogica para consultar los posts
//        ILogica viewAnclados = FabricaLogica.crearInstancia();
//
//        // Consulta la lista de posts
//        List<Anclado> listaAnclados = viewAnclados.listaAnclado();
//
//        // Construye el contenido HTML para la etiqueta <p>
//        if (listaAnclados == null || listaAnclados.isEmpty()) {
//            request.getSession().setAttribute("mensaje", "No hay posts disponibles");
//        }
//        // Establece el contenido HTML en el atributo de la solicitud (request)
//        request.getSession().setAttribute("anclados", listaAnclados);
//        getServletContext().getRequestDispatcher("/mainPublicaciones.jsp").forward(request, response);
//    }
    private void proccessViewPosts(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        String tipoUsuario = session.getAttribute("tipo").toString();
        
        
        if (tipoUsuario.equalsIgnoreCase("admor")) {
            Admor usuario = (Admor)session.getAttribute("usuario");
            request.getSession().setAttribute("usuarioComparacion", usuario.getId());
        } else {
            Normal usuario = (Normal)session.getAttribute("usuario");
            request.getSession().setAttribute("usuarioComparacion", usuario.getId());
        }
        
        // Obtén la instancia de ILogica para consultar los posts
        ILogica viewPosts = FabricaLogica.crearInstancia();

        List<Anclado> listaAnclados = viewPosts.listaAnclado();

        // Consulta la lista de posts
        List<Comun> listaComunes = viewPosts.listaComun();

        for (Comun com : listaComunes) {
            ArrayList<Comentario> coments = viewPosts.buscarComentariosPorComun(com.getIdComun().toString());
            com.setComentarios(coments);
        }
        // Construye el contenido HTML para la etiqueta <p>
        if (listaComunes == null || listaComunes.isEmpty() && listaAnclados == null || listaAnclados.isEmpty()) {
            request.getSession().setAttribute("mensaje", "No hay posts disponibles");
        }
        // Establece el contenido HTML en el atributo de la solicitud (request)
        request.getSession().setAttribute("anclados", listaAnclados);
        request.getSession().setAttribute("comunes", listaComunes);

        getServletContext().getRequestDispatcher("/mainPublicaciones.jsp").forward(request, response);
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
        if (action != null && action.equalsIgnoreCase("viewPosts")) {
            //proccessViewPosts(request, response);
            proccessViewPosts(request, response);
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
