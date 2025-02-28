<?php
require_once '../Model/Articulo.php';

// Obtener todos los articulos
$data['articulos'] = Articulo::getArticulos();

// Cargar la vista de listado
include '../View/index_view.php';
