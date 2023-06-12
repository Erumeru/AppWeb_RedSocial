/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.appimplementacion;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

/**
 *
 * @author kim, carmen, elmer, marcos
 */
public class Conexion {
    
     //Atributo de la instancia MongoDatabase
      private static MongoDatabase instancia;

    /**
     * Método que realiza la conexión con la base de datos MondoDB.
     * @return regresa el atributo de la clase
     */
    public static MongoDatabase getInstance() {
        if (instancia == null) {
            CodecRegistry co = fromRegistries(
            MongoClientSettings.getDefaultCodecRegistry(),
            fromProviders(PojoCodecProvider.builder().automatic(true).build()));
            MongoClientSettings setting = MongoClientSettings.builder().codecRegistry(co).build();
            MongoClient conexion = MongoClients.create(setting);
            instancia = conexion.getDatabase("Residuos");
        }
        return instancia;
    }
    
}
