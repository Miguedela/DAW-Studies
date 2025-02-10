<?php
if (session_status() == PHP_SESSION_NONE) session_start();

if (!isset($_REQUEST['cerrarSesion'])) {
    header("Location: login.php");
}

$_SESSION['usuarioLogeado'] = null;
header("Location: login.php");
