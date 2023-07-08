/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.appimplementacion;

import ObjNegocio.Usuario;
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
public class UsuarioDAO extends BaseDAO<Usuario> {

   /**
    * Atributo collection
    */
    private MongoCollection<Usuario> collection;
    /**
     * Atributo log
     */
    private static final Logger LOG = Logger.getLogger(UsuarioDAO.class.getName());

    /**
     * Constructor de la clase que 
     * inicializa el atributo MongoCollection.
     */
    public UsuarioDAO() {
        collection = getCollection();
    }

    /**
     * Busca todas las entidades en la base de datos MongoDB.
     * @return Una lista de todas las entidades encontradas.
     */
    @Override
    public ArrayList<Usuario> buscarTodos() {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        usuarios = collection.find().into(usuarios);
        return usuarios;
    }

    /**
     * Coleccion de la entidad
     * @return collection
     */
    @Override
    public MongoCollection<Usuario> getCollection() {
        MongoDatabase db = Conexion.getInstance();
        MongoCollection<Usuario> colleccionUsuario = db.getCollection("usuario", Usuario.class);
        return colleccionUsuario;
    }

    /**
     * Busca una entidad de tipo Usuario dentro de la colección 
     * en la base de datos.
     * @param entidad de tipo Usuario.
     * @return 
     */
    @Override
    public Usuario buscar(Usuario entidad) {
        MongoDatabase db = Conexion.getInstance();
        MongoCollection<Usuario> colleccionUsuario = db.getCollection("usuario", Usuario.class);
        Document filtro = new Document("id", entidad.getIdUsuario());
        return colleccionUsuario.find(filtro).first();
    }

    /**
     * Elimina una entidad de tipo Usuario en la base de datos MongoDB.
     * @param entidad de tipo Usuario
     * @return 
     */
    @Override
    public Usuario eliminar(Usuario entidad) {
        collection.deleteOne(new Document("id", entidad.getIdUsuario()));
        return entidad;
    }

    /**
     * Actualiza una entidad de tipo Usuario en la base de datos MongoDB.
     * @param entidad de tipo Usuario a reemplazar.
     * @param entidad2 de tipo Usuario nueva.
     * @return 
     */
    @Override
    public Usuario actualizar(Usuario entidad, Usuario entidad2) {
      collection.updateOne(eq("_id", entidad.getIdUsuario()),
                combine(set("nombre-completo", entidad2.getNombreCompleto()),
                        set("correo", entidad2.getCorreo()),
                        set("contrasenia", entidad2.getContrasenia()),
                        set("avatar", entidad2.getAvatar()),
                        set("ciudad", entidad2.getCiudad()),
                        set("fecha-nacimiento", entidad2.getFechaNacimiento()),
                        set("genero", entidad2.getGenero()),
                        set("comun", entidad2.getComun()),
                        set("municipio", entidad2.getMunicipio()),
                        set("telefono", entidad2.getTelefono())));
        return buscar(entidad2);
    }

    /**
     * Guarda una entidad de tipo Usuario en la base de datos MongoDB.
     * @param entidad a insertar en la base.
     * @return regresa la entidad
     */
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

    @Override
    public Usuario buscarRepetido(Usuario entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
