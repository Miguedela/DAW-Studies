<?php
require_once '../Model/Articulo.php';

// Obtener el artículo a modificar
if (isset($_REQUEST['modificarArticulo'])) {
    $data['articulo'] = Articulo::getArticuloById($_REQUEST['modificarArticulo']);
} else {
    header('Location: index_controller.php');
}

// Cargar la vista de listado
include '../View/modificar_view.php';
