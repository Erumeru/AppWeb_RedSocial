/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.appimplementacion;

import org.itson.interfaces.IFachadaDatos;

/**
 *
 * @author kim, carmen, elmer, marcos
 */
public class FabricaDatos {
     public static IFachadaDatos dameInstancia(){
        return new FachadaDatos();
    }
}
