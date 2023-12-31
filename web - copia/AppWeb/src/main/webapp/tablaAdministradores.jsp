<%-- 
    Document   : tablaAdministradores
    Created on : 28 jun 2023, 19:45:17
    Author     : hoshi
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="paginas/stylesTablaAdmin.css" />
        <script src="fetchApiTablaAdmin.js"></script>
        <link rel="icon" href="star.ico" type="image/x-icon">
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.0.18/dist/sweetalert2.all.min.js"></script>
        <title>Administradores</title>
    </head>
    <body>
        <button onclick="window.location.href = 'perfilUsuario.jsp';" style="background-color: transparent;  border-color: transparent;">
            <img src="paginas/imagenes/flecha-volver.png" alt="flecha-volver">
        </button>

        <h1>Control de Posts</h1>
        <div>
            <table>
                <thead>
                <th>Nombre de usuario</th>
                <th>Titulo</th>
                <th>Contenido</th>
                <th>Tipo</th>
                <th>Eliminar</th>
                </thead>
                <div>
                    <c:forEach items="${sessionScope.anclados}" var="item">
                        <tr>
                            <td>${item.admor.nombreCompleto}</td>
                            <td>${item.titulo}</td>
                            <td>${item.contenido}</td>
                            <td>Anclado</td>
                            <td><button id="eliminarAnclado" onclick="eliminarAnclado('${item}')">Eliminar</button></td>
                        </tr>
                    </c:forEach>
                </div>
                <div>
                    <c:forEach items="${sessionScope.comunes}" var="item">
                        <tr>
                            <td>${item.usuario.nombreCompleto}</td>
                            <td>${item.titulo}</td>
                            <td>${item.contenido}</td>
                            <td>Común</td>
                            <td><button id="eliminarComun" onclick="eliminarComun('${item.idComun}')">Eliminar</button></td>
                        </tr>
                    </c:forEach>
                </div>
            </table>
        </div>
    </body>
</html>
