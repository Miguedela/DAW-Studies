<!--
Una función (tipo procedimiento, no hay valor devuelto) denominada escribirNumerosMod que reciba dos 
parámetros: un array de valores enteros y una cadena de texto que puede ser "sobreescribir" ó "ampliar". La función 
debe proceder a: escribir cada uno de los números que forman el contenido del array  en una línea de un archivo 
datosEjercicio.txt usando el modo de operación que se indique con el otro parámetro. Si el archivo no existe, debe 
crearlo. 
Ejemplo: El array que se pasa es $numeros = array(5, 9, 3, 22); y la invocación que se utiliza es 
escribirNumerosMod($numeros, "sobreescribir"); En este caso, se debe eliminar el contenido que existiera 
previamente en el archivo y escribir en él 4 líneas, cada una de las cuales contendrá los números 5, 9, 3 y 22
-->
<?php
include '../funciones.php';

$ruta = 'ejercicio5.txt';
$numeros = array(5, 9, 3, 22);

escribirNumerosMod($ruta, $numeros, 'sobreescribir');
leerContenidoFichero($ruta);
?>