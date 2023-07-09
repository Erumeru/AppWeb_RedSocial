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
        <title>Administradores</title>
    </head>
    <body>
        <a href="perfilUsuario.jsp"><-</a>
        <h1>Control de Posts</h1>
        <div>
            <table>
                <thead>
                    <th>Nombre de usuario</th>
                    <th>Titulo</th>
                    <th>Contenido</th>
                    <th>Eliminar</th>
                    <th>Editar</th>
                </thead>
                <div>
                    <c:forEach items="${sessionScope.anclados}" var="item">
                        <form>
                            <tr>
                                <td>${item.admor.nombreCompleto}</td>
                                <td>${item.titulo}</td>
                                <td>${item.contenido}</td>
                                <td><button>Eliminar</button></td>
                                <td><button>Editar</button></td>
                            </tr>
                        </form>
                    </c:forEach>
                </div>
                <div>
                    <c:forEach items="${sessionScope.comunes}" var="item">
                        <form>
                            <tr>
                                <td>${item.usuario.nombreCompleto}</td>
                                <td>${item.titulo}</td>
                                <td>${item.contenido}</td>
                                <td><button>Eliminar</button></td>
                                <td><button>Editar</button></td>
                            </tr>
                        </form>
                    </c:forEach>
                </div>
            </table>
        </div>
    </body>
</html>
