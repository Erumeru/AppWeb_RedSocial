<%-- 
    Document   : mainPublicaciones
    Created on : 27-jun-2023, 16:53:52
    Author     : hoshi
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="stylesheet" href="paginas/stylesMainPublicaciones.css" />
        <title>Publicaciones</title>
    </head>
    <body>
        <main>
            <div class="profile-container">
                <img class="profile-photo" src="assets/CatAndBug.jpg" alt="profilePic">
                <span class="profile-text">Tilina</span>
                <span class="profile-last-conn">• Ultima conexión</span>
                <input class="menu-icon" type="button">
            </div>
            <div class="content-container">
                <img src="assets/fondoweb.jpg" alt="fondoweb">
            </div>
            <p></p>
            <div class="icons-container">
                <img class="icon" src="paginas/imagenes/icon-like.png" alt="icon-like">
                <img class="icon" src="paginas/imagenes/icon-message-comment.png" alt="icon-message-comment">
                <img class="icon" src="paginas/imagenes/icon-share.png" alt="icon-share">
            </div>
            <div class="comments-container">
                <p class="profile-text">Tilina <span class="space-comments">Ójala los mosquitos chuparan sangre, en vez de
                        grasa...</span> </p>
                <details class="comments-container">
                    <div></div>
                    <summary>Ver más comentarios</summary>
                    <p class="profile-text">Erumeru<span class="space-comments">Minipekka al 14 :)</span></p>
                    <p></p>
                    <p class="profile-text">Asiedad <span class="space-comments">Texto prueba</span></p>
                </details>
                <input type="text" id="textfield-comment" name="textfield-comment" placeholder="Añade un comentario">
                <button type="submit" class="send-comment"></button>
            </div>
            <div>
                <h1>Pruebas</h1>
                <c:forEach items="${requestScope.posts}" var="item">
                    <p>${item.titulo}</p>
                </c:forEach>
            </div>
        </main>
    </body>

</html>
