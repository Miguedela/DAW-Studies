<?php
if (session_status() == PHP_SESSION_NONE) session_start();

if (!isset($_REQUEST['cerrarSesion'])) {
    header("Location: principal.php");
}

$_SESSION['usuario'] = null;

header("Location: login.php");
