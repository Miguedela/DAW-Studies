<!--
Una función denominada obtenerSuma (tipo función, devolverá un valor numérico) que reciba una ruta de archivo 
como parámetro, lea los números existentes en cada línea del archivo, y devuelva la suma de todos esos números
-->
<?php
include '../funciones.php';

// Ejemplo de uso
$ruta = "ejercicio2.txt";

echo "La suma de los números en el archivo es: " . obtenerSuma($ruta);
