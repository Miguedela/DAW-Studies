<%-- 
    Document   : index
    Created on : Apr 28, 2024, 7:34:17 PM
    Author     : migue
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>I.E.S. Ruiz Gijón</title>
    </head>
    <body>
        <h1>Datos estudiante</h1>
        <form action="AnadirEstudiante.jsp" method="post">
            <label for="nombre">Nombre: </label> 
            <input type="text" name="nombre" requiered><br>
            <label for="apellidos">Apellidos: </label> 
            <input type="text" name="apellidos" requiered><br>
            <label for="fechaNacimiento">Fecha de nacimiento: </label> 
            <input type="text" name="fechaNacimiento" requiered><br>
            <label for="notaPromedio">Nota promedio: </label> 
            <input type="number" name="notaPromedio" requiered><br>
            <label for="fechaIngreso">Fecha de ingreso: </label> 
            <input type="text" name="fechaIngreso" requiered><br>
            <button type="submit">Añadir estudiante</button>
        </form>
    </body>
</html>
