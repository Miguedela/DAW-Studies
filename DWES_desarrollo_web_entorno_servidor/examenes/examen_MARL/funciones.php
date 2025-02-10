<?php
include_once "Email.php";
include_once "libreria.php";
if (session_status() == PHP_SESSION_NONE) session_start();
function devolverUsuarios()
{
    return unserialize(base64_decode($_COOKIE['usuariosRegistrados']));
}

function registrarUsuario($nombreUsuario)
{
    if (isset($_COOKIE['usuariosRegistrados'])) {
        $usuarios = unserialize(base64_decode($_COOKIE['usuariosRegistrados']));

        if (in_array($nombreUsuario, $usuarios)) {
            return "existe";
        } else {
            $usuarios[] = $nombreUsuario;
            setcookie('usuariosRegistrados', base64_encode(serialize($usuarios)), strtotime("+1 year"));
            return $nombreUsuario;
        }
    } else {
        $usuarios = [];
        $usuarios[] = $nombreUsuario;
        setcookie('usuariosRegistrados', base64_encode(serialize($usuarios)), strtotime("+1 year"));
        return $nombreUsuario;
    }
}

function iniciarSesion($nombreUsuario)
{
    if (count($_SESSION['usuariosRegistrados']) > 0) {
        if (in_array($nombreUsuario, $_SESSION['usuariosRegistrados'])) {
            return $nombreUsuario;
        } else {
            return "noexiste";
        }
    }
}

function devolverEmails()
{
    $rutaArchivo = "ficheros/emails.txt";

    $archivo = fopen($rutaArchivo, "r");
    $emails = [];

    while (!feof($archivo)) {
        $linea = fgets($archivo);
        if ($linea != "") {
            $datos = explode(",", trim($linea));

            if (count($datos) === 4) {
                $emisor = trim($datos[0]);
                $receptor = trim($datos[1]);
                $asunto = trim($datos[3]);
                $fecha = trim($datos[2]);

                $email = new Email($emisor, $receptor, $asunto, $fecha);
                $emails[] = $email;
            } else {
                error_log("Línea mal formateada: $linea");
            }
        }
    }
    fclose($archivo);

    return $emails;
}
