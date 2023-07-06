/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Clases;

import ObjNegocio.*;
import java.util.ArrayList;
import java.util.List;
import org.itson.excepciones.DAOException;

/**
 *
 * @author Marcos Toledo 00000234963
 */
public interface ILogica {

    public List<Usuario> listaUsuario();

    public Usuario buscarUsuario(Usuario usuario);

    public Usuario actualizarUsuario(Usuario usuarioBase, Usuario usuarioNuevo);

    public Usuario eliminarUsuario(Usuario usuario);

    public Usuario guardarUsuario(Usuario usuario);

    public List<Post> listaPost();

    public Post buscarPost(Post post);

    public Post actualizarPost(Post postBase, Post postNuevo);

    public Post eliminarPost(Post post);

    public Post guardarPost(Post post);

    public List<Normal> listaNormal();

    public Normal buscarNormal(Normal normal);

    public Normal actualizarNormal(Normal normalBase, Normal normalNuevo);

    public Normal eliminarNormal(Normal normal);

    public Normal guardarNormal(Normal normal);

    public List<Municipio> listaMunicipio();

    public Municipio buscarMunicipio(Municipio municipio);

    public Municipio actualizarMunicipio(Municipio municipioBase, Municipio municipioNuevo);

    public Municipio eliminarMunicipio(Municipio municipio);

    public Municipio guardarMunicipio(Municipio municipio);

    public List<Estado> listaEstado();

    public Estado buscarEstado(Estado estado);

    public Estado actualizarEstado(Estado estadoBase, Estado estadoNuevo);

    public Estado eliminarEstado(Estado estado);

    public Estado guardarEstado(Estado estado);

    public List<Comun> listaComun();

    public Comun buscarComun(Comun comun);

    public Comun actualizarComun(Comun comunBase, Comun comunNuevo);

    public Comun eliminarComun(Comun comun);

    public Comun guardarComun(Comun comun);

    public List<Comentario> listaComentario();

    public Comentario buscarComentario(Comentario comentario);

    public Comentario actualizarComentario(Comentario comentarioBase, Comentario comentarioNuevo);

    public Comentario eliminarComentario(Comentario comentario);

    public Comentario guardarComentario(Comentario comentario);

    public List<Anclado> listaAnclado();

    public Anclado buscarAnclado(Anclado anclado);

    public Anclado actualizarAnclado(Anclado ancladoBase, Anclado ancladoNuevo);

    public Anclado eliminarAnclado(Anclado anclado);

    public Anclado guardarAnclado(Anclado anclado);

    public List<Admor> listaAdmor();

    public Admor buscarAdmor(Admor admor);

    public Admor actualizarAdmor(Admor admorBase, Admor admorNuevo);

    public Admor eliminarAdmor(Admor admor);

    public Admor guardarAdmor(Admor admor) throws DAOException;

    public ArrayList<Comun> getComunesDeNormal(Normal normal);
}
