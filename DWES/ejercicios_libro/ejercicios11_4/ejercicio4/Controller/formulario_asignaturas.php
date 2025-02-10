<?php
if (isset($_REQUEST['verAsignaturas'])) {
    require_once '../Model/Asignatura.php';

    $data['asignaturas'] = Asignatura::getAsignaturas();

    include '../View/asignaturas_view.php';
} else {
    header('Location: index_controller.php');
}
