<?php
if (session_status() == PHP_SESSION_NONE) session_start();

require_once '../Model/Usuario.php';
require_once '../Model/Incidencia.php';

if (isset($_REQUEST['repararIncidencia'])) {
    $incidencia = Incidencia::getIncidenciaById($_REQUEST['repararIncidencia']);
    $incidencia->setEstado('REPARANDO');
    $incidencia->setAdmin(Usuario::getIdUsuario($_SESSION['usuario']));
    $incidencia->update();
} else if (isset($_REQUEST['soltarIncidencia'])) {
    $incidencia = Incidencia::getIncidenciaById($_REQUEST['soltarIncidencia']);
    $incidencia->setEstado('PENDIENTE');
    $incidencia->setAdmin("-1");
    $incidencia->update();
}

header('Location: redirect_controller.php');
