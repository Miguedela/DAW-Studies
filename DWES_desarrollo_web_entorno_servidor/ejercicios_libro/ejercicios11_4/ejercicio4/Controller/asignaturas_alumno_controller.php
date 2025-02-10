<?php
if (isset($_REQUEST['verAsignaturasAlumno'])) {
    require_once '../Model/AlumnoAsignatura.php';

    $code = $_REQUEST['verAsignaturasAlumno'];
    $data['asignaturasAlumno'] = AlumnoAsignatura::getAsignaturasByAlumno($code);

    include '../View/asignaturas_alumno_view.php';
} else {
    header('Location: index_controller.php');
}
