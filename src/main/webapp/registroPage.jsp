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
        <link href="estilos.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>

        <form method="get" enctype="multipart/form-data" action="registro">
            <br><br><br> 
            <div id="div1">
                <div> 
                    <p>
                        Nombre: <input type="text" name="nom" maxlength="30">
                    </p>
                </div>
            </div>
            <div id="div2">
                <div> 
                    <p>
                        Peso: <input type="text" name="peso">
                    </p>
                </div> 
            </div>            
            <div id="div3">
                <input type="submit" name="Aceptar" value="aceptar">
            </div>
        </form>
    </body>
</html>
