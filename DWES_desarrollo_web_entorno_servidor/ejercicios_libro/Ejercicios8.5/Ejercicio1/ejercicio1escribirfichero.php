<?php
include '../funciones.php';

if (isset($_REQUEST['numeros'])) {
    $numeros = $_REQUEST['numeros'];

    escribirNumeros($numeros);

    echo '<br><a href="ejercicio1.php?verArchivo">Volver</a>';
}
