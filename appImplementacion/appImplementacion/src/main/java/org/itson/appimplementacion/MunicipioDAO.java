/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.appimplementacion;

import ObjNegocio.Estado;
import ObjNegocio.Municipio;
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
public class MunicipioDAO extends BaseDAO<Municipio> {

    private MongoCollection<Municipio> collection;
    private static final Logger LOG = Logger.getLogger(MunicipioDAO.class.getName());

    public MunicipioDAO() {
        collection = getCollection();
    }

    @Override
    public ArrayList<Municipio> buscarTodos() {
        ArrayList<Municipio> municipios = new ArrayList<>();
        municipios = collection.find().into(municipios);
        return municipios;
    }

    @Override
    public MongoCollection<Municipio> getCollection() {
        MongoDatabase db = Conexion.getInstance();
        MongoCollection<Municipio> colleccionMunicipio = db.getCollection("municipio", Municipio.class);
        return colleccionMunicipio;
    }

    @Override
    public Municipio buscar(Municipio entidad) {
        MongoDatabase db = Conexion.getInstance();
        MongoCollection<Municipio> colleccionMunicipio = db.getCollection("municipio", Municipio.class);
        Document filtro = new Document("id", entidad.getId());
        return colleccionMunicipio.find(filtro).first();
    }

    @Override
    public Municipio eliminar(Municipio entidad) {
        collection.deleteOne(new Document("id", entidad.getId()));
        return entidad;
    }

    @Override
    public Municipio actualizar(Municipio entidad, Municipio entidad2) {
        Document filtro = new Document("municipio", entidad.getClass());
        Document cambios = new Document("$set", new Document("id", entidad2.getId()));
        collection.updateOne(filtro, cambios);
        return entidad2;
    }

    @Override
    public Municipio guardar(Municipio entidad) throws DAOException {
        try {
            collection.insertOne(entidad);
            return entidad;
        } catch (MongoException e) {
            Logger.getLogger(EstadoDAO.class.getName()).log(Level.SEVERE, null, e);
            throw new DAOException("Error al insertar el municipio");
        }
    }

}
