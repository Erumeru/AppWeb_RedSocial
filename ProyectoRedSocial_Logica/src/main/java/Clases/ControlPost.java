/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;


import ObjNegocio.Post;
import ObjNegocio.Anclado;
import ObjNegocio.Comun;
import java.util.List;
import org.itson.appimplementacion.FachadaDatos;
import org.itson.interfaces.IFachadaDatos;

/**
 *
 * @author Marcos Toledo 00000234963
 */
public class ControlPost {
    
     public IFachadaDatos datos = new FachadaDatos();
     
     public List<Post> listaPost() {
        datos = (IFachadaDatos) FabricaLogica.crearInstancia();
        return datos.listaPost();
    }

    public Post buscarPost(Post post) {
        datos = (IFachadaDatos) FabricaLogica.crearInstancia();
        return datos.buscarPost(post);
    }

    public Post actualizarPost(Post post) {
        datos = (IFachadaDatos) FabricaLogica.crearInstancia();
        return datos.actualizarPost(post);
    }

    public Post eliminarPost(Post post) {
        datos = (IFachadaDatos) FabricaLogica.crearInstancia();
        return datos.eliminarPost(post);
    }

    public Post guardarPost(Post post) {
        datos = (IFachadaDatos) FabricaLogica.crearInstancia();
        return datos.guardarPost(post);
    }

    public List<Anclado> listaAnclado() {
        datos = (IFachadaDatos) FabricaLogica.crearInstancia();
        return datos.listaAnclado();
    }

    public Anclado buscarAnclado(Anclado anclado) {
        datos = (IFachadaDatos) FabricaLogica.crearInstancia();
        return datos.buscarAnclado(anclado);
    }

    public Anclado actualizarAnclado(Anclado anclado) {
        datos = (IFachadaDatos) FabricaLogica.crearInstancia();
        return datos.actualizarAnclado(anclado);
    }

    public Anclado eliminarAnclado(Anclado anclado) {
        datos = (IFachadaDatos) FabricaLogica.crearInstancia();
        return datos.eliminarAnclado(anclado);
    }

    public Anclado guardarAnclado(Anclado anclado) {
        datos = (IFachadaDatos) FabricaLogica.crearInstancia();
        return datos.guardarAnclado(anclado);
    }

    public List<Comun> listaComun(){
        datos = (IFachadaDatos) FabricaLogica.crearInstancia();
        return datos.listaComun();
    }

    public Comun buscarComun(Comun comun){
        datos = (IFachadaDatos) FabricaLogica.crearInstancia();
        return datos.buscarComun(comun);
    }

    public Comun actualizarComun(Comun comun){
        datos = (IFachadaDatos) FabricaLogica.crearInstancia();
        return datos.actualizarComun(comun);
    }

    public Comun eliminarComun(Comun comun){
        datos = (IFachadaDatos) FabricaLogica.crearInstancia();
        return datos.eliminarComun(comun);
    }

    public Comun guardarComun(Comun comun){
        datos = (IFachadaDatos) FabricaLogica.crearInstancia();
        return datos.guardarComun(comun);
    }
    
}
