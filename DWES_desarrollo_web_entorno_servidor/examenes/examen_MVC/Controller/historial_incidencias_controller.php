<?php
if (session_status() == PHP_SESSION_NONE) session_start();

require_once '../Model/Usuario.php';
require_once '../Model/Incidencia.php';

if (isset($_REQUEST['verHistorial'])) {
    $data['incidenciasReparadasAdmin'] =
        Incidencia::getIncidenciasResueltasByAdmin(Usuario::getIdUsuario($_SESSION['usuario']));
    include '../View/historial_admin_view.php';
} else {
    header('Location: redirect_controller.php');
}
