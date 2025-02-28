<?php
require_once '../Model/Usuario.php';

if (session_status() == PHP_SESSION_NONE) session_start();

if (isset($_REQUEST['registrarUsuario'])) {
    header("Location: index_controller.php");

    $data['usuario'] = new Usuario(
        $_REQUEST['codigo'],
        $_REQUEST['nombre'],
        $_REQUEST['correo'],
        $_REQUEST['telefono'],
        $_REQUEST['contrasenia']
    );

    $data['usuario']->insert();
}
