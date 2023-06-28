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
import java.util.Date;
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
         Usuario user = new Usuario();  
         user.setNombreCompleto("yorx");
         user.setCiudad("obregones");
         user.setContrasenia("pip");
         user.setCorreo("kaka@gmail");
        
        Usuario no = registerNegocio.guardarUsuario(user);
         System.out.println(no.toString());
    }
}
