<?php
include_once "funciones.php";
if (session_status() == PHP_SESSION_NONE) session_start();

if (!isset($_REQUEST['registrarusuario'])) {
    header("Location: login.php");
}

$nombreUsuario = $_REQUEST['nombreUsuario'];
$contraseniaUsuario = $_REQUEST['contraseniaUsuario'];

$_SESSION['usuarioLogueado'] = registrarUsuario($nombreUsuario, $contraseniaUsuario);

header("Location: login.php");
