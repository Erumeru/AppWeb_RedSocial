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
    public Admor guardarAdmor(Admor admor);
    
    /**
     * Método eliminar Admor.
     * @param admor 
     */
    public Admor eliminarAdmor(Admor admor);
    
    /**
     * Método actualizar Admor.
     * @param admorBase
     * @param admor 
     */
    public Admor actualizarAdmor(Admor admorBase, Admor admorNuevo);
    
    /**
     * Método buscar Admor.
     * @param admor 
     */
    public Admor buscarAdmor(Admor admor);
    
    /**Método lista Admor.
     * 
     * @return 
     */
    public List<Admor> listaAdmor();

    /**
     * Método guardar Anclado.
     * @param anclado 
     */
    public Anclado guardarAnclado(Anclado anclado);
    
    /**
     * Método eliminar Anclado.
     * @param anclado 
     */
    public Anclado eliminarAnclado(Anclado anclado);
    
    /**
     * Método actualizar Anclado.
     * @param anclado 
     * @param ancladoNuevo 
     */
    public Anclado actualizarAnclado(Anclado ancladoBase, Anclado ancladoNuevo);
    
    /**
     * Método buscar Anclado.
     * @param anclado 
     */
    public Anclado buscarAnclado(Anclado anclado);
    
    /**
     * Método lista Anclado.
     * @return 
     */
    public List<Anclado> listaAnclado();
    
    /**
     * Método guardar Comentario.
     * @param comentario 
     */
    public Comentario guardarComentario(Comentario comentario);
    
    /**
     * Método eliminar Comentario.
     * @param comentario 
     */
    public Comentario eliminarComentario(Comentario comentario);
    
    /**
     * Método actualizar Comentario.
     * @param comentario 
     */
    public Comentario actualizarComentario(Comentario comentarioBasae, Comentario comentarioNuevo);
    
    /**
     * Método buscar Comentario.
     * @param comentario 
     */
    public Comentario buscarComentario(Comentario comentario);
    
    /**
     * Método lista Comentario.
     * @return 
     */
    public List<Comentario> listaComentario();
    
    /**
     * Método guardar Comun.
     * @param comun 
     */
    public Comun guardarComun(Comun comun);
    
    /**
     * Método eliminar Comun.
     * @param comun 
     */
    public Comun eliminarComun(Comun comun);
    
    /**
     * Método actualizar Comun.
     * @param comun 
     */
    public Comun actualizarComun(Comun comunBae, Comun comunNuevo);
    
    /**
     * Método buscar Comun.
     * @param comun 
     */
    public Comun buscarComun(Comun comun);
    
    /**
     * Método lista Comun.
     * @return 
     */
    public List<Comun> listaComun();
    
    /**
     * Método guardar Estado.
     * @param estado 
     */
    public Estado guardarEstado(Estado estado);
    
    /**
     * Método eliminar Estado.
     * @param estado 
     */
    public Estado eliminarEstado(Estado estado);
    
    /**
     * Método actualizar Estado.
     * @param estado 
     */
    public Estado actualizarEstado(Estado estadoBase, Estado estadoNuevo);
    
    /**
     * Método buscar Estado.
     * @param estado 
     */
    public Estado buscarEstado(Estado estado);
    
    /**
     * Método lista Estado.
     * @return 
     */
    public List<Estado> listaEstado();
    
    /**
     * Método guardar Municipio.
     * @param municipio 
     */
    public Municipio guardarMunicipio(Municipio municipio);
    
    /**
     * Método eliminar Municipio.
     * @param municipio 
     * @return  
     */
    public Municipio eliminarMunicipio(Municipio municipio);
    
    /**
     * Método actualizar Municipio.
     * @param municipio 
     * @return  
     */
    public Municipio actualizarMunicipio(Municipio municipioBase, Municipio municipioNuevo);
    
    /**
     * Método buscar Municipio.
     * @param municipio 
     * @return  
     */
    public Municipio buscarMunicipio(Municipio municipio);
    
    /**
     * Método lista Municipio.
     * @return 
     */
    public List<Municipio> listaMunicipio();
    
    /**
     * Método guardar Normal.
     * @param normal 
     * @return  
     */
    public Normal guardarNormal(Normal normal);
    
    /**
     * Método eliminar Normal.
     * @param normal 
     * @return  
     */
    public Normal eliminarNormal(Normal normal);
    
    /**
     * Método actualizar Normal.
     * @param normal 
     * @return  
     */
    public Normal actualizarNormal(Normal normalBase, Normal normalNuevo);
    
    /**
     * Método buscar Normal.
     * @param normal 
     * @return  
     */
    public Normal buscarNormal(Normal normal);
    
    /**
     * Método lista Normal.
     * @return 
     */
    public List<Normal> listaNormal();
    
    /**
     * Método guardar Post.
     * @param post 
     * @return  
     */
    public Post guardarPost(Post post);
    
    /**
     * Método eliminar Post.
     * @param post 
     * @return  
     */
    public Post eliminarPost(Post post);
    
    /**
     * Método actualizar Post.
     * @param post 
     * @return  
     */
    public Post actualizarPost(Post postBase, Post postNuevo);
    
    /**
     * Método buscar Post.
     * @param post 
     * @return  
     */
    public Post buscarPost(Post post);
    
    /**
     * Método lista Post.
     * @return 
     */
    public List<Post> listaPost();
    
    /**
     * Método guardar Usuario.
     * @param usuario 
     * @return  
     */
    public Usuario guardarUsuario(Usuario usuario);
    
    /**
     * Método eliminar Usuario.
     * @param usuario 
     * @return  
     */
    public Usuario eliminarUsuario(Usuario usuario);
    
    /**
     * Método actualizar Usuario.
     * @param usuario 
     * @return  
     */
    public Usuario actualizarUsuario(Usuario usuarioBase, Usuario usuarioNuevo);
    
    /**
     * Método buscar Usuario.
     * @param usuario 
     * @return  
     */
    public Usuario buscarUsuario(Usuario usuario);
    
    /**
     * Método lista Usuario.
     * @return 
     */
    public List<Usuario> listaUsuario();
}
