<?php
include_once "funciones.php";
if (session_status() == PHP_SESSION_NONE) session_start();

if (!isset($_SESSION['usuarioLogeado'])) {
    $_SESSION['usuarioLogeado'] = null;
}

if (
    $_SESSION['usuarioLogeado'] !== null && $_SESSION['usuarioLogeado'] !== "existe" &&
    $_SESSION['usuarioLogeado'] !== "noexiste" && $_SESSION['usuarioLogeado'] !== "noexiste"
) {
    header("Location: index.php");
}

if (!isset($_SESSION['usuariosRegistrados']) && isset($_COOKIE['usuariosRegistrados'])) {
    $_SESSION['usuariosRegistrados'] = devolverUsuarios();
} else if (!isset($_SESSION['usuariosRegistrados']) && !isset($_COOKIE['usuariosRegistrados'])) {
    $_SESSION['usuariosRegistrados'] = [];
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
            margin: auto;
            text-align: center;
        }

        form {
            padding-bottom: 30px;
            border-bottom: solid 1px black;
        }
    </style>
</head>

<body>
    <h1>Inicio Sesion</h1>
    <!-- Formulario para mostrar los usuarios registrados -->
    <?php
    if (count($_SESSION['usuariosRegistrados']) > 0) {
    ?>
        <form action="iniciarsesion.php">
            <select name="usuarios">
                <?php
                foreach ($_SESSION['usuariosRegistrados'] as $key => $value) {
                ?>
                    <option value="<?= $value ?>"><?= strtoupper($value) ?></option>
                <?php
                }
                ?>
            </select>
            <input type="hidden" name="iniciarSesion">
            <input type="submit" value="ELEGIR USUARIO">

            <?php
            if ($_SESSION['usuarioLogeado'] === "noexiste") {
            ?>
                <p style="color: red;">El usuario no existe</p>
            <?php
            }
            ?>
        </form>
    <?php
    } else {
    ?>
        <p style="color: red;">No hay usuarios registrados actualmente</p>
    <?php
    }
    ?>

    <h1>Registre a un usuario</h1>
    <form action="registrarusuario.php" method="post">
        Usuario: <input type="text" name="nombreUsuario">
        <input type="hidden" name="registrarUsuario">
        <input type="submit" value="REGISTRO NUEVO USUARIO">

        <?php
        if ($_SESSION['usuarioLogeado'] === "existe") {
        ?>
            <p style="color: red;">Usuario ya existente</p>
        <?php
        }
        ?>
    </form>
</body>

</html>