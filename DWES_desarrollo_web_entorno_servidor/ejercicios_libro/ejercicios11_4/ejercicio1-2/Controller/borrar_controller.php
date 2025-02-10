<?php
require_once '../Model/Articulo.php';

// Eliminar un artículo
if (isset($_REQUEST['eliminarArticulo'])) {
    $data['articulo'] = Articulo::getArticuloById($_REQUEST['eliminarArticulo']);
    $data['articulo']->delete();
}

// Cargar la vista de listado
header('Location: index_controller.php');
