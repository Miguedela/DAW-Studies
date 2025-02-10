<!--
Crea código php donde a través de la función escribirNumerosMod escribas en el fichero los números 2, 8, 14. Luego, 
mediante la función leerContenidoFichero muestra el contenido del fichero. Ahora con la función 
escribirNumerosMod  amplía  el  contenido  del  fichero  y  añádele  los  números  33,  11  y  16.  Muestra  nuevamente  el 
contenido  del  fichero  por  pantalla.  Finalmente,  escribe  el  fichero  pasándole  un  array  con  los  número  4,  99,  12  y 
parámetro <<sobreescribir>> para eliminar los datos que existieran previamente. Muestra el contenido del fichero 
por pantalla y un mensaje de despedida. 
Crea las siguientes páginas en PHP
-->
<?php
include '../funciones.php';

// Archivo de trabajo
$ruta = "ejercicio7.txt";

// Paso 1: Escribir los números 2, 8, 14 en el fichero
escribirNumerosMod2($ruta, [2, 8, 14], 'w');
leerContenidoFichero($ruta);

// Paso 2: Agregar los números 33, 11, 16 al fichero
escribirNumerosMod2($ruta, [33, 11, 16], 'a');
leerContenidoFichero($ruta);

// Paso 3: Sobrescribir con los números 4, 99, 12
escribirNumerosMod2($ruta, [4, 99, 12], 'w');
leerContenidoFichero($ruta);
?>