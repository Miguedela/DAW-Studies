<?php
require_once '../Model/Catalogo.php';
require_once '../Model/Carrito.php';
require_once '../Model/Usuario.php';

if (session_status() == PHP_SESSION_NONE) session_start();
$data['catalogo'] = Catalogo::getArticulos();
$data['carrito'] = Carrito::getCarritoUsuario($_SESSION['usuario']->getCodigo());
$data['cantidadProductos'] = Carrito::calcularProductosUsuario($_SESSION['usuario']->getCodigo());
$data['precioCarrito'] = Carrito::calcularPrecioCarrito($_SESSION['usuario']->getCodigo());

// Carga la vista de listado
include '../View/carrito_view.php';
