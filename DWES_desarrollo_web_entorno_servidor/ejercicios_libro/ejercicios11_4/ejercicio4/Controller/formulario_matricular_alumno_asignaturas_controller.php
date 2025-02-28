<?php
if (isset($_REQUEST['verAsignaturasLibres'])) {
    require_once '../Model/AlumnoAsignatura.php';

    $code = $_REQUEST['verAsignaturasLibres'];

    $data['asignaturas'] = AlumnoAsignatura::getAsignaturasLibresByAlumno($code);

    include '../View/matricular_alumno_asignaturas_view.php';
} else {
    header('Location: index_controller.php');
}
