<%-- 
    Document   : index
    Created on : Apr 18, 2024, 6:13:16 PM
    Author     : migue
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Random"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ajedrez</title>
    </head>
    <body>
        <%
        Random r = new Random();
        int alfil = r.nextInt(1,64);
        int caballo = r.nextInt(1,64);
        
        while(alfil == caballo) {
            caballo = r.nextInt(1,64);
        }
        %>
        <style>
            /* Estilo para elementos con IDs impares */
            /* Utiliza el selector nth-child(odd) */
            td[id]:nth-child(odd) {
                /* Estilos para los elementos impares */
                background-color: white; /* Por ejemplo, un color de fondo */
                height: 20px;
                width: 20px;
            }

            /* Estilo para elementos con IDs pares */
            /* Utiliza el selector nth-child(even) */
            td[id]:nth-child(even) {
                /* Estilos para los elementos pares */
                background-color: black; /* Por ejemplo, otro color de fondo */
                height: 20px;
                width: 20px;              
            }
        </style>
        <TABLE BORDER>
            <TR>
                <TD id="1"></TD> <TD id="2"></TD> <TD id="3"></TD> <TD id="4"></TD> <TD id="5"></TD> <TD id="6"></TD> <TD id="7"></TD> <TD id="8"></TD>
            </TR>
            <TR>
                <TD id="9"></TD> <TD id="10"></TD> <TD id="11"></TD> <TD id="12"></TD> <TD id="13"></TD> <TD id="14"></TD> <TD id="15"></TD> <TD id="16"></TD>
            </TR>
            <TR>
                <TD id="17"></TD> <TD id="18"></TD> <TD id="19"></TD> <TD id="20"></TD> <TD id="21"></TD> <TD id="22"></TD> <TD id="23"></TD> <TD id="24"></TD>
            </TR>
            <TR>
                <TD id="25"></TD> <TD id="26"></TD> <TD id="27"></TD> <TD id="28"></TD> <TD id="29"></TD> <TD id="30"></TD> <TD id="31"></TD> <TD id="32"></TD>
            </TR>
            <TR>
                <TD id="33"></TD> <TD id="34"></TD> <TD id="35"></TD> <TD id="36"></TD> <TD id="37"></TD> <TD id="38"></TD> <TD id="39"></TD> <TD id="40"></TD>
            </TR>
            <TR>
                <TD id="41"></TD> <TD id="42"></TD> <TD id="43"></TD> <TD id="44"></TD> <TD id="45"></TD> <TD id="46"></TD> <TD id="47"></TD> <TD id="48"></TD>
            </TR>
            <TR>
                <TD id="49"></TD> <TD id="50"></TD> <TD id="51"></TD> <TD id="52"></TD> <TD id="53"></TD> <TD id="54"></TD> <TD id="55"></TD> <TD id="56"></TD>
            </TR>
            <TR>
                <TD id="57"></TD> <TD id="58"></TD> <TD id="59"></TD> <TD id="60"></TD> <TD id="61"></TD> <TD id="62"></TD> <TD id="63"></TD> <TD id="64"></TD>
            </TR>
        </TABLE>

    </body>
</html>
