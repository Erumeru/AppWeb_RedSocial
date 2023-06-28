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
          src="https://www.elsotano.com/imagenes_grandes/7500588/750058800625.JPG"
        />
        <p class="hola">¡Hola de nuevo!</p>
        <form method="POST">
          
          <input id="corrNum" type="text" class="corrNum" placeholder="Ingrese Correo o Teléfono" />
          
          <input id="pass" type="password" class="pass" placeholder="Ingrese su contraseña"/>
          <input class="inputBtn" type="submit" value="Iniciar Sesión" />
        </form>
        <div class="division"></div>
        <p class="alt">O</p>
        <p class="cuenta">¿No tienes cuenta aún?</p>
        <a class="registro">Registrate</a>
      </div>
    </div>
  </body>
</html>
