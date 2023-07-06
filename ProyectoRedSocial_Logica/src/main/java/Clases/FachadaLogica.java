/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import ObjNegocio.*;
import ObjNegocio.Admor;
import ObjNegocio.Anclado;
import ObjNegocio.Comentario;
import ObjNegocio.Comun;
import ObjNegocio.Estado;
import ObjNegocio.Municipio;
import ObjNegocio.Normal;
import ObjNegocio.Post;
import ObjNegocio.Usuario;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import org.itson.excepciones.DAOException;

/**
 *
 * @author Marcos Toledo 00000234963
 */
public class FachadaLogica implements ILogica {

    ControlUsuario ctrlUsuario;
    ControlPost ctrlPost;
    ControlComentario ctrlComentario;

    @Override
    public List<Usuario> listaUsuario() {
        ctrlUsuario = new ControlUsuario();
        List<Usuario> datosARecuperar = new ArrayList<>();
        datosARecuperar.addAll(ctrlUsuario.listaUsuario());
        return datosARecuperar;
    }

    @Override
    public Usuario buscarUsuario(Usuario usuario) {
        ctrlUsuario = new ControlUsuario();
        Usuario us = new Usuario();
        us = ctrlUsuario.buscarUsuario(usuario);
        return us;
    }

    @Override
    public Usuario actualizarUsuario(Usuario usuarioBase, Usuario usuarioNuevo) {
        ctrlUsuario = new ControlUsuario();
        Usuario us = new Usuario();
        us = ctrlUsuario.actualizarUsuario(usuarioBase, usuarioNuevo);
        return us;
    }

    @Override
    public Usuario eliminarUsuario(Usuario usuario) {
        ctrlUsuario = new ControlUsuario();
        Usuario us = new Usuario();
        us = ctrlUsuario.eliminarUsuario(usuario);
        return us;
    }

    @Override
    public Usuario guardarUsuario(Usuario usuario) {
        ctrlUsuario = new ControlUsuario();
        Usuario us = new Usuario();
        us = ctrlUsuario.guardarUsuario(usuario);
        return us;
    }

    @Override
    public List<Post> listaPost() {
        ctrlPost = new ControlPost();
        List<Post> datosARecuperar = new ArrayList<>();
        datosARecuperar.addAll(ctrlPost.listaPost());
        return datosARecuperar;
    }

    @Override
    public Post buscarPost(Post post) {
        ctrlPost = new ControlPost();
        Post pt = new Post();
        pt = ctrlPost.buscarPost(post);
        return pt;
    }

    @Override
    public Post actualizarPost(Post postBase, Post postNuevo) {
        ctrlPost = new ControlPost();
        Post pt = new Post();
        pt = ctrlPost.actualizarPost(postBase, postNuevo);
        return pt;
    }

    @Override
    public Post eliminarPost(Post post) {
        ctrlPost = new ControlPost();
        Post pt = new Post();
        pt = ctrlPost.eliminarPost(post);
        return pt;
    }

    @Override
    public Post guardarPost(Post post) {
        ctrlPost = new ControlPost();
        Post pt = new Post();
        pt = ctrlPost.guardarPost(post);
        return pt;
    }

    @Override
    public List<Normal> listaNormal() {
        ctrlUsuario = new ControlUsuario();
        List<Normal> datosARecuperar = new ArrayList<>();
        datosARecuperar.addAll(ctrlUsuario.listaNormal());
        return datosARecuperar;
    }

    @Override
    public Normal buscarNormal(Normal normal) {
        ctrlUsuario = new ControlUsuario();
        Normal nl = new Normal();
        nl = ctrlUsuario.buscarNormal(normal);
        return nl;
    }

    @Override
    public Normal actualizarNormal(Normal normalBase, Normal normalNuevo) {
        ctrlUsuario = new ControlUsuario();
        Normal nl = new Normal();
        nl = ctrlUsuario.actualizarNormal(normalBase, normalNuevo);
        return nl;
    }

    @Override
    public Normal eliminarNormal(Normal normal) {
        ctrlUsuario = new ControlUsuario();
        Normal nl = new Normal();
        nl = ctrlUsuario.eliminarNormal(normal);
        return nl;
    }

    @Override
    public Normal guardarNormal(Normal normal) {
        ctrlUsuario = new ControlUsuario();
        Normal nl = new Normal();
        nl = ctrlUsuario.guardarNormal(normal);
        return nl;
    }

    @Override
    public List<Municipio> listaMunicipio() {
        ctrlUsuario = new ControlUsuario();
        List<Municipio> datosARecuperar = new ArrayList<>();
        datosARecuperar.addAll(ctrlUsuario.listaMunicipio());
        return datosARecuperar;
    }

    @Override
    public Municipio buscarMunicipio(Municipio municipio) {
        ctrlUsuario = new ControlUsuario();
        Municipio mp = new Municipio();
        mp = ctrlUsuario.buscarMunicipio(municipio);
        return mp;
    }

    @Override
    public Municipio actualizarMunicipio(Municipio municipioBase, Municipio municipioNuevo) {
        ctrlUsuario = new ControlUsuario();
        Municipio mp = new Municipio();
        mp = ctrlUsuario.actualizarMunicipio(municipioBase, municipioNuevo);
        return mp;
    }

    @Override
    public Municipio eliminarMunicipio(Municipio municipio) {
        ctrlUsuario = new ControlUsuario();
        Municipio mp = new Municipio();
        mp = ctrlUsuario.eliminarMunicipio(municipio);
        return mp;
    }

    @Override
    public Municipio guardarMunicipio(Municipio municipio) {
        ctrlUsuario = new ControlUsuario();
        Municipio mp = new Municipio();
        mp = ctrlUsuario.guardarMunicipio(municipio);
        return mp;
    }

    @Override
    public List<Estado> listaEstado() {
        ctrlUsuario = new ControlUsuario();
        List<Estado> datosARecuperar = new ArrayList<>();
        datosARecuperar.addAll(ctrlUsuario.listaEstado());
        return datosARecuperar;
    }

    @Override
    public Estado buscarEstado(Estado estado) {
        ctrlUsuario = new ControlUsuario();
        Estado et = new Estado();
        et = ctrlUsuario.buscarEstado(estado);
        return et;
    }

    @Override
    public Estado actualizarEstado(Estado estadoBase, Estado estadoNuevo) {
        ctrlUsuario = new ControlUsuario();
        Estado et = new Estado();
        et = ctrlUsuario.actualizarEstado(estadoBase, estadoNuevo);
        return et;
    }

    @Override
    public Estado eliminarEstado(Estado estado) {
        ctrlUsuario = new ControlUsuario();
        Estado et = new Estado();
        et = ctrlUsuario.eliminarEstado(estado);
        return et;
    }

    @Override
    public Estado guardarEstado(Estado estado) {
        ctrlUsuario = new ControlUsuario();
        Estado et = new Estado();
        et = ctrlUsuario.guardarEstado(estado);
        return et;
    }

    @Override
    public List<Comun> listaComun() {
        ctrlPost = new ControlPost();
        List<Comun> datosARecuperar = new ArrayList<>();
        datosARecuperar.addAll(ctrlPost.listaComun());
        return datosARecuperar;
    }

    @Override
    public Comun buscarComun(Comun comun) {
        ctrlPost = new ControlPost();
        Comun cn = new Comun(new Date(),  "titulo", "contenido");
        cn = ctrlPost.buscarComun(comun);
        return cn;
    }

    @Override
    public Comun actualizarComun(Comun comunBase, Comun comunNuevo) {
        ctrlPost = new ControlPost();
        Comun cn = new Comun(new Date(),  "titulo", "contenido");
        cn = ctrlPost.actualizarComun(comunBase, comunNuevo);
        return cn;
    }

    @Override
    public Comun eliminarComun(Comun comun) {
        ctrlPost = new ControlPost();
        Comun cn = new Comun(new Date(),  "titulo", "contenido");
        cn = ctrlPost.eliminarComun(comun);
        return cn;
    }

    @Override
    public Comun guardarComun(Comun comun) {
        ctrlPost = new ControlPost();
        Comun cn = new Comun(new Date(),  "titulo", "contenido");
        cn = ctrlPost.guardarComun(comun);
        return cn;
    }

    @Override
    public List<Comentario> listaComentario() {
        ctrlComentario = new ControlComentario();
        List<Comentario> datosARecuperar = new ArrayList<>();
        datosARecuperar.addAll(ctrlComentario.listaComentario());
        return datosARecuperar;
    }

    @Override
    public Comentario buscarComentario(Comentario comentario) {
        ctrlComentario = new ControlComentario();
        Comentario com = new Comentario();
        com = ctrlComentario.buscarComentario(comentario);
        return com;
    }

    @Override
    public Comentario actualizarComentario(Comentario comentarioBase, Comentario comentarioNuevo) {
        ctrlComentario = new ControlComentario();
        Comentario com = new Comentario();
        com = ctrlComentario.actualizarComentario(comentarioBase, comentarioNuevo);
        return com;
    }

    @Override
    public Comentario eliminarComentario(Comentario comentario) {
        ctrlComentario = new ControlComentario();
        Comentario com = new Comentario();
        com = ctrlComentario.eliminarComentario(comentario);
        return com;
    }

    @Override
    public Comentario guardarComentario(Comentario comentario) {
        ctrlComentario = new ControlComentario();
        Comentario com = new Comentario();
        com = ctrlComentario.guardarComentario(comentario);
        return com;
    }

    @Override
    public List<Anclado> listaAnclado() {
        ctrlPost = new ControlPost();
        List<Anclado> datosARecuperar = new ArrayList<>();
        datosARecuperar.addAll(ctrlPost.listaAnclado());
        return datosARecuperar;
    }

    @Override
    public Anclado buscarAnclado(Anclado anclado) {
        ctrlPost = new ControlPost();
        Anclado an = new Anclado(new Date(), "titulo", "contenido");
        an = ctrlPost.buscarAnclado(anclado);
        return an;
    }

    @Override
    public Anclado actualizarAnclado(Anclado ancladoBase, Anclado ancladoNuevo) {
        ctrlPost = new ControlPost();
        Anclado an = new Anclado(new Date(), "titulo", "contenido");
        an = ctrlPost.actualizarAnclado(ancladoBase, ancladoNuevo);
        return an;
    }

    @Override
    public Anclado eliminarAnclado(Anclado anclado) {
        ctrlPost = new ControlPost();
        Anclado an = new Anclado(new Date(), "titulo", "contenido");
        an = ctrlPost.eliminarAnclado(anclado);
        return an;
    }

    @Override
    public Anclado guardarAnclado(Anclado anclado) {
        ctrlPost = new ControlPost();
        Anclado an = new Anclado(new Date(), "titulo", "contenido");
        an = ctrlPost.guardarAnclado(anclado);
        return an;
    }

    @Override
    public List<Admor> listaAdmor() {
        ctrlUsuario = new ControlUsuario();
        List<Admor> datosARecuperar = new ArrayList<>();
        datosARecuperar.addAll(ctrlUsuario.listaAdmor());
        return datosARecuperar;
    }

    @Override
    public Admor buscarAdmor(Admor admor) {
        ctrlUsuario = new ControlUsuario();
        Admor ad = new Admor();
        ad = ctrlUsuario.buscarAdmor(admor);
        return ad;
    }

    @Override
    public Admor actualizarAdmor(Admor admorBase, Admor admorNuevo) {
        ctrlUsuario = new ControlUsuario();
        Admor ad = new Admor();
        ad = ctrlUsuario.actualizarAdmor(admorBase, admorNuevo);
        return ad;
    }

    @Override
    public Admor eliminarAdmor(Admor admor) {
        ctrlUsuario = new ControlUsuario();
        Admor ad = new Admor();
        ad = ctrlUsuario.eliminarAdmor(admor);
        return ad;
    }

    @Override
    public Admor guardarAdmor(Admor admor) throws DAOException{
        ctrlUsuario = new ControlUsuario();
        Admor ad = new Admor();
        ad = ctrlUsuario.guardarAdmor(admor);
        return ad;
    }

    @Override
    public ArrayList<Comun> getComunesDeNormal(Normal normal) {
        ctrlPost = new ControlPost();
        ArrayList<Comun> listaDePost=new ArrayList<>();
        listaDePost=ctrlPost.getComunesDeNormal(normal);
        return listaDePost;
    }

}
