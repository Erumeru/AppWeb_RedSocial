/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package Clases;

import Clases.FabricaLogica;
import Clases.ILogica;
import ObjNegocio.Comentario;
import ObjNegocio.Estado;
import ObjNegocio.Usuario;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;


/**
 *
 * @author eruma
 */
public class CALIZSUMSISTEMA {

    public static void main(String[] args) {

         ILogica registerNegocio =new FabricaLogica().crearInstancia();
         Estado estado = new Estado();  
         estado.setNombre("jorge"); 
         
            Estado estado2 = new Estado();  
         estado2.setNombre("yorx4"); 
         
        Estado no = registerNegocio.actualizarEstado(registerNegocio.buscarEstado(estado), estado2);
         System.out.println(no.toString());
    }
}
