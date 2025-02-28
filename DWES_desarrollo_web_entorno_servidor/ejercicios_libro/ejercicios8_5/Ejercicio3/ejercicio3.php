<!--
Una función denominada obtenerArrNum (tipo función, devolverá un array de valores numéricos) que reciba una 
ruta  de  archivo  como  parámetro,  lea  los  números  existentes  en  cada  línea  del  archivo,  y  devuelva  un  array  cuyo 
  
índice  0  contendrá  el  número  existente  en  la  primera  línea,  cuyo  índice  1  contendrá  el  número  existente  en  la 
segunda línea y así sucesivamente (no usar la función file)
-->
<?php
include '../funciones.php';

// Ejemplo de uso
try {
    $ruta = 'ejercicio3.txt';

    $resultado = obtenerArrNum($ruta);
    var_dump($resultado);
} catch (Exception $e) {
    echo "Error: " . $e->getMessage();
}
