<?php
include_once "funciones.php";
if (session_status() == PHP_SESSION_NONE) session_start();


if (isset($_COOKIE['usuarioRegistrado']) && !isset($_SESSION['usuarioLogueado'])) {
    $datos = explode("-", $_COOKIE['usuarioRegistrado']);
    $_SESSION['usuarioLogueado'] = iniciarSesion($datos[0], $datos[1]);
}

if (!isset($_SESSION['usuarioLogueado'])) {
    $_SESSION['usuarioLogueado'] = null;
}

if (
    $_SESSION['usuarioLogueado'] !== null && $_SESSION['usuarioLogueado'] !== "mal" &&
    $_SESSION['usuarioLogueado'] !== "existe" && $_SESSION['usuarioLogueado'] !== "registrado"
) {
    header("Location: index.php");
}
?>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        body {
            text-align: center;
            margin: auto;
        }

        form {
            border-bottom: solid 1px black;
            padding-bottom: 30px;
        }
    </style>
</head>

<body>
    <h1>Inicie Sesion</h1>
    <form action="iniciarsesion.php" method="post">
        Usuario: <input type="text" name="nombreUsuario">
        <br><br>
        Contraseña: <input type="password" name="contraseniaUsuario">
        <br><br>
        <input type="hidden" name="iniciarSesion">
        <input type="submit" value="ACCESO USUARIO">

        <?php
        if ($_SESSION['usuarioLogueado'] === "mal") {
        ?>
            <h4 style="color: red;">Usuario o contraseña incorrectos</h4>
        <?php
        }
        ?>
    </form>

    <h1>Registra un usuario nuevo</h1>
    <form action="registrarusuario.php" method="post">
        Usuario: <input type="text" name="nombreUsuario">
        <br><br>
        Contraseña: <input type="password" name="contraseniaUsuario">
        <br><br>
        <input type="hidden" name="iniciarSesion">
        <input type="submit" value="ACCESO USUARIO">

        <?php
        if ($_SESSION['usuarioLogueado'] === "existe") {
        ?>
            <h4 style="color: red;">El usuario ya esta registrado</h4>
        <?php
        } else if ($_SESSION['usuarioLogueado'] === "registrado") {
        ?>
            <h4 style="color: green;">El usuario se ha registrado exitosamente</h4>
        <?php
        }
        ?>
    </form>
</body>

</html>