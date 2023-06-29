<%-- 
    Document   : prueba
    Created on : 28 jun. 2023, 18:34:55
    Author     : kim
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="icon" href="star.ico" type="image/x-icon" />
        <link rel="preconnect" href="https://fonts.googleapis.com" />
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
        <link
            href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;500;600&display=swap"
            rel="stylesheet"
            />
        <link rel="stylesheet" href="paginas/stylesRegistro.css">

        <title>Subir avatars</title>
    </head>
    <body>
        <div class="container">
            <div class="form-information">
                <div class="container-form">
                    <h1>¡Ya casi estás listo!</h1>
                    <form
                        method="post"
                        action="FileUploadServlet"
                        enctype="multipart/form-data"
                        name="form1"
                        >
                        <p>Selecciona su Avatar de perfil! <p>
                        <input type="file" name="file" />
                        <br>
                        <input type="submit" value="go!" />
                    </form>
                    <p>¿No quieres una imagen?</p>
                    <a href="login.jsp">Iniciar Sesión</a>
                </div>
            </div>
            <div class="image">
                <div class="image-div">
                    <img
                        src="https://www.elsotano.com/imagenes_grandes/7500588/750058800625.JPG"
                        />
                </div>
            </div>
        </div>
    </body>
</html>
