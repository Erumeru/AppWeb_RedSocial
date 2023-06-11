/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ObjNegocio;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Marcos Toledo 00000234963
 */
@Entity
@Table(name = "Usuario")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombreCompleto", nullable = false, length = 100)
    private String nombreCompleto;
    
    @Column(name = "correo", nullable = false, length = 100)
    private String correo;
    
    @Column(name = "contrasenia", nullable = false, length = 100)
    private String contrasenia;
    
    @Column(name = "telefono", nullable = false, length = 100)
    private String telefono;

    @Column(name = "avatar", nullable = false, length = 100)
    private String avatar;
    
    @Column(name = "ciudad", nullable = false, length = 100)
    private String ciudad;
    
    @Column(name = "fechaNacimiento", nullable = false, length = 100)
    private String fechaNacimiento;
    
    @Column(name = "genero", nullable = false, length = 100)
    private String genero;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.id);
        hash = 47 * hash + Objects.hashCode(this.nombreCompleto);
        hash = 47 * hash + Objects.hashCode(this.correo);
        hash = 47 * hash + Objects.hashCode(this.contrasenia);
        hash = 47 * hash + Objects.hashCode(this.telefono);
        hash = 47 * hash + Objects.hashCode(this.avatar);
        hash = 47 * hash + Objects.hashCode(this.ciudad);
        hash = 47 * hash + Objects.hashCode(this.fechaNacimiento);
        hash = 47 * hash + Objects.hashCode(this.genero);
        return hash;
    }

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
        if (!Objects.equals(this.fechaNacimiento, other.fechaNacimiento)) {
            return false;
        }
        if (!Objects.equals(this.genero, other.genero)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nombreCompleto=" + nombreCompleto + ", correo=" + correo + ", contrasenia=" + contrasenia + ", telefono=" + telefono + ", avatar=" + avatar + ", ciudad=" + ciudad + ", fechaNacimiento=" + fechaNacimiento + ", genero=" + genero + '}';
    }
     
}
