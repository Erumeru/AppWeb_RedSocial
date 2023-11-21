/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ObjNegocio;

import java.util.List;
import java.util.Objects;
import org.bson.types.ObjectId;

/**
 *
 * @author kim, carmen, elmer, marcos
 */
public class Municipio {

    /**
     * Atributo que sirve para identificar a un municipio en específico.
     */
    private ObjectId idMunicipio;

    /**
     * Atributo que indica el nombre del municipio.
     */
    private String nombre;

    /**
     * Obtiene el idMunicipio del municipio.
     *
     * @return el idMunicipio del usuario.
     */
    public ObjectId getId() {
        return idMunicipio;
    }

    /**
     * Constructor que construye un municipio.
     *
     * @param id del municipio.
     * @param nombre del municipio.
     */
    public Municipio(ObjectId id, String nombre) {
        this.idMunicipio = id;
        this.nombre = nombre;
    }

    /**
     * Obtiene el nombre del municipio.
     *
     * @return regresa el nombre del municipio.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del municipio.
     *
     * @param nombre del municipio.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Constructor vacío de la clase
     */
    public Municipio() {
    }

    /**
     * Establece el idMunicipio del municipio
     *
     * @param id del municipio.
     */
    public void setId(ObjectId id) {
        this.idMunicipio = id;
    }

    /**
     * Para obtener el hash del municipio.
     *
     * @return número hash del nombre y idMunicipio.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.idMunicipio);
        hash = 89 * hash + Objects.hashCode(this.nombre);
        return hash;
    }

    /**
     * Compara si un municipio es igual a otro.
     *
     * @param obj objeto a comparar.
     * @return true si son iguales y false en caso contrario.
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
        final Municipio other = (Municipio) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return Objects.equals(this.idMunicipio, other.idMunicipio);
    }

    /**
     * Atributo que muestra la relación uno a muchos, siendo esta el 'uno'
     * teniendo una lista de usuarios.
     */
    private List<Usuario> usuarios;

    /**
     * Atributo que muestra la relación uno a muchos, siendo esta el 'muchos',
     * quedándose con la llave foránea de los Estados.
     */
    private Estado estado;

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Municipio(ObjectId idMunicipio, String nombre, List<Usuario> usuarios, Estado estado) {
        this.idMunicipio = idMunicipio;
        this.nombre = nombre;
        this.usuarios = usuarios;
        this.estado = estado;
    }

    /**
     * Método usado para escribir y con ello conocer los atributos de un
     * municipio.
     *
     * @return atributos del municipio en orden.
     */
    @Override
    public String toString() {
        return "Municipio{" + "idMunicipio=" + idMunicipio + ", nombre=" + nombre + ", usuarios=" + usuarios + ", estado=" + estado + '}';
    }

}
