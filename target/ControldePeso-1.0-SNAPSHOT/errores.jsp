<%-- 
    Document   : usuarioregistrado
    Created on : 08-oct-2016, 13:01:50
    Author     : Llorenç
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
        <h1><c:out value="${message}"/></h1>
        <c:remove var="message" scope="session" /> 
    </body>
</html>
