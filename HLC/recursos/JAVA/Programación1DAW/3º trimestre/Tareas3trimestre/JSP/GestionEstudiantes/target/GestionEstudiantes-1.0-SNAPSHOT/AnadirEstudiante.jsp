<%-- 
    Document   : AnadirEstudiante
    Created on : Apr 28, 2024, 8:55:17 PM
    Author     : migue
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.mycompany.gestionestudiantes.Estudiante"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.io.*"%>
<%@page import="java.util.Date"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Añadir estudiante</title>
    </head>
    <body>
        <h1>Title here</h1>
        <%
            // Atributos recogidos del formulario
            String nombre = request.getParameter("nombre");
            String apellidos = request.getParameter("apellidos");
            String fechaNacimiento = request.getParameter("fechaNacimiento");
            Double promedio = Double.parseDouble(request.getParameter("notaPromedio"));
            String fechaIngreso = request.getParameter("fechaIngreso");
            
            // Atributos
            ArrayList<Estudiante> estudiantes = new ArrayList<>();
            String ruta = getServletContext().getRealPath("/") + "Estudiantes.txt"; //ruta para el archivo de guardar los estudiantes
            
            estudiantes.add(new Estudiante(nombre, apellidos, fechaNacimiento, promedio, fechaIngreso));
            out.println("Estudiante añadido correctamente.");
            
            // For each que uso para que me muestre los estudiantes añadidos por pantalla
            %><h2>Lista de Estudiantes actuales</h2><%
            for (Estudiante estudiante : estudiantes) { %>
                <p>Nombre y apellidos: <%=estudiante.getNombre()%> <%=estudiante.getApellidos()%></p>
                <p>Fecha de nacimiento: <%=estudiante.getFechaNacimiento()%></p>
                <p>Promedio: <%=estudiante.getPromedioCalificaciones()%></p>
                <p>Fecha de ingreso: <%=estudiante.getFechaIngreso()%></p>
            <%}
        %>
    </body>
</html>
