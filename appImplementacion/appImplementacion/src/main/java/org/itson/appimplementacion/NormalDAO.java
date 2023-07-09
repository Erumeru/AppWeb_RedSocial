/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.appimplementacion;

import ObjNegocio.Normal;
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
public class NormalDAO extends BaseDAO<Normal> {

    /**
     * Atributo colección
     */
    private MongoCollection<Normal> collection;
    /**
     * Atributo log
     */
    private static final Logger LOG = Logger.getLogger(NormalDAO.class.getName());

    /**
     * Constructor de la clase que inicializa el atributo MongoCollection.
     */
    /**
     * Atributo del nombre de la colección
     */
    private final String COLECCION = "normal";

    public NormalDAO() {
        collection = getCollection();
    }

    /**
     * Busca todas las entidades en la base de datos MongoDB.
     *
     * @return Una lista de todas las entidades encontradas.
     */
    @Override
    public ArrayList<Normal> buscarTodos() {
        ArrayList<Normal> normales = new ArrayList<>();
        normales = collection.find().into(normales);
        return normales;
    }

    /**
     * Coleccion de la entidad
     *
     * @return collection
     */
    @Override
    public MongoCollection<Normal> getCollection() {
        MongoDatabase db = Conexion.getInstance();
        MongoCollection<Normal> colleccionNormal = db.getCollection("normal", Normal.class);
        return colleccionNormal;
    }

    /**
     * Busca una entidad de tipo Normal dentro de la colección en la base de
     * datos.
     *
     * @param entidad de tipo Normal.
     * @return
     */
    @Override
    public Normal buscar(Normal entidad) {
        MongoDatabase db = Conexion.getInstance();
        MongoCollection<Normal> colleccionNormal = db.getCollection("normal", Normal.class);
        Document filtro = new Document("_id", entidad.getId());
        Normal resultado=colleccionNormal.find(filtro).first();
        if(resultado!=null) resultado.setId(entidad.getId());
        return resultado;
    }

    /**
     * Elimina una entidad de tipo Normal en la base de datos MongoDB.
     *
     * @param entidad de tipo Normal
     * @return
     */
    @Override
    public Normal eliminar(Normal entidad) {
        collection.deleteOne(new Document("_id", entidad.getId()));
        return entidad;
    }

    /**
     * Actualiza una entidad de tipo Normal en la base de datos MongoDB.
     *
     * @param entidad de tipo Normal a reemplazar.
     * @param entidad2 de tipo Normal nueva.
     * @return
     */
    @Override
    public Normal actualizar(Normal entidad, Normal entidad2) {
        collection.updateOne(eq("_id", entidad.getId()),
                combine(set("nombreCompleto", entidad2.getNombreCompleto()),
                        set("correo", entidad2.getCorreo()),
                        set("contrasenia", entidad2.getContrasenia()),
                        set("avatar", entidad2.getAvatar()),
                        set("ciudad", entidad2.getCiudad()),
                        set("fecha-nacimiento", entidad2.getFechaNacimiento()),
                        set("genero", entidad2.getGenero()),
                        set("comun", entidad2.getComun()),
                        set("municipio", entidad2.getMunicipio()),
                        set("municipio", entidad2.getMunicipio())));
        return buscar(entidad2);
    }

    /**
     * Guarda una entidad de tipo Normal en la base de datos MongoDB.
     *
     * @param entidad a insertar en la base.
     * @return regresa la entidad
     */
    @Override
    public Normal guardar(Normal entidad) throws DAOException {
        Normal elemento = buscarRepetido(entidad);
        if (elemento != null) {
            throw new DAOException("Error al guardar.");
        } else {
            collection.insertOne(entidad);
            return entidad;
        }
    }

    /**
     * Busca si la entidad ya esta en la base
     * @param entidad a buscar
     * @return la entidad en caso de estar 
     */
    @Override
    public Normal buscarRepetido(Normal entidad) {
        MongoDatabase db = Conexion.getInstance();
        MongoCollection<Normal> colleccionNormal = db.getCollection(COLECCION, Normal.class);
        Document filtro = new Document("correo", entidad.getCorreo()).append("contrasenia", entidad.getContrasenia()).append("telefono", entidad.getTelefono());
        return colleccionNormal.find(filtro).first();
    }

}
