<?php
if (isset($_REQUEST['verAlumnosAsignatura'])) {
    require_once '../Model/AlumnoAsignatura.php';

    $data['asignaturaAlumnos'] = AlumnoAsignatura::getAlumnosByAsignatura($_REQUEST['verAlumnosAsignatura']);

    include '../View/alumnos_asignatura_view.php';
} else {
    header('Location: index_controller.php');
}
