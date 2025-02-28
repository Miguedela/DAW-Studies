<?php
if (session_status() == PHP_SESSION_NONE) session_start();

// en caso de que el usuario decida vaciar su carrito
if (isset($_REQUEST['vaciarCarrito'])) {

    // elimino las cookies con un for debido a que las almaceno en un array '$_COOKIES['carrito[¿?]']'
    if (isset($_COOKIE['carrito'])) {
        foreach ($_COOKIE['carrito'] as $key => $value) {
            setcookie("carrito[$key]", "", -1);
        }
    }
    unset($_SESSION['carrito']);

    header("Location: vercarrito.php");
}

header("Location: index_controller.php");
