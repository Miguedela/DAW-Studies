<?php
if (session_status() == PHP_SESSION_NONE) session_start();

if (!isset($_REQUEST['aniadirProducto'])) {
    header("Location: index_controller.php");
}

// Carga la vista de listado
include '../View/aniadirproducto_view.php';
