<?php
require_once '../Model/Articulo.php';

// Creo el objeto articulo con los datos recibidos y lo inserto en la base de datos
$data['articulo'] = new Articulo("", $_REQUEST['titulo'], "", $_REQUEST['contenido']);
$data['articulo']->insert();

// Redirigir al index del controlador
header('Location: index_controller.php');
