<?php
require_once '../Model/Foto.php';
require_once '../Model/Like.php';
require_once '../Model/Usuario.php';
require_once '../Model/FotografiasDB.php';

$metodo = $_SERVER['REQUEST_METHOD'];
$codEstado = 200;
$mensaje = "OK";
$devolver = [];

// Recoger fotos de un usuario
if ($metodo == 'GET') {
    if (isset($_REQUEST['nombre'])) {
        $fotos = Foto::getFotosUsuarioByNombre($_REQUEST['nombre']);

        if (empty($fotos)) {
            $mensaje = "NO SE ENCONTRARON RESULTADOS";
            $codEstado = 404;
        } else {
            foreach ($fotos as $foto) {
                $devolver[] = [
                    "id_foto" => $foto->getId(),
                    "foto" => $foto->getImagen(),
                    "id_usuario" => $foto->getId_usuario()
                ];
            }
        }
    }
} else {
    $mensaje = "DATOS INSUFICIENTES";
    $codEstado = 400;
}

// Cambiar el autor de una foto (PUT)
if ($metodo == 'PUT') {

    if (isset($_REQUEST['id_foto']) && isset($_REQUEST['id_usuario'])) {
        $resultado = Foto::updateAutorImagen($_REQUEST['id_foto'], $_REQUEST['id_usuario']);

        if ($resultado) {
            $mensaje = "AUTOR DE LA FOTO ACTUALIZADO";
        } else {
            $mensaje = "ERROR AL ACTUALIZAR EL AUTOR DE LA FOTO ACTUALIZADO";
            $codEstado = 404;
        }
    } else {
        $mensaje = "DATOS INSUFICIENTES";
        $codEstado = 400;
    }

    // parse_str(file_get_contents("php://input"), $parametros);
    // $devolver[] = var_dump($parametros);

    // if (isset($parametros['id_foto']) && isset($parametros['id_usuario'])) {
    //     $resultado = Foto::updateAutorImagen($parametros['id_foto'], $parametros['id_usuario']);

    //     if ($resultado) {
    //         $mensaje = "AUTOR DE LA FOTO ACTUALIZADO";
    //     } else {
    //         $mensaje = "ERROR AL ACTUALIZAR EL AUTOR DE LA FOTO ACTUALIZADO";
    //         $codEstado = 404;
    //     }
    // } else {
    //     $mensaje = "DATOS INSUFICIENTES";
    //     $codEstado = 400;
    // }

}

// // Matricular un alumno en una asignatura (POST)
// if ($metodo == 'POST') {
//     if (isset($_REQUEST['matricula']) && isset($_REQUEST['codigoAsignatura'])) {
//         $resultado = AlumnoAsignatura::matricularAlumno(
//             $_REQUEST['matricula'],
//             $_REQUEST['codigoAsignatura']
//         );

//         if ($resultado) {
//             $mensaje = "ALUMNO MATRICULADO CORRECTAMENTE";
//         } else {
//             $mensaje = "ERROR AL MATRICULAR ALUMNO";
//             $codEstado = 400;
//         }
//     } else {
//         $mensaje = "DATOS INSUFICIENTES";
//         $codEstado = 400;
//     }
// }

// // Borrar un alumno (DELETE)
// if ($metodo == 'DELETE') {
//     if (isset($_REQUEST['matricula'])) {
//         $resultado = Alumno::borrarAlumno($_REQUEST['matricula']);

//         if ($resultado) {
//             $mensaje = "ALUMNO ELIMINADO CORRECTAMENTE";
//         } else {
//             $mensaje = "ERROR AL ELIMINAR ALUMNO";
//             $codEstado = 400;
//         }
//     } else {
//         $mensaje = "DATOS INSUFICIENTES";
//         $codEstado = 400;
//     }
// }

setCabecera($codEstado, $mensaje);
echo json_encode(["mensaje" => [$codEstado, $mensaje], "datos" => $devolver]);

function setCabecera($codEstado, $mensaje)
{
    header("HTTP/1.1 $codEstado $mensaje");
    header("Content-Type: application/json;charset=utf-8");
}
