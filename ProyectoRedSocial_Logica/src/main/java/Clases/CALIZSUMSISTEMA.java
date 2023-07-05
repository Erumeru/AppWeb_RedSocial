/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package Clases;

import ObjNegocio.Admor;
import ObjNegocio.Comun;
import ObjNegocio.Normal;
import ObjNegocio.Post;
import ObjNegocio.Usuario;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author eruma
 */
public class CALIZSUMSISTEMA {

    public static void main(String[] args) {

        ILogica registerNegocio = new FabricaLogica().crearInstancia();
//         Usuario user = new Usuario();  
//         user.setNombreCompleto("yorx");
//         user.setCiudad("obregones");
//         user.setContrasenia("pip");
//         user.setCorreo("kaka@gmail");
//        user.setFechaNacimiento(new Date());
//        Admor adm=new Admor();
//        adm.setId(new ObjectId("64a36c5f3dee74217c3b4782"));
//        adm=registerNegocio.buscarAdmor(adm);
//      //  System.out.println(adm.getId().toString());
//        Admor admact= adm;
//        admact.setAvatar("p[ene");
//        Admor adddd=new Admor();
//        adddd.setNombreCompleto("sisiis");
//       adddd= registerNegocio.guardarAdmor(adddd);
//        System.out.println(adddd.getId());
//         //   Usuario no = registerNegocio.guardarUsuario(user);
//         Admor act=registerNegocio.actualizarAdmor(adm, admact);
//       //  System.out.println(act.getAvatar());
        Comun post = new Comun(new Date(), "primer post", "Z:\\ProfilePics\\a chambear.png");
        // Post po = registerNegocio.guardarPost(post);

        Comun post2 = new Comun(new Date(), "post 2", "Z:\\ProfilePics\\awd.png");

        //  po = registerNegocio.guardarPost(post2);
        Normal user = new Normal();
        user.setNombreCompleto("post");
        user.setCiudad("post");
        user.setContrasenia("post");
        user.setCorreo("post");
        user.setFechaNacimiento(new Date());
//        Admor adm=new Admor();
//        adm.setId(new ObjectId("64a36c5f3dee74217c3b4782"));
//        adm=registerNegocio.buscarAdmor(adm);
//        System.out.println(adm.getId().toString());
//        Admor admact= adm;
//        admact.setAvatar("p[ene");
//        Admor adddd=new Admor();
//        adddd.setNombreCompleto("sisiis");
//       adddd= registerNegocio.guardarAdmor(adddd);
//        System.out.println(adddd.getId());
//            Usuario no = registerNegocio.guardarUsuario(user);
//         Admor act=registerNegocio.actualizarAdmor(adm, admact);
//         System.out.println(act.getAvatar());
        //user.setComun(Arrays.asList(post,post2));
//        Comun comun = new Comun(new Date(), "prueba 1","tilin");
//        Comun comun2 = new Comun(new Date(), "prueba 2","tilina");
//        Comun comun3 = new Comun(new Date(), "prueba 3","tuneado");
        post.setUsuario(user);
        post2.setUsuario(user);

        registerNegocio.guardarComun(post);
        registerNegocio.guardarComun(post2);

//        Comun co = registerNegocio.guardarComun(comun);
//        Usuario no = registerNegocio.guardarUsuario(user);
//        Admor admor = new Admor();
//        admor.setNombreCompleto("titi");
//        admor.setCiudad("city");
//        admor.set
//        
    }
}
