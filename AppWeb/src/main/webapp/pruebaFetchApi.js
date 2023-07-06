/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

window.onload = function(){
    
    const consultarDatos = () => {
        fetch("http://localhost:8080/AppWeb/mainPublicaciones?action=subirPost").then(response => {
            return response.text();
        }).then(text => {
            const divMensaje = document.getElementById("container-publicaciones");
            divMensaje.innerHTML = text;
            console.log(texto)

        }).catch(err => {
            console.error(err)
        });
        
        
    }
    
    
    const btnSubirPost = document.getElementById("btn-subir");
    btnSubirPost.onclick = consultarDatos;
}
