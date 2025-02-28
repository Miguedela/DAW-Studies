<?php
session_start();

if (isset($_REQUEST['nombre'])) {
    // Guardo la última key en una varibale
    $ultimaClave = "";
    foreach ($_SESSION['catalogo'] as $key => $value) {
        $ultimaClave = $key;
    }

    // Extraemos el número de la última clave
    $numero = (int)substr($ultimaClave, 2);
    // Incrementamos el número
    $numero++;

    $key = 'JD' . $numero;

    $nombre = $_REQUEST['nombre'];
    $precio = (float) $_REQUEST['precio'];
    $imagen = $_REQUEST['imagen'];
    $detallesProducto = $_REQUEST['detallesProducto'];

    // Guardo el nuevo producto en el catalogo de session y de las cookies
    $_SESSION['catalogo'][$key] = [
        "nombre" => $nombre,
        "precio" => $precio,
        "imgUrl" => $imagen,
        "detalles" => $detallesProducto
    ];
    setcookie("catalogo", base64_encode(serialize($_SESSION['catalogo'])), time() + 3600);

    header("Location: ejercicio3.php");
} else {
    header("Location: ejercicio3.php");
}
