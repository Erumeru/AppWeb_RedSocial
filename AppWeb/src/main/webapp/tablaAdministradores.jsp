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
        <title>Administradores</title>
    </head>
     <body>
        <h1>Publicaciones :D</h1>
        <table>
            <tr>
                <th>Fecha Publicación</th>
                <th>Nombre de usuario</th>
                <th>Titulo</th>
            </tr>
        
            <tr>
                <td>Wed Jun 28 22:32:10 MST 2023</td>
                <td>${sessionScope.usuario.nombreCompleto}</td>
                <td>atil</td>
            </tr>
        </table>
    </body>
</html>
