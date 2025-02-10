<?php
include '../funciones.php';


if (isset($_REQUEST['nombreFichero'])) {
    $ruta = $_REQUEST['nombreFichero'];
    $palabra = $_REQUEST['palabraBuscar'];

    echo 'El número de veces que aparece la palabra ' . $ruta . ' en el fichero ' . "$ruta" . ' es de: ' . buscarPalabra($ruta, $palabra);
}
