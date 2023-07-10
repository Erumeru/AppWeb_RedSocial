/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
function editarPublicacion(id) {

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
                    window.location.reload();
                });
            }).catch(err => {
                btnEditar.disabled = false;
                console.error(err);
            });
        }
    })

}


