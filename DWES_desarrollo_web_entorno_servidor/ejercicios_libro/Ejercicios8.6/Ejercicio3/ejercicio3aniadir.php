<?php
session_start();

// if que te manda a la pagina principal en caso de no recibir la variable necesaria
if (!isset($_REQUEST['aniadirCarrito'])) {
    header("Location: ejercicio3.php");
} else {
    $key = $_REQUEST['aniadirCarrito'];
}

if (isset($_SESSION['carrito'][$key])) {
    $_SESSION['carrito'][$key]++;
    setcookie('carrito[' . $key . ']', $_SESSION['carrito'][$key], time() + 3600);
} else {
    $_SESSION['carrito'][$key] = 1;
    setcookie('carrito[' . $key . ']', $_SESSION['carrito'][$key], time() + 3600);
}

header("Location: ejercicio3.php");
