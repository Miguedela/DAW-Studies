<?php

if (isset($_REQUEST['eliminarAlumno'])) {
    require_once '../Model/Alumno.php';

    $data['alumno'] = Alumno::getAlumno($_REQUEST['eliminarAlumno']);
    $data['alumno']->delete();
}

header('Location: index_controller.php');
