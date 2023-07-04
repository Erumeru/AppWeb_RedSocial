/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package Clases;

import ObjNegocio.Admor;
import ObjNegocio.Usuario;
import java.util.Date;
import org.bson.types.ObjectId;



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
        Admor adm=new Admor();
        adm.setId(new ObjectId("64a36c5f3dee74217c3b4782"));
        adm=registerNegocio.buscarAdmor(adm);
        System.out.println(adm.getId().toString());
        Admor admact= adm;
        admact.setAvatar("p[ene");
         //   Usuario no = registerNegocio.guardarUsuario(user);
         Admor act=registerNegocio.actualizarAdmor(adm, admact);
         System.out.println(act.getAvatar());
    }
}
