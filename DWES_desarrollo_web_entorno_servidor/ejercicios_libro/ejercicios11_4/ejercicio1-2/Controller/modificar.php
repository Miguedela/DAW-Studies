<?php
require_once '../Model/Articulo.php';

// Crear nuevo objeto articulo e insertar el nuevo artículo
$data['articulo'] = new Articulo($_REQUEST['codigo'], $_REQUEST['titulo'], $_REQUEST['fechaHora'], $_REQUEST['contenido']);
$data['articulo']->update();

// Cargar la vista de listado
header('Location: index_controller.php');
