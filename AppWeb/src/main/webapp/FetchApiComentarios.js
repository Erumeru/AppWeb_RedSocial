/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

window.onload = function () {

    const guardarComentario = (event) => {
        // evento que ejecuta el guaradar 
        const boton = event.target;
        // primer parent al form, segundo parent al div 
        const commentsContainer = boton.parentNode.parentNode;
        // se accede al input del contenido y se obtiene el valor
        const contenido = commentsContainer.querySelector('input[type="text"]').value;  // Obtener el valor del comentario especÃ­fico
        // se usa para traer el objeto comun del div 
        const comun = commentsContainer.getAttribute('objeto-comun');
        // se crea la fecha y hora actual
        const fechaHora = new Date();
        // se obtiene el boton y se deshabilita para evitar doble click
        const subirComentario = boton;
        subirComentario.disabled = true;
        // se crea comentario
        const comentario = {
            comun,
            contenido,
            fechaHora
        };
        console.table(comentario);
        console.log(JSON.stringify(comentario));
        // Enviar datos al servidor con FetchAPI (Formato JSON)
        fetch("http://localhost:8080/AppWeb/Posts?action=subirComentario", {
            method: "POST",
            body: JSON.stringify(comentario),
            headers: {
                "content-type": "application/json"
            }
        }).then(response => {
            // volvemos a habilitar el btn
            subirComentario.disabled = false;
            return response.json();
        }).then(comentario => {
        //    console.log(comentario);
        alert("Comentario Creado, recarga la página!");
        }).catch(err => {
            subirComentario.disabled = false;
             swal("¡Hey!", "Eres admin, no puedes comentar", "error")
            console.error(err);
        });
    };
    // obtenemos el btn para enviar el comentario
    const btnGuardar = document.getElementsByClassName("send-comment");
    // por cada publicacion que se comenta hay distinto onclick 
    for (let i = 0; i < btnGuardar.length; i++) {
        let boton = btnGuardar[i];
        boton.onclick = guardarComentario;
    }
};