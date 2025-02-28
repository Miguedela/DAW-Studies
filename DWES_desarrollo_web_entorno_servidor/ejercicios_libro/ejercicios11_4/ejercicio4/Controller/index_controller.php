<?php
require_once '../Model/Alumno.php';

// Saco los alumnos almacenados en la base de datos
$data['alumnos'] = Alumno::getAlumnos();

// Cargar la vista de la página index
include '../View/index_view.php';
