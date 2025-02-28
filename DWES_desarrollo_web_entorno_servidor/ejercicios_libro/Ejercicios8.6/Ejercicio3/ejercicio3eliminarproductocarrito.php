<?php
session_start();

// en caso de que el usuario decida eliminar un producto
if (isset($_REQUEST['eliminarProducto'])) {
    $key = $_REQUEST['eliminarProducto'];

    if (isset($_SESSION['carrito'][$key]) && $_SESSION['carrito'][$key] > 1) {
        $_SESSION['carrito'][$key]--;
        setcookie("carrito[$key]", $_SESSION['carrito'][$key], time() + 3600);
    } else if (isset($_SESSION['carrito'][$key]) && $_SESSION['carrito'][$key] == 1) {
        unset($_SESSION['carrito'][$key]);

        setcookie("carrito[$key]", "", -1);
    }

    header("Location: ejercicio3carritovista.php");
} else {
    header("Location: ejercicio3.php");
}
