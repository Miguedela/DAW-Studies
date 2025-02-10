<?php
if (isset($_REQUEST['verAsignaturasAlumno'])) {
    require_once '../Model/Asignatura.php';

    $data['asignaturasAlumno'] = Asignatura::getAsignaturas();

    include '../View/asignaturas_view.php';
} else {
    header('Location: index_controller.php');
}
