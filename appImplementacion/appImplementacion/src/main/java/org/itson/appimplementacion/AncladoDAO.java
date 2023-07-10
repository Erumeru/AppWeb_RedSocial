/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.appimplementacion;

import ObjNegocio.Admor;
import ObjNegocio.Anclado;
import ObjNegocio.Comun;
import ObjNegocio.Normal;
import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.combine;
import static com.mongodb.client.model.Updates.set;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.itson.excepciones.DAOException;

/**
 *
 * @author kim, carmen, elmer, marcos
 */
public class AncladoDAO extends BaseDAO<Anclado> {

    /**
     * Atributo de la colección
     */
    private MongoCollection<Document> collection;
    /**
     * Atributo log
     */
    private static final Logger LOG = Logger.getLogger(AdmorDAO.class.getName());

    /**
     * Constructor de la clase que inicializa el atributo MongoCollection.
     */
    public AncladoDAO() {
        collection = getColl();
    }

    public MongoCollection<Document> getColl() {
        MongoDatabase db = Conexion.getInstance();
        MongoCollection<Document> colleccionComun = db.getCollection("Anclado");
        return colleccionComun;
    }

    /**
     * Guarda una entidad de tipo Anclado en la base de datos MongoDB.
     *
     * @param entidad a insertar en la base.
     * @return regresa la entidad
     */
    @Override
    public Anclado guardar(Anclado entidad) throws DAOException {
        try {
            Document doc = new Document("contenido", entidad.getContenido())
                    .append("fechaHoraCreacion", entidad.getFechaHoraCreacion())
                    .append("titulo", entidad.getTitulo())
                    .append("usuario", entidad.getAdmor());
            collection.insertOne(doc);
            ObjectId id = doc.getObjectId("_id");
            entidad.setIdAnclado(id);
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
    public ArrayList<Anclado> buscarTodos() {
        FindIterable<Document> iterComun = collection.find();
        ArrayList<Anclado> anclados = new ArrayList<>();
        Iterator it = iterComun.iterator();
        while (it.hasNext()) {
            Document doc = (Document) it.next();
            Anclado ancladoDoc = new Anclado();
            Document usuario=new Document();
            if (doc.get("admor", Document.class) != null) {
                usuario = doc.get("admor", Document.class);
            }
            if (usuario.get("idAdmor") != null) {
                Admor adm = new Admor();
                adm.setId(new ObjectId(usuario.get("_id").toString()));
                if (new AdmorDAO().buscar(adm) != null) {
                    adm = new AdmorDAO().buscar(adm);
                    ancladoDoc.setIdAnclado(doc.getObjectId("_id"));
                    ancladoDoc = buscar(ancladoDoc);
                    ancladoDoc.setAdmor(adm);
                    ancladoDoc.setTitulo(doc.get("titulo").toString());
                    ancladoDoc.setFechaHoraCreacion((Date) doc.get("fechaHoraCreacion"));
                    ancladoDoc.setContenido(doc.get("contenido").toString());
                }
            }
            if (ancladoDoc.getIdAnclador() != null) {
                anclados.add(ancladoDoc);
            }
        }

        return anclados;
    }

    /**
     * Coleccion de la entidad
     *
     * @return collection
     */
    @Override
    public MongoCollection<Anclado> getCollection() {
        MongoDatabase db = Conexion.getInstance();
        MongoCollection<Anclado> colleccionAnclado = db.getCollection("anclado", Anclado.class);
        return colleccionAnclado;
    }

    /**
     * Busca una entidad de tipo Anclado dentro de la colección en la base de
     * datos.
     *
     * @param entidad de tipo Anclado.
     * @return
     */
    @Override
    public Anclado buscar(Anclado entidad) {
        MongoDatabase db = Conexion.getInstance();
        MongoCollection<Anclado> colleccionAnclado = db.getCollection("anclado", Anclado.class);
        Document filtro = new Document("_id", entidad.getIdPost());
        Anclado anc = colleccionAnclado.find(filtro).first();
        if (anc != null) {
            anc.setIdAnclado(entidad.getIdAnclador());
        }
        return colleccionAnclado.find(filtro).first();
    }

    /**
     * Elimina una entidad de tipo Anclado en la base de datos MongoDB.
     *
     * @param entidad de tipo Anclado
     * @return
     */
    @Override
    public Anclado eliminar(Anclado entidad) {
        collection.deleteOne(new Document("id", entidad.getIdPost()));
        return entidad;
    }

    /**
     * Actualiza una entidad de tipo Anclado en la base de datos MongoDB.
     *
     * @param entidad de tipo Anclado a reemplazar.
     * @param entidad2 de tipo Anclado nueva.
     * @return
     */
    @Override
    public Anclado actualizar(Anclado entidad, Anclado entidad2) {
        collection.updateOne(eq("_id", entidad.getIdAnclador()),
                combine(set("fechahora-creacion", entidad2.getFechaHoraCreacion()),
                        set("titulo", entidad2.getTitulo()),
                        set("contenido", entidad2.getContenido()),
                        set("fechahora-edicion", entidad2.getFechaHoraEdicion())));
        return buscar(entidad2);
    }

    @Override
    public Anclado buscarRepetido(Anclado entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
