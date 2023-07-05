/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.appimplementacion;

import ObjNegocio.Estado;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.set;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;
import org.itson.excepciones.DAOException;

/**
 *
 * @author kim, carmen, elmer, marcos
 */
public class EstadoDAO extends BaseDAO<Estado> {

    /**
     * Atributo log
     */
    private MongoCollection<Estado> collection;
    /**
     * Atributo colección
     */
    private static final Logger LOG = Logger.getLogger(AdmorDAO.class.getName());

    /**
     * Constructor de la clase que inicializa el atributo MongoCollection.
     */
    public EstadoDAO() {
        collection = getCollection();
    }

    /**
     * Guarda una entidad de tipo Estado en la base de datos MongoDB.
     *
     * @param entidad a insertar en la base.
     * @return regresa la entidad
     */
    @Override
    public Estado guardar(Estado entidad) throws DAOException {
        try {
            collection.insertOne(entidad);
            return entidad;
        } catch (MongoException e) {
            Logger.getLogger(EstadoDAO.class.getName()).log(Level.SEVERE, null, e);
            throw new DAOException("Error al insertar el estado");
        }
    }

    /**
     * Busca todas las entidades en la base de datos MongoDB.
     *
     * @return Una lista de todas las entidades encontradas.
     */
    @Override
    public ArrayList<Estado> buscarTodos() {
        ArrayList<Estado> estados = new ArrayList<>();
        estados = collection.find().into(estados);
        return estados;
    }

    /**
     * Coleccion de la entidad
     *
     * @return collection
     */
    @Override
    public MongoCollection<Estado> getCollection() {
        MongoDatabase db = Conexion.getInstance();
        MongoCollection<Estado> colleccionEstado = db.getCollection("estado", Estado.class);
        return colleccionEstado;
    }

    /**
     * Busca una entidad de tipo Estado dentro de la colección en la base de
     * datos.
     *
     * @param entidad de tipo Estado.
     * @return la entidad
     */
    @Override
    public Estado buscar(Estado entidad) {
        MongoDatabase db = Conexion.getInstance();
        MongoCollection<Estado> colleccionEstado = db.getCollection("estado", Estado.class);
        Document filtro = new Document("id", entidad.getId());
        return colleccionEstado.find(filtro).first();
    }

    /**
     * Elimina una entidad de tipo Estado en la base de datos MongoDB.
     *
     * @param entidad de tipo Estado
     * @return la entidad eliminada
     */
    @Override
    public Estado eliminar(Estado entidad) {
        collection.deleteOne(new Document("id", entidad.getId()));
        return entidad;
    }

    /**
     * Actualiza una entidad de tipo Estado en la base de datos MongoDB.
     *
     * @param entidad de tipo Estado a reemplazar.
     * @param entidad2 de tipo Estado nueva.
     * @return la entidad actualizada
     */
    @Override
    public Estado actualizar(Estado entidad, Estado entidad2) {
        collection.updateOne(eq("_id", entidad.getId()),
                set("nombre", entidad2.getNombre()));
        return buscar(entidad2);
    }

    @Override
    public Estado buscarRepetido(Estado entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
