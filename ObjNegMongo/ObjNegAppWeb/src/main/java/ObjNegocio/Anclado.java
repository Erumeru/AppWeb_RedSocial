/*
Clase Anclado.java creada el 10/06/2023.
 */
package ObjNegocio;

import java.util.Calendar;
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
    private Admor admor;

    /**
     * Atributo que sirve para identificar a un post anclado en específico.
     */
    private ObjectId id;

    /**
     * Contructor para crear un comentario anclado.
     *
     * @param fechaHoraCreacion fecha y hora de creación del comentario.
     * @param titulo título del cometario.
     * @param contenido contenido que es el cuerpo del comentario.
     * @param fechaHoraEdicion fecha y hora en la que el comentario se edito.
     */
    public Anclado(Calendar fechaHoraCreacion, String titulo, String contenido, Calendar fechaHoraEdicion) {
        super(fechaHoraCreacion, titulo, contenido, fechaHoraEdicion);
    }

    /**
     * Obtiene el usuario administrador.
     *
     * @return admor usuario.
     */
    public Admor getAdmor() {
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
    public Anclado(Calendar fechaHoraCreacion, String titulo, String contenido) {
        super(fechaHoraCreacion, titulo, contenido);
    }

}
