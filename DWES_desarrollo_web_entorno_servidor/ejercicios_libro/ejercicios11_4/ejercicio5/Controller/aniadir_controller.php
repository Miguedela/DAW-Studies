<?php
require_once '../Model/Catalogo.php';
require_once '../Model/Carrito.php';
require_once '../Model/Usuario.php';

if (session_status() == PHP_SESSION_NONE) session_start();

// if que te manda a la pagina principal en caso de no recibir la variable necesaria
if (isset($_REQUEST['aniadirCarrito'])) {
    $data['productoCatalogo'] = Catalogo::getTractor($_REQUEST['aniadirCarrito']);
    $cantidad = Carrito::obtenerPedidoProducto($_REQUEST['aniadirCarrito'], $_SESSION['usuario']->getCodigo());

    if ($data['productoCatalogo']->getStock() - $cantidad == 0) {
        header("Location: index_controller.php");
    } else {
        $data['carrito'] = new Carrito(
            $_REQUEST['aniadirCarrito'],
            $_SESSION['usuario']->getCodigo()
        );

        $data['carrito']->insert();
        header("Location: vercarrito.php");
    }
}

header("Location: index_controller.php");
