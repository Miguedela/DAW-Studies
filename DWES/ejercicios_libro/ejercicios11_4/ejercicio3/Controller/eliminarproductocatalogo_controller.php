<?php
require_once '../Model/Tractor.php';

if (session_status() == PHP_SESSION_NONE) session_start();

if (!isset($data['tractores'])) {
    $data['tractores'] = Tractor::getArticulos();

    if (isset($_REQUEST['eliminarProductoCatalogo'])) {
        $key = $_REQUEST['eliminarProductoCatalogo'];

        // Verifico si existe la imagen asociada al producto
        if (
            isset($data['tractores'][$key]) &&
            $data['tractores'][$key]->getImagen() !== "" && $data['tractores'][$key]->getImagen() !== null
        ) {
            $imagenRuta = $data['tractores'][$key]->getImagen();

            // Eliminar el archivo de la imagen si existe
            if (file_exists($imagenRuta)) {
                unlink($imagenRuta);  // Elimina la imagen del servidor
            }
        }

        // elimino el producto del catalogo de la session y de las cookies
        $data['tractores'][$key]->delete();

        // elimino el producto eliminado del catalogo tambien del carrito
        if (isset($_SESSION['carrito'][$key])) {
            unset($_SESSION['carrito'][$key]);
            setcookie('carrito[' . $key . ']', "", -1);
        }
    }
}

header("Location: administrarweb_controller.php");
