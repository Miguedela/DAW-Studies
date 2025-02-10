<?php
include_once "Email.php";
include_once "funciones.php";
include_once "libreria.php";
if (session_status() == PHP_SESSION_NONE) session_start();

if (!isset($_REQUEST['importante'])) {
    header("Location: index.php");
} else if (isset($_REQUEST['importante'])) {
    $indice = $_REQUEST['importante'];
    $_SESSION['emails'][$indice]->destacarAsunto();
    actualizarFichero();

    header("Location: index.php");
}

if (!isset($_REQUEST['retrasar'])) {
    header("Location: index.php");
} else if (isset($_REQUEST['retrasar'])) {
    $indice = $_REQUEST['retrasar'];
    $_SESSION['emails'][$indice]->retrasarEnvio();
    actualizarFichero();

    header("Location: index.php");
}
