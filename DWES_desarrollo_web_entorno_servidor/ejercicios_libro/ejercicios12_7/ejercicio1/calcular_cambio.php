<?php
header("Content-Type: application/json");

// Función para convertir euros a pesetas
function euros_a_pesetas($euros)
{
    return $euros * 166.386;
}

// Función para convertir pesetas a euros
function pesetas_a_euros($pesetas)
{
    return $pesetas / 166.386;
}

// Capturar el parámetro de la URL
if (isset($_REQUEST['euros'])) {
    if ($_REQUEST['euros'] < 0) {
        echo json_encode(["error" => "Debes proporcionar una cantidad de euros mayor que 0."]);
    }

    $euros = floatval($_REQUEST['euros']);
    $pesetas = euros_a_pesetas($euros);
    echo json_encode(["entrada" => $euros, "salida" => round($pesetas, 2)]);
} elseif (isset($_REQUEST['pesetas'])) {
    if ($_REQUEST['pesetas'] < 0) {
        echo json_encode(["error" => "Debes proporcionar una cantidad de pesetas mayor que 0."]);
    }

    $pesetas = floatval($_REQUEST['pesetas']);
    $euros = pesetas_a_euros(pesetas: $pesetas);
    echo json_encode(["entrada" => $pesetas, "salida" => round($euros, 2)]);
} else {
    echo json_encode(["error" => "Debes proporcionar una cantidad en euros o pesetas en la URL."]);
}
