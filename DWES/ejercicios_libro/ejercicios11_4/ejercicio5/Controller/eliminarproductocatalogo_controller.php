<?php
require_once '../Model/Catalogo.php';

if (session_status() == PHP_SESSION_NONE) session_start();

if (!isset($data['catalogo'])) {
    $data['catalogo'] = Catalogo::getArticulos();

    if (isset($_REQUEST['eliminarProductoCatalogo'])) {
        $key = $_REQUEST['eliminarProductoCatalogo'];

        // Verifico si existe la imagen asociada al producto
        if (
            isset($data['catalogo'][$key]) &&
            $data['catalogo'][$key]->getImagen() !== "" && $data['catalogo'][$key]->getImagen() !== null
        ) {
            $imagenRuta = $data['catalogo'][$key]->getImagen();

            // Eliminar el archivo de la imagen si existe
            if (file_exists($imagenRuta)) {
                unlink($imagenRuta);  // Elimina la imagen del servidor
            }
        }

        // elimino el producto del catalogo de la session y de las cookies
        $data['catalogo'][$key]->delete();

        // elimino el producto eliminado del catalogo tambien del carrito
        if (isset($_SESSION['carrito'][$key])) {
            unset($_SESSION['carrito'][$key]);
            setcookie('carrito[' . $key . ']', "", -1);
        }
    }
}

header("Location: administrarweb_controller.php");
