package org.itson.appweb;

import Clases.FabricaLogica;
import Clases.ILogica;
import ObjNegocio.Admor;
import ObjNegocio.Usuario;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.System.Logger.Level;
import java.util.Scanner;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.bson.types.ObjectId;
import org.itson.appweb.FileUpload;

/**
 * @author Juan Díez-Yanguas Barber
 */
//Anotación necesaria para procesar formulario
@MultipartConfig
@WebServlet(name = "FileUploadServlet", urlPatterns = {"/FileUploadServlet"})
public class FileUploadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.processUpload(request, response);
    }

    private void processUpload(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        boolean isMultiPart = ServletFileUpload.isMultipartContent(request);
        if (isMultiPart) {
            ServletFileUpload upload = new ServletFileUpload();

            try {
                FileItemIterator itr = upload.getItemIterator(request);
                // String fieldName=itr.next().getFieldName();
                while (itr.hasNext()) {
                    FileItemStream item = itr.next();
                    String fieldName = item.getName();

                    if (item.isFormField()) {
                        InputStream is = item.openStream();
                        byte[] b = new byte[is.available()];
                        is.read(b);
                        String value = new String(b);
                        response.getWriter().println(fieldName + ":" + value + "<br/>");
                    } else {
                        String path = getServletContext().getRealPath("/");
                        String id = (String) request.getSession().getAttribute("id");
                        ObjectId objId = new ObjectId(id);
                        ILogica registerNegocio = FabricaLogica.crearInstancia();

                        Admor adm = new Admor();
                        adm.setId(objId);

                        adm = registerNegocio.buscarAdmor(adm);

                        Admor admAvatar = adm;
                        admAvatar.setAvatar(path +"images\\"+ fieldName);
                        registerNegocio.actualizarAdmor(adm, admAvatar);
                        if (FileUpload.processFile(path, item)) {
                            response.getWriter().println("file uploaded successfully");
                        } else {
                            response.getWriter().println("file uploaded falied");
                        }
                    }
                }
            } catch (FileUploadException ex) {
                ex.printStackTrace();
            }
            getServletContext().getRequestDispatcher("/login.jsp")
                    .forward(request, response);

        }
    }
}
