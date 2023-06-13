/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.appimplementacion;

import ObjNegocio.Admor;
import ObjNegocio.Anclado;
import ObjNegocio.Comentario;
import ObjNegocio.Comun;
import ObjNegocio.Estado;
import ObjNegocio.Municipio;
import ObjNegocio.Normal;
import ObjNegocio.Post;
import ObjNegocio.Usuario;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.itson.excepciones.DAOException;
import org.itson.interfaces.IFachadaDatos;

/**
 *
 * @author kim, carmen, elmer, marcos
 */
public class FachadaDatos implements IFachadaDatos{

    /**
     * Método guardar que llama al método guardar de la clase 
     * AdmorDAO para guardar una entidad Admor.
     * @param admor a insertar en la base de datos.
     */
    @Override
    public void guardarAdmor(Admor admor) {
       AdmorDAO admorDAO = new AdmorDAO();
        try {
            admorDAO.guardar(admor);
        } catch (DAOException ex) {
            Logger.getLogger(FachadaDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Método eliminar que llama al método eliminar de la clase 
     * AdmorDAO para eliminar una entidad Admor.
     * @param admor a eliminar en la base de datos.
     */
    @Override
    public void eliminarAdmor(Admor admor) {
        AdmorDAO admorDAO = new AdmorDAO();
        admorDAO.eliminar(admor);
    }

    /**
     * Método actualizar que llama al actualizar guardar de la clase 
     * AdmorDAO para actualizar una entidad Admor.
     * @param admor a actualizar en la base de datos.
     */
    @Override
    public void actualizarAdmor(Admor admor) {
        AdmorDAO admorDAO = new AdmorDAO();
        admorDAO.actualizar(admor, admor);
    }

    /**
     * Método buscar que llama al método buscar de la clase 
     * AdmorDAO para buscar una entidad Admor.
     * @param admor a buscar en la base de datos.
     */
    @Override
    public void buscarAdmor(Admor admor) {
        AdmorDAO admorDAO = new AdmorDAO();
        admorDAO.buscar(admor);
    }

    /**
     * Método buscar todos que llama al método buscar todos de la clase 
     * AdmorDAO para buscar todas las entidads Admor.
     * @return regresa una lista de todos los admor.
     */
    @Override
    public List<Admor> listaAdmor() {
         AdmorDAO admorDAO = new AdmorDAO();
         return admorDAO.buscarTodos();
    }

    /**
     * Método guardar que llama al método guardar de la clase 
     * AncladoDAO para guardar una entidad Anclado.
     * @param anclado a insertar en la base de datos.
     */
    @Override
    public void guardarAnclado(Anclado anclado) {
       AncladoDAO ancladoDAO = new AncladoDAO();
        try {
            ancladoDAO.guardar(anclado);
        } catch (DAOException ex) {
            Logger.getLogger(FachadaDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Método eliminar que llama al método eliminar de la clase 
     * AncladoDAO para eliminar una entidad Anclado.
     * @param anclado a eliminar en la base de datos.
     */
    @Override
    public void eliminarAnclado(Anclado anclado) {
        AncladoDAO ancladoDAO = new AncladoDAO();
        ancladoDAO.eliminar(anclado);
    }

    /**
     * Método actualizar que llama al método actualizar de la clase 
     * AncladoDAO para actualizar una entidad Anclado.
     * @param anclado a actualizar en la base de datos.
     */
    @Override
    public void actualizarAnclado(Anclado anclado) {
        AncladoDAO ancladoDAO = new AncladoDAO();
        ancladoDAO.actualizar(anclado, anclado);
    }

    /**
     * Método buscar que llama al método buscar de la clase 
     * AncladoDAO para buscar una entidad Anclado.
     * @param anclado a buscar en la base de datos.
     */
    @Override
    public void buscarAnclado(Anclado anclado) {
       AncladoDAO ancladoDAO = new AncladoDAO();
       ancladoDAO.buscar(anclado);
    }

    /**
     * Método buscar todos que llama al método buscar todos de la clase 
     * AncladoDAO para buscar todos una entidad Anclado.
     * @return regresa una lista de todos los anclado.
     */
    @Override
    public List<Anclado> listaAnclado() {
        AncladoDAO ancladoDAO = new AncladoDAO();
        return ancladoDAO.buscarTodos();
    }

    /**
     * Método guardar que llama al método guardar de la clase 
     * ComentarioDAO para guardar una entidad Comentario.
     * @param comentario a insertar en la base de datos.
     */
    @Override
    public void guardarComentario(Comentario comentario) {
        ComentarioDAO comentDAO = new ComentarioDAO();
        try {
            comentDAO.guardar(comentario);
        } catch (DAOException ex) {
            Logger.getLogger(FachadaDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Método eliminar que llama al método eliminar de la clase 
     * ComentarioDAO para eliminar una entidad Comentario.
     * @param comentario a eliminar en la base de datos.
     */
    @Override
    public void eliminarComentario(Comentario comentario) {
        ComentarioDAO comentDAO = new ComentarioDAO();
        comentDAO.eliminar(comentario);
    }

    /**
     * Método actualizar que llama al método actualizar de la clase 
     * ComentarioDAO para actualizar una entidad Comentario.
     * @param comentario a actualizar en la base de datos.
     */
    @Override
    public void actualizarComentario(Comentario comentario) {
        ComentarioDAO comentDAO = new ComentarioDAO();
        comentDAO.actualizar(comentario, comentario);
    }

    /**
     * Método buscar que llama al método buscar de la clase 
     * ComentarioDAO para buscar una entidad Comentario.
     * @param comentario a buscar en la base de datos.
     */
    @Override
    public void buscarComentario(Comentario comentario) {
        ComentarioDAO comentDAO = new ComentarioDAO();
        comentDAO.buscar(comentario);
    }

    /**
     * Método buscar todos que llama al método buscar todos de la clase 
     * ComentarioDAO para buscar todos una entidad Comentario.
     * @return regresa una lista de todos los comentarios.
     */
    @Override
    public List<Comentario> listaComentario() {
        ComentarioDAO comentDAO = new ComentarioDAO();
        return comentDAO.buscarTodos();
    }

    /**
     * Método guardar que llama al método guardar de la clase 
     * ComunDAO para guardar una entidad Comun.
     * @param comun a insertar en la base de datos.
     */
    @Override
    public void guardarComun(Comun comun) {
        ComunDAO comunDAO = new ComunDAO();
        try {
            comunDAO.guardar(comun);
        } catch (DAOException ex) {
            Logger.getLogger(FachadaDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Método eliminar que llama al método eliminar de la clase 
     * ComunDAO para eliminar una entidad Comun.
     * @param comun a eliminar en la base de datos.
     */
    @Override
    public void eliminarComun(Comun comun) {
        ComunDAO comunDAO = new ComunDAO();
        comunDAO.eliminar(comun);
    }

    /**
     * Método actualizar que llama al método actualizar de la clase 
     * ComunDAO para actualizar una entidad Comun.
     * @param comun a actualizar en la base de datos.
     */
    @Override
    public void actualizarComun(Comun comun) {
        ComunDAO comunDAO = new ComunDAO();
        comunDAO.actualizar(comun, comun);
    }

    /**
     * Método buscar que llama al método buscar de la clase 
     * ComunDAO para buscar una entidad Comun.
     * @param comun a buscar en la base de datos.
     */
    @Override
    public void buscarComun(Comun comun) {
        ComunDAO comunDAO = new ComunDAO();
        comunDAO.buscar(comun);
    }

    /**
     * Método buscar todos que llama al método buscar todos de la clase 
     * ComunDAO para buscar todos una entidad Comun.
     * @return regresa una lista de los comun.
     */
    @Override
    public List<Comun> listaComun() {
        ComunDAO comunDAO = new ComunDAO();
        return comunDAO.buscarTodos();
    }
   
    /**
     * Método guardar que llama al método guardar de la clase 
     * EstadoDAO para guardar una entidad Estado.
     * @param estado a insertar en la base de datos.
     */
    @Override
    public void guardarEstado(Estado estado) {
        EstadoDAO estadoDAO = new EstadoDAO();
        try {
            estadoDAO.guardar(estado);
        } catch (DAOException ex) {
            Logger.getLogger(FachadaDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Método eliminar que llama al método eliminar de la clase 
     * EstadoDAO para eliminar una entidad Estado.
     * @param estado a eliminar en la base de datos.
     */
    @Override
    public void eliminarEstado(Estado estado) {
        EstadoDAO estadoDAO = new EstadoDAO();
        estadoDAO.eliminar(estado);
    }

    /**
     * Método actualizar que llama al método actualizar de la clase 
     * EstadoDAO para actualizar una entidad Estado.
     * @param estado a actualizar en la base de datos.
     */
    @Override
    public void actualizarEstado(Estado estado) {
        EstadoDAO estadoDAO = new EstadoDAO();
        estadoDAO.actualizar(estado, estado);
    }

    /**
     * Método buscar que llama al método buscar de la clase 
     * EstadoDAO para buscar una entidad Estado.
     * @param estado a buscar en la base de datos.
     */
    @Override
    public void buscarEstado(Estado estado) {
        EstadoDAO estadoDAO = new EstadoDAO();
        estadoDAO.buscar(estado);
    }

    /**
     * Método buscar todos que llama al método buscar todos de la clase 
     * EstadoDAO para buscar todos una entidad Estado.
     * @return regresa una lista de todos los estados.
     */
    @Override
    public List<Estado> listaEstado() {
        EstadoDAO estadoDAO = new EstadoDAO();
        return estadoDAO.buscarTodos();
    }

    /**
     * Método guardar que llama al método guardar de la clase 
     * MunicipioDAO para guardar una entidad Municipio.
     * @param municipio a insertar en la base de datos.
     */
    @Override
    public void guardarMunicipio(Municipio municipio) {
        MunicipioDAO muniDAO = new MunicipioDAO();
        try {
            muniDAO.guardar(municipio);
        } catch (DAOException ex) {
            Logger.getLogger(FachadaDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Método eliminar que llama al método eliminar de la clase 
     * MunicipioDAO para eliminar una entidad Municipio.
     * @param municipio a eliminar en la base de datos.
     */
    @Override
    public void eliminarMunicipio(Municipio municipio) {
        MunicipioDAO muniDAO = new MunicipioDAO();
        muniDAO.eliminar(municipio);
    }

    /**
     * Método actualizar que llama al método actualizar de la clase 
     * MunicipioDAO para actualizar una entidad Municipio.
     * @param municipio a actualizar en la base de datos.
     */
    @Override
    public void actualizarMunicipio(Municipio municipio) {
        MunicipioDAO muniDAO = new MunicipioDAO();
        muniDAO.actualizar(municipio, municipio);
    }

    /**
     * Método buscar que llama al método buscar de la clase 
     * MunicipioDAO para buscar una entidad Municipio.
     * @param municipio a buscar en la base de datos.
     */
    @Override
    public void buscarMunicipio(Municipio municipio) {
        MunicipioDAO muniDAO = new MunicipioDAO();
        muniDAO.buscar(municipio);
    }

    /**
     * Método buscar todos que llama al método buscar todos de la clase 
     * MunicipioDAO para buscar todos una entidad Municipio.
     * @return regresa una lista de todos los municipios.
     */
    @Override
    public List<Municipio> listaMunicipio() {
       MunicipioDAO muniDAO = new MunicipioDAO();
       return muniDAO.buscarTodos();
    }

    /**
     * Método guardar que llama al método guardar de la clase 
     * NormalDAO para guardar una entidad Normal.
     * @param normal a insertar en la base de datos.
     */
    @Override
    public void guardarNormal(Normal normal) {
       NormalDAO normalDAO = new NormalDAO();
        try {
            normalDAO.guardar(normal);
        } catch (DAOException ex) {
            Logger.getLogger(FachadaDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Método eliminar que llama al método eliminar de la clase 
     * NormalDAO para eliminar una entidad Normal.
     * @param normal a eliminar en la base de datos.
     */
    @Override
    public void eliminarNormal(Normal normal) {
        NormalDAO normalDAO = new NormalDAO();
        normalDAO.eliminar(normal);
    }

    /**
     * Método actualizar que llama al método actualizar de la clase 
     * NormalDAO para actualizar una entidad Normal.
     * @param normal a actualizar en la base de datos.
     */
    @Override
    public void actualizarNormal(Normal normal) {
         NormalDAO normalDAO = new NormalDAO();
         normalDAO.actualizar(normal, normal);
    }

    /**
     * Método buscar que llama al método buscar de la clase 
     * NormalDAO para buscar una entidad Normal.
     * @param normal a buscar en la base de datos.
     */
    @Override
    public void buscarNormal(Normal normal) {
         NormalDAO normalDAO = new NormalDAO();
         normalDAO.buscar(normal);
    }

    /**
     * Método buscar todos que llama al método buscar todos de la clase 
     * NormalDAO para buscar todos una entidad Normal.
     * @return regresa una lista de todos los normales.
     */
    @Override
    public List<Normal> listaNormal() {
        NormalDAO normalDAO = new NormalDAO();
        return normalDAO.buscarTodos();
    }

    /**
     * Método guardar que llama al método guardar de la clase 
     * PostDAO para guardar una entidad Post.
     * @param post a insertar en la base de datos.
     */
    @Override
    public void guardarPost(Post post) {
        PostDAO postDAO = new PostDAO();
        try {
            postDAO.guardar(post);
        } catch (DAOException ex) {
            Logger.getLogger(FachadaDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Método eliminar que llama al método eliminar de la clase 
     * PostDAO para eliminar una entidad Post.
     * @param post a eliminar en la base de datos.
     */
    @Override
    public void eliminarPost(Post post) {
        PostDAO postDAO = new PostDAO();
        postDAO.eliminar(post);
    }

    /**
     * Método actualizar que llama al método actualizar de la clase 
     * PostDAO para actualizar una entidad Post.
     * @param post a actualizar en la base de datos.
     */
    @Override
    public void actualizarPost(Post post) {
       PostDAO postDAO = new PostDAO();
       postDAO.actualizar(post, post);
    }

    /**
     * Método buscar que llama al método buscar de la clase 
     * PostDAO para buscar una entidad Post.
     * @param post a buscar en la base de datos.
     */
    @Override
    public void buscarPost(Post post) {
        PostDAO postDAO = new PostDAO();
        postDAO.buscar(post);
    }

    /**
     * Método buscar todos que llama al método buscar todos de la clase 
     * PostDAO para buscar todos una entidad Post.
     * @return regresa una lista de todos los posts.
     */
    @Override
    public List<Post> listaPost() {
        PostDAO postDAO = new PostDAO();
        return postDAO.buscarTodos();
    }

    /**
     * Método guardar que llama al método guardar de la clase 
     * UsuarioDAO para guardar una entidad Usuario.
     * @param usuario a insertar en la base de datos.
     */
    @Override
    public void guardarUsuario(Usuario usuario) {
       UsuarioDAO usuDAO = new UsuarioDAO();
        try {
            usuDAO.guardar(usuario);
        } catch (DAOException ex) {
            Logger.getLogger(FachadaDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Método eliminar que llama al método eliminar de la clase 
     * UsuarioDAO para eliminar una entidad Usuario.
     * @param usuario a eliminar en la base de datos.
     */
    @Override
    public void eliminarUsuario(Usuario usuario) {
        UsuarioDAO usuDAO = new UsuarioDAO();
        usuDAO.eliminar(usuario);
    }

    /**
     * Método actualizar que llama al método actualizar de la clase 
     * UsuarioDAO para actualizar una entidad Usuario.
     * @param usuario a actualizar en la base de datos.
     */
    @Override
    public void actualizarUsuario(Usuario usuario) {
        UsuarioDAO usuDAO = new UsuarioDAO();
        usuDAO.actualizar(usuario, usuario);
    }

    /**
     * Método buscar que llama al método buscar de la clase 
     * UsuarioDAO para buscar una entidad Usuario.
     * @param usuario a buscar en la base de datos.
     */
    @Override
    public void buscarUsuario(Usuario usuario) {
        UsuarioDAO usuDAO = new UsuarioDAO();
        usuDAO.buscar(usuario);
    }

    /**
     * Método buscar todos que llama al método buscar todos de la clase 
     * UsuarioDAO para buscar todos una entidad Usuario.
     * @return regresa una lista de todos los usuarios.
     */
    @Override
    public List<Usuario> listaUsuario() {
       UsuarioDAO usuDAO = new UsuarioDAO();
       return usuDAO.buscarTodos();
    }
    
}
