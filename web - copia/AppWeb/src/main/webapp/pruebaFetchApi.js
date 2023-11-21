/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

window.onload = function(){
    
    const consultarDatos = () => {
        console.log(JSON.stringify(usuario));
        // Enviar datos al server con FetchAPI (Formato JSON)
        fetch("http://localhost:8080/AppWeb/mainPublicaciones?action=subirPost", {
            method: "POST",
            body: JSON.stringify(usuario),
            headers: {
                "content-type": "application/json"
            }
        }).then(response => {
            btnGuardar.disabled = false;
            return response.json();
        }).then(response => {
            alert(usuario.nombre);
        }).catch(err => {
            btnGuardar.disabled = false;
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
    
    
    const btnSubirPost = document.getElementById("btn-subir");
    btnSubirPost.onclick = consultarDatos;
}
