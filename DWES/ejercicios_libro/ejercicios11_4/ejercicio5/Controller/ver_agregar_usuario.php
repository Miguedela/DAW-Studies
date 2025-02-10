<?php
if (session_status() == PHP_SESSION_NONE) session_start();

if (!isset($_REQUEST['agregarUsuario'])) {
    header("Location: index_controller.php");
}

// Carga la vista de listado
include '../View/aniadir_usuario_view.php';
