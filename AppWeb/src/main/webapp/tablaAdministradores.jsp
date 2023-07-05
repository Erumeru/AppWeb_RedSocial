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
        <link href="paginas/stylesTablaAdmin.css">
        <title>Administradores</title>
    </head>
    <body>
        <h1>Publicaciones :D</h1>
        <table>
            <tr>
                <th>Nombre de usuario</th>
                <th>Fecha Publicación</th>
                <th>Titulo</th>
            </tr>
            <tr>
                <td>${sessionScope.usuario.nombreCompleto}</td>
                <c:forEach items="${sessionScope.admor.anclado}" var="item">

                    <td>${item.fechaHoraCreacion}</td>
                    <td>${item.titulo}</td>
                 </c:forEach>
                </tr>
            </table>
    </body>
</html>
