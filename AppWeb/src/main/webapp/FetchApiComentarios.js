/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

const obtenerUsuario = () => {
  return new Promise((resolve, reject) => {
    const solicitud = new XMLHttpRequest();
    solicitud.open("GET", "/Posts", true);
    solicitud.onreadystatechange = function () {
      if (solicitud.readyState === 4 && solicitud.status === 200) {
        const usuario = JSON.parse(solicitud.responseText);
        resolve(usuario); // Resuelve la promesa con el usuario
      } else if (solicitud.readyState === 4) {
        reject(new Error("No se pudo obtener el usuario")); // Rechaza la promesa en caso de error
      }
    };
    //tilin
    solicitud.send();
  });
};

window.onload = function(){
    
        
    const subirComentario = document.getElementById("send-comment");
    subirComentario.onclick = consultarDatos;
    
    
      const consultarDatos = () => {
        
        const fechaHoraCreacion = new Date();
        const contenido = document.getElementById("textfield-comment");
        
        
        const comentario ={
            contenido,
            fechaHoraCreacion,
            obtenerUsuario
        }
          
        console.log(JSON.stringify(comentario));
        // Enviar datos al server con FetchAPI (Formato JSON)
        fetch("http://localhost:8080/AppWeb/mainPublicaciones?action=subirComentario", {
            method: "POST",
            body: JSON.stringify(comentario),
            headers: {
                "content-type": "application/json"
            }
        }).then(response => {
            subirComentario.disabled = false;
            return response.json();
        }).then(response => {
            alert(comentario.nombre);
        }).catch(err => {
            subirComentario.disabled = false;
            //Tilin
            console.error(err);
        });

//        fetch("http://localhost:8080/AppWeb/mainPublicaciones?action=subirPost").then(response => {
//            return response.text();
//        }).then(text => {
//            const divMensaje = document.getElementById("container-publicaciones");
//            divMensaje.innerHTML = text;
//            console.log(texto)
//
//        }).catch(err => {
//            console.error(err)
//        });
        
        
    }
    
}

