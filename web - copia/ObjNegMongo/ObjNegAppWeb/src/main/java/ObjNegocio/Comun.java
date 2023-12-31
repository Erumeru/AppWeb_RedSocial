/*
Clase Comun.java creada el 10/06/2023.
 */
package ObjNegocio;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import org.bson.types.ObjectId;

/**
 * Clase que representa a los comentarios comunes.
 *
 * @author kim, carmen, elmer, marcos
 */
public class Comun extends Post implements Serializable{

    /**
     * Atributo que sirve para identificar a un post común en específico.
     */
    private ObjectId idComun;

    /**
     * Atributo que muestra la relación uno a muchos, siendo esta el 'uno',
     * teniendo una lista de comentarios.
     */
    private List<Comentario> comentarios;

    /**
     * Representa el usuario que es comun.
     */
    private Usuario usuario;

    /**
     * Contructor para crear un comentario común.
     *
     * @param fechaHoraCreacion fecha y hora de creación del comentario.
     * @param titulo título del cometario.
     * @param contenido contenido que es el cuerpo del comentario.
     * @param fechaHoraEdicion fecha y hora en la que el comentario se edito.
     */
    public Comun(Date fechaHoraCreacion, String titulo, String contenido, Date fechaHoraEdicion) {
        super(fechaHoraCreacion, titulo, contenido, fechaHoraEdicion);
    }

    /**
     * Contructor para crear un comentario común.
     *
     * @param usuario
     * @param fechaHoraCreacion fecha y hora de creación del comentario.
     * @param titulo título del cometario.
     * @param contenido contenido que es el cuerpo del comentario.
     * @param fechaHoraEdicion fecha y hora en la que el comentario se edito.
     */
    public Comun(Usuario usuario, Date fechaHoraCreacion, String titulo, String contenido, Date fechaHoraEdicion) {
        super(fechaHoraCreacion, titulo, contenido, fechaHoraEdicion);
        this.usuario = usuario;
    }

    public Comun() {
        super();
    }

    public ObjectId getIdComun() {
        return idComun;
    }

    public void setIdComun(ObjectId idComun) {
        this.idComun = idComun;
    }

    public Comun(ObjectId idComun, List<Comentario> comentarios, Usuario usuario) {
        this.idComun = idComun;
        this.comentarios = comentarios;
        this.usuario = usuario;
    }

    /**
     * Contructor para crear un comentario común.
     *
     * @param fechaHoraCreacion fecha y hora de creación del comentario.
     * @param titulo título del cometario.
     * @param contenido contenido que es el cuerpo del comentario.
     */
    public Comun(Date fechaHoraCreacion, String titulo, String contenido) {
        super(fechaHoraCreacion, titulo, contenido);
    }

    /**
     * Obtiene los comentarios.
     *
     * @return lista de comentarios.
     */
    public List<Comentario> getComentarios() {
        return comentarios;
    }

    /**
     * Establece los comentarios.
     *
     * @param comentarios coemntarios a establecer.
     */
    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    /**
     * Obtiene el número hash del post.
     *
     * @return número de hash.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.idComun);
        hash = 47 * hash + Objects.hashCode(this.comentarios);
        hash = 47 * hash + Objects.hashCode(this.usuario);
        return hash;
    }

    /**
     * Compara si dos cometarios comunes son iguales.
     *
     * @param obj comentario a comparar.
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
        final Comun other = (Comun) obj;
        if (!Objects.equals(this.idComun, other.idComun)) {
            return false;
        }
        if (!Objects.equals(this.comentarios, other.comentarios)) {
            return false;
        }
        return Objects.equals(this.usuario, other.usuario);
    }

    /**
     * Regresa el usuario.
     *
     * @return usuario.
     */
    public Usuario getUsuario() {
        return usuario;
    }

    
    
    /**
     * Establece el usuario.
     *
     * @param usuario a establecer.
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * Método usado para escribir y con ello conocer los comentarios.
     *
     * @return comentarios en orden.
     */
    @Override
    public String toString() {
        return "Comun{" + "idComun=" + idComun + ", titulo=" + getTitulo() + ", contenido=" + getContenido() + ", comentarios=" + comentarios + ", usuario=" + usuario + '}';
    }

}
