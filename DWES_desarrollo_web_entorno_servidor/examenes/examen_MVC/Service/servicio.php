<?php
require_once '../Model/Usuario.php';
require_once '../Model/Incidencia.php';

$metodo = $_SERVER['REQUEST_METHOD'];
$codEstado = 200;
$mensaje = "OK";
$devolver = [];

// Recoger fotos de un usuario
if ($metodo == 'GET') {
    if (isset($_REQUEST['idAdmin'])) {
        $incidencias = Incidencia::getIncidenciasResueltasByAdmin($_REQUEST['idAdmin']);

        if (empty($incidencias)) {
            $mensaje = "NO SE ENCONTRARON RESULTADOS";
            $codEstado = 404;
        } else {
            foreach ($incidencias as $incidencia) {
                $devolver[] = [
                    "descripcion" => $incidencia->getDescripcion(),
                    "reparador" => Usuario::getNombreUsuario($incidencia->getAdmin()),
                    "fecha" => $incidencia->getFecha()
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

    // if (isset($_REQUEST['id_propietario']) && isset($_REQUEST['id_destinatario'])) {
    //     $incidencias = Incidencia::getIncidenciasByAdmin($_REQUEST['id_propietario']);

    //     if (
    //         !Usuario::comprobarUsuarioById($_REQUEST['id_propietario']) ||
    //         !Usuario::comprobarUsuarioById($_REQUEST['id_destinatario'])
    //     ) {
    //         $mensaje = "USUARIOS NO ENCONTRADOS";
    //         $codEstado = 404;
    //     } else if (
    //         Usuario::comprobarUsuarioById($_REQUEST['id_propietario']) &&
    //         Usuario::comprobarUsuarioById($_REQUEST['id_destinatario']) &&
    //         !Usuario::comprobarAdminById($_REQUEST['id_propietario']) ||
    //         !Usuario::comprobarAdminById($_REQUEST['id_destinatario'])
    //     ) {
    //         $mensaje = "ALGUNOS DE LOS USUARIOS NO ES ADMIN";
    //         $codEstado = 409;
    //     } else {
    //         foreach ($incidencias as $incidencia) {
    //             $incidencia->setAdmin($_REQUEST['id_destinatario']);
    //             $incidencia->update();
    //         }
    //         $mensaje = "LAS INCIDENCIAS HAN SIDO ACTUALIZADAS CORRECTAMENTE";
    //     }
    // } else {
    //     $mensaje = "DATOS INSUFICIENTES";
    //     $codEstado = 400;
    // }

    // METODO DE LA CABERCERA
    // ----------------------------------------------------------------------------------------------------
    // ----------------------------------------------------------------------------------------------------
    // ----------------------------------------------------------------------------------------------------
    parse_str(file_get_contents("php://input"), $parametros);

    if (isset($parametros['id_propietario']) && isset($parametros['id_destinatario'])) {
        $incidencias = Incidencia::getIncidenciasByAdmin($parametros['id_propietario']);

        if (
            !Usuario::comprobarUsuarioById($parametros['id_propietario']) ||
            !Usuario::comprobarUsuarioById($parametros['id_destinatario'])
        ) {
            $mensaje = "USUARIOS NO ENCONTRADOS";
            $codEstado = 404;
        } else if (
            Usuario::comprobarUsuarioById($parametros['id_propietario']) &&
            Usuario::comprobarUsuarioById($parametros['id_destinatario']) &&
            !Usuario::comprobarAdminById($parametros['id_propietario']) ||
            !Usuario::comprobarAdminById($parametros['id_destinatario'])
        ) {
            $mensaje = "ALGUNOS DE LOS USUARIOS NO ES ADMIN";
            $codEstado = 409;
        } else {
            foreach ($incidencias as $incidencia) {
                // ERROR AQUI POR NO PODER HACER LA COMPROBACIÓN DEBIDO AL POSTMAN
                $incidencia->setAdmin($parametros['id_destinatario']);
                $incidencia->update();
            }
            $mensaje = "LAS INCIDENCIAS HAN SIDO ACTUALIZADAS CORRECTAMENTE";
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
