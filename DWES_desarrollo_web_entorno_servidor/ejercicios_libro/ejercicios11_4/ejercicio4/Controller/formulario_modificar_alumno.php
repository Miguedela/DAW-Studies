<?php
require_once '../Model/Alumno.php';

if (isset($_REQUEST['modificarAlumno'])) {
    require_once '../Model/Alumno.php';

    $data['alumno'] = Alumno::getAlumno($_REQUEST['modificarAlumno']);

    include '../View/modificar_alumno_view.php';
} else {
    header('Location: index_controller.php');
}
