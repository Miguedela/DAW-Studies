<?php
require_once '../Model/Tractor.php';

if (session_status() == PHP_SESSION_NONE) session_start();

if (isset($_REQUEST['agregarProcutoCatalogo'])) {
    $nombreImagen = basename($_FILES['imagen']['name']);

    $directorio = '../View/img/';
    $rutaDestino = $directorio . $nombreImagen;

    move_uploaded_file($_FILES['imagen']['tmp_name'], $rutaDestino);
    $imagen = $rutaDestino;

    $tractor = new Tractor("", $_REQUEST['nombre'], $_REQUEST['precio'], $imagen, $_REQUEST['detallesProducto']);
    $tractor->insert();
}


header("Location: administrarweb_controller.php");
