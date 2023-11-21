<%-- 
    Document   : register
    Created on : 27-jun-2023, 16:53:03
    Author     : hoshi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="icon" href="star.ico" type="image/x-icon">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;500;600&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="paginas/stylesRegistro.css">
        <title>Register</title>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    </head>

    <body>
        <c:if test="${not empty mensaje}">
            <script>
                swal("¡Alerta!", "${requestScope.mensaje}", "warning");
            </script>
        </c:if>
        <div class="container">
            <div class="form-information">
                <div class="container-form">
                    <h1>¡Empieza hoy!</h1>
                    <form action="./Register?action=register" method="post">
                        <label for="mail-phone">
                            <input id="mail-phone" type="email" name="mail-phone" placeholder="Correo" />
                        </label>
                        <label for="user-name">
                            <input id="user-name" type="text" name="user-name" placeholder="Nombre de usuario" />
                        </label>
                        <label for="password">
                            <input id="password" type="password" name="password" placeholder="Contraseña" />
                        </label>
                        <label for="password-confirmation">
                            <input id="password-confirmation" type="password" name="password-confirmation" placeholder="Confirma contraseña" />
                        </label>
                        <label for="birthdate"> Fecha de nacimiento
                            <input id="birthdate" name="birthdate" name="birthdate" type="date">
                        </label>
                        <label for="telephone"> 
                            <input id="telephone" name="telephone"type="text" placeholder="Teléfono">
                        </label>
                        <label for="ciudad" id="ciudad"> Ciudad: 
                            <select id="ciudad" name="ciudad" placeholder="Ciudades">
                                <optgroup label="Sonora">
                                    <option value="cd_obregon">Cd.Obregón</option>
                                    <option value="hermosillo">Hermosillo </option>
                                </optgroup>
                                <optgroup label="Sinaloa">
                                    <option value="culiacan">Culiacán</option>
                                    <option value="mazatlan">Mazatlán</option>
                                </optgroup>
                            </select> 
                            Usuario Admin:
                            <input id="tipo" name="tipo" type="checkbox" value="true">
                        </label>
                        <label for="sexo" id="sexo"> Sexo: 
                            <select id="sexo" name="sexo">
                                <option value="Femenino">Femenino</option>
                                <option value="Masculino">Masculino</option>
                                <option value="Sin especificar">Prefiero no decirlo</option>
                            </select> 
                        </label>
                        <input type="submit" value="Registrarme">
                    </form>
                    <p>¿Ya tienes cuenta?</p>
                    <a href="login.jsp">Iniciar Sesión</a>
                </div>
            </div>
            <div class="image">
                <div class="image-div">
                    <img src="https://www.elsotano.com/imagenes_grandes/7500588/750058800625.JPG" />
                </div>
            </div>
        </div>
    </body>
</html>
