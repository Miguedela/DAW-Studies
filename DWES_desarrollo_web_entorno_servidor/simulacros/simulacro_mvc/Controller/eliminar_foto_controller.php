<?php
if (session_status() == PHP_SESSION_NONE) session_start();

require_once '../Model/Foto.php';
require_once '../Model/Usuario.php';

if (isset($_REQUEST['eliminarFoto'])) {
    $foto = new Foto($_REQUEST['idFoto'], $imagen, Usuario::getIdUsuario($_SESSION['usuario']));
    $foto->delete();
    header('Location: ver_cuenta_controller.php');
} else {
    header('Location: index_controller.php');
}
