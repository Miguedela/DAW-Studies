<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<?php
$cadenaTexto = "Mi moto alpina derrapante";
?>

<body>
    <br>------------------------------Ejercicio 1-----------------------------------<br>
    <!--
    Ejercicio 1
    Imprimir carácter por carácter un string dado, cada uno en una línea distinta.
    -->
    <?php

    for ($i = 0; $i < strlen($cadenaTexto); $i++) {
        echo $cadenaTexto[$i], "<br>";
    }
    ?>

    <br>------------------------------Ejercicio 2-----------------------------------<br>
    <!--
    Ejercicio 2
    Cambiar todas las vocales de la frase “Tengo una hormiguita en la patita, que me esta haciendo 
    cosquillitas y no me puedo aguantar” por otra vocal pedida al usuario.
    -->
    <?php
    $aux = str_replace(["a", "e", "i", "o", "u"], "e", $cadenaTexto);
    echo $aux, "<br>";
    ?>

    <br>------------------------------Ejercicio 3-----------------------------------<br>
    <!--
    Ejercicio 3
    Contar cuantas palabras tiene una frase introducida por el usuario, ten en cuenta que el usuario 
    puede poner varios espacios seguidos, incluso al principio o al final. 
    -->
    <?php
    $aux = trim($cadenaTexto);
    $palabras = explode(" ", $aux);

    echo count($palabras);
    ?>

    <br>------------------------------Ejercicio 4-----------------------------------<br>
    <!--
    Ejercicio 4.
    Verificar si un string leído por teclado finaliza con la misma palabra que empieza.
    -->
    <?php
    $aux = trim($cadenaTexto);
    $palabras = explode(" ", $aux);

    if ($palabras[0] == $palabras[count($palabras) - 1]) {
        echo "Empieza por la misma palabra que acaba", "<br>";
    } else {
        echo "No empieza por la misma palabra que acaba", "<br>";
    }
    ?>

    <br>------------------------------Ejercicio 5-----------------------------------<br>
    <!--
    Ejercicio 5.  
    Intercambiar un string dado, hasta volverlo a su forma original: 
    ejemplo: Hola, ahol, laho, olah, hola (stop).
    -->
    <?php
    $aux2 = $cadenaTexto;

    echo $aux2, "<br>";
    for ($i = 0; $i < strlen($cadenaTexto); $i++) {
        $aux1 = substr($aux2, -1); // cojo el ultimo carácter
        $aux2 = substr($aux2, 0, -1); // cojo todos, menos el ultimo carácter
        $aux2 = $aux1 . "" . $aux2; // concateno en la variable $aux2 la frase modificada
        echo $aux2, "<br>";
    }
    ?>

    <br>------------------------------Ejercicio 6-----------------------------------<br>
    <!--
    Ejercicio 6.  
    Dado un párrafo con dos frases (separadas por un punto), contar cuántas palabras tiene cada 
    frase.
    -->
    <?php
    $aux1 = $cadenaTexto . '. ' . $cadenaTexto;
    $aux2 = trim($aux1); // elimmino los espacios de los extremos
    $frases = explode(".", $aux2); // separo la frase por el punto

    // separo las palabras por los espacios para almacenarlas una por una
    $palabrasFrase1 = explode(" ", trim($frases[0]));
    $palabrasFrase2 = explode(" ", trim($frases[1]));

    echo "Palabras que contiene la frase1: ", count($palabrasFrase1), "<br>Palabras que contiene la frase2: ", count($palabrasFrase2);
    ?>

    <br>------------------------------Ejercicio 7-----------------------------------<br>
    <!--
    Ejercicio 7.  
    Verificar si en una frase se encuentra una determinada palabra pedida al usuario.
    -->
    <?php
    $aux = trim($cadenaTexto);
    $palabras = explode(" ", $aux);

    $palabraBuscar = "moto";

    // paso los valores a minusculas
    foreach ($palabras as $key => $value) {
        $value = strtolower($value);
    }
    $palabraBuscar = strtolower($palabraBuscar);

    // creo una bandera para comprobar si la palabra ha sido encontrada en la frase
    $encontrada = false;
    foreach ($palabras as $key => $value) {
        if ($value == $palabraBuscar) {
            $encontrada = true;
        }
    }

    // Muestro la respuesta por pantalla
    if ($encontrada) {
        echo "La palabra ", $palabraBuscar, " ha sido encontrada en la frase '", $aux, "'.";
    } else {
        echo "La palabra ", $palabraBuscar, " no ha sido encontrada en la frase '", $aux, "'.";
    }
    ?>
    <br>------------------------------Ejercicio 8-----------------------------------<br>
    <!--
    Ejercicio 8.  
    Pedir un string al usuario e imprimir todos los números seguidos y sin espacios, 
    correspondientes al código ascii de cada uno de sus caracteres. Posteriormente calcular la frase 
    original a partir de dichos números (usar un array). 
    -->


    <br>------------------------------Ejercicio 9-----------------------------------<br>
    <!--
    Ejercicio 9.  
    Pedir al usuario una cadena de caracteres e imprimirla invertida.
    -->
    <?php
    $aux = trim($cadenaTexto);

    for ($i = strlen($aux) - 1; $i >= 0; $i--) {
        echo $aux[$i];
    }
    ?>
</body>

</html>