<?php
require_once 'config.php'; // Incluir el archivo de configuración
require_once 'Provincias.php'; // Incluir la clase Comunidades

sleep(2);

try {
    // Crear una nueva conexión PDO usando las variables del archivo de configuración
    $conexion = new PDO("mysql:host=$db_host;dbname=$db_nombre;charset=$db_charset", $db_usuario, $db_contraseña);
    // Configurar el modo de error de PDO
    $conexion->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
} catch (PDOException $e) {
    die("Error en la conexión: " . $e->getMessage());
}

$codigoComunidad = $_REQUEST['comunidad'];
$provincias = []; // Array en el que se almacenarán los objetos Periferico

$consulta = $conexion->query("SELECT * FROM provincias WHERE id_comunidad_autonoma='$codigoComunidad'"); // Realizar una consulta SQL
while ($reg = $consulta->fetchObject()) {
    $provincias[] = new Provincias(
        $reg->id,
        $reg->nombre,
        $reg->id_comunidad_autonoma
    );
}

// Crear la estructura XML usando SimpleXMLElement
$xmlstr = "<?xml version='1.0' encoding='UTF-8'?>\n" .
    "<provincias></provincias>";
$xml = new SimpleXMLElement($xmlstr);

foreach ($provincias as $provincia) {
    $item = $xml->addChild('provincia');
    $item->addChild('id', $provincia->id);
    $item->addChild('nombre', $provincia->nombre);
    $item->addChild('id_comunidad_autonoma', $provincia->id_comunidad);
}

// Configurar el encabezado para XML
header('Content-Type: application/xml; charset=utf-8');
// Imprimir el XML generado
print $xml->asXML();
