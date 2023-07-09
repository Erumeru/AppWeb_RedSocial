/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package org.itson.appimplementacion;

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
        System.out.println(new ComunDAO().buscarComentariosPorComun("64aa3001242d636eed7358ed"));
    }
    
}
