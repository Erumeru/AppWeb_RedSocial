/* 
 
 Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */

window.onload = function () {
    const guardarComun = () => {
        const frm = document.getElementById("frm");

        const btnSubir = document.getElementById("btn-subir");
        const fechaHoraCreacion = new Date();
        const titulo = document.getElementById("txt-titulo").value;
        const contenido = document.getElementById("imageUpload").files[0];
        const fechaHoraEdicion = new Date();
        const tipo=document.getElementById("tipo").checked;
        const formData = new FormData(frm);
        formData.append('fechaHoraCreacion', fechaHoraCreacion);
        formData.append('fechaHoraEdicion', fechaHoraCreacion);

if(tipo===true){
    fetch("http://localhost:8080/AppWeb/Posts?action=subirAnclado", {
            method: "POST",
            body: formData,
            headers: {'enctype': 'multipart/form-data'}
        }).then(response => {
// volvemos a habilitar el btn
            btnSubir.disabled = false;
            return response.json();
        }).then(comun => {
//    console.log(comentario);
            swal("¡Éxito!", "Imagen publicada :D", "success").then(() => {
                // Redirigir a otra página
               // window.location.href = './mainPublicaciones?action=viewPosts';
               window.history.back();
            });

        }).catch(err => {
            btnSubir.disabled = false;
            console.error(err);
        });
}else{
    fetch("http://localhost:8080/AppWeb/Posts?action=subirComun", {
            method: "POST",
            body: formData,
            headers: {'enctype': 'multipart/form-data'}
        }).then(response => {
// volvemos a habilitar el btn
            btnSubir.disabled = false;
            console.log(response)
          //  return response.json();
        }).then(comun => {
//    console.log(comentario);
            swal("¡Éxito!", "Imagen publicada :D", "success").then(() => {
                // Redirigir a otra página
               // window.location.href = './mainPublicaciones?action=viewPosts';
               window.history.back();
            });

        }).catch(err => {
            btnSubir.disabled = false;
            console.error(err);
        });
    };
}
        // Enviar datos al servidor con FetchAPI (Formato JSON)
        
    const btnSubir = document.getElementById("btn-subir");
    btnSubir.onclick = guardarComun;
};