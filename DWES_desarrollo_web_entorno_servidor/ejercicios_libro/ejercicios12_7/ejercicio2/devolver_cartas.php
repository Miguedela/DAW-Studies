<?php
header("Content-Type: application/json");

// Capturar el parámetro de la URL
if (isset($_GET['cantidadCartas'])) {
    $palos = ['oro', 'copa', 'basto', 'espadas'];
    $baraja = [];

    for ($i = 1; $i <= $_GET['cantidadCartas']; $i++) {
        $carta = null;

        do {
            $palo = $palos[rand(0, 3)];
            $numero = rand(1, 10);

            switch ($numero) {
                case 1:
                    $numero = "AS";
                    break;
                case 8:
                    $numero = "Sota";
                    break;
                case 9:
                    $numero = "Caballo";
                    break;
                case 10:
                    $numero = "Rey";
                    break;
            }

            $carta = $numero . " de " . $palo;
        } while (in_array($carta, $baraja));

        $baraja[] = $carta;
    }

    echo json_encode(["baraja" => $baraja]);
}
