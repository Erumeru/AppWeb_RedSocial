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
 * @author Marcos x Elmer x Kim x Carmen
 */
public class ControlUsuario {

    public IFachadaDatos datos = new FachadaDatos();

    public List<Usuario> listaUsuario() {
        datos = (IFachadaDatos) FabricaLogica.crearInstancia();
        return datos.listaUsuario();
    }

    public Usuario buscarUsuario(Usuario usuario) {
        datos = (IFachadaDatos) FabricaLogica.crearInstancia();
        return datos.buscarUsuario(usuario);
    }

    public Usuario actualizarUsuario(Usuario usuario) {
        datos = (IFachadaDatos) FabricaLogica.crearInstancia();
        return datos.actualizarUsuario(usuario);
    }

    public Usuario eliminarUsuario(Usuario usuario) {
        datos = (IFachadaDatos) FabricaLogica.crearInstancia();
        return datos.eliminarUsuario(usuario);
    }

    public Usuario guardarUsuario(Usuario usuario) {
        datos = (IFachadaDatos) FabricaLogica.crearInstancia();
        return datos.guardarUsuario(usuario);
    }

    public List<Admor> listaAdmor() {
        datos = (IFachadaDatos) FabricaLogica.crearInstancia();
        return datos.listaAdmor();
    }

    public Admor buscarAdmor(Admor admor) {
        datos = (IFachadaDatos) FabricaLogica.crearInstancia();
        return datos.buscarAdmor(admor);
    }

    public Admor actualizarAdmor(Admor admor) {
        datos = (IFachadaDatos) FabricaLogica.crearInstancia();
        return datos.actualizarAdmor(admor);
    }

    public Admor eliminarAdmor(Admor admor) {
        datos = (IFachadaDatos) FabricaLogica.crearInstancia();
        return datos.eliminarAdmor(admor);
    }

    public Admor guardarAdmor(Admor admor) {
        datos = (IFachadaDatos) FabricaLogica.crearInstancia();
        return datos.guardarAdmor(admor);
    }

    public List<Normal> listaNormal() {
        datos = (IFachadaDatos) FabricaLogica.crearInstancia();
        return datos.listaNormal();
    }

    public Normal buscarNormal(Normal normal) {
        datos = (IFachadaDatos) FabricaLogica.crearInstancia();
        return datos.buscarNormal(normal);
    }

    public Normal actualizarNormal(Normal normal) {
        datos = (IFachadaDatos) FabricaLogica.crearInstancia();
        return datos.actualizarNormal(normal);
    }

    public Normal eliminarNormal(Normal normal) {
        datos = (IFachadaDatos) FabricaLogica.crearInstancia();
        return datos.eliminarNormal(normal);
    }

    public Normal guardarNormal(Normal normal) {
        datos = (IFachadaDatos) FabricaLogica.crearInstancia();
        return datos.guardarNormal(normal);
    }

    public List<Municipio> listaMunicipio() {
        datos = (IFachadaDatos) FabricaLogica.crearInstancia();
        return datos.listaMunicipio();

    }

    public Municipio buscarMunicipio(Municipio municipio) {
        datos = (IFachadaDatos) FabricaLogica.crearInstancia();
        return datos.buscarMunicipio(municipio);

    }

    public Municipio actualizarMunicipio(Municipio municipio) {
        datos = (IFachadaDatos) FabricaLogica.crearInstancia();
        return datos.actualizarMunicipio(municipio);

    }

    public Municipio eliminarMunicipio(Municipio municipio) {
        datos = (IFachadaDatos) FabricaLogica.crearInstancia();
        return datos.eliminarMunicipio(municipio);

    }

    public Municipio guardarMunicipio(Municipio municipio) {
        datos = (IFachadaDatos) FabricaLogica.crearInstancia();
        return datos.guardarMunicipio(municipio);

    }

    public List<Estado> listaEstado() {
        datos = (IFachadaDatos) FabricaLogica.crearInstancia();
        return datos.listaEstado();

    }

    public Estado buscarEstado(Estado estado) {
        datos = (IFachadaDatos) FabricaLogica.crearInstancia();
        return datos.buscarEstado(estado);

    }

    public Estado actualizarEstado(Estado estado) {
        datos = (IFachadaDatos) FabricaLogica.crearInstancia();
        return datos.actualizarEstado(estado);

    }

    public Estado eliminarEstado(Estado estado) {
        datos = (IFachadaDatos) FabricaLogica.crearInstancia();
        return datos.eliminarEstado(estado);

    }

    public Estado guardarEstado(Estado estado) {
        datos = (IFachadaDatos) FabricaLogica.crearInstancia();
        return datos.guardarEstado(estado);

    }
}
