/* 
 
 Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */
function eliminarComun(id) {

    Swal.fire({
        title: 'Are you sure?',
        text: "You won't be able to revert this!",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Yes, delete it!'
    }).then((result) => {
        if (result.isConfirmed) {
            const btnEliminar = document.querySelector("#eliminarComun");
            const publiElim = {
                id
            };
            btnEliminar.disabled = false;
            fetch("http://localhost:8080/AppWeb/Posts?action=eliminarComun", {
                method: "POST",
                body: JSON.stringify(publiElim),
                headers: {"content-type": "application/json"}
            }).then(_ => {
                Swal.fire("¡Éxito!", "Publicacion comun eliminada", "success").then(() => {
                    window.location.reload();
                });
            }).catch(err => {
                btnEliminar.disabled = false;
                console.error(err);
            });
        }
    })

}

function eliminarAnclado(item) {

    Swal.fire({
        title: 'Are you sure?',
        text: "You won't be able to revert this!",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Yes, delete it!'
    }).then((result) => {
        if (result.isConfirmed) {
            const removeBeforeString = item.split("idAnclado=");
            const id = removeBeforeString[removeBeforeString.length - 1].split("}")[0];
            const btnEliminar = document.querySelector("#eliminarAnclado");
            const publiElim = {
                id
            };
            btnEliminar.disabled = false;
            fetch("http://localhost:8080/AppWeb/Posts?action=eliminarAnclado", {
                method: "POST",
                body: JSON.stringify(publiElim),
                headers: {"content-type": "application/json"}
            }).then(_ => {
                Swal.fire("¡Éxito!", "Publicacion anclado eliminada", "success").then(() => {
                    window.location.reload();
                })
            }).catch(err => {
                btnEliminar.disabled = false;
                console.error(err);
            });
        }
    })



}