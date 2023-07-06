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
            <div class="anclados">
                <h2 class="title-anclados">Publicaciones Ancladas</h2>
                <c:forEach items="${sessionScope.anclados}" var="item">
                    <div class="Post-Container">
                        <div class="profile-container">
                            <img class="profile-photo" src=${sessionScope.id} alt="profilePic">
                            <span class="profile-text">${item.admor.nombreCompleto}</span>
                            <span class="profile-last-conn">• ${item.fechaHoraCreacion}</span>
                            <input class="menu-icon" type="button">
                        </div>
                        <div class="content-container">
                            <img class="fotoContenido" src=${item.contenido} alt="post"> 
                        </div>
                        <p></p>
                        <div class="icons-container">
                            <img class="icon" src="paginas/imagenes/icon-like.png" alt="icon-share">
                            <img class="icon" src="paginas/imagenes/icon-message-comment.png" alt="icon-message-comment">
                            <img class="icon" src="paginas/imagenes/icon-share.png" alt="icon-share">
                        </div>
                        <br>
                    </div>
                </c:forEach>
            </div>
            <div class="normales">
                <c:forEach items="${sessionScope.comunes}" var="item">
                    <div class="Post-Container">
                        <div class="profile-container">
                            <img class="profile-photo" src=${item.usuario.avatar} alt="profilePic">
                            <span class="profile-text">${item.usuario.nombreCompleto}</span>
                            <span class="profile-last-conn">• ${item.fechaHoraCreacion}</span>
                            <input class="menu-icon" type="button">
                        </div>
                        <div class="content-container">
                            <img class="fotoContenido" src=${item.contenido} alt="post"> 
                        </div>
                        <p></p>
                        <div class="icons-container">
                            <img class="icon" src="paginas/imagenes/icon-like.png" alt="icon-share">
                            <img class="icon" src="paginas/imagenes/icon-message-comment.png" alt="icon-message-comment">
                            <img class="icon" src="paginas/imagenes/icon-share.png" alt="icon-share">
                        </div>
                        <div class="comments-container">
                            <p class="profile-text">${item.usuario.nombreCompleto}<span class="space-comments">${item.titulo}</span> </p>
                            <details class="comments-container">
                                <div></div>
                                <summary>Ver comentarios...</summary>
                                    <c:forEach items="${item.comentarios}" var="comentario">
                                    <p class="profile-text">${comentario.normal.nombreCompleto}<span class="space-comments">${comentario.contenido}</span></p>
                                    <p></p>
                                    </c:forEach>
                            </details>
                            <input type="text" id="textfield-comment" name="textfield-comment" placeholder="Añade un comentario">
                            <button type="submit" class="send-comment" src="paginas/imagenes/send.png"></button>
                        </div>
                        <br>
                    </div>
                </c:forEach>
            </div>
        </main>
    </body>

</html>
