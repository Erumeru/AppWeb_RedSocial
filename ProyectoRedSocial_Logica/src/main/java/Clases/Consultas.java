/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Clases;

import ObjNegocio.Comun;
import ObjNegocio.Municipio;
import ObjNegocio.Normal;
import java.util.Date;

/**
 *
 * @author Marcos Toledo 00000234963
 */
public class Consultas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ILogica registerNegocio = new FabricaLogica().crearInstancia();
       
//        Normal normal = new Normal("Elmer Baca", "a@gmail.com", "1", "644444", "uploads/64a90fc9ff3a6f2c0fc9094d.png", "Morelos", new Date(), "Masculino", null, new Municipio());
//        Comun comun = new Comun(normal, new Date(), "Elmer naco", "uploads/64a90fc9ff3a6f2c0fc9094d.png", new Date());
//        registerNegocio.guardarNormal(normal);
//        registerNegocio.guardarComun(comun);
        
        System.out.println(registerNegocio.listaAnclado());
    }
    
}
