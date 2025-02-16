<?php
if (session_status() == PHP_SESSION_NONE) session_start();

require_once '../Model/Usuario.php';
require_once '../Model/Incidencia.php';

if (isset($_REQUEST['finalizarIncidencia'])) {
    $incidencia = Incidencia::getIncidenciaById($_REQUEST['finalizarIncidencia']);
    $incidencia->setEstado('RESUELTA');
    $incidencia->update();
}

header('Location: redirect_controller.php');
