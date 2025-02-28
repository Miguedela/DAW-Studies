<%-- 
    Document   : Carrito
    Created on : Apr 19, 2024, 5:19:24 PM
    Author     : migue
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="tiendaelectronica.Producto"%>
<%@page import="tiendaelectronica.Errores"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.io.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Carrito de la compra</title>
    </head>
    <body>
        <h1>Carrito</h1>
        <%
        String nombreProducto = request.getParameter("nombre");
        int cantidadProducto = Integer.parseInt(request.getParameter("cantidad"));
            
        ArrayList<Producto> listaProductos = new ArrayList<>();
        String ruta = getServletContext().getRealPath("/") + "Productos.txt";
        String ruta2 = getServletContext().getRealPath("/") + "NuevosProductos.txt";
        
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
        
        for (Producto producto : listaProductos) {
            if (nombreProducto.equalsIgnoreCase(producto.getNombre())) {
                if (cantidadProducto > producto.getStock()) {%>
                    <h2>No hay stock suficiente de <%=producto.getNombre()%></h2>
                <%
                } else {
                    int nuevaCantidad = producto.getStock() - cantidadProducto;
                    producto.setStock(nuevaCantidad);%>
                    <div>
                        <p>Nombre: <%=producto.getNombre()%></p>
                        <p>Precio: <%=producto.getPrecio()%></p>
                        <p>Stock: <%=producto.getStock()%></p>
                    </div>
              <%
                    try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta2))) {
                        String linea;
                        for (int i = 0; i < listaProductos.size(); i++) {
                            bw.write(producto.getNombre() + "," + producto.getPrecio() + "," + producto.getStock());
                            bw.newLine();
                        }
                    } catch (Exception e){
                        out.println("Error al leer el archivo de empleados");
                        e.printStackTrace();
                    }
                  
                }
            
            }
        }%>
    </body>
</html>
