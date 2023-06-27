/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Clases;

import ObjNegocio.*;
import java.util.List;

/**
 *
 * @author Marcos Toledo 00000234963
 */
public interface ILogica {

    public List<Usuario> listaUsuario();

    public void buscarUsuario(Usuario usuario);

    public void actualizarUsuario(Usuario usuario);

    public void eliminarUsuario(Usuario usuario);

    public void guardarUsuario(Usuario usuario);

    public List<Post> listaPost();

    public void buscarPost(Post post);

    public void actualizarPost(Post post);

    public void eliminarPost(Post post);

    public void guardarPost(Post post);

    public List<Normal> listaNormal();

    public void buscarNormal(Normal normal);

    public void actualizarNormal(Normal normal);

    public void eliminarNormal(Normal normal);

    public void guardarNormal(Normal normal);

    public List<Municipio> listaMunicipio();

    public void buscarMunicipio(Municipio municipio);

    public void actualizarMunicipio(Municipio municipio);

    public void eliminarMunicipio(Municipio municipio);

    public void guardarMunicipio(Municipio municipio);

    public List<Estado> listaEstado();

    public void buscarEstado(Estado estado);
}
