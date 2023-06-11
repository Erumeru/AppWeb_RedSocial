/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ObjNegocio;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Clase que representa a los Usuarios.
 *
 * @author kim, carmen, elmer, marcos
 */
@Entity
@Table(name = "Usuario")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Atributo que sirve para identificar a un Usuario en específico.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Atributo que indica el nombre completo del Usuario.
     */
    @Column(name = "nombreCompleto", nullable = false, length = 100)
    private String nombreCompleto;

    /**
     * Atributo que indica el correo del Usuario.
     */
    @Column(name = "correo", nullable = false, length = 100)
    private String correo;

    /**
     * Atributo que indica la contraseña de dicho Usuario.
     */
    @Column(name = "contrasenia", nullable = false, length = 100)
    private String contrasenia;

    /**
     * Atributo que indica el número de telefono del Usuario.
     */
    @Column(name = "telefono", nullable = false, length = 100)
    private String telefono;

    /**
     * Atributo que indica el avatar del Usuario.
     */
    @Column(name = "avatar", nullable = false, length = 100)
    private String avatar;

    /**
     * Atributo que indica el ciudad del Usuario.
     */
    @Column(name = "ciudad", nullable = false, length = 100)
    private String ciudad;

    /**
     * Atributo que indica la fecha en el que usuario nacio.
     */
    @Temporal(TemporalType.DATE)
    @Column(name = "fechaNacimiento", nullable = false)
    private Calendar fechaNacimiento;

    /**
     * Atributo que indica el genero del usuario.
     */
    @Column(name = "genero", nullable = false, length = 100)
    private String genero;

    @OneToMany(mappedBy = "usuario", cascade = {CascadeType.PERSIST})
    private List<Comun> comun;

    @ManyToOne()
    @JoinColumn(name = "idMunicipio", nullable = false)
    private Municipio municipio;

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
    public Usuario(String nombreCompleto, String correo, String contrasenia, String telefono, String avatar, String ciudad, Calendar fechaNacimiento, String genero, List<Comun> comun, Municipio municipio) {
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
    public Integer getId() {
        return id;
    }

    /**
     * Establece el id del usuario.
     *
     * @param id El id del usuario.
     */
    public void setId(Integer id) {
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
    public Calendar getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Establece la fecha de nacimiento del usuario.
     *
     * @param fechaNacimiento La fecha de nacimiento del usuario.
     */
    public void setFechaNacimiento(Calendar fechaNacimiento) {
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
