/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.appimplementacion;

import ObjNegocio.Admor;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.itson.excepciones.DAOException;

/**
 *
 * @author kim, carmen, elmer, marcos
 */
public class AdmorDAO extends BaseDAO<Admor> {

    /**
     * Atributo para la conexión
     */
    private MongoDatabase conn;
    /**
     * Atributo del nombre de la colección
     */
    private final String COLECCION = "admor";
    /**
     * Atributo de la colección 
     */
    private MongoCollection<Admor> collection;
    /**
     * Atributo log
     */
    private static final Logger LOG = Logger.getLogger(AdmorDAO.class.getName());

    /**
     * Constructor de la clase que 
     * inicializa el atributo MongoCollection.
     */
    public AdmorDAO() {
        conn = Conexion.getInstance();
        collection = conn.getCollection(COLECCION, Admor.class);
    }

    /**
     * Guarda una entidad de tipo Admor en la base de datos MongoDB.
     * @param entidad a insertar en la base.
     * @return regresa la entidad
     * @throws DAOException 
     */
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

    /**
     * Busca todas las entidades en la base de datos MongoDB.
     * @return Una lista de todas las entidades encontradas.
     */
    @Override
    public ArrayList<Admor> buscarTodos() {
        ArrayList<Admor> admors = new ArrayList<>();
        admors = collection.find().into(admors);
        return admors;
    }

    /**
     * Coleccion de la entidad.
     * @return collection
     */
    @Override
    public MongoCollection<Admor> getCollection() {
        MongoDatabase db = Conexion.getInstance();
        MongoCollection<Admor> colleccionAdmor = db.getCollection(COLECCION, Admor.class);
        return colleccionAdmor;
    }

    /**
     * Busca una entidad de tipo Admor dentro de la colección 
     * en la base de datos.
     * @param entidad de tipo Admor.
     * @return 
     */
    @Override
    public Admor buscar(Admor entidad) {
        MongoDatabase db = Conexion.getInstance();
        MongoCollection<Admor> colleccionAdmor = db.getCollection(COLECCION, Admor.class);
        Document filtro = new Document("id", entidad.getId());
        return colleccionAdmor.find(filtro).first();
    }

    /**
     * Elimina una entidad de tipo Admor en la base de datos MongoDB.
     * @param entidad de tipo Admor
     * @return 
     */
    @Override
    public Admor eliminar(Admor entidad) {
        collection.deleteOne(new Document("id", entidad.getId()));
        return entidad;
    }

    /**
     * Actualiza una entidad de tipo Admor en la base de datos MongoDB.
     * @param entidad de tipo Admor a reemplazar.
     * @param entidad2 de tipo Admor nueva.
     * @return 
     */
    @Override
    public Admor actualizar(Admor entidad, Admor entidad2) {
        Document filtro = new Document("_id", entidad.getId());
        Document cambios = new Document("$set", new Document());

        cambios.append("nombre-completo", entidad2.getNombreCompleto());
        cambios.append("correo", entidad2.getCorreo());
        cambios.append("contrasenia", entidad2.getContrasenia());
        cambios.append("avatar", entidad2.getAvatar());
        cambios.append("ciudad", entidad2.getCiudad());
        cambios.append("fecha-nacimiento", entidad2.getFechaNacimiento());
        cambios.append("genero", entidad2.getGenero());
        cambios.append("comun", entidad2.getComun());
        cambios.append("municipio", entidad2.getMunicipio());

        collection.updateOne(filtro, cambios);
        return entidad2;
    }

}