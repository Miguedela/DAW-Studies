<?php
if (session_status() == PHP_SESSION_NONE) session_start();

require_once '../Model/Usuario.php';
require_once '../Model/Incidencia.php';

if (isset($_REQUEST['accederCuenta'])) {
    if (Usuario::comprobarUsuario($_REQUEST['nombreUsuario'])) {
        $usuario = Usuario::getUsuarioByNombre($_REQUEST['nombreUsuario']);
        $_SESSION['usuario'] = $usuario->getNombre();
    } else {
        $usuario = new Usuario(null, $_REQUEST['nombreUsuario'], 'user');
        $usuario->insert();
        $usuario = Usuario::getUsuarioByNombre($_REQUEST['nombreUsuario']);
        $_SESSION['usuario'] = $usuario->getNombre();
    }
}

if (isset($_SESSION['usuario'])) {
    if (Usuario::comprobarAdmin($_SESSION['usuario'])) {
        $_SESSION['admin'] = true;
    }

    $data['incidencias'] = Incidencia::getIncidencias();
    include '../View/index_view.php';
} else {
    include '../View/login_view.php';
}
