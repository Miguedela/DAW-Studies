<?php
require_once '../Model/Catalogo.php';
require_once '../Model/Carrito.php';
require_once '../Model/Usuario.php';

if (session_status() == PHP_SESSION_NONE) session_start();

// en caso de que el usuario decida vaciar su carrito
if (isset($_REQUEST['comprarCarrito'])) {
    $data['catalogo'] = Catalogo::getArticulos();
    $data['carritoUsuario'] = Carrito::getCarritoUsuario($_SESSION['usuario']->getCodigo());
    $data['cantidadProductos'] = Carrito::calcularProductosUsuario($_SESSION['usuario']->getCodigo());
    $data['precioCarrito'] = Carrito::calcularPrecioCarrito($_SESSION['usuario']->getCodigo());

    include '../View/factura_view.php';
} else {
    header("Location: index_controller.php");
}
