/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.appimplementacion;

import ObjNegocio.Usuario;
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
public class UsuarioDAO extends BaseDAO<Usuario> {

    private MongoCollection<Usuario> collection;
    private static final Logger LOG = Logger.getLogger(UsuarioDAO.class.getName());

    public UsuarioDAO() {
        collection = getCollection();
    }

    @Override
    public ArrayList<Usuario> buscarTodos() {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        usuarios = collection.find().into(usuarios);
        return usuarios;
    }

    @Override
    public MongoCollection<Usuario> getCollection() {
        MongoDatabase db = Conexion.getInstance();
        MongoCollection<Usuario> colleccionUsuario = db.getCollection("usuario", Usuario.class);
        return colleccionUsuario;
    }

    @Override
    public Usuario buscar(Usuario entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario eliminar(Usuario entidad) {
        collection.deleteOne(new Document("id", entidad.getId()));
        return entidad;
    }

    @Override
    public Usuario actualizar(Usuario entidad, Usuario entidad2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario guardar(Usuario entidad) throws DAOException {
        try {
            collection.insertOne(entidad);
            return entidad;
        } catch (MongoException e) {
            Logger.getLogger(EstadoDAO.class.getName()).log(Level.SEVERE, null, e);
            throw new DAOException("Error al insertar un usuario");
        }
    }

}
