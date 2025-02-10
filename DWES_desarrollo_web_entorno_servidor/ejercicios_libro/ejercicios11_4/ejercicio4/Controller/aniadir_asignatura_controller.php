<?php
if (isset($_REQUEST['aniadirAsignatura'])) {
    require_once '../Model/Asignatura.php';

    $data['asignatura'] = new Asignatura("", $_REQUEST['nombre']);
    $data['asignatura']->insert();

    header('Location: formulario_asignaturas.php');
} else {
    header('Location: index_controller.php');
}
