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
        <script src="FetchApiComentarios.js"></script>
        <script src="fetchApiEditarP.js"></script>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <title>Publicaciones</title>
    </head>
    <body>
        <header>
            <nav class="nav-arriba">
                <div class="nav-cont">
                    <img width="103" height="35" src="paginas/imagenes/logo.png" alt="Logo">
                    <div class="cont-input">
                        <a href="#"><span><img width="10px" src="paginas/imagenes/8666693_search_icon.svg" alt="Proyecto"></span></a>
                        <input type="text" placeholder=" Buscar" />
                    </div>
                    <div class="iconos">
                        <form  action='./mainPublicaciones?action=viewPosts' method="post">
                            <button type="submit"><img src="paginas/imagenes/8666691_home_icon.svg"></button>
                        </form>
                        <c:choose>
                            <c:when test="${sessionScope.tipo == 'normal'}">
                                <c:set var="jspDestino" value="perfilUsuario_1.jsp" />
                            </c:when>
                            <c:when test="${sessionScope.tipo == 'admor'}">
                                <c:set var="jspDestino" value="perfilUsuario.jsp" />
                            </c:when>
                            <c:otherwise>
                                <c:set var="jspDestino" value="errorInterno.jsp" />
                            </c:otherwise>
                        </c:choose>
                        <a href="${jspDestino}"><img class="small-logo" src="${sessionScope.id}" alt="foto-perfil"></a>
                        <form  action='./Login?action=logout' method="post">
                            <button type="submit"><img width="24" height="24" src="paginas/imagenes/1564505_close_delete_exit_remove_icon.svg"></button>
                        </form>
                    </div>
                </div>
            </nav>
        </header>
        <main>
            <div class="anclados">
                <h2 class="title-anclados">Publicaciones Ancladas</h2>
                <c:forEach items="${sessionScope.anclados}" var="item">
                    <div class="Post-Container">
                        <div class="profile-container">
                            <img class="profile-photo" src=${item.admor.avatar} alt="profilePic">
                            <span class="profile-text">${item.admor.nombreCompleto}</span>
                            <span class="profile-last-conn">• ${item.fechaHoraCreacion}</span>
                            
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
                               <c:choose>
                                <c:when test="${sessionScope.usuarioComparacion == item.usuario.id}">
                                    <button 
                                        onclick="window.location.href='editarPublicacion.html'" 
                                        class="menu-icon" type="button" idPublicacion="${item.idComun}"></button>
                                </c:when>
                            </c:choose>
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
                        <div class="comments-container" objeto-comun="${item.idComun}">
                            <p class="profile-text">${item.usuario.nombreCompleto}<span class="space-comments">${item.titulo}</span> </p>
                            <details class="comments-container">
                                <div></div>
                                <summary>Ver comentarios...</summary>
                                    <c:forEach items="${item.comentarios}" var="comentario">
                                    <p class="profile-text" id="profile-text">${comentario.normal.nombreCompleto}<span class="space-comments">${comentario.contenido}</span></p>
                                    <p></p>
                                </c:forEach>
                            </details>
                            <form>
                                <input type="text" id="textfield-comment" name="textfield-comment" placeholder="Añade un comentario">
                                <button type="button" class="send-comment" name="send-comment" id="send-comment" src="paginas/imagenes/send.png"></button>
                            </form>
                        </div>
                        <br>
                    </div>
                </c:forEach>
            </div>
        </main>
    </body>

</html>
