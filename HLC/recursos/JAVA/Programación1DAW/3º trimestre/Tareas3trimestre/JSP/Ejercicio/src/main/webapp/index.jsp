<%-- 
    Document   : Ejercicio4
    Created on : Apr 18, 2024, 5:13:26 PM
    Author     : migue
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ejercicio 4</title>
    </head>
    <body>
        <form action="media.jsp" method="post">
            <label for="nota1">Nota 1: </label> 
            <input type="number" name="nota1" requiered><br>
            <label for="nota2">Nota 2: </label> 
            <input type="number" name="nota2" requiered><br>
            <label for="nota3">Nota 3:</label> 
            <input type="number" name="nota3" requiered><br>
            <button type="submit">Calcular media</button>
        </form>
    </body>
</html>
