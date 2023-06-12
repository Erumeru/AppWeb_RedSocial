/*
Clase Anclado.java creada el 10/06/2023.
 */
package ObjNegocio;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Clase que representa los comentarios anclados.
 *
 * @author kim, carmen, elmer, marcos
 */
@Table(name = "Anclados")
@DiscriminatorValue("anclado")
@Entity
public class Anclado extends Post implements Serializable {

    /**
     * Representa el anclado que tiene un usuario administrador.
     */
    @ManyToOne()
    @JoinColumn(name = "id_admor", nullable = false)
    private Admor admor;

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
