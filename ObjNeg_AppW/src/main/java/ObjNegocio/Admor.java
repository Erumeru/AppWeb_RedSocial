/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ObjNegocio;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Clase que representa los Usuarios Administrador.
 *
 * @author kim, carmen, elmer, marcos
 */
@Table(name = "Admor")
@DiscriminatorValue("admor")
@Entity
public class Admor extends Usuario implements Serializable {

    /**
     * Representa la lista de anclados que tiene un usuario administrador.
     */
    @OneToMany(mappedBy = "admor")
    private List<Anclado> anclado;

    /**
     * Constructor para crear un Usuario.
     *
     * @param nombreCompleto El nombre completo del usuario.
     * @param correo El correo del usuario.
     * @param contrasenia La contraseña del usuario.
     * @param telefono El teléfono del usuario.
     * @param avatar El avatar del usuario.
     * @param ciudad La ciudad del usuario.
     * @param fechaNacimiento La fecha de nacimiento del usuario.
     * @param genero El género del usuario.
     * @param comun La lista de objetos de tipo Comun asociados al usuario.
     * @param municipio El objeto de tipo Municipio asociado al Usuario.
     */
    public Admor(String nombreCompleto, String correo, String contrasenia, String telefono, String avatar, String ciudad, Calendar fechaNacimiento, String genero, List<Comun> comun, Municipio municipio) {
        super(nombreCompleto, correo, contrasenia, telefono, avatar, ciudad, fechaNacimiento, genero, comun, municipio);
    }

    /**
     * Constructor por defecto.
     */
    public Admor() {
    }

    /**
     * Regresa el post anclado.
     *
     * @return post anclado.
     */
    public List<Anclado> getAnclado() {
        return anclado;
    }

    /**
     * Establece el post a anclar.
     *
     * @param anclado a establecer.
     */
    public void setAnclado(List<Anclado> anclado) {
        this.anclado = anclado;
    }

    /**
     * Método usado para escribir y con ello conocer los atributos de un admor.
     *
     * @return atributos de admor en orden.
     */
    @Override
    public String toString() {
        return "Admor{" + "anclado=" + anclado + '}';
    }

}