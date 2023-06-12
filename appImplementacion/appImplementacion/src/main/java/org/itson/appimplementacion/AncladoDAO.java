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

    private MongoCollection<Anclado> collection;
    private static final Logger LOG = Logger.getLogger(AdmorDAO.class.getName());

    public AncladoDAO() {
        collection = getCollection();
    }

    @Override
    public Anclado guardar(Anclado entidad) throws DAOException {
        try {
            collection.insertOne(entidad);
            return entidad;
        } catch (MongoException e) {
            Logger.getLogger(AncladoDAO.class.getName()).log(Level.SEVERE, null, e);
            throw new DAOException("Error al insertar el itinerario");
        }
    }

    @Override
    public ArrayList<Anclado> buscarTodos() {
        ArrayList<Anclado> anclados = new ArrayList<>();
        anclados = collection.find().into(anclados);
        return anclados;
    }

    @Override
    public MongoCollection<Anclado> getCollection() {
        MongoDatabase db = Conexion.getInstance();
        MongoCollection<Anclado> colleccionAnclado = db.getCollection("anclado", Anclado.class);
        return colleccionAnclado;
    }

    @Override
    public Anclado buscar(Anclado entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Anclado eliminar(Anclado entidad) {
        collection.deleteOne(new Document("id", entidad.getId()));
        return entidad;
    }

    @Override
    public Anclado actualizar(Anclado entidad, Anclado entidad2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
