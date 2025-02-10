<?php
require_once 'config.php'; // Incluir el archivo de configuración
require_once 'ComunidadAutonoma.php'; // Incluir la clase Comunidades

sleep(2);

try {
    // Crear una nueva conexión PDO usando las variables del archivo de configuración
    $conexion = new PDO("mysql:host=$db_host;dbname=$db_nombre;charset=$db_charset", $db_usuario, $db_contraseña);
    // Configurar el modo de error de PDO
    $conexion->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
} catch (PDOException $e) {
    die("Error en la conexión: " . $e->getMessage());
}


$comunidades_autonomas = []; // Array en el que se almacenarán los objetos Periferico

$consulta = $conexion->query("SELECT * FROM comunidades_autonomas ORDER BY id"); // Realizar una consulta SQL
while ($reg = $consulta->fetchObject()) {
    $comunidades_autonomas[] = new ComunidadAutonoma(
        $reg->id,
        $reg->nombre
    );
}

header('Content-Type: application/json; charset=utf-8'); // Configurar la cabecera de la respuesta HTTP
print json_encode($comunidades_autonomas); // Imprimir el array de objetos Periferico en formato JSON
