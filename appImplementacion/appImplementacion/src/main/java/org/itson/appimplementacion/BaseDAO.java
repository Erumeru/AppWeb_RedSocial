/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.appimplementacion;

import com.mongodb.client.MongoCollection;
import java.util.ArrayList;
import org.itson.excepciones.DAOException;

/**
 *
 * @author kim, carmen, elmer, marcos
 * @param <T>
 */
public abstract class BaseDAO<T> {

    /**
     * Guarda una entidad de tipo User en la base de datos MongoDB.
     *
     * @param entidad La entidad a guardar.
     */
    public abstract T guardar(T entidad) throws DAOException;

    /**
     * Busca todas las entidades en la base de datos MongoDB.
     *
     * @return Una lista de todas las entidades encontradas.
     */
    public abstract ArrayList<T> buscarTodos();

    /**
     * Coleccion de la entidad
     *
     * @return collection
     */
    public abstract MongoCollection<T> getCollection();

    /**
     * Busca la entidad que se le mando como paramentro en la base de datos.
     *
     * @param entidad que se desea buscar.
     * @return la entidad que se encuentra en la base de datos.
     */
    public abstract T buscar(T entidad);

    /**
     * Elimina la entidad que se le encia como parametro en la base de datos.
     *
     * @param entidad que se desea eliminar.
     * @return la entidad eliminada.
     */
    public abstract T eliminar(T entidad);

    /**
     * Modifica la entidad que se le manda como paramentro dentro de la base de
     * datos.
     *
     * @param entidad a modificar.
     * @param entidad2 reemplazo de la entidad.
     * @return entidad reemplazada.
     */
    public abstract T actualizar(T entidad, T entidad2);

}
