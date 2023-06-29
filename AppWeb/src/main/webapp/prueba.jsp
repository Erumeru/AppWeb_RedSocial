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
        <title>Subir avatars</title>
    </head>
    <body>
        <h1>sube archivo o q!</h1>
        <form method="post" action="FileUploadServlet" enctype="multipart/form-data" name="form1" >
            Selecciona imagen <input type="file" name="file">
            <input type="submit" value="go!"/>
</form>
    </body>
</html>
