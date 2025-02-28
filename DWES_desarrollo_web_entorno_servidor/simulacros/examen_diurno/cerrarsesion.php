<?php
if (session_status() == PHP_SESSION_NONE) session_start();

if (!isset($_REQUEST['cerrarSesion'])) {
    header("Location: index.php");
}

$_SESSION['usuarioLogueado'] = null;
setcookie("usuarioRegistrado", "", -1);
session_destroy();

header("Location: login.php");
