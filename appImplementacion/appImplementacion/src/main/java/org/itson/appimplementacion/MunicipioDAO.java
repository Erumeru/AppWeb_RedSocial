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
public class MunicipioDAO extends BaseDAO<Municipio> {

    /**
     * Atributo colección
     */
    private MongoCollection<Municipio> collection;
    /**
     * Atributo log
     */
    private static final Logger LOG = Logger.getLogger(MunicipioDAO.class.getName());

    /**
     * Constructor de la clase que 
     * inicializa el atributo MongoCollection.
     */
    public MunicipioDAO() {
        collection = getCollection();
    }

    /**
     * Busca todas las entidades en la base de datos MongoDB.
     * @return Una lista de todas las entidades encontradas.
     */
    @Override
    public ArrayList<Municipio> buscarTodos() {
        ArrayList<Municipio> municipios = new ArrayList<>();
        municipios = collection.find().into(municipios);
        return municipios;
    }

    /**
     * Coleccion de la entidad
     * @return collection
     */
    @Override
    public MongoCollection<Municipio> getCollection() {
        MongoDatabase db = Conexion.getInstance();
        MongoCollection<Municipio> colleccionMunicipio = db.getCollection("municipio", Municipio.class);
        return colleccionMunicipio;
    }

    /**
     * Busca una entidad de tipo Municipio dentro de la colección 
     * en la base de datos.
     * @param entidad de tipo Municipio.
     * @return 
     */
    @Override
    public Municipio buscar(Municipio entidad) {
        MongoDatabase db = Conexion.getInstance();
        MongoCollection<Municipio> colleccionMunicipio = db.getCollection("municipio", Municipio.class);
        Document filtro = new Document("id", entidad.getId());
        return colleccionMunicipio.find(filtro).first();
    }

    /**
     * Elimina una entidad de tipo Municipio en la base de datos MongoDB.
     * @param entidad de tipo Municipio
     * @return 
     */
    @Override
    public Municipio eliminar(Municipio entidad) {
        collection.deleteOne(new Document("id", entidad.getId()));
        return entidad;
    }

    /**
     * Actualiza una entidad de tipo Municipio en la base de datos MongoDB.
     * @param entidad de tipo Municipio a reemplazar.
     * @param entidad2 de tipo Municipio nueva.
     * @return 
     */
    @Override
    public Municipio actualizar(Municipio entidad, Municipio entidad2) {
        collection.updateOne(eq("_id", entidad.getId()),
                set("nombre", entidad2.getNombre()));
        return buscar(entidad2);
    }

    /**
     * Guarda una entidad de tipo Municipio en la base de datos MongoDB.
     * @param entidad a insertar en la base.
     * @return regresa la entidad
     */
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
