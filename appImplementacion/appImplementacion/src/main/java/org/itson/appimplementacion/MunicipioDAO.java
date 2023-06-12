/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.appimplementacion;

import ObjNegocio.Estado;
import ObjNegocio.Municipio;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;

/**
 *
 * @author kim, carmen, elmer, marcos
 */
public class MunicipioDAO extends BaseDAO<Municipio>{

    @Override
    public void guardar(Municipio entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Municipio> buscarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MongoCollection<Municipio> getCollection() {
        MongoDatabase db= Conexion.getInstance();
        MongoCollection<Municipio> colleccionMunicipio = db.getCollection("municipio", Municipio.class);
        return colleccionMunicipio;
    }
    
}
