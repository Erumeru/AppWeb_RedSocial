<%-- 
    Document   : editarPerfil
    Created on : 27-jun-2023, 16:53:21
    Author     : hoshi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="stylesheet" href="paginas/stylesEditarPerfil.css" />
        <title>Editar Perfil</title>
    </head>
    <header>
        <a href="perfilUsuario.jsp">x</a>
        <h1>Configuración</h1>
    </header>

    <body>
        <main>
            <div class="secciones-container">
                <div class="seccion-administrar">
                    <p class="text-div1">Administra tu <br>
                        experiencias conectadas y <br>
                        la configuración.
                    </p>
                </div>
                <div class="seccion-editar">
                    <h2 class="text-div2">Editar perfil</h2>
                </div>
                <div class="seccion-editarPerfil">
                    <h2 class="h1-div3">Editar perfil</h2>
                    <img class="profile-photo" src="assets/CatAndBug.jpg">
                    <a href="">Editar mi foto de perfil</a>
                    <div class="form-information">
                        <div class="container-form">
                            <form method="POST">
                                <label>Sitio web:
                                    <input type="text">
                                </label>
                                <label>Presentación
                                    <textarea></textarea>
                                </label>
                                <label>Sexo:
                                    <input type="text">
                                </label>
                                <input type="submit" value="Editar mi información">
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </main>
    </body>
</html>
