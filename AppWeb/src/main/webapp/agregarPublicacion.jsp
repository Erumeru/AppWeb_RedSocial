<%-- 
    Document   : login
    Created on : 27-jun-2023, 16:52:58
    Author     : hoshi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="stylesheet" href="paginas/stylesLogin.css" />
        <link rel="stylesheet"
              href="https://fonts.googleapis.com/css?family=Inter">
        <title>Login</title>
    </head>
    <body>
        <div class="container">
            <div class="recuadro">
                <img
                    class="imgPrincipal"
                    src="https://www.elsotano.com/imagenes_grandes/7500588/750058800624.JPG"
                    />
                <p class="hola">¡Agrega una publicación a tu perfil!</p>
                <form>
                    <input id="txt-titulo" type="text" class="corrNum" name="txt-titulo" placeholder="Ingrese Titulo" />
                    <input type="file" class="corrNum"/>
                    <button class="inputBtn" type="submit">Guardar</button>
                </form>
                <div class="division"></div>
                <p class="alt">O</p>
                <p class="cuenta">¿Ya no quieres? Regresa a tu perfil</p>
                <a href="perfilUsuario.jsp" class="registro">Cancelar</a>
            </div>
        </div>
    </body>
</html>