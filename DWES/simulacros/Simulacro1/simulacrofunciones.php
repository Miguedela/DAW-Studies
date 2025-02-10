<?php
function generaMatricula($marca)
{
    if (isset($_SESSION['coches'])) {
        do {
            $numeroMatricula = rand(100, 999);
            $letrasMatricula = substr($marca, strlen($marca) - 3, strlen($marca));

            $matricula = $numeroMatricula . $letrasMatricula;
        } while (array_key_exists($matricula, $_SESSION['coches']));
    } else {
        $numeroMatricula = rand(100, 999);
        $letrasMatricula = substr($marca, strlen($marca) - 3, strlen($marca));

        $matricula = $numeroMatricula . $letrasMatricula;
    }
    return $matricula;
}
