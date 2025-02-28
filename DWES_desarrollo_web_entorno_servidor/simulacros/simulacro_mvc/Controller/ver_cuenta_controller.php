<?php
if (session_status() == PHP_SESSION_NONE) session_start();

require_once '../Model/Foto.php';
require_once '../Model/Usuario.php';

if (isset($_SESSION['usuario'])) {
    $data['fotosUsuario'] = Foto::getFotosUsuario(Usuario::getIdUsuario($_SESSION['usuario']));
    include '../View/cuenta_usuario_view.php';
} else {
    header('Location: index_controller.php');
}
