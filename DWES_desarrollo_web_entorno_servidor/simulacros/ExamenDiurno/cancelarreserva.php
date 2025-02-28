<?php
include_once "Reserva.php";
include_once "funciones.php";
if (session_status() == PHP_SESSION_NONE) session_start();

if (!isset($_REQUEST['cancelarReserva'])) {
    header("Location: login.php");
}

$indice = $_REQUEST['cancelarReserva'];
$reserva = unserialize(base64_decode($_SESSION['reservas'][$indice]));
$reserva->cancelar();
$_SESSION['reservas'][$indice] = base64_encode(serialize($reserva));

actualizarFichero();

header("Location: index.php");
