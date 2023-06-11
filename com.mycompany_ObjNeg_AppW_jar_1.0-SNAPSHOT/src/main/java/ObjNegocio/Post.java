/*
Clase Post.java creada el 10/06/2023.
 */
package ObjNegocio;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Clase que representan los post de nuestra red social.
 *
 * @author kim, carmen, elmer, marcos
 */
@Table(name = "Posts")
@DiscriminatorColumn(name = "tipo", discriminatorType = DiscriminatorType.STRING)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Entity
public class Post implements Serializable {

    /**
     * Atributo que sirve para identificar a un post en específico.
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Atributo que indica la fecha en la que se creo un post, almacenando
     * también su fecha.
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fechaHoraCreacion", nullable = false)
    private Calendar fechaHoraCreacion;

    /**
     * Atributo que indica el título que tiene el post
     */
    @Column(name = "titulo", nullable = false, length = 50)
    private String titulo;

    /**
     * Atributo que muestra el contenido del post.
     */
    @Column(name = "contenido", nullable = false, length = 1000)
    private String contenido;

    /**
     * Atributo que indica la fecha y hora de edición de un post.
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fechaHoraEdicion", nullable = true)
    private Calendar fechaHoraEdicion;

    /**
     * Constructor para hacer un post dentro de la red social.
     *
     * @param fechaHoraCreacion fecha de creación de post.
     * @param titulo título del post.
     * @param contenido cuerpo del post.
     * @param fechaHoraEdicion fecha en la que se edito el post.
     */
    public Post(Calendar fechaHoraCreacion, String titulo, String contenido, Calendar fechaHoraEdicion) {
        this.fechaHoraCreacion = fechaHoraCreacion;
        this.titulo = titulo;
        this.contenido = contenido;
        this.fechaHoraEdicion = fechaHoraEdicion;
    }

    /**
     * Constructor para hacer un post dentro de la red social.
     *
     * @param fechaHoraCreacion fecha de creación de post.
     * @param titulo título del post.
     * @param contenido cuerpo del post.
     */
    public Post(Calendar fechaHoraCreacion, String titulo, String contenido) {
        this.fechaHoraCreacion = fechaHoraCreacion;
        this.titulo = titulo;
        this.contenido = contenido;
    }

    /**
     * Obtiene el id del post.
     *
     * @return regresa id.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el id de post.
     *
     * @param id id a establecer.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Regresa la fecha y hora de creación del post.
     *
     * @return regresa el post.
     */
    public Calendar getFechaHoraCreacion() {
        return fechaHoraCreacion;
    }

    /**
     * Establece la fecha y la hora del post.
     *
     * @param fechaHoraCreacion a establecer en el post.
     */
    public void setFechaHoraCreacion(Calendar fechaHoraCreacion) {
        this.fechaHoraCreacion = fechaHoraCreacion;
    }

    /**
     * Regresa el título de un post.
     *
     * @return título del post.
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Establece el título de un post.
     *
     * @param titulo título a establecer.
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Obtiene el contenido del post.
     *
     * @return contenido del post.
     */
    public String getContenido() {
        return contenido;
    }

    /**
     * Establece el contenio del post.
     *
     * @param contenido contenido a establecer en el post.
     */
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    /**
     * Obtiene la fecha y hora de la edición del post.
     *
     * @return fecha y hora en que se edito.
     */
    public Calendar getFechaHoraEdicion() {
        return fechaHoraEdicion;
    }

    /**
     * Establece la fecha y hora en la que se edito el post.
     *
     * @param fechaHoraEdicionla fecha y hora a establecer.
     */
    public void setFechaHoraEdicion(Calendar fechaHoraEdicion) {
        this.fechaHoraEdicion = fechaHoraEdicion;
    }

    /**
     * Obtiene el número hash del post.
     *
     * @return número hash.
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + Objects.hashCode(this.id);
        return hash;
    }

    /**
     * Compara si dos post son iguales.
     *
     * @param obj objeto a comparar.
     * @return regresa true si es igual y false en caso contrario.
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
        final Post other = (Post) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    /**
     * Método usado para escribir y con ello conocer los atributos de un post.
     *
     * @return atributos del post en orden.
     */
    @Override
    public String toString() {
        return "Post{" + "id=" + id + ", fechaHoraCreacion=" + fechaHoraCreacion + ", titulo=" + titulo + ", contenido=" + contenido + ", fechaHoraEdicion=" + fechaHoraEdicion + '}';
    }

}
