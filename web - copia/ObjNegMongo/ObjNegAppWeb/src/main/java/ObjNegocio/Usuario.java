/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ObjNegocio;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import org.bson.types.ObjectId;

/**
 * Clase que representa a los Usuarios.
 *
 * @author kim, carmen, elmer, marcos
 */
public class Usuario {

    /**
     * Atributo que sirve para identificar a un Usuario en específico.
     */
    private ObjectId id;

    /**
     * Atributo que indica el nombre completo del Usuario.
     */
    private String nombreCompleto;

    /**
     * Atributo que indica el correo del Usuario.
     */
    private String correo;

    /**
     * Atributo que indica la contraseña de dicho Usuario.
     */
    private String contrasenia;

    /**
     * Atributo que indica el número de telefono del Usuario.
     */
    private String telefono;

    /**
     * Atributo que indica el avatar del Usuario.
     */
    private String avatar;

    /**
     * Atributo que indica el ciudad del Usuario.
     */
    private String ciudad;

    /**
     * Atributo que indica la fecha en el que usuario nacio.
     */
    private Date fechaNacimiento;

    /**
     * Atributo que indica el genero del usuario.
     */
    private String genero;

    /**
     * Representa la lista de usuarios comunes.
     */
    private List<Comun> comun;

    private Municipio municipio;

    /**
     * Constructor por defecto.
     */
    public Usuario() {
    }

    /**
     * Constructor de la clase Usuario.
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
    public Usuario(String nombreCompleto, String correo, String contrasenia, String telefono, String avatar, String ciudad, Date fechaNacimiento, String genero, List<Comun> comun, Municipio municipio) {
        this.nombreCompleto = nombreCompleto;
        this.correo = correo;
        this.contrasenia = contrasenia;
        this.telefono = telefono;
        this.avatar = avatar;
        this.ciudad = ciudad;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        this.comun = comun;
        this.municipio = municipio;
    }

    /**
     * Obtiene el id del usuario.
     *
     * @return El id del usuario.
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Establece el id del usuario.
     *
     * @param id El id del usuario.
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre completo del usuario.
     *
     * @return El nombre completo del usuario.
     */
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    /**
     * Establece el nombre completo del usuario.
     *
     * @param nombreCompleto El nombre completo del usuario.
     */
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    /**
     * Obtiene el correo del usuario.
     *
     * @return El correo del usuario.
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Establece el correo del usuario.
     *
     * @param correo El correo del usuario.
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Obtiene la contraseña del usuario.
     *
     * @return La contraseña del usuario.
     */
    public String getContrasenia() {
        return contrasenia;
    }

    /**
     * Establece la contraseña del usuario.
     *
     * @param contrasenia La contraseña del usuario.
     */
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    /**
     * Obtiene el teléfono del usuario.
     *
     * @return El teléfono del usuario.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el teléfono del usuario.
     *
     * @param telefono El teléfono del usuario.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Obtiene el avatar del usuario.
     *
     * @return El avatar del usuario.
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * Establece el avatar del usuario.
     *
     * @param avatar El avatar del usuario.
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    /**
     * Obtiene la ciudad del usuario.
     *
     * @return La ciudad del usuario.
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * Establece la ciudad del usuario.
     *
     * @param ciudad La ciudad del usuario.
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * Obtiene la fecha de nacimiento del usuario.
     *
     * @return La fecha de nacimiento del usuario.
     */
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Establece la fecha de nacimiento del usuario.
     *
     * @param fechaNacimiento La fecha de nacimiento del usuario.
     */
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Obtiene el género del usuario.
     *
     * @return El género del usuario.
     */
    public String getGenero() {
        return genero;
    }

    /**
     * Establece el género del usuario.
     *
     * @param genero El género del usuario.
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * Obtiene la lista de objetos de tipo Comun asociados al Usuario.
     *
     * @return La lista de objetos de tipo Comun asociados al Usuario.
     */
    public List<Comun> getComun() {
        return comun;
    }

    /**
     * Establece la lista de objetos de tipo Comun asociados al Usuario.
     *
     * @param comun La lista de objetos de tipo Comun a establecer.
     */
    public void setComun(List<Comun> comun) {
        this.comun = comun;
    }

    /**
     * Obtiene el objeto de tipo Municipio asociado al Usuario.
     *
     * @return El objeto de tipo Municipio asociado al Usuario.
     */
    public Municipio getMunicipio() {
        return municipio;
    }

    /**
     * Establece el objeto de tipo Municipio asociado al Usuario.
     *
     * @param municipio El objeto de tipo Municipio a establecer.
     */
    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    /**
     * Calcula el hash code de la instancia de Usuario.
     *
     * @return El hash code calculado.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
        hash = 97 * hash + Objects.hashCode(this.nombreCompleto);
        hash = 97 * hash + Objects.hashCode(this.correo);
        hash = 97 * hash + Objects.hashCode(this.contrasenia);
        hash = 97 * hash + Objects.hashCode(this.telefono);
        hash = 97 * hash + Objects.hashCode(this.avatar);
        hash = 97 * hash + Objects.hashCode(this.ciudad);
        hash = 97 * hash + Objects.hashCode(this.fechaNacimiento);
        hash = 97 * hash + Objects.hashCode(this.genero);
        return hash;
    }

    /**
     * Compara si dos objetos de Usuario son iguales.
     *
     * @param obj El objeto a comparar.
     * @return true si los objetos son iguales, false de lo contrario.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.nombreCompleto, other.nombreCompleto)) {
            return false;
        }
        if (!Objects.equals(this.correo, other.correo)) {
            return false;
        }
        if (!Objects.equals(this.contrasenia, other.contrasenia)) {
            return false;
        }
        if (!Objects.equals(this.telefono, other.telefono)) {
            return false;
        }
        if (!Objects.equals(this.avatar, other.avatar)) {
            return false;
        }
        if (!Objects.equals(this.ciudad, other.ciudad)) {
            return false;
        }
        if (!Objects.equals(this.genero, other.genero)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return Objects.equals(this.fechaNacimiento, other.fechaNacimiento);
    }

    /**
     * Devuelve una representación en forma de cadena del objeto Usuario.
     *
     * @return La representación en forma de cadena del objeto.
     */
    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nombreCompleto=" + nombreCompleto + ", correo=" + correo + ", contrasenia=" + contrasenia + ", telefono=" + telefono + ", avatar=" + avatar + ", ciudad=" + ciudad + ", fechaNacimiento=" + fechaNacimiento + ", genero=" + genero + ", comun=" + comun + ", municipio=" + municipio + '}';
    }

}
