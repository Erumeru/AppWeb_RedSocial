/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

window.onload = function(){
document.getElementById("createPostButton").addEventListener("click", function() {
  document.getElementById("overlay").style.display = "block";
  document.getElementById("modal").style.display = "block";
});

document.getElementsByClassName("close")[0].addEventListener("click", function() {
  document.getElementById("overlay").style.display = "none";
  document.getElementById("modal").style.display = "none";
});


    document.getElementById("imageUpload").addEventListener("change", function () {
        let  file = this.files[0];


        console.log("Archivo seleccionado:", file);
    });

}