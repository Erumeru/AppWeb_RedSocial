/*
Clase Comentario.java creada el 10/06/2023.
 */
package ObjNegocio;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import org.bson.types.ObjectId;

/**
 * Clase que representa los comentarios de la red social.
 *
 * @author kim, carmen, elmer, marcos
 */
public class Comentario {

    /**
     * Atributo que sirve para identificar a un comentario en específico.
     */
    private ObjectId idComentario;

    /**
     * Atributo que indica la fecha y la hora en las que el comentario fue
     * hecho.
     */
    private Date fechaHora;

    /**
     * Atributo que muestra el contenido del comentario.
     */
    private String contenido;

    /**
     * Atributo que muestra la relación uno a muchos, siendo esta el 'muchos',
     * quedándose con la llave foránea de los comentarios comunes.
     */
    private Comun comun;

    /**
     * Atributo que muestra la relación uno a muchos, siendo esta el 'muchos',
     * quedándose con la llave foránea.
     */
    private Comentario comentario;

    /**
     * Atributo que muestra la relación uno a muchos, siendo esta el 'uno'
     * teniendo una lista de comentarios.
     */
    private List<Comentario> comentarios;

    /**
     * Representa el coemntario que tiene un usuario normal.
     */
    private Normal normal;

    /**
     * Constructor por defecto.
     */
    public Comentario() {
    }

    /**
     * Constructor que construye un comentario.
     *
     * @param fechaHora de la creación del comentario.
     * @param contenido del contenido del comentario.
     */
    public Comentario(Date fechaHora, String contenido) {
        this.fechaHora = fechaHora;
        this.contenido = contenido;
    }

    /**
     * Obtiene el contenido del comentario.
     *
     * @return regresa el contenido del comentario.
     */
    public String getContenido() {
        return contenido;
    }

    /**
     * Establece el contenido que obtendra el comentario.
     *
     * @param contenido el contenido a establecer.
     */
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    /**
     * Obtiene el idComentario del comentario.
     *
     * @return regresa el idComentario del comentario.
     */
    public ObjectId getIdComentario() {
        return idComentario;
    }

    /**
     * Establece el idComentario del comentario.
     *
     * @param idComentario el idComentario a establecer.
     */
    public void setIdComentario(ObjectId idComentario) {
        this.idComentario = idComentario;
    }

    /**
     * Obtiene la fecha de vcreación del comentario.
     *
     * @return regresa la fecha y hora.
     */
    public Date getFechaHora() {
        return fechaHora;
    }

    /**
     * Establece la fecha de creación del comentario.
     *
     * @param fechaHora la fecha a establecer.
     */
    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    /**
     * Obtiene el comentario si es común.
     *
     * @return el comentario común.
     */
    public Comun getComun() {
        return comun;
    }

    /**
     * Establece el coemtario común.
     *
     * @param comun el comentario común a establecer.
     */
    public void setComun(Comun comun) {
        this.comun = comun;
    }

    /**
     * Obtiene el comentario.
     *
     * @return regresa el comentario.
     */
    public Comentario getComentario() {
        return comentario;
    }

    /**
     * Establece el comentario.
     *
     * @param comentario coemtario que se desa establecer.
     */
    public void setComentario(Comentario comentario) {
        this.comentario = comentario;
    }

    /**
     * Obtiene la list de comentarios.
     *
     * @return lista de comentarios hechos.
     */
    public List<Comentario> getComentarios() {
        return comentarios;
    }

    /**
     * Establece los comentarios.
     *
     * @param comentarios los comentarios a establecer.
     */
    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    /**
     * Obtiene el usuario normal.
     *
     * @return usuario normal.
     */
    public Normal getNormal() {
        return normal;
    }

    /**
     * Establece el usuario normal.
     *
     * @param normal usuario a establecer.
     */
    public void setNormal(Normal normal) {
        this.normal = normal;
    }

    /**
     * Para obtener el hash del comentario.
     *
     * @return número hash del comentario.
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.idComentario);
        return hash;
    }

    /**
     * Compara si un comentario es igual a otro.
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
        final Comentario other = (Comentario) obj;
        if (!Objects.equals(this.idComentario, other.idComentario)) {
            return false;
        }
        return true;
    }

    /**
     * Método usado para escribir y con ello conocer los atributos de un
     * comentario.
     *
     * @return atributos del comentario en orden.
     */
    @Override
    public String toString() {
        return "Comentario{" + "id=" + idComentario + ", fechaHora=" + fechaHora + ", contenido=" + contenido + ", comun=" + comun + ", comentario=" + comentario + ", comentarios=" + comentarios + ", normal=" + normal + '}';
    }
}
