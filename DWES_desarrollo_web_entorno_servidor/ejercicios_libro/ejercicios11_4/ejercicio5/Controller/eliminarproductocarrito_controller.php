<?php
require_once '../Model/Carrito.php';
require_once '../Model/Usuario.php';

if (session_status() == PHP_SESSION_NONE) session_start();

// en caso de que el usuario decida eliminar un producto
if (isset($_REQUEST['eliminarProducto'])) {
    $data['productoCarrito'] = new Carrito(
        $_REQUEST['eliminarProducto'],
        $_SESSION['usuario']->getCodigo()
    );
    $data['productoCarrito']->delete();

    header("Location: vercarrito.php");
} else {
    header("Location: index_controller.php");
}

