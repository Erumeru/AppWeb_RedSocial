/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.appimplementacion;

import ObjNegocio.Normal;
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
public class NormalDAO extends BaseDAO<Normal> {

    private MongoCollection<Normal> collection;
    private static final Logger LOG = Logger.getLogger(NormalDAO.class.getName());

    public NormalDAO() {
        collection = getCollection();
    }

    @Override
    public ArrayList<Normal> buscarTodos() {
        ArrayList<Normal> normales = new ArrayList<>();
        normales = collection.find().into(normales);
        return normales;
    }

    @Override
    public MongoCollection<Normal> getCollection() {
        MongoDatabase db = Conexion.getInstance();
        MongoCollection<Normal> colleccionNormal = db.getCollection("normal", Normal.class);
        return colleccionNormal;
    }

    @Override
    public Normal buscar(Normal entidad) {
        MongoDatabase db = Conexion.getInstance();
        MongoCollection<Normal> colleccionNormal = db.getCollection("normal", Normal.class);
        Document filtro = new Document("id", entidad.getId());
        return colleccionNormal.find(filtro).first();
    }

    @Override
    public Normal eliminar(Normal entidad) {
        collection.deleteOne(new Document("id", entidad.getId()));
        return entidad;
    }

    @Override
    public Normal actualizar(Normal entidad, Normal entidad2) {
        Document filtro = new Document("normal", entidad.getClass());
        Document cambios = new Document("$set", new Document("id", entidad2.getId()));
        collection.updateOne(filtro, cambios);
        return entidad2;
    }

    @Override
    public Normal guardar(Normal entidad) throws DAOException {
        try {
            collection.insertOne(entidad);
            return entidad;
        } catch (MongoException e) {
            Logger.getLogger(EstadoDAO.class.getName()).log(Level.SEVERE, null, e);
            throw new DAOException("Error al insertar un usuario normal");
        }
    }

}
