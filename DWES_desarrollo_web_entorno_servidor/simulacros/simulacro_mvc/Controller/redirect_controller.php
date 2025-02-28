<?php
if (session_status() == PHP_SESSION_NONE) session_start();

require_once '../Model/Usuario.php';

if (isset($_REQUEST['iniciarSesionORegistro'])) {
    include '../View/acceso_cuenta_view.php';
} else if (isset($_REQUEST['acceso'])) {
    if (Usuario::comprobarUsuario($_REQUEST['usuario'])) {
        $_SESSION['usuario'] = $_REQUEST['usuario'];
        header('Location: index_controller.php');
    } else {
        $mensajeError = "ESTE USUARIO NO ESTA REGISTRADO";
        include '../View/acceso_cuenta_view.php';
    }
} else if (isset($_REQUEST['registro'])) {
    if (Usuario::comprobarUsuario($_REQUEST['usuario'])) {
        $mensajeError = "ESTE USUARIO YA ESTA REGISTRADO";
        include '../View/acceso_cuenta_view.php';
    } else {
        $usuario = new Usuario(null, $_REQUEST['usuario']);
        $usuario->insert();
        $_SESSION['usuario'] = $usuario->getNombre();
    }
}
