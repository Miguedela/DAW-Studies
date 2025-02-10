<!--
Realiza un programa que sea capaz de ordenar alfabéticamente las palabras contenidas en un fichero de texto. El 
nombre  del  fichero  que  contiene  las  palabras  se  debe  pasar  a  través  de  un  formulario.  El  nombre  del  fichero 
resultado debe ser el mismo que el original añadiendo la coletilla sort, por ejemplo palabras_sort.txt. Suponemos 
que cada palabra ocupa una línea.
-->
<?php
include '../funciones.php';

$ruta = '../ejercicio8/ejercicio8.txt';

ordenarFichero($ruta);
?>