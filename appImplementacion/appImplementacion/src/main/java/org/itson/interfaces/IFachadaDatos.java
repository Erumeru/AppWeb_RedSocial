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
    
    public void guardarAdmor(Admor admor);
    
    public void eliminarAdmor(Admor admor);
    
    public void actualizarAdmor(Admor admor);
    
    public void buscarAdmor(Admor admor);
    
    public List<Admor> listaAdmor();

    public void guardarAnclado(Anclado anclado);
    
    public void eliminarAnclado(Anclado anclado);
    
    public void actualizarAnclado(Anclado anclado);
    
    public void buscarAnclado(Anclado anclado);
    
    public List<Anclado> listaAnclado();
    
    public void guardarComentario(Comentario comentario);
    
    public void eliminarComentario(Comentario comentario);
    
    public void actualizarComentario(Comentario comentario);
    
    public void buscarComentario(Comentario comentario);
    
    public List<Comentario> listaComentario();
    
    public void guardarComun(Comun comun);
    
    public void eliminarComun(Comun comun);
    
    public void actualizarComun(Comun comun);
    
    public void buscarComun(Comun comun);
    
    public List<Comun> listaComun();
    
    public void guardarEstado(Estado estado);
    
    public void eliminarEstado(Estado estado);
    
    public void actualizarEstado(Estado estado);
    
    public void buscarEstado(Estado estado);
    
    public List<Estado> listaEstado();
    
    public void guardarMunicipio(Municipio municipio);
    
    public void eliminarMunicipio(Municipio municipio);
    
    public void actualizarMunicipio(Municipio municipio);
    
    public void buscarMunicipio(Municipio municipio);
    
    public List<Municipio> listaMunicipio();
    
    public void guardarNormal(Normal normal);
    
    public void eliminarNormal(Normal normal);
    
    public void actualizarNormal(Normal normal);
    
    public void buscarNormal(Normal normal);
    
    public List<Normal> listaNormal();
    
    public void guardarPost(Post post);
    
    public void eliminarPost(Post post);
    
    public void actualizarPost(Post post);
    
    public void buscarPost(Post post);
    
    public List<Post> listaPost();
    
    public void guardarUsuario(Usuario usuario);
    
    public void eliminarUsuario(Usuario usuario);
    
    public void actualizarUsuario(Usuario usuario);
    
    public void buscarUsuario(Usuario usuario);
    
    public List<Usuario> listaUsuario();
}
