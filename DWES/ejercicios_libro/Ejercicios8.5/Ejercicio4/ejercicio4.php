<!--
Crea código php donde a través de la función escribirTresNumeros escribas en el fichero los números 2, 8, 14. Luego, 
mediante la función obtenerSuma muestra por pantalla el resultado de sumar los números existentes en el archivo. 
Finalmente, mediante la función obtenerArrNum obtén el array, recórrelo y muestra cada uno de los elementos del 
array.
-->
<?php
include '../funciones.php';

$ruta = 'ejercicio4.txt';

// Escribir los números 2, 8, y 14 en el archivo
escribirTresNumeros($ruta, 2, 8, 14);

// Mostrar la suma de los números
echo "La suma de los números es: " . obtenerSuma($ruta) . "\n";

// Obtener el array de números y recorrerlo
$numeros = obtenerArrNum($ruta);
echo "Los números en el archivo son:\n";
foreach ($numeros as $num) {
    echo $num . "\n";
}
?>