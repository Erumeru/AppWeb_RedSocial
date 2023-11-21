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
public class Estado {

    /**
     * Atributo que sirve para identificar a un estado en específico.
     */
    private ObjectId idEstado;

    /**
     * Atributo que indica el nombre del estado.
     */
    private String nombre;

    /**
     * Obtiene el idEstado del estado.
     *
     * @return el idEstado del estado.
     */
    public ObjectId getId() {
        return idEstado;
    }

    /**
     * Establece el idEstado del estado.
     *
     * @param id del estado.
     */
    public void setId(ObjectId id) {
        this.idEstado = id;
    }

    /**
     * Constructor que construye un estado.
     *
     * @param id del estado.
     * @param nombre del estado.
     */
    public Estado(ObjectId id, String nombre) {
        this.idEstado = id;
        this.nombre = nombre;
    }

    /**
     * Obtiene el nombre del estado.
     *
     * @return el nombre del estado.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del estado.
     *
     * @param nombre del estado.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Contructor vacío de la clase.
     */
    public Estado() {
    }

    /**
     * Atributo que muestra la relación uno a muchos, siendo esta el 'uno'
     * teniendo una lista de municipios.
     */
    private List<Municipio> municipios;

    public List<Municipio> getMunicipios() {
        return municipios;
    }

    public void setMunicipios(List<Municipio> municipios) {
        this.municipios = municipios;
    }
    
    public Estado(ObjectId idEstado, String nombre, List<Municipio> municipios) {
        this.idEstado = idEstado;
        this.nombre = nombre;
        this.municipios = municipios;
    }
    
    /**
     * Para obtener el hash del estado.
     *
     * @return número hash del nombre y idEstado.
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.idEstado);
        hash = 23 * hash + Objects.hashCode(this.nombre);
        return hash;
    }

    /**
     * Compara si un estado es igual a otro.
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
        final Estado other = (Estado) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return Objects.equals(this.idEstado, other.idEstado);
    }

    /**
     * Método usado para escribir y con ello conocer los atributos de un estado.
     *
     * @return atributos del estado en orden.
     */
    @Override
    public String toString() {
        return "Estado{" + "id=" + idEstado + ", nombre=" + nombre + '}';
    }

}
