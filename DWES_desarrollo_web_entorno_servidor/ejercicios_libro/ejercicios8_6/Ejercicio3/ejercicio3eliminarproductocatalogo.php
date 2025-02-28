<?php
session_start();

include 'funciones/funciones.php';

if (!isset($_REQUEST['eliminarProductoCatalogo'])) {
    header("Location: ejercicio3.php");
} else {
    $key = $_REQUEST['eliminarProductoCatalogo'];

    // Verifico si existe la imagen asociada al producto
    if (isset($_SESSION['catalogo'][$key]['imgUrl'])) {
        $imagenRuta = $_SESSION['catalogo'][$key]['imgUrl'];

        // Eliminar el archivo de la imagen si existe
        if (file_exists($imagenRuta)) {
            unlink($imagenRuta);  // Elimina la imagen del servidor
        }
    }

    // elimino el producto del catalogo de la session y de las cookies
    unset($_SESSION['catalogo'][$key]);
    guardarTractores($_SESSION['catalogo'], 'ficheros/catalogo.txt');

    // setcookie('catalogo[' . $key . ']', "", -1);

    // elimino el producto eliminado del catalogo tambien del carrito
    if (isset($_SESSION['carrito'][$key])) {
        unset($_SESSION['carrito'][$key]);
        setcookie('carrito[' . $key . ']', "", -1);
    }

    header("Location: " . $_SERVER['HTTP_REFERER']);
}
