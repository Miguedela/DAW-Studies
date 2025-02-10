<%-- 
    Document   : index
    Created on : Apr 18, 2024, 5:34:20 PM
    Author     : migue
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Random"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ejercicio 16</title>
    </head>
    <body>
        <h1>El resultado de los dados es:</h1>
        <%
        Random r = new Random();
        int dado1 = r.nextInt(1,6);
        
        int dado2 = r.nextInt(1,6);      
        while (dado1 == dado2) {
            dado2 = r.nextInt(1,6);
        }
        
        int dado3 = r.nextInt(1,6);
        while (dado3 == dado2 || dado1 == dado3) {
            dado3 = r.nextInt(1,6);
        }
        %>
        <h2>Dado 1: <%=dado2%></h2>
        <%if(dado1 == 1){%>
        <img src="1.jpg">
        <%}else if(dado1 == 2){%>
        <img src="2.jpg">
        <%}else if(dado1 == 3){%>
        <img src="3.jpg">
        <%}else if(dado1 == 4){%>
        <img src="4.png">
        <%}else if(dado1 == 5){%>
        <img src="5.jpg">
        <%}else if(dado1 == 6){%>
        <img src="6.jpg">
        <%}%>

        <h2>Dado 2: <%=dado2%></h2>    
        <%if(dado2 == 1){%>
        <img src="1.jpg">
        <%}else if(dado2 == 2){%>
        <img src="2.jpg">
        <%}else if(dado2 == 3){%>
        <img src="3.jpg">
        <%}else if(dado2 == 4){%>
        <img src="4.png">
        <%}else if(dado2 == 5){%>
        <img src="5.jpg">
        <%}else if(dado2 == 6){%>
        <img src="6.jpg">
        <%}%>

        <h2>Dado 3: <%=dado3%></h2>
        <%if(dado3 == 1){%>
        <img src="1.jpg">
        <%}else if(dado3 == 2){%>
        <img src="2.jpg">
        <%}else if(dado3 == 3){%>
        <img src="3.jpg">
        <%}else if(dado3 == 4){%>
        <img src="4.png">
        <%}else if(dado3 == 5){%>
        <img src="5.jpg">
        <%}else if(dado3 == 6){%>
        <img src="6.jpg">
        <%}%>
    </body>
</html>
