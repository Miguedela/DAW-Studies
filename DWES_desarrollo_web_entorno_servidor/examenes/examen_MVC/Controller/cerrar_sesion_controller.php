<?php
if (session_status() == PHP_SESSION_NONE) session_start();

if (isset($_REQUEST['cerrarSesion'])) {
    session_destroy();
}

header('Location: redirect_controller.php');
