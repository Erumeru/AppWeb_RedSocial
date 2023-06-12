/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.appimplementacion;

import com.mongodb.client.MongoCollection;
import java.util.ArrayList;

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
    public abstract void guardar(T entidad);

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
}
