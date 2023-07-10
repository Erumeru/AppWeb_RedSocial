/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package org.itson.appimplementacion;

import ObjNegocio.Anclado;
import ObjNegocio.Comun;
import ObjNegocio.Normal;
import org.bson.types.ObjectId;

/**
 *
 * @author eruma
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
       // System.out.println(new ComunDAO().buscarTodos());
    //   Anclado ac=new Anclado();
      // ac.setIdAnclado(new ObjectId("64ab62994ba5ba22abcaa87e"));
     ComunDAO registerNegocio = new ComunDAO();
        //System.out.println(registerNegocio.buscarTodos());
        //Anclado com=new Anclado();
        Normal cm=new Normal();
        cm.setId(new ObjectId("64aba3da3da942504a185011"));
       // com.setIdAnclado(new ObjectId("64ab6dc3cec11e5f328b63e8"));
       
        System.out.println(registerNegocio.getComunesDeNormal(cm));
    }
    
}
