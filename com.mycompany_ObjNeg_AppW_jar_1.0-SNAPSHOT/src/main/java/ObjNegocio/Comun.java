/*
Clase Comun.java creada el 10/06/2023.
 */
package ObjNegocio;

import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Clase que representa a los comentarios comunes.
 *
 * @author kim, carmen, elmer, marcos
 */
@Table(name = "Comunes")
@DiscriminatorValue("comun")
@Entity
public class Comun extends Post {

    /**
     * Atributo que muestra la relación uno a muchos, siendo esta el 'uno',
     * teniendo una lista de comentarios.
     */
    @OneToMany(mappedBy = "comun")
    private List<Comentario> comentarios;

    /**
     * Contructor para crear un comentario común.
     *
     * @param fechaHoraCreacion fecha y hora de creación del comentario.
     * @param titulo título del cometario.
     * @param contenido contenido que es el cuerpo del comentario.
     * @param fechaHoraEdicion fecha y hora en la que el comentario se edito.
     */
    public Comun(Calendar fechaHoraCreacion, String titulo, String contenido, Calendar fechaHoraEdicion) {
        super(fechaHoraCreacion, titulo, contenido, fechaHoraEdicion);
    }

    /**
     * Contructor para crear un comentario común.
     *
     * @param fechaHoraCreacion fecha y hora de creación del comentario.
     * @param titulo título del cometario.
     * @param contenido contenido que es el cuerpo del comentario.
     */
    public Comun(Calendar fechaHoraCreacion, String titulo, String contenido) {
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
        hash = 71 * hash + Objects.hashCode(this.comentarios);
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
        if (!Objects.equals(this.comentarios, other.comentarios)) {
            return false;
        }
        return true;
    }

    /**
     * Método usado para escribir y con ello conocer los comentarios.
     *
     * @return comentarios en orden.
     */
    @Override
    public String toString() {
        return "Comun{" + "comentarios=" + comentarios + '}';
    }

}
