/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package Clases;

import ObjNegocio.Usuario;
import java.util.Date;



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
        user.setFechaNacimiento(new Date());
        Usuario no = registerNegocio.guardarUsuario(user);
         System.out.println(no.toString());
    }
}
