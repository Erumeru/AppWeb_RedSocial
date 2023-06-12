/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ObjNegocio;

import java.io.Serializable;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author kim, carmen, elmer, marcos
 */
@Entity
@Table(name = "Municipio")
public class Municipio implements Serializable {

    /**
     * Atributo que sirve para identificar a un municipio en específico.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    /**
     * Atributo que indica el nombre del municipio.
     */
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    /**
     * Obtiene el id del municipio.
     * @return el id del usuario.
     */
    public Long getId() {
        return id;
    }

    /**
     * Constructor que construye un municipio.
     * @param id del municipio.
     * @param nombre del municipio.
     */
    public Municipio(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    /**
     * Obtiene el nombre del municipio.
     * @return regresa el nombre del municipio.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del municipio.
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
     * Establece el id del municipio
     * @param id del municipio.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Para obtener el hash del municipio.
     * @return número hash del nombre y id.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.id);
        hash = 89 * hash + Objects.hashCode(this.nombre);
        return hash;
    }

    /**
     * Compara si un municipio es igual a otro.
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
        return Objects.equals(this.id, other.id);
    }

    /**
     * Atributo que muestra la relación uno a muchos, siendo esta el 'uno'
     * teniendo una lista de usuarios.
     */
    @OneToMany(mappedBy="municipio", cascade={CascadeType.PERSIST})
    private List<Usuario> usuarios;
    
    /**
     * Atributo que muestra la relación uno a muchos, siendo esta el 'muchos',
     * quedándose con la llave foránea de los Estados.
     */
    @ManyToOne()
    @JoinColumn(name="idEstado", nullable=false)
    private Estado estado;
    
     /**
     * Método usado para escribir y con ello conocer los atributos de un
     * municipio.
     *
     * @return atributos del municipio en orden.
     */
    @Override
    public String toString() {
        return "Municipio{" + "id=" + id + ", nombre=" + nombre + '}';
    }

    
}
