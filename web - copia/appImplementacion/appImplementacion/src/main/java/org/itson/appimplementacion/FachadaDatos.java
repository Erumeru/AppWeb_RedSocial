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
import com.mongodb.client.MongoCollection;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.itson.excepciones.DAOException;
import org.itson.interfaces.IFachadaDatos;

/**
 *
 * @author kim, carmen, elmer, marcos
 */
public class FachadaDatos implements IFachadaDatos {

    /**
     * Método guardar que llama al método guardar de la clase AdmorDAO para
     * guardar una entidad Admor.
     *
     * @param admor a insertar en la base de datos.
     */
    @Override
    public Admor guardarAdmor(Admor admor) {
        AdmorDAO admorDAO = new AdmorDAO();
        try {
            return admorDAO.guardar(admor);
        } catch (DAOException ex) {
            Logger.getLogger(FachadaDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Método eliminar que llama al método eliminar de la clase AdmorDAO para
     * eliminar una entidad Admor.
     *
     * @param admor a eliminar en la base de datos.
     */
    @Override
    public Admor eliminarAdmor(Admor admor) {
        AdmorDAO admorDAO = new AdmorDAO();
        return admorDAO.eliminar(admor);
    }

    /**
     * Método actualizar que llama al actualizar guardar de la clase AdmorDAO
     * para actualizar una entidad Admor.
     *
     * @param admorBase a actualizar en la base de datos.
     * @param admorNuevo
     * @return admor
     */
    @Override
    public Admor actualizarAdmor(Admor admorBase, Admor admorNuevo) {
        AdmorDAO admorDAO = new AdmorDAO();
        return admorDAO.actualizar(admorBase, admorNuevo);
    }

    /**
     * Método buscar que llama al método buscar de la clase AdmorDAO para buscar
     * una entidad Admor.
     *
     * @param admor a buscar en la base de datos.
     * @return
     */
    @Override
    public Admor buscarAdmor(Admor admor) {
        AdmorDAO admorDAO = new AdmorDAO();
        return admorDAO.buscar(admor);
    }

    /**
     * Método buscar todos que llama al método buscar todos de la clase AdmorDAO
     * para buscar todas las entidads Admor.
     *
     * @return regresa una lista de todos los admor.
     */
    @Override
    public List<Admor> listaAdmor() {
        AdmorDAO admorDAO = new AdmorDAO();
        return admorDAO.buscarTodos();
    }

    /**
     * Método guardar que llama al método guardar de la clase AncladoDAO para
     * guardar una entidad Anclado.
     *
     * @param anclado a insertar en la base de datos.
     * @return
     */
    @Override
    public Anclado guardarAnclado(Anclado anclado) {
        AncladoDAO ancladoDAO = new AncladoDAO();
        try {
            return ancladoDAO.guardar(anclado);
        } catch (DAOException ex) {
            Logger.getLogger(FachadaDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Método eliminar que llama al método eliminar de la clase AncladoDAO para
     * eliminar una entidad Anclado.
     *
     * @param anclado a eliminar en la base de datos.
     * @return
     */
    @Override
    public Anclado eliminarAnclado(Anclado anclado) {
        AncladoDAO ancladoDAO = new AncladoDAO();
        return ancladoDAO.eliminar(anclado);
    }

    /**
     * Método actualizar que llama al método actualizar de la clase AncladoDAO
     * para actualizar una entidad Anclado.
     *
     * @param ancladoBase
     * @param ancladoNuevo a actualizar en la base de datos.
     * @return
     */
    @Override
    public Anclado actualizarAnclado(Anclado ancladoBase, Anclado ancladoNuevo) {
        AncladoDAO ancladoDAO = new AncladoDAO();
        return ancladoDAO.actualizar(ancladoBase, ancladoNuevo);
    }

    /**
     * Método buscar que llama al método buscar de la clase AncladoDAO para
     * buscar una entidad Anclado.
     *
     * @param anclado a buscar en la base de datos.
     * @return
     */
    @Override
    public Anclado buscarAnclado(Anclado anclado) {
        AncladoDAO ancladoDAO = new AncladoDAO();
        return ancladoDAO.buscar(anclado);
    }

    /**
     * Método buscar todos que llama al método buscar todos de la clase
     * AncladoDAO para buscar todos una entidad Anclado.
     *
     * @return regresa una lista de todos los anclado.
     */
    @Override
    public List<Anclado> listaAnclado() {
        AncladoDAO ancladoDAO = new AncladoDAO();
        return ancladoDAO.buscarTodos();
    }

    /**
     * Método guardar que llama al método guardar de la clase ComentarioDAO para
     * guardar una entidad Comentario.
     *
     * @param comentario a insertar en la base de datos.
     * @return
     */
    @Override
    public Comentario guardarComentario(Comentario comentario) {
        ComentarioDAO comentDAO = new ComentarioDAO();
        try {
            return comentDAO.guardar(comentario);
        } catch (DAOException ex) {
            Logger.getLogger(FachadaDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Método eliminar que llama al método eliminar de la clase ComentarioDAO
     * para eliminar una entidad Comentario.
     *
     * @param comentario a eliminar en la base de datos.
     * @return
     */
    @Override
    public Comentario eliminarComentario(Comentario comentario) {
        ComentarioDAO comentDAO = new ComentarioDAO();
        return comentDAO.eliminar(comentario);
    }

    /**
     * Método actualizar que llama al método actualizar de la clase
     * ComentarioDAO para actualizar una entidad Comentario.
     *
     * @param comentario a actualizar en la base de datos.
     * @return
     */
    @Override
    public Comentario actualizarComentario(Comentario comentarioBase, Comentario comentarioNuevo) {
        ComentarioDAO comentDAO = new ComentarioDAO();
        return comentDAO.actualizar(comentarioBase, comentarioNuevo);
    }

    /**
     * Método buscar que llama al método buscar de la clase ComentarioDAO para
     * buscar una entidad Comentario.
     *
     * @param comentario a buscar en la base de datos.
     * @return
     */
    @Override
    public Comentario buscarComentario(Comentario comentario) {
        ComentarioDAO comentDAO = new ComentarioDAO();
        return comentDAO.buscar(comentario);
    }

    /**
     * Método buscar todos que llama al método buscar todos de la clase
     * ComentarioDAO para buscar todos una entidad Comentario.
     *
     * @return regresa una lista de todos los comentarios.
     */
    @Override
    public List<Comentario> listaComentario() {
        ComentarioDAO comentDAO = new ComentarioDAO();
        return comentDAO.buscarTodos();
    }

    /**
     * Método guardar que llama al método guardar de la clase ComunDAO para
     * guardar una entidad Comun.
     *
     * @param comun a insertar en la base de datos.
     * @return
     */
    @Override
    public Comun guardarComun(Comun comun) {
        ComunDAO comunDAO = new ComunDAO();
        try {
            return comunDAO.guardar(comun);
        } catch (DAOException ex) {
            Logger.getLogger(FachadaDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Método eliminar que llama al método eliminar de la clase ComunDAO para
     * eliminar una entidad Comun.
     *
     * @param comun a eliminar en la base de datos.
     * @return
     */
    @Override
    public Comun eliminarComun(Comun comun) {
        ComunDAO comunDAO = new ComunDAO();
        return comunDAO.eliminar(comun);
    }

    /**
     * Método actualizar que llama al método actualizar de la clase ComunDAO
     * para actualizar una entidad Comun.
     *
     * @param comun a actualizar en la base de datos.
     * @return
     */
    @Override
    public Comun actualizarComun(Comun comunBase, Comun comunNuevo) {
        ComunDAO comunDAO = new ComunDAO();
        return comunDAO.actualizar(comunBase, comunNuevo);
    }

    /**
     * Método buscar que llama al método buscar de la clase ComunDAO para buscar
     * una entidad Comun.
     *
     * @param comun a buscar en la base de datos.
     * @return
     */
    @Override
    public Comun buscarComun(Comun comun) {
        ComunDAO comunDAO = new ComunDAO();
        return comunDAO.buscar(comun);
    }

    /**
     * Método buscar todos que llama al método buscar todos de la clase ComunDAO
     * para buscar todos una entidad Comun.
     *
     * @return regresa una lista de los comun.
     */
    @Override
    public List<Comun> listaComun() {
        ComunDAO comunDAO = new ComunDAO();
        return comunDAO.buscarTodos();
    }

    /**
     * Método guardar que llama al método guardar de la clase EstadoDAO para
     * guardar una entidad Estado.
     *
     * @param estado a insertar en la base de datos.
     * @return
     */
    @Override
    public Estado guardarEstado(Estado estado) {
        EstadoDAO estadoDAO = new EstadoDAO();
        try {
            return estadoDAO.guardar(estado);
        } catch (DAOException ex) {
            Logger.getLogger(FachadaDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Método eliminar que llama al método eliminar de la clase EstadoDAO para
     * eliminar una entidad Estado.
     *
     * @param estado a eliminar en la base de datos.
     * @return
     */
    @Override
    public Estado eliminarEstado(Estado estado) {
        EstadoDAO estadoDAO = new EstadoDAO();
        return estadoDAO.eliminar(estado);
    }

    /**
     * Método actualizar que llama al método actualizar de la clase EstadoDAO
     * para actualizar una entidad Estado.
     *
     * @param estado a actualizar en la base de datos.
     * @return
     */
    @Override
    public Estado actualizarEstado(Estado estadoBase, Estado estadoNuevo) {
        EstadoDAO estadoDAO = new EstadoDAO();
        return estadoDAO.actualizar(estadoBase, estadoNuevo);
    }

    /**
     * Método buscar que llama al método buscar de la clase EstadoDAO para
     * buscar una entidad Estado.
     *
     * @param estado a buscar en la base de datos.
     * @return
     */
    @Override
    public Estado buscarEstado(Estado estado) {
        EstadoDAO estadoDAO = new EstadoDAO();
        return estadoDAO.buscar(estado);
    }

    /**
     * Método buscar todos que llama al método buscar todos de la clase
     * EstadoDAO para buscar todos una entidad Estado.
     *
     * @return regresa una lista de todos los estados.
     */
    @Override
    public List<Estado> listaEstado() {
        EstadoDAO estadoDAO = new EstadoDAO();
        return estadoDAO.buscarTodos();
    }

    /**
     * Método guardar que llama al método guardar de la clase MunicipioDAO para
     * guardar una entidad Municipio.
     *
     * @param municipio a insertar en la base de datos.
     * @return
     */
    @Override
    public Municipio guardarMunicipio(Municipio municipio) {
        MunicipioDAO muniDAO = new MunicipioDAO();
        try {
            return muniDAO.guardar(municipio);
        } catch (DAOException ex) {
            Logger.getLogger(FachadaDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Método eliminar que llama al método eliminar de la clase MunicipioDAO
     * para eliminar una entidad Municipio.
     *
     * @param municipio a eliminar en la base de datos.
     */
    @Override
    public Municipio eliminarMunicipio(Municipio municipio) {
        MunicipioDAO muniDAO = new MunicipioDAO();
        return muniDAO.eliminar(municipio);
    }

    /**
     * Método actualizar que llama al método actualizar de la clase MunicipioDAO
     * para actualizar una entidad Municipio.
     *
     * @param municipio a actualizar en la base de datos.
     */
    @Override
    public Municipio actualizarMunicipio(Municipio municipioBase, Municipio municipioNuevo) {
        MunicipioDAO muniDAO = new MunicipioDAO();
        return muniDAO.actualizar(municipioBase, municipioNuevo);
    }

    /**
     * Método buscar que llama al método buscar de la clase MunicipioDAO para
     * buscar una entidad Municipio.
     *
     * @param municipio a buscar en la base de datos.
     */
    @Override
    public Municipio buscarMunicipio(Municipio municipio) {
        MunicipioDAO muniDAO = new MunicipioDAO();
        return muniDAO.buscar(municipio);
    }

    /**
     * Método buscar todos que llama al método buscar todos de la clase
     * MunicipioDAO para buscar todos una entidad Municipio.
     *
     * @return regresa una lista de todos los municipios.
     */
    @Override
    public List<Municipio> listaMunicipio() {
        MunicipioDAO muniDAO = new MunicipioDAO();
        return muniDAO.buscarTodos();
    }

    /**
     * Método guardar que llama al método guardar de la clase NormalDAO para
     * guardar una entidad Normal.
     *
     * @param normal a insertar en la base de datos.
     */
    @Override
    public Normal guardarNormal(Normal normal) {
        NormalDAO normalDAO = new NormalDAO();
        try {
            return normalDAO.guardar(normal);
        } catch (DAOException ex) {
            Logger.getLogger(FachadaDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Método eliminar que llama al método eliminar de la clase NormalDAO para
     * eliminar una entidad Normal.
     *
     * @param normal a eliminar en la base de datos.
     */
    @Override
    public Normal eliminarNormal(Normal normal) {
        NormalDAO normalDAO = new NormalDAO();
        return normalDAO.eliminar(normal);
    }

    /**
     * Método actualizar que llama al método actualizar de la clase NormalDAO
     * para actualizar una entidad Normal.
     *
     * @param normal a actualizar en la base de datos.
     */
    @Override
    public Normal actualizarNormal(Normal normalBase, Normal normalNuevo) {
        NormalDAO normalDAO = new NormalDAO();
        return normalDAO.actualizar(normalBase, normalNuevo);
    }

    /**
     * Método buscar que llama al método buscar de la clase NormalDAO para
     * buscar una entidad Normal.
     *
     * @param normal a buscar en la base de datos.
     */
    @Override
    public Normal buscarNormal(Normal normal) {
        NormalDAO normalDAO = new NormalDAO();
        return normalDAO.buscar(normal);
    }

    /**
     * Método buscar todos que llama al método buscar todos de la clase
     * NormalDAO para buscar todos una entidad Normal.
     *
     * @return regresa una lista de todos los normales.
     */
    @Override
    public List<Normal> listaNormal() {
        NormalDAO normalDAO = new NormalDAO();
        return normalDAO.buscarTodos();
    }

    /**
     * Método guardar que llama al método guardar de la clase PostDAO para
     * guardar una entidad Post.
     *
     * @param post a insertar en la base de datos.
     */
    @Override
    public Post guardarPost(Post post) {
        PostDAO postDAO = new PostDAO();
        try {
            return postDAO.guardar(post);
        } catch (DAOException ex) {
            Logger.getLogger(FachadaDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Método eliminar que llama al método eliminar de la clase PostDAO para
     * eliminar una entidad Post.
     *
     * @param post a eliminar en la base de datos.
     */
    @Override
    public Post eliminarPost(Post post) {
        PostDAO postDAO = new PostDAO();
        return postDAO.eliminar(post);
    }

    /**
     * Método actualizar que llama al método actualizar de la clase PostDAO para
     * actualizar una entidad Post.
     *
     * @param post a actualizar en la base de datos.
     */
    @Override
    public Post actualizarPost(Post postBase, Post postNuevo) {
        PostDAO postDAO = new PostDAO();
        return postDAO.actualizar(postBase, postNuevo);
    }

    /**
     * Método buscar que llama al método buscar de la clase PostDAO para buscar
     * una entidad Post.
     *
     * @param post a buscar en la base de datos.
     */
    @Override
    public Post buscarPost(Post post) {
        PostDAO postDAO = new PostDAO();
        return postDAO.buscar(post);
    }

    /**
     * Método buscar todos que llama al método buscar todos de la clase PostDAO
     * para buscar todos una entidad Post.
     *
     * @return regresa una lista de todos los posts.
     */
    @Override
    public List<Post> listaPost() {
        PostDAO postDAO = new PostDAO();
        return postDAO.buscarTodos();
    }

    /**
     * Método guardar que llama al método guardar de la clase UsuarioDAO para
     * guardar una entidad Usuario.
     *
     * @param usuario a insertar en la base de datos.
     */
    @Override
    public Usuario guardarUsuario(Usuario usuario) {
        UsuarioDAO usuDAO = new UsuarioDAO();
        try {
            return usuDAO.guardar(usuario);
        } catch (DAOException ex) {
            Logger.getLogger(FachadaDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Método eliminar que llama al método eliminar de la clase UsuarioDAO para
     * eliminar una entidad Usuario.
     *
     * @param usuario a eliminar en la base de datos.
     */
    @Override
    public Usuario eliminarUsuario(Usuario usuario) {
        UsuarioDAO usuDAO = new UsuarioDAO();
        return usuDAO.eliminar(usuario);
    }

    /**
     * Método actualizar que llama al método actualizar de la clase UsuarioDAO
     * para actualizar una entidad Usuario.
     *
     * @param usuario a actualizar en la base de datos.
     */
    @Override
    public Usuario actualizarUsuario(Usuario usuarioBase, Usuario usuarioNuevo) {
        UsuarioDAO usuDAO = new UsuarioDAO();
        return usuDAO.actualizar(usuarioBase, usuarioNuevo);
    }

    /**
     * Método buscar que llama al método buscar de la clase UsuarioDAO para
     * buscar una entidad Usuario.
     *
     * @param usuario a buscar en la base de datos.
     */
    @Override
    public Usuario buscarUsuario(Usuario usuario) {
        UsuarioDAO usuDAO = new UsuarioDAO();
        return usuDAO.buscar(usuario);
    }

    /**
     * Método buscar todos que llama al método buscar todos de la clase
     * UsuarioDAO para buscar todos una entidad Usuario.
     *
     * @return regresa una lista de todos los usuarios.
     */
    @Override
    public List<Usuario> listaUsuario() {
        UsuarioDAO usuDAO = new UsuarioDAO();
        return usuDAO.buscarTodos();
    }

    /**
     * Metodo que regresa lista de publicaciones de un normal
     * @param normal creador de la publicacion
     * @return ArrayList de comunes
     */
    @Override
    public ArrayList<Comun> getComunesDeNormal(Normal normal) {
        ComunDAO comunDao = new ComunDAO();
        return comunDao.getComunesDeNormal(normal);
    }

    @Override
    public ArrayList<Comentario> buscarComentariosPorComun(String idPost) {
        ComunDAO comunDao=new ComunDAO();
        return comunDao.buscarComentariosPorComun(idPost);
    }
    
    @Override
    public Comun actualizarEditado(Comun entidad1, Comun entidad2){
        ComunDAO comunDao=new ComunDAO();
        return comunDao.actualizarEditado(entidad1,entidad2);
    }
    
    @Override
    public ArrayList<Comun> getComunesYAncDeAdmor(Admor admr) {
        ComunDAO comunDao=new ComunDAO();
        return comunDao.getComunesYAncDeAdmor(admr);
    }
}
