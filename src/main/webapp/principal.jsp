<%-- 
    Document   : principal
    Created on : 04-oct-2016, 9:21:31
    Author     : dam2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <h1>Bienvenido <c:out value="${nom}"/></h1>
        <h1> Pesas <c:out value="${peso}"/>  </h1>
    </body>
</html>
