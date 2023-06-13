/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.interfaces;

import ObjNegocio.Admor;
import ObjNegocio.Anclado;
import ObjNegocio.Comentario;
import ObjNegocio.Normal;
import ObjNegocio.Comun;
import ObjNegocio.Estado;
import ObjNegocio.Municipio;
import ObjNegocio.Post;
import ObjNegocio.Usuario;
import java.util.List;


/**
 *
 * @author kim, carmen, elmer, marcos
 */
public interface IFachadaDatos {
    
    /**
     * Método guardar Admor.
     * @param admor 
     */
    public void guardarAdmor(Admor admor);
    
    /**
     * Método eliminar Admor.
     * @param admor 
     */
    public void eliminarAdmor(Admor admor);
    
    /**
     * Método actualizar Admor.
     * @param admor 
     */
    public void actualizarAdmor(Admor admor);
    
    /**
     * Método buscar Admor.
     * @param admor 
     */
    public void buscarAdmor(Admor admor);
    
    /**Método lista Admor.
     * 
     * @return 
     */
    public List<Admor> listaAdmor();

    /**
     * Método guardar Anclado.
     * @param anclado 
     */
    public void guardarAnclado(Anclado anclado);
    
    /**
     * Método eliminar Anclado.
     * @param anclado 
     */
    public void eliminarAnclado(Anclado anclado);
    
    /**
     * Método actualizar Anclado.
     * @param anclado 
     */
    public void actualizarAnclado(Anclado anclado);
    
    /**
     * Método buscar Anclado.
     * @param anclado 
     */
    public void buscarAnclado(Anclado anclado);
    
    /**
     * Método lista Anclado.
     * @return 
     */
    public List<Anclado> listaAnclado();
    
    /**
     * Método guardar Comentario.
     * @param comentario 
     */
    public void guardarComentario(Comentario comentario);
    
    /**
     * Método eliminar Comentario.
     * @param comentario 
     */
    public void eliminarComentario(Comentario comentario);
    
    /**
     * Método actualizar Comentario.
     * @param comentario 
     */
    public void actualizarComentario(Comentario comentario);
    
    /**
     * Método buscar Comentario.
     * @param comentario 
     */
    public void buscarComentario(Comentario comentario);
    
    /**
     * Método lista Comentario.
     * @return 
     */
    public List<Comentario> listaComentario();
    
    /**
     * Método guardar Comun.
     * @param comun 
     */
    public void guardarComun(Comun comun);
    
    /**
     * Método eliminar Comun.
     * @param comun 
     */
    public void eliminarComun(Comun comun);
    
    /**
     * Método actualizar Comun.
     * @param comun 
     */
    public void actualizarComun(Comun comun);
    
    /**
     * Método buscar Comun.
     * @param comun 
     */
    public void buscarComun(Comun comun);
    
    /**
     * Método lista Comun.
     * @return 
     */
    public List<Comun> listaComun();
    
    /**
     * Método guardar Estado.
     * @param estado 
     */
    public void guardarEstado(Estado estado);
    
    /**
     * Método eliminar Estado.
     * @param estado 
     */
    public void eliminarEstado(Estado estado);
    
    /**
     * Método actualizar Estado.
     * @param estado 
     */
    public void actualizarEstado(Estado estado);
    
    /**
     * Método buscar Estado.
     * @param estado 
     */
    public void buscarEstado(Estado estado);
    
    /**
     * Método lista Estado.
     * @return 
     */
    public List<Estado> listaEstado();
    
    /**
     * Método guardar Municipio.
     * @param municipio 
     */
    public void guardarMunicipio(Municipio municipio);
    
    /**
     * Método eliminar Municipio.
     * @param municipio 
     */
    public void eliminarMunicipio(Municipio municipio);
    
    /**
     * Método actualizar Municipio.
     * @param municipio 
     */
    public void actualizarMunicipio(Municipio municipio);
    
    /**
     * Método buscar Municipio.
     * @param municipio 
     */
    public void buscarMunicipio(Municipio municipio);
    
    /**
     * Método lista Municipio.
     * @return 
     */
    public List<Municipio> listaMunicipio();
    
    /**
     * Método guardar Normal.
     * @param normal 
     */
    public void guardarNormal(Normal normal);
    
    /**
     * Método eliminar Normal.
     * @param normal 
     */
    public void eliminarNormal(Normal normal);
    
    /**
     * Método actualizar Normal.
     * @param normal 
     */
    public void actualizarNormal(Normal normal);
    
    /**
     * Método buscar Normal.
     * @param normal 
     */
    public void buscarNormal(Normal normal);
    
    /**
     * Método lista Normal.
     * @return 
     */
    public List<Normal> listaNormal();
    
    /**
     * Método guardar Post.
     * @param post 
     */
    public void guardarPost(Post post);
    
    /**
     * Método eliminar Post.
     * @param post 
     */
    public void eliminarPost(Post post);
    
    /**
     * Método actualizar Post.
     * @param post 
     */
    public void actualizarPost(Post post);
    
    /**
     * Método buscar Post.
     * @param post 
     */
    public void buscarPost(Post post);
    
    /**
     * Método lista Post.
     * @return 
     */
    public List<Post> listaPost();
    
    /**
     * Método guardar Usuario.
     * @param usuario 
     */
    public void guardarUsuario(Usuario usuario);
    
    /**
     * Método eliminar Usuario.
     * @param usuario 
     */
    public void eliminarUsuario(Usuario usuario);
    
    /**
     * Método actualizar Usuario.
     * @param usuario 
     */
    public void actualizarUsuario(Usuario usuario);
    
    /**
     * Método buscar Usuario.
     * @param usuario 
     */
    public void buscarUsuario(Usuario usuario);
    
    /**
     * Método lista Usuario.
     * @return 
     */
    public List<Usuario> listaUsuario();
}
