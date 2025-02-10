<?php
include_once "funciones.php";
if (session_status() == PHP_SESSION_NONE) session_start();

if (!isset($_REQUEST['iniciarSesion'])) {
    header("Location: login.php");
}

$nombreUsuario = $_REQUEST['nombreUsuario'];
$contraseniaUsuario = $_REQUEST['contraseniaUsuario'];

$_SESSION['usuarioLogueado'] = iniciarSesion($nombreUsuario, $contraseniaUsuario);

header("Location: index.php");
