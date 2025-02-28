<?php
if (session_status() == PHP_SESSION_NONE) session_start();

require_once '../Model/Usuario.php';
require_once '../Model/Incidencia.php';

if (isset($_REQUEST['nuevaIncidencia'])) {
    include '../View/nueva_incidencia_view.php';
} else if (isset($_REQUEST['agregarNuevaIncidencia'])) {
    $incidencia = new Incidencia(
        null,
        $_REQUEST['descripcion'],
        $_REQUEST['nombreProfesor'],
        $_REQUEST['fecha'],
        $_REQUEST['estado'],
        null
    );

    $incidencia->insert();

    header('Location: redirect_controller.php');
}
