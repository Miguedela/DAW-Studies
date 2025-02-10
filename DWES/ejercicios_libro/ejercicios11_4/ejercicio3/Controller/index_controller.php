<?php
require_once '../Model/Tractor.php';

if (session_status() == PHP_SESSION_NONE) session_start();

if (!isset($data['tractores'])) {
    $data['tractores'] = Tractor::getArticulos();
}

if (!isset($_SESSION['carrito']) && isset($_COOKIE['carrito'])) {
    $_SESSION['carrito'] = $_COOKIE['carrito'];
}

// Cargar la vista de la página index
include '../View/index_view.php';
