<?php
if (!isset($_REQUEST['agregarCliente'])) {
    header("Location: index.php");
}

try {
    $conexion = new PDO("mysql:host=localhost;dbname=banco;charset=utf8", "root", "");

    $dni = $_REQUEST['dni'];
    $nombre = $_REQUEST['nombre'];
    $direccion = $_REQUEST['direccion'];
    $telefono = $_REQUEST['telefono'];

    $sql = "INSERT INTO cliente (dni, nombre, direccion, telefono) VALUES (:dni, :nombre, :direccion, :telefono)";
    $stmt = $conexion->prepare($sql);
    $stmt->execute([
        ':dni' => $dni,
        ':nombre' => $nombre,
        ':direccion' => $direccion,
        ':telefono' => $telefono
    ]);

    header("Location: index.php");
} catch (PDOException $e) {
    echo "No se ha podido establecer conexión con el servidor de bases de datos.<br>";

    die("Error: " . $e->getMessage());
}

header("Location: index.php");
