/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package Clases;

import ObjNegocio.Admor;
import ObjNegocio.Comun;
import ObjNegocio.Post;
import ObjNegocio.Usuario;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;



/**
 *
 * @author eruma
 */
public class CALIZSUMSISTEMA {

    public static void main(String[] args) {

         ILogica registerNegocio =new FabricaLogica().crearInstancia();
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
        Post post = new Post();
        post.setFechaHoraCreacion(new Date());
        post.setContenido("popo");
        post.setTitulo("Hola mundo");
        Post po = registerNegocio.guardarPost(post);
        
        Post post2 = new Post();
        post.setFechaHoraCreacion(new Date());
        post.setContenido("popo");
        post.setTitulo("Hola mundo");
        po = registerNegocio.guardarPost(post2);
        
        Post post3 = new Post();
        post.setFechaHoraCreacion(new Date());
        post.setContenido("popo");
        post.setTitulo("Hola mundo");
        po = registerNegocio.guardarPost(post3);
        
        Post post4 = new Post();
        post.setFechaHoraCreacion(new Date());
        post.setContenido("popo");
        post.setTitulo("Hola mundo");
        po = registerNegocio.guardarPost(post4);
        
         Usuario user = new Usuario();  
         user.setNombreCompleto("yorx");
         user.setCiudad("obregones");
         user.setContrasenia("pip");
         user.setCorreo("kaka@gmail");
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
        
        Comun comun = new Comun(new Date(), "prueba 1","tilin");
        Comun comun2 = new Comun(new Date(), "prueba 2","tilina");
        Comun comun3 = new Comun(new Date(), "prueba 3","tuneado");
        comun.setUsuario(user);
        comun2.setUsuario(user);
        comun3.setUsuario(user);
        
        List<Comun> lista = new ArrayList<>();
        lista.add(comun);
        lista.add(comun2);
        lista.add(comun3);
        
        for (Comun elemento : lista) {
            
        }
        
        user.setComun(lista);
        
//        Comun co = registerNegocio.guardarComun(comun);
//        Usuario no = registerNegocio.guardarUsuario(user);
        
        
//        Admor admor = new Admor();
//        admor.setNombreCompleto("titi");
//        admor.setCiudad("city");
//        admor.set
//        
        
        
    }
}
