<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
    <?php
    // Realiza un programa que escoja al azar 10 cartas de la baraja española y que diga cuántos puntos suman
    // según el juego de la brisca. Emplea un array asociativo para obtener los puntos a partir del nombre de la
    // figura de la carta. Asegúrate de que no se repite ninguna carta, igual que si las hubieras cogido de una
    // baraja de verdad.
    $palos = ['Oro', 'Espada', 'Basto', 'Copa'];
    $barajaEspanola = ['As', 'Dos', 'Tres', 'Cuatro', 'Cinco', 'Tres', 'Seis', 'Siete', 'Sota', 'Caballo', 'Rey'];

    $valor = array(
        'As' => 11,
        'Dos' => 0,
        'Tres' => 10,
        'Cuatro' => 0,
        'Cinco' => 0,
        'Seis' => 0,
        'Siete' => 0,
        'Sota' => 2,
        'Caballo' => 3,
        'Rey' => 4
    );

    $cantidad = 10;
    $acumulador = 0;
    $cartasGeneradas = [];
    for ($i = 0; $i < $cantidad; $i++) {
        do {
            $cartaRand = rand(0, count($barajaEspanola) - 1);
            $paloRand = rand(0, count($palos) - 1);
            $menu = $barajaEspanola[$cartaRand] . ' de ' . $palos[$paloRand];
            // Metodo para comprobar que el array no tiene la carta en concreto
        } while (in_array($menu, $cartasGeneradas));
        $cartasGeneradas[] = $menu; // Añado la carta al array
        $acumulador += $valor[$barajaEspanola[$cartaRand]]; // Sumo los puntos de la carta creada
        echo $menu, "<br>"; // Imprimo la carte generada
    }
    echo $acumulador; // Imprimo los puntos ganados con todas las cartas
    ?>
</body>

</html>