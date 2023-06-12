/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.appimplementacion;

import ObjNegocio.Municipio;
import ObjNegocio.Post;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;

/**
 *
 * @author kim, carmen, elmer, marcos
 */
public class PostDAO extends BaseDAO<Post>{

    @Override
    public void guardar(Post entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Post> buscarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MongoCollection<Post> getCollection() {
       MongoDatabase db= Conexion.getInstance();
        MongoCollection<Post> colleccionPost = db.getCollection("post", Post.class);
        return colleccionPost;
    }
    
}
