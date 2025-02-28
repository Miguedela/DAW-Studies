<?php
session_start();

if (!isset($_REQUEST['productoModificado'])) {
    header("Location: ejercicio3.php");
} else {
    $key = $_REQUEST['productoModificado'];
    $nuevoPrecio = (float) $_REQUEST['precio'];
    $nuevosDetalles = $_REQUEST['detalles'];

    // en caso de haber escrito un nuevo precio lo modificamos
    if ($nuevoPrecio != "" || $nuevoPrecio != null) {
        $_SESSION['catalogo'][$key]['precio'] = $nuevoPrecio;
    }

    // en caso de haber escrito un nuevo detalles del producto lo modificamos
    if ($nuevosDetalles != "" || $nuevosDetalles != null) {
        $_SESSION['catalogo'][$key]['detalles'] = $nuevosDetalles;
    }

    setcookie('catalogo', base64_encode(serialize($_SESSION['catalogo'])), time() + 3600);

    header("Location: ejercicio3.php");
}
