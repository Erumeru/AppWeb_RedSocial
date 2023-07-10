/*
Clase Anclado.java creada el 10/06/2023.
 */
package ObjNegocio;

import java.util.Calendar;
import java.util.Date;
import org.bson.types.ObjectId;

/**
 * Clase que representa los comentarios anclados.
 *
 * @author kim, carmen, elmer, marcos
 */
public class Anclado extends Post {

    /**
     * Representa el anclado que tiene un usuario administrador.
     */
    private Usuario admor;

    /**
     * Atributo que sirve para identificar a un post anclado en específico.
     */
    private ObjectId idAnclado;
    

    /**
     * Contructor para crear un comentario anclado.
     *
     * @param fechaHoraCreacion fecha y hora de creación del comentario.
     * @param titulo título del cometario.
     * @param contenido contenido que es el cuerpo del comentario.
     * @param fechaHoraEdicion fecha y hora en la que el comentario se edito.
     */
    public Anclado(Date fechaHoraCreacion, String titulo, String contenido, Date fechaHoraEdicion) {
        super(fechaHoraCreacion, titulo, contenido, fechaHoraEdicion);
    }

    public ObjectId getIdAnclador() {
        return idAnclado;
    }

    public void setIdAnclado(ObjectId id) {
        this.idAnclado = id;
    }

    public Anclado() {
        super();
    }

    /**
     * Obtiene el usuario administrador.
     *
     * @return admor usuario.
     */
    public Usuario getAdmor() {
        return admor;
    }

    /**
     * Establece el usuario administrador.
     *
     * @param admor a establecer.
     */
    public void setAdmor(Admor admor) {
        this.admor = admor;
    }

    /**
     * Contructor para crear un comentario anclado.
     *
     * @param fechaHoraCreacion fecha y hora de creación del comentario.
     * @param titulo título del cometario.
     * @param contenido contenido que es el cuerpo del comentario.
     */
    public Anclado(Date fechaHoraCreacion, String titulo, String contenido) {
        super(fechaHoraCreacion, titulo, contenido);
    }

    @Override
    public String toString() {
        return "Anclado{" + "admor=" + admor + ", idAnclado=" + idAnclado + '}';
    }

    
    
}
