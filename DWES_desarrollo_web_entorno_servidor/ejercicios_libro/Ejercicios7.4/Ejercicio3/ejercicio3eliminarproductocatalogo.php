<?php
session_start();

if (!isset($_REQUEST['eliminarProductoCatalogo'])) {
    header("Location: ejercicio3.php");
} else {
    $key = $_REQUEST['eliminarProductoCatalogo'];

    // elimino el producto del catalogo de la session y de las cookies
    unset($_SESSION['catalogo'][$key]);
    setcookie('catalogo[' . $key . ']', "", -1);

    // elimino el producto eliminado del catalogo tambien del carrito
    if (isset($_SESSION['carrito'][$key])) {
        unset($_SESSION['carrito'][$key]);
        setcookie('carrito[' . $key . ']', "", -1);
    }

    header("Location: ejercicio3.php");
}
