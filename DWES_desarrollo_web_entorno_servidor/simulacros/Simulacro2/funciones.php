<?php
function comprobarUsuarioRegistrado($nombreUsuario, $contraseniaUsuario)
{
    $rutaArchivo = "ficheros/usuarios.dat";

    if (!file_exists($rutaArchivo)) {
        echo "El archivo no existe.";
        return false;
    }

    $archivo = fopen($rutaArchivo, "r");
    $bandera = false;

    $nombreUsuario = trim($nombreUsuario);
    $contraseniaUsuario = trim($contraseniaUsuario);

    while (!feof($archivo)) {
        $linea = fgets($archivo);
        if ($linea != "") {
            $datos = explode("-", trim($linea));

            if (count($datos) === 2) {
                $nombre = trim($datos[0]);
                $contrasenia = trim($datos[1]);

                if ($nombreUsuario === $nombre && $contraseniaUsuario === $contrasenia) {
                    $bandera = true;
                }
            } else {
                error_log("Línea mal formateada: $linea");
            }
        }
    }

    return $bandera;
}

function escribirUsuario($nombreUsuario, $contraseniaUsuario)
{
    $rutaArchivo = "ficheros/usuarios.dat";

    $archivo = fopen($rutaArchivo, "a");
    if ($archivo === false) {
        throw new Exception("No se pudo abrir el archivo para escritura.");
    }

    $linea = trim($nombreUsuario) . "-" . trim($contraseniaUsuario);
    fwrite($archivo, $linea . PHP_EOL);

    fclose($archivo);
}
