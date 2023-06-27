/**
 * ControlComentario.java creada el 27/06/2023.
 */
package Clases;

import ObjNegocio.Comentario;
import java.util.List;
import org.itson.appimplementacion.FabricaDatos;
import org.itson.appimplementacion.FachadaDatos;
import org.itson.interfaces.IFachadaDatos;

/**
 * Clase para el control de acceso a operaciones CRUD de usuarios.
 *
 * @author Marcos x Elmer x Kim x Carmen
 */
public class ControlComentario {

    /**
     * Ayuda a acceder a la fachada de datos
     */
    public IFachadaDatos datos = new FachadaDatos();

    /**
     * Busca un comentario.
     *
     * @param comentario comentario que se desea buscar.
     * @return regresa el comentario encontrado.
     */
    public Comentario buscarComentario(Comentario comentario) {
        datos = FabricaDatos.dameInstancia();
        return datos.buscarComentario(comentario);
    }

    /**
     * Actualiza un comntario.
     *
     * @param comentario comentario que se desea actualizar.
     * @return regresa el comentario actualizado.
     */
    public Comentario actualizarComentario(Comentario comentario) {
        datos = FabricaDatos.dameInstancia();
        return datos.actualizarComentario(comentario);
    }

    /**
     * Elimina un comentario.
     *
     * @param comentario comentario que se desea eliminar.
     * @return regresa el comentario eliminado.
     */
    public Comentario eliminarComentario(Comentario comentario) {
        datos = (IFachadaDatos) FabricaLogica.crearInstancia();
        return datos.eliminarComentario(comentario);
    }

    /**
     * Guarda un comentario.
     *
     * @param comentario comentario que se desea guardar.
     * @return regresa el comentario guardado.
     */
    public Comentario guardarComentario(Comentario comentario) {
        datos = FabricaDatos.dameInstancia();
        return datos.guardarComentario(comentario);
    }
}
