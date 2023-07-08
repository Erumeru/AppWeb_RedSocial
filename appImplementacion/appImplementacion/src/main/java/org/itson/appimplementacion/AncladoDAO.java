/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.appimplementacion;

import ObjNegocio.Admor;
import ObjNegocio.Anclado;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.combine;
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
public class AncladoDAO extends BaseDAO<Anclado> {

    /**
     * Atributo de la colección
     */
    private MongoCollection<Anclado> collection;
    /**
     * Atributo log
     */
    private static final Logger LOG = Logger.getLogger(AdmorDAO.class.getName());

    /**
     * Constructor de la clase que inicializa el atributo MongoCollection.
     */
    public AncladoDAO() {
        collection = getCollection();
    }

    /**
     * Guarda una entidad de tipo Anclado en la base de datos MongoDB.
     *
     * @param entidad a insertar en la base.
     * @return regresa la entidad
     */
    @Override
    public Anclado guardar(Anclado entidad) throws DAOException {
        try {
            collection.insertOne(entidad);
            return entidad;
        } catch (MongoException e) {
            Logger.getLogger(AncladoDAO.class.getName()).log(Level.SEVERE, null, e);
            throw new DAOException("Error al insertar el post anclado");
        }
    }

    /**
     * Busca todas las entidades en la base de datos MongoDB.
     *
     * @return Una lista de todas las entidades encontradas.
     */
    @Override
    public ArrayList<Anclado> buscarTodos() {
        ArrayList<Anclado> anclados = new ArrayList<>();
        anclados = collection.find().into(anclados);
        return anclados;
    }

    /**
     * Coleccion de la entidad
     *
     * @return collection
     */
    @Override
    public MongoCollection<Anclado> getCollection() {
        MongoDatabase db = Conexion.getInstance();
        MongoCollection<Anclado> colleccionAnclado = db.getCollection("anclado", Anclado.class);
        return colleccionAnclado;
    }

    /**
     * Busca una entidad de tipo Anclado dentro de la colección en la base de
     * datos.
     *
     * @param entidad de tipo Anclado.
     * @return
     */
    @Override
    public Anclado buscar(Anclado entidad) {
        MongoDatabase db = Conexion.getInstance();
        MongoCollection<Anclado> colleccionAnclado = db.getCollection("anclado", Anclado.class);
        Document filtro = new Document("id", entidad.getIdPost());
        return colleccionAnclado.find(filtro).first();
    }

    /**
     * Elimina una entidad de tipo Anclado en la base de datos MongoDB.
     *
     * @param entidad de tipo Anclado
     * @return
     */
    @Override
    public Anclado eliminar(Anclado entidad) {
        collection.deleteOne(new Document("id", entidad.getIdPost()));
        return entidad;
    }

    /**
     * Actualiza una entidad de tipo Anclado en la base de datos MongoDB.
     *
     * @param entidad de tipo Anclado a reemplazar.
     * @param entidad2 de tipo Anclado nueva.
     * @return
     */
    @Override
    public Anclado actualizar(Anclado entidad, Anclado entidad2) {
        collection.updateOne(eq("_id", entidad.getIdPost()),
                combine(set("fechahora-creacion", entidad2.getFechaHoraCreacion()),
                        set("titulo", entidad2.getTitulo()),
                        set("contenido", entidad2.getContenido()),
                        set("fechahora-edicion", entidad2.getFechaHoraEdicion())));
        return buscar(entidad2);
    }

    @Override
    public Anclado buscarRepetido(Anclado entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
