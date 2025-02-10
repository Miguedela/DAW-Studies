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

    foreach ($data['carritoUsuario'] as $key => $articulo) {
        $data['catalogo'][$key]->extraer($articulo->getCantidad());
        $data['catalogo'][$key]->update();
    }

    Carrito::eliminarCarritoUsuario(codigo_usuario: $_SESSION['usuario']->getCodigo());

    header("Location: vercarrito.php");
} else {
    header("Location: index_controller.php");
}
