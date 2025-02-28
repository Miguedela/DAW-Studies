<?php
include_once "funciones.php";
if (session_status() == PHP_SESSION_NONE) session_start();

function registrarUsuario($nombreUsuario, $contraseniaUsuario)
{
    $rutaArchivo = 'ficheros/' . $nombreUsuario . '.rsv';

    $nombreUsuario = trim($nombreUsuario);
    $contraseniaUsuario = trim($contraseniaUsuario);

    if (!file_exists($rutaArchivo)) {
        $archivo = fopen($rutaArchivo, "w");

        fwrite($archivo, $contraseniaUsuario . PHP_EOL);

        fclose($archivo);

        return "registrado";
    } else {
        return "existe";
    }
}

function iniciarSesion($nombreUsuario, $contraseniaUsuario)
{
    $rutaArchivo = 'ficheros/' . $nombreUsuario . '.rsv';

    $nombreUsuario = trim($nombreUsuario);

    if (!file_exists($rutaArchivo)) {
        echo "El archivo no existe.";
        return "mal";
    }

    $archivo = fopen($rutaArchivo, "r");

    $contraseniaUsuario = trim($contraseniaUsuario);

    // while (!feof($archivo)) {
    $linea = fgets($archivo);
    // if ($linea != "") {
    $contrasenia = trim($linea);

    if ($contraseniaUsuario === $contrasenia) {
        setcookie("usuarioRegistrado", $nombreUsuario . '-' . $contrasenia, strtotime("+1 month"));
        return $nombreUsuario;
    }
    //     }
    // }

    return "mal";
}

function recogerReservas()
{
    $rutaArchivo = 'ficheros/' . $_SESSION['usuarioLogueado'] . '.rsv';

    $archivo = fopen($rutaArchivo, "r");

    $reservas = [];
    $indice = 0;

    while (!feof($archivo)) {
        $linea = fgets($archivo);
        if ($linea != "" && $indice > 0) {
            $reserva = unserialize(base64_decode(trim($linea)));
            if ($reserva->getEstado() === "PENDIENTE") {
                Reserva::setTotalPendientes(Reserva::getTotalPendientes() + 1);
            }
            $reservas[] = base64_encode(serialize($reserva));
        }
        $indice++;
    }

    return $reservas;
}

function actualizarFichero()
{
    $rutaArchivo = 'ficheros/' . $_SESSION['usuarioLogueado'] . '.rsv';

    $archivo = fopen($rutaArchivo, "r");

    // Recojo la contraseña del archivo para no perderla
    $linea = fgets($archivo);
    $contrasenia = trim($linea);
    fclose($archivo);

    // Escribo el fichero por primera vez (w) con la contraseña solo
    $archivo = fopen($rutaArchivo, "w");
    fwrite($archivo, $contrasenia . PHP_EOL);
    fclose($archivo);

    // Sobreesxcribo el fichero con los datos de las reservas
    $archivo = fopen($rutaArchivo, "a");
    foreach ($_SESSION['reservas'] as $key => $value) {
        fwrite($archivo, $value . PHP_EOL);
    }
    fclose($archivo);
}
