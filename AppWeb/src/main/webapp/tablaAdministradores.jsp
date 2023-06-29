<%-- 
    Document   : tablaAdministradores
    Created on : 28 jun 2023, 19:45:17
    Author     : hoshi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administradores</title>
    </head>
     <body>
        <h1>Emails registradosss :D</h1>
        <table>
            <tr>
                <th>Fecha Publicación</th>
                <th>Nombre de usuario</th>
                <th>Titulo</th>
            </tr>
            <c:forEach items="${sessionScope.usuario}" var="item">
            <tr>
                <td>${item.fechaHoraCreacion}</td>
                <td>${item.nombreCompleto}</td>
                <td>${item.titulo}</td>
            </tr>
            </c:forEach>
        </table>
    </body>
</html>
