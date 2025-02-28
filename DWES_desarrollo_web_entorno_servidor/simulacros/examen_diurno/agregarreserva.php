<?php
include_once "Reserva.php";
include_once "funciones.php";
if (session_status() == PHP_SESSION_NONE) session_start();

if (!isset($_REQUEST['realizarReserva'])) {
    header("Location: login.php");
}

$sala = $_REQUEST['salaReserva'];
$fechaHora = $_REQUEST['fechaHoraReserva'];

$reserva = new Reserva($_SESSION['usuarioLogueado'], strtotime($fechaHora), $sala);
$_SESSION['reservas'][] = base64_encode(serialize($reserva));

actualizarFichero();

header("Location: index.php");
