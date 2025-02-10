<?php
function obtenerBombillas()
{
    $rutaArchivo = "ficheros/bombillas.txt";

    if (!file_exists($rutaArchivo)) {
        echo "El archivo no existe.";
        return [];
    }

    $archivo = fopen($rutaArchivo, "r");
    $bombillas = [];

    while (!feof($archivo)) {
        $linea = fgets($archivo);
        if ($linea != "") {
            $datos = explode("-", trim($linea));

            if (count($datos) === 2) {
                $ubicacion = trim($datos[0]);
                $potencia = trim($datos[1]);

                $bombillas[$ubicacion] = base64_encode(serialize(
                    new Bombilla($ubicacion, $potencia)
                ));
            } else {
                error_log("Línea mal formateada: $linea");
            }
        }
    }

    return $bombillas;
}

function guardarBombilla($bombilla)
{
    $rutaArchivo = "ficheros/bombillas.txt";

    $archivo = fopen($rutaArchivo, "a");
    if ($archivo === false) {
        throw new Exception("No se pudo abrir el archivo para escritura.");
    }

    $linea = $bombilla->getUbicacionBombilla() . "-" . $bombilla->getPotenciaBombilla();
    fwrite($archivo, $linea . PHP_EOL);

    fclose($archivo);
}
