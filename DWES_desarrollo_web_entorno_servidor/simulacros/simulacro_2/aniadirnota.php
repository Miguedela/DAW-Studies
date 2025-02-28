<?php
include_once "Nota.php";
if (session_status() == PHP_SESSION_NONE) session_start();

if (!isset($_REQUEST['aniadirNota'])) {
    header("Location: principal.php");
}

$tituloNota = $_REQUEST['tituloNota'];
$textoNota = $_REQUEST['textoNota'];

$nota = new Nota($tituloNota, $textoNota);

$_SESSION['notas'][$_SESSION['usuario']][$tituloNota] = base64_encode(serialize($nota));

header("Location: principal.php");
