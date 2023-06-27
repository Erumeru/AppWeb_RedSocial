/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import ObjNegocio.*;
import java.util.List;
import org.itson.appimplementacion.FachadaDatos;
import org.itson.interfaces.IFachadaDatos;

/**
 *
 * @author Marcos Toledo 00000234963
 */
public class ControlUsuario {

    public IFachadaDatos datos = new FachadaDatos();

    public List<Usuario> listaUsuario() {
        datos = (IFachadaDatos) FabricaLogica.crearInstancia();
        return datos.listaUsuario();
    }

    public void buscarUsuario(Usuario usuario) {
        datos = (IFachadaDatos) FabricaLogica.crearInstancia();
    }

    public void actualizarUsuario(Usuario usuario) {
        datos = (IFachadaDatos) FabricaLogica.crearInstancia();
    }

    public void eliminarUsuario(Usuario usuario) {
        datos = (IFachadaDatos) FabricaLogica.crearInstancia();
    }

    public void guardarUsuario(Usuario usuario) {
        datos = (IFachadaDatos) FabricaLogica.crearInstancia();
    }

    public List<Admor> listaAdmor() {
        datos = (IFachadaDatos) FabricaLogica.crearInstancia();
        return null;
    }

    public void buscarAdmor(Admor admor) {
        datos = (IFachadaDatos) FabricaLogica.crearInstancia();
    }

    public void actualizarAdmor(Admor admor) {
        datos = (IFachadaDatos) FabricaLogica.crearInstancia();
    }

    public void eliminarAdmor(Admor admor) {
        datos = (IFachadaDatos) FabricaLogica.crearInstancia();
    }

    public void guardarAdmor(Admor admor) {
        datos = (IFachadaDatos) FabricaLogica.crearInstancia();
    }

    public List<Normal> listaNormal(){
        datos = (IFachadaDatos) FabricaLogica.crearInstancia();
        return null;
    }

    public void buscarNormal(Normal normal){
        datos = (IFachadaDatos) FabricaLogica.crearInstancia();
    }

    public void actualizarNormal(Normal normal){
        datos = (IFachadaDatos) FabricaLogica.crearInstancia();
    }

    public void eliminarNormal(Normal normal){
        datos = (IFachadaDatos) FabricaLogica.crearInstancia();
    }

    public void guardarNormal(Normal normal){
        datos = (IFachadaDatos) FabricaLogica.crearInstancia();
    }
}
