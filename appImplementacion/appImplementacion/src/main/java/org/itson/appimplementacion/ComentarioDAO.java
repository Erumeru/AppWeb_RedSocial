/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.appimplementacion;

import ObjNegocio.Anclado;
import ObjNegocio.Comentario;
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
public class ComentarioDAO extends BaseDAO<Comentario> {

    /**
     * Atributo colección
     */
    private MongoCollection<Comentario> collection;
    /**
     * Atributo log
     */
    private static final Logger LOG = Logger.getLogger(AdmorDAO.class.getName());

    /**
     * Constructor de la clase que inicializa el atributo MongoCollection.
     */
    public ComentarioDAO() {
        collection = getCollection();
    }

    /**
     * Guarda una entidad de tipo Comentario en la base de datos MongoDB.
     *
     * @param entidad a insertar en la base.
     * @return regresa la entidad
     */
    @Override
    public Comentario guardar(Comentario entidad) throws DAOException {
        try {
            collection.insertOne(entidad);
            return entidad;
        } catch (MongoException e) {
            Logger.getLogger(ComentarioDAO.class.getName()).log(Level.SEVERE, null, e);
            throw new DAOException("Error al insertar el comentario");
        }
    }

    /**
     * Busca todas las entidades en la base de datos MongoDB.
     *
     * @return Una lista de todas las entidades encontradas.
     */
    @Override
    public ArrayList<Comentario> buscarTodos() {
        ArrayList<Comentario> comentarios = new ArrayList<>();
        comentarios = collection.find().into(comentarios);
        return comentarios;
    }

    /**
     * Coleccion de la entidad
     *
     * @return collection
     */
    @Override
    public MongoCollection<Comentario> getCollection() {
        MongoDatabase db = Conexion.getInstance();
        MongoCollection<Comentario> colleccionComentario = db.getCollection("comentario", Comentario.class);
        return colleccionComentario;
    }

    /**
     * Busca una entidad de tipo Comentario dentro de la colección en la base de
     * datos.
     *
     * @param entidad de tipo Comentario.
     * @return
     */
    @Override
    public Comentario buscar(Comentario entidad) {
        MongoDatabase db = Conexion.getInstance();
        MongoCollection<Comentario> colleccionComentario = db.getCollection("comentario", Comentario.class);
        Document filtro = new Document("id", entidad.getId());
        return colleccionComentario.find(filtro).first();
    }

    /**
     * Elimina una entidad de tipo Comentario en la base de datos MongoDB.
     *
     * @param entidad de tipo Comentario
     * @return
     */
    @Override
    public Comentario eliminar(Comentario entidad) {
        collection.deleteOne(new Document("id", entidad.getId()));
        return entidad;
    }

    /**
     * Actualiza una entidad de tipo Comentario en la base de datos MongoDB.
     *
     * @param entidad de tipo Comentario a reemplazar.
     * @param entidad2 de tipo Comentario nueva.
     * @return
     */
    @Override
    public Comentario actualizar(Comentario entidad, Comentario entidad2) {
        collection.updateOne(eq("_id", entidad.getId()),
                combine(set("fechahora-creacion", entidad2.getFechaHora()),
                        set("contenido", entidad2.getContenido()),
                        set("comentario", entidad2.getComentario()),
                        set("comentarios", entidad2.getComentarios())));
        return buscar(entidad2);
    }

}
