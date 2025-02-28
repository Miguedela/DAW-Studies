<?php
if (!isset($_REQUEST['eliminarArtiuculo'])) {
    header("Location: index.php");
}

try {
    $conexion = new PDO("mysql:host=localhost;dbname=ejercicio4__10_5;charset=utf8", "root", "");
    $codigo = $_REQUEST['codigo'];

    $sql = "DELETE FROM articulo WHERE codigo = :codigo";
    $stmt = $conexion->prepare($sql);
    $stmt->execute([':codigo' => $codigo]);
} catch (PDOException $e) {
    echo "No se ha podido establecer conexión con el servidor de bases de datos.<br>";

    die("Error: " . $e->getMessage());
}


header("Location: index.php");
