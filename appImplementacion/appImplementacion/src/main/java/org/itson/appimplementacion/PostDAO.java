/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.appimplementacion;

import ObjNegocio.Normal;
import ObjNegocio.Post;
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
public class PostDAO extends BaseDAO<Post> {

    /**
     * Atributo colección
     */
    private MongoCollection<Post> collection;
    /**
     * Atributo log
     */
    private static final Logger LOG = Logger.getLogger(PostDAO.class.getName());

    /**
     * Constructor de la clase que 
     * inicializa el atributo MongoCollection.
     */
    public PostDAO() {
        collection = getCollection();
    }

    /**
     * Busca todas las entidades en la base de datos MongoDB.
     * @return Una lista de todas las entidades encontradas.
     */
    @Override
    public ArrayList<Post> buscarTodos() {
        ArrayList<Post> posts = new ArrayList<>();
        posts = collection.find().into(posts);
        return posts;
    }

    /**
     * Coleccion de la entidad
     * @return collection
     */
    @Override
    public MongoCollection<Post> getCollection() {
        MongoDatabase db = Conexion.getInstance();
        MongoCollection<Post> colleccionPost = db.getCollection("post", Post.class);
        return colleccionPost;
    }

    /**
     * Busca una entidad de tipo Post dentro de la colección 
     * en la base de datos.
     * @param entidad de tipo Post.
     * @return 
     */
    @Override
    public Post buscar(Post entidad) {
        MongoDatabase db = Conexion.getInstance();
        MongoCollection<Post> colleccionPost = db.getCollection("post", Post.class);
        Document filtro = new Document("id", entidad.getId());
        return colleccionPost.find(filtro).first();
    }

    /**
     * Elimina una entidad de tipo Post en la base de datos MongoDB.
     * @param entidad de tipo Post
     * @return 
     */
    @Override
    public Post eliminar(Post entidad) {
        collection.deleteOne(new Document("id", entidad.getId()));
        return entidad;
    }

    /**
     * Actualiza una entidad de tipo Post en la base de datos MongoDB.
     * @param entidad de tipo Post a reemplazar.
     * @param entidad2 de tipo Post nueva.
     * @return 
     */
    @Override
    public Post actualizar(Post entidad, Post entidad2) {
     Document filtro = new Document("_id", entidad.getId());
        Document cambios = new Document("$set", new Document());

        cambios.append("fechahora-creacion", entidad2.getFechaHoraCreacion());
        cambios.append("titulo", entidad2.getTitulo());
        cambios.append("contenido", entidad2.getContenido());
        cambios.append("fechahora-edicion", entidad2.getFechaHoraEdicion());

        collection.updateOne(filtro, cambios);
        return entidad2;
    }

    /**
     * Guarda una entidad de tipo Post en la base de datos MongoDB.
     * @param entidad a insertar en la base.
     * @return regresa la entidad
     */
    @Override
    public Post guardar(Post entidad) throws DAOException {
        try {
            collection.insertOne(entidad);
            return entidad;
        } catch (MongoException e) {
            Logger.getLogger(EstadoDAO.class.getName()).log(Level.SEVERE, null, e);
            throw new DAOException("Error al insertar un post");
        }
    }

}
