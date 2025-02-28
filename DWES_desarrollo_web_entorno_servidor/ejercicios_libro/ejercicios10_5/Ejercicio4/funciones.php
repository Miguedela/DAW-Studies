<?php
function conexion()
{
    try {
        $conexion = new PDO("mysql:host=localhost;dbname=ejercicio4__10_5;charset=utf8", "root", "");
        // echo "Se ha establecido una conexión con el servidor de bases de datos.";
    } catch (PDOException $e) {
        echo "No se ha podido establecer conexión con el servidor de bases de datos.<br>";
        die("Error: " . $e->getMessage());
    }
    return $conexion;
}
