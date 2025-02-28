<?php
include_once "funciones.php";
if (!isset($_REQUEST['iniciarSesion'])) {
    header("Location: login.php");
}

$nombreUsuario = $_REQUEST['usuarios'];

$_SESSION['usuarioLogeado'] = iniciarSesion($nombreUsuario);

header("Location: login.php");
