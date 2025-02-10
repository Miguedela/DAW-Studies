<?php
if (!isset($_REQUEST['agregarArticulo'])) {
    header("Location: index.php");
}

try {
    $conexion = new PDO("mysql:host=localhost;dbname=ejercicio4__10_5;charset=utf8", "root", "");
} catch (PDOException $e) {
    echo "No se ha podido establecer conexión con el servidor de bases de datos.<br>";
    die("Error: " . $e->getMessage());
}

$consulta = "INSERT INTO articulo (codigo, descripcion, precio_compra, precio_venta, stock) VALUES ('$_REQUEST[codigo]', '$_REQUEST[descripcion]', '$_REQUEST[precioCompra]', '$_REQUEST[precioVenta]', '$_REQUEST[stock]')";

$conexion->exec($consulta);

header("Location: index.php");
