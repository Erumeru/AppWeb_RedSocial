/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import ObjNegocio.Admor;
import ObjNegocio.Post;
import ObjNegocio.Anclado;
import ObjNegocio.Comentario;
import ObjNegocio.Comun;
import ObjNegocio.Normal;
import java.util.ArrayList;
import java.util.List;
import org.itson.appimplementacion.FabricaDatos;
import org.itson.appimplementacion.FachadaDatos;
import org.itson.interfaces.IFachadaDatos;

/**
 *
 * @author Marcos Toledo 00000234963
 */
public class ControlPost {

    public IFachadaDatos datos = new FachadaDatos();

    public List<Post> listaPost() {
        datos = FabricaDatos.dameInstancia();
        return datos.listaPost();
    }

    public Post buscarPost(Post post) {
        datos = FabricaDatos.dameInstancia();
        return datos.buscarPost(post);
    }

    public Post actualizarPost(Post postBase, Post postNuevo) {
        datos = FabricaDatos.dameInstancia();
        return datos.actualizarPost(postBase, postNuevo);
    }

    public Post eliminarPost(Post post) {
        datos = FabricaDatos.dameInstancia();
        return datos.eliminarPost(post);
    }

    public Post guardarPost(Post post) {
        datos = FabricaDatos.dameInstancia();
        return datos.guardarPost(post);
    }

    public List<Anclado> listaAnclado() {
        datos = FabricaDatos.dameInstancia();
        return datos.listaAnclado();
    }

    public Anclado buscarAnclado(Anclado anclado) {
        datos = FabricaDatos.dameInstancia();
        return datos.buscarAnclado(anclado);
    }

    public Anclado actualizarAnclado(Anclado ancladoBase, Anclado ancladoNuevo) {
        datos = FabricaDatos.dameInstancia();
        return datos.actualizarAnclado(ancladoBase, ancladoNuevo);
    }

    public Anclado eliminarAnclado(Anclado anclado) {
        datos = FabricaDatos.dameInstancia();
        return datos.eliminarAnclado(anclado);
    }

    public Anclado guardarAnclado(Anclado anclado) {
        datos = FabricaDatos.dameInstancia();
        return datos.guardarAnclado(anclado);
    }

    public List<Comun> listaComun() {
        datos = FabricaDatos.dameInstancia();
        return datos.listaComun();
    }

    public Comun buscarComun(Comun comun) {
        datos = FabricaDatos.dameInstancia();
        return datos.buscarComun(comun);
    }

    public Comun actualizarComun(Comun comunBase, Comun comunNuevo) {
        datos = FabricaDatos.dameInstancia();
        return datos.actualizarComun(comunBase, comunNuevo);
    }

    public Comun eliminarComun(Comun comun) {
        datos = FabricaDatos.dameInstancia();
        return datos.eliminarComun(comun);
    }

    public Comun guardarComun(Comun comun) {
        datos = FabricaDatos.dameInstancia();
        return datos.guardarComun(comun);
    }

    public ArrayList<Comun> getComunesDeNormal(Normal normal) {
        datos = FabricaDatos.dameInstancia();
        return datos.getComunesDeNormal(normal);
    }

    public ArrayList<Comentario> buscarComentariosPorComun(String idPost) {
        datos = FabricaDatos.dameInstancia();
        return datos.buscarComentariosPorComun(idPost);
    }

    public Comun actualizarEditado(Comun entidad1, Comun entidad2) {
        datos = FabricaDatos.dameInstancia();
        return datos.actualizarEditado(entidad1, entidad2);
    }
    
    public ArrayList<Comun> getComunesYAncDeAdmor(Admor admr) {
                datos = FabricaDatos.dameInstancia();
        return datos.getComunesYAncDeAdmor(admr);

    }
}
