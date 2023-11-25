/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

function redirectEditar(id) {
    let encryptKey = 'yorch';
    let encryptId = CryptoJS.AES.encrypt(id, encryptKey).toString();
    let url = 'editarPublicacion.html?mit0t3rO=' + encodeURIComponent(encryptId);
    window.location.href = url;
}
function editarPublicacion() {
    Swal.fire({
        title: '¿Quieres modificar esto?',
        text: "No serás capaz de revertir esto",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Sí, modificar'
    }).then((result) => {
        if (result.isConfirmed) {
            let idEncrypt = decodeURIComponent(window.location.search.substring(1).split('=')[1]);
            let llave = 'yorch';
            let id = CryptoJS.AES.decrypt(idEncrypt, llave).toString(CryptoJS.enc.Utf8);
            const titulo = document.querySelector("#txt-titulo").value;
            const btnEditar = document.querySelector("#btn-editar");
            const publiEdit = {
                id,
                titulo
            };
            btnEditar.disabled = false;

            // Configuración de la solicitud POST
            const requestOptions = {
                method: 'POST',
                body: JSON.stringify(publiEdit),
                headers: {
                    'Content-Type': 'application/json'
                },
            };

            // Realizar la solicitud POST
            fetch("http://localhost:8080/AppWeb/Posts?action=editarComun", requestOptions)
                .then(response => {
                    if (!response.ok) {
                        throw new Error('Error en la solicitud');
                    }
                    return response.text();
                })
                .then(_ => {
                    Swal.fire("¡Éxito!", "Publicacion comun editada", "success").then(() => {
                        const jspUrl = '/mainPublicaciones?action=viewPosts'; // Reemplaza con la ruta correcta de tu JSP
                        window.location.href = 'http://localhost:8080/AppWeb/perfilUsuario_1.jsp';
                    });
                })
                .catch(err => {
                    btnEditar.disabled = false;
                    console.error(err);
                });
        }
    });
}

