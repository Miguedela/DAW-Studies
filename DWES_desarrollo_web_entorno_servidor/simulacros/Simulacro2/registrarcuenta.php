<?php
include_once("funciones.php");
if (session_status() == PHP_SESSION_NONE) session_start();

if (isset($_REQUEST['registrarCuenta'])) {
    header("Location: login.php");
}

// Recogo los datos introducidos por el usuario en el formulario
$nombreUsuario = $_REQUEST['nombreUsuario'];
$contraseniaUsuario = $_REQUEST['contraseniaUsuario'];

escribirUsuario($nombreUsuario, $contraseniaUsuario);

header("Location: login.php");
