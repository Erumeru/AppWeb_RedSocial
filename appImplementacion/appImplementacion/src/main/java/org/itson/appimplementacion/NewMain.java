/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package org.itson.appimplementacion;

import ObjNegocio.Anclado;
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
      Normal nnr=new Normal();
      nnr.setId(new ObjectId("64aa3001242d636eed7358ec"));
        System.out.println(new ComunDAO().getComunesDeNormal(nnr));
    }
    
}
