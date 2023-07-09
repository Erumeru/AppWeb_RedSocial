/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.appimplementacion;

import ObjNegocio.Admor;
import ObjNegocio.Comentario;
import ObjNegocio.Comun;
import ObjNegocio.Normal;
import ObjNegocio.Usuario;
import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.combine;
import static com.mongodb.client.model.Updates.set;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.BsonDocument;
import org.bson.Document;
import org.bson.codecs.BsonDocumentCodec;
import org.bson.types.ObjectId;
import org.itson.excepciones.DAOException;

/**
 *
 * @author kim, carmen, elmer, marcos
 */
public class ComunDAO extends BaseDAO<Comun> {

    /**
     * Atributo colección
     */
    private MongoCollection<Document> collection;
    /**
     * Atributo log
     */
    private static final Logger LOG = Logger.getLogger(AdmorDAO.class.getName());

    /**
     * Constructor de la clase que inicializa el atributo MongoCollection.
     */
    public ComunDAO() {
        collection = getColl();
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
            Document doc = new Document("contenido", entidad.getContenido())
                    .append("fechaHoraCreacion", entidad.getFechaHoraCreacion())
                    .append("titulo", entidad.getTitulo())
                    .append("usuario", entidad.getUsuario());
            collection.insertOne(doc);
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
        FindIterable<Document> iterComun = collection.find();
        ArrayList<Comun> comun = new ArrayList<>();
        Iterator it = iterComun.iterator();
        while (it.hasNext()) {
            Document doc = (Document) it.next();
            Comun comunDoc = new Comun();
            Document usuario = doc.get("usuario", Document.class);

            if (usuario.get("_id") != null) {
                Admor adm = new Admor();
                adm.setId(new ObjectId(usuario.get("_id").toString()));
                if (new AdmorDAO().buscar(adm) != null) {
                    adm = new AdmorDAO().buscar(adm);
                    comunDoc.setIdComun(doc.getObjectId("_id"));
                    comunDoc = buscar(comunDoc);
                    comunDoc.setUsuario(adm);
                } else {
                    Normal user = new Normal();
                    user.setId(new ObjectId(usuario.get("_id").toString()));
                    if (new NormalDAO().buscar(user) != null) {
                        user = new NormalDAO().buscar(user);
                        comunDoc.setIdComun(doc.getObjectId("_id"));
                        comunDoc = buscar(comunDoc);
                        comunDoc.setUsuario(user);
                        System.out.println(user);
                    }
                }
            }
            if (comunDoc.getIdComun() != null) {
                comun.add(comunDoc);
            }
        }

        return comun;
    }

    /**
     * Coleccion de la entidad
     *
     * @return collection
     */
    public MongoCollection<Document> getColl() {
        MongoDatabase db = Conexion.getInstance();
        MongoCollection<Document> colleccionComun = db.getCollection("comun");
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
        Document filtro = new Document("id", entidad.getIdPost());
        Comun comunEncontrado = colleccionComun.find(filtro).first();
        if (comunEncontrado != null) {
            comunEncontrado.setIdComun(entidad.getIdComun());
        }

        return comunEncontrado;
    }

    /**
     * Metodo que busca y regresa las publicaciones comunes de un usuario
     *
     * @param normal Usuario al que pertenecen publicaciones comunes
     * @return Lista MongoCollection<Comun> con las publicaciones del usuario
     * Normal
     */
    public ArrayList<Comun> getComunesDeNormal(Normal normal) {
        MongoDatabase db = Conexion.getInstance();
        MongoCollection<Comun> colleccionComun = db.getCollection("comun", Comun.class);

        Document filtro = new Document("usuario._id", normal.getId());
        ArrayList<Comun> lista = new ArrayList<>();
        lista = colleccionComun.find(filtro).into(lista);
        return lista;
    }

    public ArrayList<Comentario> buscarComentariosPorComun(String idPost) {
        ArrayList<Comentario> comentarios = new ArrayList<>();
        MongoDatabase db = Conexion.getInstance();
        MongoCollection<Document> colleccionComun = db.getCollection("comun");
        MongoCollection<Document> colleccionComen = db.getCollection("comentario");
        FindIterable<Document> iterComun = colleccionComen.find();

        Document post = colleccionComun.find(Filters.eq("_id", new ObjectId(idPost))).first();
        Iterator it = iterComun.iterator();
        while (it.hasNext()) {
            Document com = (Document) it.next();
            Document comun = com.get("comun", Document.class);
            if (comun.get("idComun") != null) {
                String idcom=comun.get("idComun").toString();
                
                if (idcom.equalsIgnoreCase(idPost)) {
                    System.out.println(com);
                    System.out.println(com.getObjectId("_id"));
                    Comentario comentarioAgg = new Comentario();
                    comentarioAgg.setIdComentario(new ObjectId(com.getObjectId("_id").toString()));
                    Comentario fin=new ComentarioDAO().buscar(comentarioAgg);
                    comentarios.add(fin);
                }
            }
        }
        return comentarios;
    }
    /**
     * Elimina una entidad de tipo Comun en la base de datos MongoDB.
     *
     * @param entidad de tipo Comun
     * @return
     */
    @Override
    public Comun eliminar(Comun entidad) {
        collection.deleteOne(new Document("id", entidad.getIdPost()));
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
        collection.updateOne(eq("_id", entidad.getIdPost()),
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

    @Override
    public MongoCollection<Comun> getCollection() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
