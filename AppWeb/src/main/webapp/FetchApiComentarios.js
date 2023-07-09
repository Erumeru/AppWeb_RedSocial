/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

window.onload = function () {

    const guardarComentario = () => {
        const commentsContainer = document.querySelector('.comments-container');
        // Obtener el valor del atributo data-item
        const comun = commentsContainer.getAttribute('objeto-comun');

        const fechaHora = new Date();

        const contenido = document.getElementById("textfield-comment").value;

        const subirComentario = document.getElementById("send-comment");
        subirComentario.disabled = true;
        const comentario = {
            comun,
            contenido,
            fechaHora
        };
        console.table(comentario);
        console.log(JSON.stringify(comentario));

        // Enviar datos al server con FetchAPI (Formato JSON)
        fetch("http://localhost:8080/AppWeb/Posts?action=subirComentario", {
            method: "POST",
            body: JSON.stringify(comentario),
            headers: {
                "content-type": "application/json"
            }
        }).then(response => {
            //subirComentario.disabled = false;
            return response.json();
        }).then(comentario => {
            console.log(comentario);
            alert(comentario.contenido);
        }).catch(err => {
            //subirComentario.disabled = false;
            //Tilin
            console.error(err);
        });
    };

    const btnGuardar = document.getElementsByClassName("send-comment");

    for (let i = 0; btnGuardar.length; i++) {
        let boton = btnGuardar[i];
        boton.onclick = guardarComentario;
    }

};

