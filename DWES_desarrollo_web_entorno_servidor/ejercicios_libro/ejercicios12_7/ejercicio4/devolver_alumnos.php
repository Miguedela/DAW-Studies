<?php
require_once 'Alumno.php';
require_once 'AlumnoAsignatura.php';

$metodo = $_SERVER['REQUEST_METHOD'];
$codEstado = 200;
$mensaje = "OK";
$devolver = [];

// Registrar la petición

if ($metodo == 'GET') {
    if (isset($_REQUEST['grupo'])) {
        $alumnos = Alumno::getAlumnosGrupo($_REQUEST['grupo']);
    } else if (isset($_REQUEST['buscador'])) {
        $alumnos = Alumno::getAlumnosNombre($_REQUEST['buscador']);
    } else if (isset($_REQUEST['matriculaAlumno'])) {
        $asignaturas = AlumnoAsignatura::getAsignaturasByAlumno($_REQUEST['matriculaAlumno']);
    }

    if (empty($alumnos) && empty($asignaturas)) {
        $mensaje = "NO SE ENCONTRARON RESULTADOS";
        $codEstado = 404;
    } else {
        if (!empty($alumnos)) {
            foreach ($alumnos as $alumno) {
                $devolver[] = $alumno;
            }
        }

        if (!empty($asignaturas)) {
            foreach ($asignaturas as $asignatura) {
                $devolver[] = $asignatura;
            }
        }
    }
}

// Matricular un alumno en una asignatura (POST)
if ($metodo == 'POST') {
    if (isset($_REQUEST['matricula']) && isset($_REQUEST['codigoAsignatura'])) {
        $resultado = AlumnoAsignatura::matricularAlumno(
            $_REQUEST['matricula'],
            $_REQUEST['codigoAsignatura']
        );

        if ($resultado) {
            $mensaje = "ALUMNO MATRICULADO CORRECTAMENTE";
        } else {
            $mensaje = "ERROR AL MATRICULAR ALUMNO";
            $codEstado = 400;
        }
    } else {
        $mensaje = "DATOS INSUFICIENTES";
        $codEstado = 400;
    }
}

// Cambiar grupo de un alumno (PUT)
if ($metodo == 'PUT') {
    if (isset($_REQUEST['matricula']) && isset($_REQUEST['nuevoGrupo'])) {
        $resultado = Alumno::cambiarGrupo($_REQUEST['matricula'], $_REQUEST['nuevoGrupo']);

        if ($resultado) {
            $mensaje = "GRUPO ACTUALIZADO CORRECTAMENTE";
        } else {
            $mensaje = "ERROR AL ACTUALIZAR GRUPO";
            $codEstado = 400;
        }
    } else {
        $mensaje = "DATOS INSUFICIENTES";
        $codEstado = 400;
    }
}

// Borrar un alumno (DELETE)
if ($metodo == 'DELETE') {
    if (isset($_REQUEST['matricula'])) {
        $resultado = Alumno::borrarAlumno($_REQUEST['matricula']);

        if ($resultado) {
            $mensaje = "ALUMNO ELIMINADO CORRECTAMENTE";
        } else {
            $mensaje = "ERROR AL ELIMINAR ALUMNO";
            $codEstado = 400;
        }
    } else {
        $mensaje = "DATOS INSUFICIENTES";
        $codEstado = 400;
    }
}

setCabecera($codEstado, $mensaje);
echo json_encode(["mensaje" => [$codEstado, $mensaje], "datos" => $devolver]);

function setCabecera($codEstado, $mensaje)
{
    header("HTTP/1.1 $codEstado $mensaje");
    header("Content-Type: application/json;charset=utf-8");
}
