/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Clases;

import ObjNegocio.Comentario;
import java.util.GregorianCalendar;

/**
 *
 * @author kim
 */
public class PruebaFuncionamiento {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ILogica registerNegocio =new FabricaLogica().crearInstancia();
         Comentario usuario = new Comentario(new GregorianCalendar(),"contenido");

         registerNegocio.guardarComentario(usuario);
    }
    
}
