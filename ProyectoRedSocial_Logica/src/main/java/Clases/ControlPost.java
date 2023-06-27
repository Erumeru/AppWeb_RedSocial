/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import ObjNegocio.Post;
import ObjNegocio.Anclado;
import ObjNegocio.Comun;
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

    public Post actualizarPost(Post post) {
        datos = FabricaDatos.dameInstancia();
        return datos.actualizarPost(post);
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

    public Anclado actualizarAnclado(Anclado anclado) {
        datos = FabricaDatos.dameInstancia();
        return datos.actualizarAnclado(anclado);
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

    public Comun actualizarComun(Comun comun) {
        datos = FabricaDatos.dameInstancia();
        return datos.actualizarComun(comun);
    }

    public Comun eliminarComun(Comun comun) {
        datos = FabricaDatos.dameInstancia();
        return datos.eliminarComun(comun);
    }

    public Comun guardarComun(Comun comun) {
        datos = FabricaDatos.dameInstancia();
        return datos.guardarComun(comun);
    }

}
