/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

function redirectEditar(id){
    let encryptKey='yorch';
    let encryptId=CryptoJS.AES.encrypt(id, encryptKey).toString();
    let url='editarPublicacion.html?mit0t3rO='+encodeURIComponent(encryptId);
    window.location.href=url;
}
function editarPublicacion() {
    Swal.fire({
        title: 'Quieres modificar eso?',
        text: "No seras capaz de revertir esto!",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Si, modificar'
    }).then((result) => {
        if (result.isConfirmed) {
            let idEncrypt=decodeURIComponent(window.location.search.substring(1).split('=')[1]);
            let llave='yorch';
            let id=CryptoJS.AES.decrypt(idEncrypt,llave).toString(CryptoJS.enc.Utf8);
            const titulo = document.querySelector("#txt-titulo").value;
            const btnEditar = document.querySelector("#btn-editar");
            const publiEdit= {
                id,
                titulo
            };
            btnEditar.disabled = false;
            fetch("http://localhost:8080/AppWeb/Posts?action=editarComun", {
                method: "POST",
                body: JSON.stringify(publiEdit),
                headers: {"content-type": "application/json"}
            }).then(_ => {
                Swal.fire("¡Éxito!", "Publicacion comun editada", "success").then(() => {
                    window.history.back().reload();
                });
            }).catch(err => {
                btnEditar.disabled = false;
                console.error(err);
            });
        }
    })

}


