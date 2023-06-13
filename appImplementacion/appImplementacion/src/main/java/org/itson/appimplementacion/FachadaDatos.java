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

    @Override
    public void guardarAdmor(Admor admor) {
       AdmorDAO admorDAO = new AdmorDAO();
        try {
            admorDAO.guardar(admor);
        } catch (DAOException ex) {
            Logger.getLogger(FachadaDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminarAdmor(Admor admor) {
        AdmorDAO admorDAO = new AdmorDAO();
        admorDAO.eliminar(admor);
    }

    @Override
    public void actualizarAdmor(Admor admor) {
        AdmorDAO admorDAO = new AdmorDAO();
        admorDAO.actualizar(admor, admor);
    }

    @Override
    public void buscarAdmor(Admor admor) {
        AdmorDAO admorDAO = new AdmorDAO();
        admorDAO.buscar(admor);
    }

    @Override
    public List<Admor> listaAdmor() {
         AdmorDAO admorDAO = new AdmorDAO();
         return admorDAO.buscarTodos();
    }

    @Override
    public void guardarAnclado(Anclado anclado) {
       AncladoDAO ancladoDAO = new AncladoDAO();
        try {
            ancladoDAO.guardar(anclado);
        } catch (DAOException ex) {
            Logger.getLogger(FachadaDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminarAnclado(Anclado anclado) {
        AncladoDAO ancladoDAO = new AncladoDAO();
        ancladoDAO.eliminar(anclado);
    }

    @Override
    public void actualizarAnclado(Anclado anclado) {
        AncladoDAO ancladoDAO = new AncladoDAO();
        ancladoDAO.actualizar(anclado, anclado);
    }

    @Override
    public void buscarAnclado(Anclado anclado) {
       AncladoDAO ancladoDAO = new AncladoDAO();
       ancladoDAO.buscar(anclado);
    }

    @Override
    public List<Anclado> listaAnclado() {
        AncladoDAO ancladoDAO = new AncladoDAO();
        return ancladoDAO.buscarTodos();
    }

    @Override
    public void guardarComentario(Comentario comentario) {
        ComentarioDAO comentDAO = new ComentarioDAO();
        try {
            comentDAO.guardar(comentario);
        } catch (DAOException ex) {
            Logger.getLogger(FachadaDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminarComentario(Comentario comentario) {
        ComentarioDAO comentDAO = new ComentarioDAO();
        comentDAO.eliminar(comentario);
    }

    @Override
    public void actualizarComentario(Comentario comentario) {
        ComentarioDAO comentDAO = new ComentarioDAO();
        comentDAO.actualizar(comentario, comentario);
    }

    @Override
    public void buscarComentario(Comentario comentario) {
        ComentarioDAO comentDAO = new ComentarioDAO();
        comentDAO.buscar(comentario);
    }

    @Override
    public List<Comentario> listaComentario() {
        ComentarioDAO comentDAO = new ComentarioDAO();
        return comentDAO.buscarTodos();
    }

    @Override
    public void guardarComun(Comun comun) {
        ComunDAO comunDAO = new ComunDAO();
        try {
            comunDAO.guardar(comun);
        } catch (DAOException ex) {
            Logger.getLogger(FachadaDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminarComun(Comun comun) {
        ComunDAO comunDAO = new ComunDAO();
        comunDAO.eliminar(comun);
    }

    @Override
    public void actualizarComun(Comun comun) {
        ComunDAO comunDAO = new ComunDAO();
        comunDAO.actualizar(comun, comun);
    }

    @Override
    public void buscarComun(Comun comun) {
        ComunDAO comunDAO = new ComunDAO();
        comunDAO.buscar(comun);
    }

    @Override
    public List<Comun> listaComun() {
        ComunDAO comunDAO = new ComunDAO();
        return comunDAO.buscarTodos();
    }

    @Override
    public void guardarEstado(Estado estado) {
        EstadoDAO estadoDAO = new EstadoDAO();
        try {
            estadoDAO.guardar(estado);
        } catch (DAOException ex) {
            Logger.getLogger(FachadaDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminarEstado(Estado estado) {
        EstadoDAO estadoDAO = new EstadoDAO();
        estadoDAO.eliminar(estado);
    }

    @Override
    public void actualizarEstado(Estado estado) {
        EstadoDAO estadoDAO = new EstadoDAO();
        estadoDAO.actualizar(estado, estado);
    }

    @Override
    public void buscarEstado(Estado estado) {
        EstadoDAO estadoDAO = new EstadoDAO();
        estadoDAO.buscar(estado);
    }

    @Override
    public List<Estado> listaEstado() {
        EstadoDAO estadoDAO = new EstadoDAO();
        return estadoDAO.buscarTodos();
    }

    @Override
    public void guardarMunicipio(Municipio municipio) {
        MunicipioDAO muniDAO = new MunicipioDAO();
        try {
            muniDAO.guardar(municipio);
        } catch (DAOException ex) {
            Logger.getLogger(FachadaDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminarMunicipio(Municipio municipio) {
        MunicipioDAO muniDAO = new MunicipioDAO();
        muniDAO.eliminar(municipio);
    }

    @Override
    public void actualizarMunicipio(Municipio municipio) {
        MunicipioDAO muniDAO = new MunicipioDAO();
        muniDAO.actualizar(municipio, municipio);
    }

    @Override
    public void buscarMunicipio(Municipio municipio) {
        MunicipioDAO muniDAO = new MunicipioDAO();
        muniDAO.buscar(municipio);
    }

    @Override
    public List<Municipio> listaMunicipio() {
       MunicipioDAO muniDAO = new MunicipioDAO();
       return muniDAO.buscarTodos();
    }

    @Override
    public void guardarNormal(Normal normal) {
       NormalDAO normalDAO = new NormalDAO();
        try {
            normalDAO.guardar(normal);
        } catch (DAOException ex) {
            Logger.getLogger(FachadaDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminarNormal(Normal normal) {
        NormalDAO normalDAO = new NormalDAO();
        normalDAO.eliminar(normal);
    }

    @Override
    public void actualizarNormal(Normal normal) {
         NormalDAO normalDAO = new NormalDAO();
         normalDAO.actualizar(normal, normal);
    }

    @Override
    public void buscarNormal(Normal normal) {
         NormalDAO normalDAO = new NormalDAO();
         normalDAO.buscar(normal);
    }

    @Override
    public List<Normal> listaNormal() {
        NormalDAO normalDAO = new NormalDAO();
        return normalDAO.buscarTodos();
    }

    @Override
    public void guardarPost(Post post) {
        PostDAO postDAO = new PostDAO();
        try {
            postDAO.guardar(post);
        } catch (DAOException ex) {
            Logger.getLogger(FachadaDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminarPost(Post post) {
        PostDAO postDAO = new PostDAO();
        postDAO.eliminar(post);
    }

    @Override
    public void actualizarPost(Post post) {
       PostDAO postDAO = new PostDAO();
       postDAO.actualizar(post, post);
    }

    @Override
    public void buscarPost(Post post) {
        PostDAO postDAO = new PostDAO();
        postDAO.buscar(post);
    }

    @Override
    public List<Post> listaPost() {
        PostDAO postDAO = new PostDAO();
        return postDAO.buscarTodos();
    }

    @Override
    public void guardarUsuario(Usuario usuario) {
       UsuarioDAO usuDAO = new UsuarioDAO();
        try {
            usuDAO.guardar(usuario);
        } catch (DAOException ex) {
            Logger.getLogger(FachadaDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminarUsuario(Usuario usuario) {
        UsuarioDAO usuDAO = new UsuarioDAO();
        usuDAO.eliminar(usuario);
    }

    @Override
    public void actualizarUsuario(Usuario usuario) {
        UsuarioDAO usuDAO = new UsuarioDAO();
        usuDAO.actualizar(usuario, usuario);
    }

    @Override
    public void buscarUsuario(Usuario usuario) {
        UsuarioDAO usuDAO = new UsuarioDAO();
        usuDAO.buscar(usuario);
    }

    @Override
    public List<Usuario> listaUsuario() {
       UsuarioDAO usuDAO = new UsuarioDAO();
       return usuDAO.buscarTodos();
    }
    
}
