/*
Clase Post.java creada el 10/06/2023.
 */
package ObjNegocio;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
import org.bson.types.ObjectId;


/**
 * Clase que representan los post de nuestra red social.
 *
 * @author kim, carmen, elmer, marcos
 */

public class Post {

    /**
     * Atributo que sirve para identificar a un post en específico.
     */

    private ObjectId idPost;

    /**
     * Atributo que indica la fecha en la que se creo un post, almacenando
     * también su fecha.
     */
 
    private Date fechaHoraCreacion;

    /**
     * Atributo que indica el título que tiene el post
     */

    private String titulo;

    /**
     * Atributo que muestra el contenido del post.
     */
  
    private String contenido;

    /**
     * Atributo que indica la fecha y hora de edición de un post.
     */
  
    private Date fechaHoraEdicion;

    /**
     * Constructor por defecto.
     */
    public Post() {
    }
    
    /**
     * Constructor para hacer un post dentro de la red social.
     *
     * @param fechaHoraCreacion fecha de creación de post.
     * @param titulo título del post.
     * @param contenido cuerpo del post.
     * @param fechaHoraEdicion fecha en la que se edito el post.
     */
    public Post(Date fechaHoraCreacion, String titulo, String contenido, Date fechaHoraEdicion) {
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
    public Post(Date fechaHoraCreacion, String titulo, String contenido) {
        this.fechaHoraCreacion = fechaHoraCreacion;
        this.titulo = titulo;
        this.contenido = contenido;
    }

    /**
     * Obtiene el idPost del post.
     *
     * @return regresa idPost.
     */
    public ObjectId getIdPost() {
        return idPost;
    }

    /**
     * Establece el idPost de post.
     *
     * @param idPost idPost a establecer.
     */
    public void setIdPost(ObjectId idPost) {
        this.idPost = idPost;
    }

    /**
     * Regresa la fecha y hora de creación del post.
     *
     * @return regresa el post.
     */
    public Date getFechaHoraCreacion() {
        return fechaHoraCreacion;
    }

    /**
     * Establece la fecha y la hora del post.
     *
     * @param fechaHoraCreacion a establecer en el post.
     */
    public void setFechaHoraCreacion(Date fechaHoraCreacion) {
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
    public Date getFechaHoraEdicion() {
        return fechaHoraEdicion;
    }

    /**
     * Establece la fecha y hora en la que se edito el post.
     *
     * @param fechaHoraEdicionla fecha y hora a establecer.
     */
    public void setFechaHoraEdicion(Date fechaHoraEdicion) {
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
        hash = 43 * hash + Objects.hashCode(this.idPost);
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
        if (!Objects.equals(this.idPost, other.idPost)) {
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
        return "Post{" + "id=" + idPost + ", fechaHoraCreacion=" + fechaHoraCreacion + ", titulo=" + titulo + ", contenido=" + contenido + ", fechaHoraEdicion=" + fechaHoraEdicion + '}';
    }

}
