<?php
if (session_status() == PHP_SESSION_NONE) session_start();

if (!isset($_SESSION['usuario'])) {
    $_SESSION['usuario'] = null;
} else if ($_SESSION['usuario'] !== null && $_SESSION['usuario'] !== "mal") {
    header("Location: principal.php");
}
?>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        .container {
            text-align: center;
            margin: 0 auto;
        }

        .inicioSesion {
            padding-bottom: 30px;
            border-top: solid 1px black;
            border-bottom: solid 1px black;
        }

        .registro {
            padding-bottom: 30px;
            border-bottom: solid 1px black;
        }
    </style>
</head>

<body>
    <div class="container">

        <h1>MASQUENOTAS</h1>
        <h2>Tus notas siempre accesibles en cualquier lugar</h2>

        <div class="inicioSesion">

            <h3>Inicie sesion para acceder a su panel de notas</h3>

            <form action="iniciarsesion.php" method="post">
                <?php
                if (isset($_COOKIE['usuario'])) {
                    $datosUsuario = explode("-", $_COOKIE['usuario']);
                ?>
                    USUARIO: <input type="text" name="nombreUsuario" value="<?= $datosUsuario[0] ?>">
                    <br><br>
                    CONTRASEÑA: <input type="password" name="contraseniaUsuario" value="<?= $datosUsuario[1] ?>">
                    <br><br>
                <?php
                } else {
                ?>
                    USUARIO: <input type="text" name="nombreUsuario">
                    <br><br>
                    CONTRASEÑA: <input type="password" name="contraseniaUsuario">
                    <br><br>
                <?php
                }
                ?>
                Recordar contraseña <input type="checkbox" name="recordarContrasenia">
                <br><br>
                <input type="hidden" name="iniciarSesion">
                <input type="submit" value="ACEPTAR">
            </form>

            <?php
            if ($_SESSION['usuario'] === "mal") {
            ?>
                <h4 style="color: red;">Usuario o contraseña incorrectos.</h4>
            <?php
            }
            ?>

        </div>

        <div class="registro">

            <h3>Todavía no tienes cuenta? Registrate, es gratis</h3>

            <form action="registrarcuentavista.php" method="post">
                <input type="hidden" name="registrarCuenta">
                <input type="submit" value="REGISTRAR">
            </form>

        </div>
    </div>
</body>

</html>