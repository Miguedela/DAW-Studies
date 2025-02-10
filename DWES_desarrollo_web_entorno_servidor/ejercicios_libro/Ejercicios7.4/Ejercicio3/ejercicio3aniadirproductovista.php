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
</head>

<body>
    <!-- Formulario para insetar los datos del nuevo producto -->
    <h2>Añadir producto</h2>
    <form action="ejercicio3aniadirproducto.php" method="post"><br>
        Nombre: <input type="text" name="nombre"><br>
        Precio: <input type="text" name="precio"><br>
        Nombre de la imagén: <input type="text" name="imagen"><br>
        Detalles del producto:<br>
        <input type="text" name="detallesProducto"><br>
        <input type="submit" value="Añadir">
    </form>
</body>

</html>