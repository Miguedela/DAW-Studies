<?php
if (!isset($_REQUEST['eliminarCliente'])) {
    header("Location: index.php");
}

try {
    $conexion = new PDO("mysql:host=localhost;dbname=banco;charset=utf8", "root", "");
    $dni = $_REQUEST['eliminarCliente'];

    $sql = "DELETE FROM cliente WHERE dni = :dni";
    $stmt = $conexion->prepare($sql);
    $stmt->execute([':dni' => $dni]);

    header("Location: index.php");
} catch (PDOException $e) {
    echo "No se ha podido establecer conexión con el servidor de bases de datos.<br>";

    die("Error: " . $e->getMessage());
}


header("Location: index.php");
