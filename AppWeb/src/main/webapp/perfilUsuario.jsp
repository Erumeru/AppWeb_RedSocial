<%-- 
    Document   : perfilUsuario
    Created on : 27-jun-2023, 16:53:11
    Author     : hoshi
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="stylesheet" href="paginas/stylesPerfil.css" />
        <link rel="icon" href="star.ico" type="image/x-icon">
        <title>Perfil Admor</title>
    </head>

    <body>
        <script src="prueba.js"></script>
        <nav class="nav-arriba">
            <div class="nav-cont">
               <form  action='./mainPublicaciones?action=viewPosts' method="post">
                <button type="submit"><img width="103" height="35" src="paginas/imagenes/logo.png" alt="Logo"></button>
                </form>
                <div class="cont-input">
                    <a href="#"><span><img width="10px" src="paginas/imagenes/8666693_search_icon.svg" alt="Proyecto"></span></a>
                    <input type="text" placeholder=" Buscar" />
                </div>
                <div class="iconos">
                    <form  action='./mainPublicaciones?action=viewPosts' method="post">
                        <button type="submit"><img src="paginas/imagenes/8666691_home_icon.svg"></button>
                    </form>
                    <a class="refencia-img" href="perfilUsuario.jsp"><img class="small-logo" src=${sessionScope.id} alt="foto-perfil"></a>
                    <form  action='./Login?action=logout' method="post">
                        <button type="submit"><img width="24" height="24" src="paginas/imagenes/1564505_close_delete_exit_remove_icon.svg"></button>
                    </form>
                </div>
            </div>
        </nav>
        <div class="centrar-Total">
            <div class="contenedor-Total">
                <header>
                    <div class="perfil-container">
                        <img class="img-perfil" src=${sessionScope.id}>
                        <div class="contenedor-cabecera">
                            <div class="cabecera1">
                                <h1>${sessionScope.usuario.nombreCompleto}</h1>
                                <a href="editarPerfil.jsp"><button>Editar perfil</button></a>
                                <form  action='./Administrador?action=details' method="post">
                                    <button type="submit"><img width="24" height="24" src="paginas/imagenes/3643771_configuration_configure_gear_set_setting_icon.svg"></button>
                                </form>
                            </div>
                            <div class="cabecera2">
                                <p><b>8</b> publicaciones</p>
                                <p><b>10</b> amigos</p>
                            </div>
                            <div class="cabecera3">
                                <h2>${sessionScope.usuario.correo}</h2>
                                <p class="p-presentation">Me encanta ser feliz</p>
                            </div>
                        </div>
                    </div>
                </header>
                <main>
                    <div class="linea"></div>
                    <div class="main-nav">
                        <a href="#">
                            <svg aria-label="" class="_ab6-" color="black" fill="black" height="12"
                                 role="img" viewBox="0 0 24 24" width="12">
                            <rect fill="none" height="18" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round"
                                  stroke-width="2" width="18" x="3" y="3"></rect>
                            <line fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round"
                                  stroke-width="2" x1="9.015" x2="9.015" y1="3" y2="21"></line>
                            <line fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round"
                                  stroke-width="2" x1="14.985" x2="14.985" y1="3" y2="21"></line>
                            <line fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round"
                                  stroke-width="2" x1="21" x2="3" y1="9.015" y2="9.015"></line>
                            <line fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round"
                                  stroke-width="2" x1="21" x2="3" y1="14.985" y2="14.985"></line>
                            </svg>
                            PUBLICACIONES
                        </a>
                    </div>
                    <div class="mainCont_grid">
                        <div class="container-publicaciones">
                            <c:forEach items="${sessionScope.listPostUser}" var="item">
                                <div class="content-container">
                                    <img class="fotoContenido" src=${item.contenido} alt="post">
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </main>
            </div>
        </div>
        <footer>
            <%@include file="WEB-INF/jspf/footer.jspf" %>
        </footer>
    </body>
</html>