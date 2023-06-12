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

    private MongoCollection<Post> collection;
    private static final Logger LOG = Logger.getLogger(PostDAO.class.getName());

    public PostDAO() {
        collection = getCollection();
    }

    @Override
    public ArrayList<Post> buscarTodos() {
        ArrayList<Post> posts = new ArrayList<>();
        posts = collection.find().into(posts);
        return posts;
    }

    @Override
    public MongoCollection<Post> getCollection() {
        MongoDatabase db = Conexion.getInstance();
        MongoCollection<Post> colleccionPost = db.getCollection("post", Post.class);
        return colleccionPost;
    }

    @Override
    public Post buscar(Post entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Post eliminar(Post entidad) {
        collection.deleteOne(new Document("id", entidad.getId()));
        return entidad;
    }

    @Override
    public Post actualizar(Post entidad, Post entidad2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

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
