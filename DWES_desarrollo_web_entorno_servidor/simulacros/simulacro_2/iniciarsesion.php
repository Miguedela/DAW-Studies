<?php
include_once("funciones.php");
if (session_status() == PHP_SESSION_NONE) session_start();

if (!isset($_REQUEST['iniciarSesion'])) {
    header("Location: login.php");
}

// Recogo los datos introducidos por el usuario en el formulario
$nombreUsuario = $_REQUEST['nombreUsuario'];
$contraseniaUsuario = $_REQUEST['contraseniaUsuario'];

// Compruebación si el usuario esta registrado
if (comprobarUsuarioRegistrado($nombreUsuario, $contraseniaUsuario)) {
    $_SESSION['usuario'] = $nombreUsuario;

    // Comprobación de el usuario desea guardar sus datos de inicio
    if (isset($_REQUEST['recordarContrasenia'])) {
        setcookie("usuario", $nombreUsuario . "-" . $contraseniaUsuario, time() + (30 * 24 * 60 * 60));
    } else if (!isset($_REQUEST['recordarContrasenia']) && isset($_COOKIE['usuario'])) {
        setcookie("usuario", "", -1);
    }
} else {
    $_SESSION['usuario'] = "mal";
}

// Le devuelvo a la página principal
header("Location: login.php");
