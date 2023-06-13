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

    private MongoCollection<Comentario> collection;
    private static final Logger LOG = Logger.getLogger(AdmorDAO.class.getName());

    public ComentarioDAO() {
        collection = getCollection();
    }

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

    @Override
    public ArrayList<Comentario> buscarTodos() {
        ArrayList<Comentario> comentarios = new ArrayList<>();
        comentarios = collection.find().into(comentarios);
        return comentarios;
    }

    @Override
    public MongoCollection<Comentario> getCollection() {
        MongoDatabase db = Conexion.getInstance();
        MongoCollection<Comentario> colleccionComentario = db.getCollection("comentario", Comentario.class);
        return colleccionComentario;
    }

    @Override
    public Comentario buscar(Comentario entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Comentario eliminar(Comentario entidad) {
        collection.deleteOne(new Document("id", entidad.getId()));
        return entidad;
    }

    @Override
    public Comentario actualizar(Comentario entidad, Comentario entidad2) {
        Document filtro = new Document("comentario", entidad.getClass());
        Document cambios = new Document("$set", new Document("id", entidad2.getId()));
        collection.updateOne(filtro, cambios);
        return entidad2;
    }

}
