/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.appimplementacion;

import ObjNegocio.Normal;
import ObjNegocio.Post;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;

/**
 *
 * @author kim, carmen, elmer, marcos
 */
public class NormalDAO extends BaseDAO<Normal>{

    @Override
    public void guardar(Normal entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Normal> buscarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MongoCollection<Normal> getCollection() {
          MongoDatabase db= Conexion.getInstance();
        MongoCollection<Normal> colleccionNormal = db.getCollection("normal", Normal.class);
        return colleccionNormal;
    }
    
}
