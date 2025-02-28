<?php
require_once '../Model/Tractor.php';

if (session_status() == PHP_SESSION_NONE) session_start();

if (!isset($data['tractores'])) {
    $data['tractores'] = Tractor::getArticulos();
}

// Carga la vista de listado
include '../View/carrito_view.php';
