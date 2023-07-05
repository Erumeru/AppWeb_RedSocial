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
public class ComunDAO extends BaseDAO<Comun> {

    /**
     * Atributo colección
     */
    private MongoCollection<Comun> collection;
    /**
     * Atributo log
     */
    private static final Logger LOG = Logger.getLogger(AdmorDAO.class.getName());

    /**
     * Constructor de la clase que inicializa el atributo MongoCollection.
     */
    public ComunDAO() {
        collection = getCollection();
    }

    /**
     * Guarda una entidad de tipo Comun en la base de datos MongoDB.
     *
     * @param entidad a insertar en la base.
     * @return regresa la entidad
     */
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

    /**
     * Busca todas las entidades en la base de datos MongoDB.
     *
     * @return Una lista de todas las entidades encontradas.
     */
    @Override
    public ArrayList<Comun> buscarTodos() {
        ArrayList<Comun> comunes = new ArrayList<>();
        comunes = collection.find().into(comunes);
        return comunes;
    }

    /**
     * Coleccion de la entidad
     *
     * @return collection
     */
    @Override
    public MongoCollection<Comun> getCollection() {
        MongoDatabase db = Conexion.getInstance();
        MongoCollection<Comun> colleccionComun = db.getCollection("comun", Comun.class);
        return colleccionComun;
    }

    /**
     * Busca una entidad de tipo Comun dentro de la colección en la base de
     * datos.
     *
     * @param entidad de tipo Comun.
     * @return
     */
    @Override
    public Comun buscar(Comun entidad) {
        MongoDatabase db = Conexion.getInstance();
        MongoCollection<Comun> colleccionComun = db.getCollection("comun", Comun.class);
        Document filtro = new Document("id", entidad.getId());
        return colleccionComun.find(filtro).first();
    }

    /**
     * Elimina una entidad de tipo Comun en la base de datos MongoDB.
     *
     * @param entidad de tipo Comun
     * @return
     */
    @Override
    public Comun eliminar(Comun entidad) {
        collection.deleteOne(new Document("id", entidad.getId()));
        return entidad;
    }

    /**
     * Actualiza una entidad de tipo Comun en la base de datos MongoDB.
     *
     * @param entidad de tipo Comun a reemplazar.
     * @param entidad2 de tipo Comun nueva.
     * @return
     */
    @Override
    public Comun actualizar(Comun entidad, Comun entidad2) {
        collection.updateOne(eq("_id", entidad.getId()),
                combine(set("fechahora-creacion", entidad2.getFechaHoraCreacion()),
                        set("titulo", entidad2.getTitulo()),
                        set("contenido", entidad2.getContenido()),
                        set("fechahora-edicion", entidad2.getFechaHoraEdicion())));
        return buscar(entidad2);
    }

    @Override
    public Comun buscarRepetido(Comun entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
