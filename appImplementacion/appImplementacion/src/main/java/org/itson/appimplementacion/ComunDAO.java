/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.appimplementacion;

import ObjNegocio.Comentario;
import ObjNegocio.Comun;
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
public class ComunDAO extends BaseDAO<Comun> {

    private MongoCollection<Comun> collection;
    private static final Logger LOG = Logger.getLogger(AdmorDAO.class.getName());

    public ComunDAO() {
        collection = getCollection();
    }

    @Override
    public Comun guardar(Comun entidad) throws DAOException {
        try {
            collection.insertOne(entidad);
            return entidad;
        } catch (MongoException e) {
            Logger.getLogger(ComunDAO.class.getName()).log(Level.SEVERE, null, e);
            throw new DAOException("Error al insertar el usuario comun");
        }
    }

    @Override
    public ArrayList<Comun> buscarTodos() {
        ArrayList<Comun> comunes = new ArrayList<>();
        comunes = collection.find().into(comunes);
        return comunes;
    }

    @Override
    public MongoCollection<Comun> getCollection() {
        MongoDatabase db = Conexion.getInstance();
        MongoCollection<Comun> colleccionComun = db.getCollection("comun", Comun.class);
        return colleccionComun;
    }

    @Override
    public Comun buscar(Comun entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Comun eliminar(Comun entidad) {
        collection.deleteOne(new Document("id", entidad.getId()));
        return entidad;
    }

    @Override
    public Comun actualizar(Comun entidad, Comun entidad2) {
        Document filtro = new Document("comun", entidad.getClass());
        Document cambios = new Document("$set", new Document("id", entidad2.getId()));
        collection.updateOne(filtro, cambios);
        return entidad2;
    }
}
