<%-- 
    Document   : index
    Created on : Apr 19, 2024, 4:51:59 PM
    Author     : migue
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="tiendaelectronica.Producto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.io.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tienda electronica</title>
    </head>
    <body>
        <h1>Productos</h1>
        <%
        ArrayList<Producto> listaProductos = new ArrayList<>();
        String ruta = getServletContext().getRealPath("/") + "Productos.txt";
        
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                
                String nombre = datos[0];
                double precio = Double.parseDouble(datos[1]);
                int stock = Integer.parseInt(datos[2]);
                
                listaProductos.add(new Producto(nombre, precio, stock));
            }
        } catch (Exception e){
            out.println("Error al leer el archivo de empleados");
            e.printStackTrace();
        }
        
        for (Producto producto : listaProductos) {%>
        <div>
            <p>Nombre: <%=producto.getNombre()%></p>
            <p>Precio: <%=producto.getPrecio()%></p>
            <p>Stock: <%=producto.getStock()%></p>
        </div>
        <%}%>
        <h2>Agregar productos a la cesta</h2>
        <form action="Carrito.jsp" method="post">
            <label for="nombre">Nombre: </label> 
            <input type="text" name="nombre" requiered><br>
            <label for="cantidad">Cantidad: </label> 
            <input type="number" name="cantidad" requiered><br>
            <button type="submit">Añadir el producto</button>
        </form>
    </body>
</html>
