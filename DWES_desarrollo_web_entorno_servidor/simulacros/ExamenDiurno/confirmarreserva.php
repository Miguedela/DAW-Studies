<?php
include_once "Reserva.php";
include_once "funciones.php";
if (session_status() == PHP_SESSION_NONE) session_start();

if (!isset($_REQUEST['confirmarReserva'])) {
    header("Location: login.php");
}

$indice = $_REQUEST['confirmarReserva'];
$reserva = unserialize(base64_decode($_SESSION['reservas'][$indice]));
$reserva->confirmar();
$_SESSION['reservas'][$indice] = base64_encode(serialize($reserva));

actualizarFichero();

header("Location: index.php");
