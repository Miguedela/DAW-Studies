<?php
require_once '../Model/Catalogo.php';
require_once '../Model/Carrito.php';
require_once '../Model/Usuario.php';

if (session_status() == PHP_SESSION_NONE) session_start();
if (isset($_SESSION['usuario'])) {
    $data['catalogo'] = Catalogo::getArticulos();
    $data['carrito'] = Carrito::getCarritoUsuario($_SESSION['usuario']->getCodigo());
    $data['cantidadProductos'] = Carrito::calcularProductosUsuario($_SESSION['usuario']->getCodigo());
}

if (
    isset($_SESSION['usuario']) &&
    ($_SESSION['usuario']->getNombre() === "root" && $_SESSION['usuario']->getContrasenia() === "root")
) {
    include '../View/administrar_view.php';
} else if (
    isset($_SESSION['usuario']) &&
    ($_SESSION['usuario']->getNombre() !== "root" || $_SESSION['usuario']->getContrasenia() !== "root")
) {
    include '../View/index_view.php';
} else {
    include '../View/login_view.php';
}
