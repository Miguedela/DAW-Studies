<?php
require_once '../Model/Catalogo.php';

if (session_status() == PHP_SESSION_NONE) session_start();

if (isset($_REQUEST['productoModificado'])) {
    include 'funciones/funciones.php';

    $key = $_REQUEST['productoModificado'];
    $nombre = $_REQUEST['nombre'];
    $imagen = $_REQUEST['imagen'];
    $nuevoPrecio = (float) $_REQUEST['precio'];
    $nuevosDetalles = $_REQUEST['detalles'];
    $stock = $_REQUEST['stock'];

    $data['catalogo'] = new Catalogo(
        $key,
        $nombre,
        $nuevoPrecio,
        $imagen,
        $nuevosDetalles,
        $stock
    );
    $data['catalogo']->update();
}

header("Location: administrarweb_controller.php");
