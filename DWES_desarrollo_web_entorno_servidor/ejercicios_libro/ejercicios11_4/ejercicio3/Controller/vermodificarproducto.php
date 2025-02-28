<?php
require_once '../Model/Tractor.php';

if (session_status() == PHP_SESSION_NONE) session_start();

// if que te manda a la pagina principal en caso de no recibir la variable necesaria
if (isset($_REQUEST['modificarProducto'])) {
    if (!isset($data['tractores'])) {
        $data['tractores'] = Tractor::getArticulos();
    }

    $key = $_REQUEST['modificarProducto'];
}

include '../View/modificarproducto_view.php';
