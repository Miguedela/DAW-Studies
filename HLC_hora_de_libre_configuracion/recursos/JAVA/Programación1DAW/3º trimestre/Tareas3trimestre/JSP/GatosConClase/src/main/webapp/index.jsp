<%-- 
    Document   : index
    Created on : Apr 18, 2024, 4:58:38 PM
    Author     : migue
--%>

<%-- index.jsp (proyecto GatosConClase) --%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="DAW1.Gato"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gatos con clase</title>
    </head>
    <body>
        <h1>Gatos con clase</h1>
        <hr>
        <%
        Gato g1 = new Gato("Pepe", "gato.jpg");
        Gato g2 = new Gato("Garfield", "garfield.jpg");
        Gato g3 = new Gato("Tom", "tom.png");
        out.println(g1);
        out.println(g2);
        out.println(g3);
        out.println(g1.maulla());
        out.println(g2.come("sardinas"));
        %>
    </body>
</html>
