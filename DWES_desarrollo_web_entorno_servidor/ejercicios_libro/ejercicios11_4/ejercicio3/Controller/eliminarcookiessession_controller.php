<?php
session_start();

include 'funciones/funciones.php';

// elimino las cookies y las session
if (isset($_REQUEST['elimarCookiesSession'])) {
    // setcookie("catalogo", "", -1);

    // elimino las cookies con un for debido a que las almaceno en un array '$_COOKIES['carrito[¿?]']'
    if (isset($_COOKIE['carrito'])) {
        foreach ($_COOKIE['carrito'] as $key => $value) {
            setcookie("carrito[$key]", "", -1);
        }
    }
    
    // // Borro el catalogo del fichero
    // vaciarFichero('ficheros/catalogo.txt');

    session_destroy();
}

header("Location: index_controller.php");
