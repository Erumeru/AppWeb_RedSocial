/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */

window.onload = function () {

    const guardarComun = () => {
        const btnSubir = document.getElementById("btn-subir");
        const fechaHoraCreacion = new Date();
        const titulo = document.getElementById("txt-titulo").value;
        const contenido = document.getElementById("txt-contenido").value;
        const fechaHoraEdicion = new Date();

        // se crea comentario
        const comun = {
            fechaHoraCreacion,
            contenido,
            titulo,
            fechaHoraEdicion
        };
        console.table(comun);
        console.log(JSON.stringify(comun));
        // Enviar datos al servidor con FetchAPI (Formato JSON)
        fetch("http://localhost:8080/AppWeb/Posts?action=subirComun", {
            method: "POST",
            body: JSON.stringify(comun),
            headers: {
                "content-type": "application/json"
            }
        }).then(response => {
            // volvemos a habilitar el btn
            btnSubir.disabled = false;
            return response.json();
        }).then(comun => {
            //    console.log(comentario);
            alert("Publicación Creada, salte de la página!");
        }).catch(err => {
            btnSubir.disabled = false;
            console.error(err);
        });
    };

    const btnSubir = document.getElementById("btn-subir");
    btnSubir.onclick = guardarComun;

};

