<?php

if (isset($_REQUEST['modificarAlumno'])) {
    require_once '../Model/Alumno.php';

    $codigoMatricula = $_REQUEST['matricula'];
    $nombre = $_REQUEST['nombre'];
    $apellidos = $_REQUEST['apellidos'];
    $curso = $_REQUEST['curso'];

    $alumno = new Alumno($codigoMatricula, $nombre, $apellidos, $curso);
    $alumno->update();
}

header('Location: index_controller.php');
