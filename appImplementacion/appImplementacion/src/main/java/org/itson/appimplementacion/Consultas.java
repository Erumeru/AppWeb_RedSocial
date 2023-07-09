/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package org.itson.appimplementacion;

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
        ComunDAO registerNegocio = new ComunDAO();
        System.out.println(registerNegocio.buscarTodos());
    }
    
}
