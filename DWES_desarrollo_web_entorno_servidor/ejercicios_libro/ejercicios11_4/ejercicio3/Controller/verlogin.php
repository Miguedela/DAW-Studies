<?php
if (session_status() == PHP_SESSION_NONE) session_start();

if (!isset($_REQUEST['logear'])) {
    header('Location: index_controller.php');
}

// Carga la vista de listado
include '../View/login_view.php';
