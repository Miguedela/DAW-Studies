<?php
session_start();

// en caso de no tener el catalogo creado en las session lo creo
if (!isset($_SESSION['catalogo']) && !isset($_COOKIE['catalogo'])) {
    // array statico de los productos del catalogo
    $catalogo = [
        "JD1" => array(
            "nombre" => "Jhon Deere 001",
            "precio" => 10599.99,
            "imgUrl" => "tractor1",
            "detalles" => "tractor potentisimo"
        ),
        "JD2" => array(
            "nombre" => "Jhon Deere 002",
            "precio" => 11599.99,
            "imgUrl" => "tractor2",
            "detalles" => "tractor potentisimo"
        ),
        "JD3" => array(
            "nombre" => "Jhon Deere 003",
            "precio" => 12599.99,
            "imgUrl" => "tractor3",
            "detalles" => "tractor potentisimo"
        )
    ];

    // creo la session y las cookies catalogo al array statico del catalogo
    $_SESSION['catalogo'] = $catalogo;
    setcookie('catalogo', base64_encode(serialize($catalogo)), time() + 3600);
    // en caso de no tener la session del catalogo pero si tener las cookies (copia de seguridad) del catalogo
} else if (!isset($_SESSION['catalogo']) && isset($_COOKIE['catalogo'])) {
    $_SESSION['catalogo'] = unserialize(base64_decode($_COOKIE['catalogo']));
}

// en caso de no tener el carrito lo creamos
if (!isset($_SESSION['carrito']) && isset($_COOKIE['carrito'])) {
    $_SESSION['carrito'] = $_COOKIE['carrito'];
}

header("Location: ejercicio3.php");
