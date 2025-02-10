<?php
require_once '../Model/Catalogo.php';
require_once '../Model/Usuario.php';

if (session_status() == PHP_SESSION_NONE) session_start();
$data['catalogo'] = Catalogo::getArticulos();

if (isset($_REQUEST['logear'])) {
    $nombre = $_REQUEST['nombreUsuario'];
    $contrasenia = $_REQUEST['contrasenia'];

    $data['usuario'] = new Usuario("", $nombre, "", "", $contrasenia);

    if ($data['usuario']->comprobarUsuario()) {
        $_SESSION['usuario'] = $data['usuario']->comprobarUsuario();
    }
}

header("Location: index_controller.php");
