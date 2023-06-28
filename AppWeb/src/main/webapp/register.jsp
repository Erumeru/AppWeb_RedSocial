<%-- 
    Document   : register
    Created on : 27-jun-2023, 16:53:03
    Author     : hoshi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
    </head>
    
<body>
    <div class="container">
        <div class="form-information">
            <div class="container-form">
                <h1>¡Empieza hoy!</h1>
                <form action="register" method="POST">
                    <label for="mail-phone">
                        <input id="mail-phone" type="text" placeholder="Correo o teléfono" />
                    </label>
                    <label for="user-name">
                        <input id="user-name" type="text" placeholder="Nombre de usuario" />
                    </label>
                    <label for="password">
                        <input id="password" type="password" placeholder="Contraseña" />
                    </label>
                    <label for="password-confirmation">
                        <input id="password-confirmation" type="password" placeholder="Confirma contraseña" />
                    </label>
                    <label for="birthdate"> Fecha de nacimiento
                        <input id="birthdate" name="birthdate" type="date">
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
