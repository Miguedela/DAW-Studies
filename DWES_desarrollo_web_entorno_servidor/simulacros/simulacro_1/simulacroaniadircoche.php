<?php
session_start();
include 'simulacrofunciones.php';

if (isset($_REQUEST['aniadirCoche'])) {
    $fecha = date("d/m/Y", time()); //Creo la fecha actual
    $marca = $_REQUEST['marca']; // recojo la marca
    $matricula = generaMatricula($marca);

    $tipo = $_REQUEST['tipo']; // recojo el tipo

    $extras = [];
    // Recojo los extras en caso de haberse solicitado
    if (isset($_REQUEST['extras'])) {
        $extras = $_REQUEST['extras'];
    }

    $_SESSION['coches'][$matricula] = [
        'fecha' => $fecha,
        'marca' => $marca,
        'tipo' => $tipo,
        'extras' => $extras
    ];


    setcookie('coches', base64_encode(serialize($_SESSION['coches'])), date(strtotime("+1 year")));
    header('Location: simulacro.php');
} else {
    header('Location: simulacro.php');
}
