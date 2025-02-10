<?php
// Funcion para guardar las mascotas en los ficheros
function guardar()
{
    $hoy = date("d-m-Y");
    $hoy = "#" . $hoy . "#";
    $fp = fopen("../ficheros/mascotas.txt", "r");
    $existeFecha = false;

    while (!feof($fp)) {
        $linea = fgets($fp);
        if (trim($linea) === $hoy) {
            $existeFecha = true;
        }
    }
    fclose($fp);


    $fp = fopen("../ficheros/mascotas.txt", "a");
    $mascotas = $_SESSION['mascota'];
    //Si la fecha no esta la ponemos
    if ($existeFecha == false) {
        fwrite($fp, $hoy . PHP_EOL);
    }

    foreach ($mascotas as $key => $value) {
        $linea = $key . "-" . $value["tipo"] . "-" . $value["edad"];
        fwrite($fp, $linea . PHP_EOL);
    }
    fclose($fp);
}

// Funcion para obtener un array de las fechas del fichero de las mascotas
function obtenerFechas()
{
    $fp = fopen("../ficheros/mascotas.txt", "r");
    $fechas = [];

    while (!feof($fp)) {
        $linea = fgets($fp);
        $linea = trim($linea);
        if (isset($linea[0])) {
            if ($linea[0] === "#" && !empty($linea)) {
                $fechas[] = $linea;
            }
        }
    }

    fclose($fp);
    return $fechas;
}

// Funcion para obtener las mascotas de una fecha concreta
function obtenerMascotas($fecha)
{
    $fp = fopen("../ficheros/mascotas.txt", "r");
    $mascotas = [];
    $fecha = trim($fecha);
    $fechaLinea = "";

    while (!feof($fp)) {
        $linea = fgets($fp);
        $linea = trim($linea);
        if (isset($linea[0])) {
            if ($linea[0] === "#") {
                $fechaLinea = $linea;
            } elseif ($fechaLinea === $fecha) {
                $partes = explode("-", $linea);
                $mascotas[$partes[0]] = [
                    "tipo" => $partes[1],
                    "edad" => $partes[2]
                ];
            }
        }
    }
    fclose($fp);
    return $mascotas;
}
