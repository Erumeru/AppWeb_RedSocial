/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ObjNegocio;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;

/**
 * Clase que representa los Usuarios Normales.
 *
 * @author kim, carmen, elmer, marcos
 */
public class Normal extends Usuario {

    /**
     * Atributo que sirve para identificar a un Usuario normal en específico.
     */
    private ObjectId idUsuario;

    /**
     * Representa la lista de comentario que tiene un usuario normal.
     */
    private List<Comentario> comentario;

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
    public Normal(String nombreCompleto, String correo, String contrasenia, String telefono, String avatar, String ciudad, Date fechaNacimiento, String genero, List<Comun> comun, Municipio municipio) {
        super(nombreCompleto, correo, contrasenia, telefono, avatar, ciudad, fechaNacimiento, genero, comun, municipio);
    }

    /**
     * Constructor por defecto.
     */
    public Normal() {
        super();
    }

    /**
     * Regresa los comentarios.
     *
     * @return lista de comentarios.
     */
    public List<Comentario> getComentario() {
        return comentario;
    }

    public ObjectId getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(ObjectId idUsuario) {
        this.idUsuario = idUsuario;
    }

    
    /**
     * Establece los comentarios.
     *
     * @param comentario a establecer.
     */
    public void setComentario(List<Comentario> comentario) {
        this.comentario = comentario;
    }

    /**
     * Método usado para escribir y con ello conocer los atributos de un normal.
     *
     * @return atributos de un usuario normal en orden.
     */
    @Override
    public String toString() {
        return "Normal{" + "idUsuario=" + getId() + ", comentario=" + comentario + ", nombreCompleto=" + getNombreCompleto()
                + ", correo=" + getCorreo()
                + ", contrasenia=" + getContrasenia()
                + ", telefono=" + getTelefono()
                + ", avatar=" + getAvatar()
                + ", ciudad=" + getCiudad()
                + ", fechaNacimiento=" + getFechaNacimiento()
                + ", genero=" + getGenero()
                + ", comun=" + getComun()
                + ", municipio=" + getMunicipio()
                + '}';
    }

}
