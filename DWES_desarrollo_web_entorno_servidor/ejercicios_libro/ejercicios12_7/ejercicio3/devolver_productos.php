<?php
require_once 'Producto.php';
require_once 'Cliente.php';

$metodo = $_SERVER['REQUEST_METHOD'];
$codEstado = 200;
$mensaje = "OK";
$devolver = [];

// Verificar token de cliente
if (!isset($_REQUEST['token']) || !Cliente::validarToken($_REQUEST['token'])) {
    $codEstado = 403;
    $mensaje = "ACCESO DENEGADO";
    setCabecera($codEstado, $mensaje);
    echo json_encode(["error" => $mensaje]);
    exit;
}

// Registrar la petición
Cliente::sumarPeticion($_REQUEST['token']);

if ($metodo == 'GET') {
    if (isset($_REQUEST['min']) && isset($_REQUEST['max'])) {
        $productos = Producto::getProductosFiltroPrecio($_REQUEST['min'], $_REQUEST['max']);
    } else if (isset($_REQUEST['nombre'])) {
        $productos = Producto::getProductosFiltroNombre($_REQUEST['nombre']);
    }

    if (empty($productos)) {
        $mensaje = "PRODUCTO NO ENCONTRADO";
        $codEstado = 404;
    } else {
        foreach ($productos as $producto) {
            $devolver[] = $producto;
        }
    }
}

setCabecera($codEstado, $mensaje);
echo json_encode(["mensaje" => [$codEstado, $mensaje], "datos" => $devolver]);

function setCabecera($codEstado, $mensaje)
{
    header("HTTP/1.1 $codEstado $mensaje");
    header("Content-Type: application/json;charset=utf-8");
}
