<?php
if (!isset($_REQUEST['modificarCliente'])) {
    header("Location: index.php");
}

// Recoger datos del formulario
$dni = $_REQUEST['dni'];
$nombre = $_REQUEST['nombre'];
$direccion = $_REQUEST['direccion'];
$telefono = $_REQUEST['telefono'];

if (isset($_REQUEST['realizarModificacion'])) {
    try {
        $conexion = new PDO("mysql:host=localhost;dbname=banco;charset=utf8", "root", "");

        // Actualizar datos del cliente
        $sql = "UPDATE cliente SET nombre = :nombre, direccion = :direccion, telefono = :telefono WHERE dni = :dni";
        $stmt = $conexion->prepare($sql);
        $stmt->execute([
            ':nombre' => $nombre,
            ':direccion' => $direccion,
            ':telefono' => $telefono,
            ':dni' => $dni
        ]);

        header("Location: index.php");
    } catch (PDOException $e) {
        echo "No se ha podido establecer conexión con el servidor de bases de datos.<br>";
        die("Error: " . $e->getMessage());
    }
}
?>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Modificar Cliente</title>
</head>

<body>
    <h1>Modificar Cliente</h1>
    <form action="#" method="post">
        <label for="nombre">Nombre:</label>
        <input type="text" name="nombre" value="<?= $nombre ?>">
        <br><br>

        <label for="direccion">Dirección:</label>
        <input type="text" name="direccion" value="<?= $direccion ?>">
        <br><br>

        <label for="telefono">Teléfono:</label>
        <input type="text" name="telefono" value="<?= $telefono ?>">
        <br><br>

        <input type="hidden" name="dni" value="<?= $dni ?>">
        <input type="hidden" name="realizarModificacion">
        <input type="submit" value="Modificar Cliente">
    </form>
</body>

</html>