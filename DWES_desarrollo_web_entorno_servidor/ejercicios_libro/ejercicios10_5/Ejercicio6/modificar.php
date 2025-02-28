<?php
if (!isset($_REQUEST['hora'])) {
    header("Location: index.php");
}

$asignaturas = [
    "Empresa e Iniciativa Emprendedora",
    "Desarrollo Web en Entorno Servidor",
    "Despliegue de Aplicaciones Web",
    "Diseño de Interfaces Web",
    "Desarrollo Web en Entorno Cliente",
    "Horas de Libre Configuracion"
];

if (isset($_REQUEST['asignatura'])) {
    try {
        $conexion = new PDO("mysql:host=localhost;dbname=ejercicio6__10_5;charset=utf8", "root", "");
    } catch (PDOException $e) {
        echo "No se ha podido establecer conexión con el servidor de bases de datos.<br>";
        die("Error: " . $e->getMessage());
    }

    $consulta = $conexion->query("SELECT * FROM horario");
    $update = "UPDATE horario SET $_REQUEST[hora]=\"$_REQUEST[asignatura]\" WHERE dia=\"$_REQUEST[dia]\"";
    $conexion->exec($update);
    header("Location: index.php");
}
?>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
    <h1>Editar Horario</h1>
    <form action="#" method="post">
        <select name="asignatura" id="">
            <?php
            foreach ($asignaturas as $key => $asignatura) {
                echo "<option value='" . $asignatura . "'>" . $asignatura . "</option>";
            }
            ?>
        </select>
        <input type="hidden" name="dia" value="<?= $_REQUEST['dia'] ?>">
        <input type="hidden" name="hora" value="<?= $_REQUEST['hora'] ?>">
        <br><br>
        <input type="submit" value="Modificar">
    </form>

    <a href="index.php">Volver</a>
</body>

</html>