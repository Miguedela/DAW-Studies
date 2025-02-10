<?php
include_once "funciones.php";
if (session_status() == PHP_SESSION_NONE) session_start();

if (!isset($_REQUEST['registrarUsuario'])) {
    header("Location: login.php");
}

$nombreUsuario = $_REQUEST['nombreUsuario'];

$_SESSION['usuarioLogeado'] = registrarUsuario($nombreUsuario);

header("Location: login.php");
