<?php
require_once '../Model/Carrito.php';
require_once '../Model/Usuario.php';

if (session_status() == PHP_SESSION_NONE) session_start();

// en caso de que el usuario decida vaciar su carrito
if (isset($_REQUEST['vaciarCarrito'])) {

    Carrito::eliminarCarritoUsuario($_SESSION['usuario']->getCodigo());

    header("Location: vercarrito.php");
}

header("Location: index_controller.php");
