<?php
session_start();

if (!isset($_REQUEST['generarColor'])) {
    header("Location: ejercicio1.php");
}

// Genero los 3 números random
$rand1 = rand(0, 255);
$rand2 = rand(0, 255);
$rand3 = rand(0, 255);

// Creo el nuevo color con los 3 numeros random
$nuevoColor = 'rgb(' . $rand1 . ', ' . $rand2 . ', ' . $rand3 . ')';

// Almaceno el nuevo color generado en una posicion nueva del array
$_SESSION['paletaColores'][] = $nuevoColor;

header("Location: ejercicio1.php");
