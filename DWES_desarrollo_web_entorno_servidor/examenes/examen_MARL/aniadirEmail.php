<?php
include_once "Email.php";
include_once "funciones.php";

if (session_status() == PHP_SESSION_NONE) session_start();

if (!isset($_REQUEST['registrarCorreoS'])) {
    header("Location: index.php");
}

$emisor = $_SESSION['usuarioLogeado'];
$receptor = $_REQUEST['receptorEmail'];
$asunto = $_REQUEST['asuntoEmail'];
$fecha = date("d/m/Y", time());

$email = new Email($emisor, $receptor, $asunto, $fecha);

agregarEmail($email);

header("Location: index.php");
