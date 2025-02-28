<?php
require_once '../Model/Catalogo.php';

if (session_status() == PHP_SESSION_NONE) session_start();

// if que te manda a la pagina principal en caso de no recibir la variable necesaria
if (!isset($_REQUEST['key'])) {
    header("Location: index_controller.php");
} else {
    $key = $_REQUEST['key'];
    $data['tractor'] = Catalogo::getTractor($key);
}

// Carga la vista de listado
include '../View/detallesproducto_view.php';
