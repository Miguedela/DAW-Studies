<%-- 
    Document   : index
    Created on : Apr 19, 2024, 3:46:22 PM
    Author     : migue
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.io.*"%>
<%@page import="empleadosjsp.Empleado"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Empleados JSP</title>
    </head>
    <body>
        <h1>Empleados</h1>
        <%
        ArrayList<Empleado> listaEmpleados = new ArrayList<>();
        String ruta = getServletContext().getRealPath("/") + "Empleados.txt";
        
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                
                String nombre = datos[0];
                int edad = Integer.parseInt(datos[1]);
                String cargo = datos[2];
                double salario = Double.parseDouble(datos[3]);
                
                listaEmpleados.add(new Empleado(nombre, edad, cargo, salario));
            }
        } catch (Exception e){
            out.println("Error al leer el archivo de empleados");
            e.printStackTrace();
        }
        
        for (Empleado empleado : listaEmpleados) {%>
        <div>
            <h2>Nombre: <%=empleado.getNombre()%></h2>
            <h2>Edad: <%=empleado.getEdad()%></h2>
            <h2>Cargo: <%=empleado.getCargo()%></h2>
            <h2>Salario: <%=empleado.getSalario()%></h2>
        </div>
        <%}
        %>
    </body>
</html>
