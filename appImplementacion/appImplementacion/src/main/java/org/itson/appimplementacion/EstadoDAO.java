/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.appimplementacion;

import ObjNegocio.Comun;
import ObjNegocio.Estado;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;

/**
 *
 * @author kim, carmen, elmer, marcos
 */
public class EstadoDAO extends BaseDAO<Estado>{

    @Override
    public void guardar(Estado entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Estado> buscarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MongoCollection<Estado> getCollection() {
       MongoDatabase db= Conexion.getInstance();
        MongoCollection<Estado> colleccionEstado = db.getCollection("estado", Estado.class);
        return colleccionEstado;
    }
    
}
