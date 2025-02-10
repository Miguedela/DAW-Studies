<?php
if (isset($_REQUEST['aniadirAlumno'])) {
    require_once '../Model/Alumno.php';

    $codigoMatricula = $_REQUEST['codigoMatricula'];
    $nombre = $_REQUEST['nombre'];
    $apellidos = $_REQUEST['apellidos'];
    $curso = $_REQUEST['curso'];

    $data['alumno'] = new Alumno($codigoMatricula, $nombre, $apellidos, $curso);
    $data['alumno']->insert();
}

header('Location: index_controller.php');
