/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.appimplementacion;

import ObjNegocio.Comun;
import ObjNegocio.Estado;
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
public class EstadoDAO extends BaseDAO<Estado> {

    private MongoCollection<Estado> collection;
    private static final Logger LOG = Logger.getLogger(AdmorDAO.class.getName());

    public EstadoDAO() {
        collection = getCollection();
    }

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

    @Override
    public ArrayList<Estado> buscarTodos() {
        ArrayList<Estado> estados = new ArrayList<>();
        estados = collection.find().into(estados);
        return estados;
    }

    @Override
    public MongoCollection<Estado> getCollection() {
        MongoDatabase db = Conexion.getInstance();
        MongoCollection<Estado> colleccionEstado = db.getCollection("estado", Estado.class);
        return colleccionEstado;
    }

    @Override
    public Estado buscar(Estado entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Estado eliminar(Estado entidad) {
        collection.deleteOne(new Document("id", entidad.getId()));
        return entidad;
    }

    @Override
    public Estado actualizar(Estado entidad, Estado entidad2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
