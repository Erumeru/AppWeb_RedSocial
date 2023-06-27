/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import ObjNegocio.*;
import java.util.List;
import org.itson.appimplementacion.FachadaDatos;
import org.itson.appimplementacion.FabricaDatos;
import org.itson.interfaces.IFachadaDatos;

/**
 *
 * @author Marcos x Elmer x Kim x Carmen
 */
public class ControlUsuario {

    public IFachadaDatos datos = new FachadaDatos();

    public List<Usuario> listaUsuario() {
        datos = FabricaDatos.dameInstancia();
        return datos.listaUsuario();
    }

    public Usuario buscarUsuario(Usuario usuario) {
        datos = FabricaDatos.dameInstancia();
        return datos.buscarUsuario(usuario);
    }

    public Usuario actualizarUsuario(Usuario usuarioBase, Usuario usuarioNuevo) {
        datos = FabricaDatos.dameInstancia();
        return datos.actualizarUsuario(usuarioBase, usuarioNuevo);
    }

    public Usuario eliminarUsuario(Usuario usuario) {
        datos = FabricaDatos.dameInstancia();
        return datos.eliminarUsuario(usuario);
    }

    public Usuario guardarUsuario(Usuario usuario) {
        datos = FabricaDatos.dameInstancia();
        return datos.guardarUsuario(usuario);
    }

    public List<Admor> listaAdmor() {
        datos = FabricaDatos.dameInstancia();
        return datos.listaAdmor();
    }

    public Admor buscarAdmor(Admor admor) {
        datos = FabricaDatos.dameInstancia();
        return datos.buscarAdmor(admor);
    }

    public Admor actualizarAdmor(Admor admorBase, Admor admorNuevo) {
        datos = FabricaDatos.dameInstancia();
        return datos.actualizarAdmor(admorBase, admorNuevo);
    }

    public Admor eliminarAdmor(Admor admor) {
        datos = FabricaDatos.dameInstancia();
        return datos.eliminarAdmor(admor);
    }

    public Admor guardarAdmor(Admor admor) {
        datos = FabricaDatos.dameInstancia();
        return datos.guardarAdmor(admor);
    }

    public List<Normal> listaNormal() {
        datos = FabricaDatos.dameInstancia();
        return datos.listaNormal();
    }

    public Normal buscarNormal(Normal normal) {
        datos = FabricaDatos.dameInstancia();
        return datos.buscarNormal(normal);
    }

    public Normal actualizarNormal(Normal normalBase, Normal normalNuevo) {
        datos = FabricaDatos.dameInstancia();
        return datos.actualizarNormal(normalBase, normalNuevo);
    }

    public Normal eliminarNormal(Normal normal) {
        datos = FabricaDatos.dameInstancia();
        return datos.eliminarNormal(normal);
    }

    public Normal guardarNormal(Normal normal) {
        datos = FabricaDatos.dameInstancia();
        return datos.guardarNormal(normal);
    }

    public List<Municipio> listaMunicipio() {
        datos = FabricaDatos.dameInstancia();
        return datos.listaMunicipio();

    }

    public Municipio buscarMunicipio(Municipio municipio) {
        datos = FabricaDatos.dameInstancia();
        return datos.buscarMunicipio(municipio);

    }

    public Municipio actualizarMunicipio(Municipio municipioBase, Municipio municipioNuevo) {
        datos = FabricaDatos.dameInstancia();
        return datos.actualizarMunicipio(municipioBase, municipioNuevo);

    }

    public Municipio eliminarMunicipio(Municipio municipio) {
        datos = FabricaDatos.dameInstancia();
        return datos.eliminarMunicipio(municipio);

    }

    public Municipio guardarMunicipio(Municipio municipio) {
        datos = FabricaDatos.dameInstancia();
        return datos.guardarMunicipio(municipio);

    }

    public List<Estado> listaEstado() {
        datos = FabricaDatos.dameInstancia();
        return datos.listaEstado();

    }

    public Estado buscarEstado(Estado estado) {
        datos = FabricaDatos.dameInstancia();
        return datos.buscarEstado(estado);

    }

    public Estado actualizarEstado(Estado estadoBase, Estado estadoNuevo) {
        datos = FabricaDatos.dameInstancia();
        return datos.actualizarEstado(estadoBase, estadoNuevo);

    }

    public Estado eliminarEstado(Estado estado) {
        datos = FabricaDatos.dameInstancia();
        return datos.eliminarEstado(estado);

    }

    public Estado guardarEstado(Estado estado) {
        datos = FabricaDatos.dameInstancia();
        return datos.guardarEstado(estado);

    }
}
