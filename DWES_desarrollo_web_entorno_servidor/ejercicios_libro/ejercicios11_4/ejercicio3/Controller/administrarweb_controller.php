<?php
require_once '../Model/Tractor.php';

if (session_status() == PHP_SESSION_NONE) session_start();

if (!isset($data['tractores'])) {
    $data['tractores'] = Tractor::getArticulos();
}

if (isset($_REQUEST['logear'])) {
    $nombre = $_REQUEST['nombreUsuario'];
    $contrasenia = $_REQUEST['contrasenia'];

    if ($nombre != 'root' || $contrasenia != 'root') {
        header('Location: index_controller.php');
    } else {
        $_SESSION['usuario'] = $nombre;
    }

    // Carga la vista de administrador
    include '../View/administrar_view.php';
} else if (isset($_SESSION['usuario'])) {
    // Carga la vista de administrador
    include '../View/administrar_view.php';
} else {
    header('Location: index_controller.php');
}
