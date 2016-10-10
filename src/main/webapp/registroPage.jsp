<%-- 
    Document   : registro
    Created on : 04-oct-2016, 9:01:29
    Author     : dam2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>

        <form method="get" enctype="multipart/form-data" action="registro">
            <br><br><br> 
            <div> 
                <p>
                    Nombre: <input type="text" name="nom" maxlength="30">
                </p>
            </div>
            <div> 
                <p>
                    Peso: <input type="text" name="peso">
                </p>
            </div>       
            <div>
                <input type="submit" name="Aceptar" value="aceptar">
            </div>
        </form>
    </body>
</html>
