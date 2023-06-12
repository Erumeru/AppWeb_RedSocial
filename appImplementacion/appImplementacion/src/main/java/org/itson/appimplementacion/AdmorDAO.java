/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.appimplementacion;

import ObjNegocio.Admor;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;
import org.itson.excepciones.DAOException;

/**
 *
 * @author kim, carmen, elmer, marcos
 */
public class AdmorDAO extends BaseDAO<Admor> {

    private MongoDatabase conn;
    private final String COLECCION = "admor";
    private MongoCollection<Admor> collection;
    private static final Logger LOG = Logger.getLogger(AdmorDAO.class.getName());

    public AdmorDAO() {
        conn = Conexion.getInstance();
        collection = conn.getCollection(COLECCION, Admor.class);
    }

    @Override
    public Admor guardar(Admor entidad) throws DAOException {
        try {
            collection.insertOne(entidad);
            return entidad;
        } catch (MongoException e) {
            Logger.getLogger(AdmorDAO.class.getName()).log(Level.SEVERE, null, e);
            throw new DAOException("Error al insertar el usuario administrador");
        }
    }

    @Override
    public ArrayList<Admor> buscarTodos() {
        ArrayList<Admor> admors = new ArrayList<>();
        admors = collection.find().into(admors);
        return admors;
    }

    @Override
    public MongoCollection<Admor> getCollection() {
        MongoDatabase db = Conexion.getInstance();
        MongoCollection<Admor> colleccionAdmor = db.getCollection("admor", Admor.class);
        return colleccionAdmor;
    }

    @Override
    public Admor buscar(Admor entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Admor eliminar(Admor entidad) {
        collection.deleteOne(new Document("id",entidad.getId())); 
        return entidad;
    }

    @Override
    public Admor actualizar(Admor entidad, Admor entidad2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
