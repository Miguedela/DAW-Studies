<?php
session_start();

if (!isset($_REQUEST['aniadirProducto'])) {
    header("Location: ejercicio3.php");
}
?>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="css/ejercicio3formularios.css" />
</head>

<body>
    <div class="container">
        <h2>Añadir Producto</h2>
        <form action="ejercicio3aniadirproductocatalogo.php" method="POST" enctype="multipart/form-data">
            Nombre: <input type="text" name="nombre" required><br>
            Precio: <input type="text" name="precio" required><br>
            Imagen: <input type="file" name="imagen" required><br>
            Detalles del producto:<br>
            <textarea name="detallesProducto" required></textarea><br>
            <input type="submit" value="Añadir">
        </form>
    </div>
</body>

</html>