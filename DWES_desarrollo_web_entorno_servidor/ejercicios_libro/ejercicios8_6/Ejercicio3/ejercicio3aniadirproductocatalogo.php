<?php
session_start();

include 'funciones/funciones.php';

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
    $key = 'JD' . $numero; //clave del nuevo producto

    $nombre = $_REQUEST['nombre'];
    $precio = (float) $_REQUEST['precio'];
    $detallesProducto = $_REQUEST['detallesProducto'];
    $nombreImagen = basename($_FILES['imagen']['name']);

    $directorio = 'img/';
    $rutaDestino = $directorio . $nombreImagen;
    
    move_uploaded_file($_FILES['imagen']['tmp_name'], $rutaDestino);
    $imagen = $rutaDestino;

    // Guardar el nuevo producto en el catálogo de sesión y cookies
    $_SESSION['catalogo'][$key] = [
        "nombre" => $nombre,
        "precio" => $precio,
        "imgUrl" => $imagen,
        "detalles" => $detallesProducto
    ];

    // setcookie("catalogo", base64_encode(serialize($_SESSION['catalogo'])), time() + 3600);

    guardarTractores($_SESSION['catalogo'], 'ficheros/catalogo.txt');

    header("Location: ejercicio3.php");
} else {
    header("Location: ejercicio3.php");
}
