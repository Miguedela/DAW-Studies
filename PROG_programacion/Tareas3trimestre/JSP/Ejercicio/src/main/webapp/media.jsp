<%-- 
    Document   : Media
    Created on : Apr 18, 2024, 5:24:09 PM
    Author     : migue
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Media</title>
    </head>
    <body>
        <h1>Media de las 3 notas:</h1>
        <%
        double nota1 = Double.parseDouble(request.getParameter("nota1"));
        double nota2 = Double.parseDouble(request.getParameter("nota2"));
        double nota3 = Double.parseDouble(request.getParameter("nota3"));
        double media = (nota1 + nota2 + nota3) / 3;
        %>
        <h2>La media de las notas es: <%=media%></h2>
    </body>
</html>
