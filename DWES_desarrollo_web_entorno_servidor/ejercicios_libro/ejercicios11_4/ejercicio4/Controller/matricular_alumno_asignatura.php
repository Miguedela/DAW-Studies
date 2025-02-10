<?php
if (isset($_REQUEST['matricularAsignatura'])) {
    require_once '../Model/AlumnoAsignatura.php';

    $data['alumnoAsignatura'] = new AlumnoAsignatura($_REQUEST['matricula'], $_REQUEST['asignatura']);
    $data['alumnoAsignatura']->insert();
}

header('Location: index_controller.php');
