<?php
include_once "Email.php";
include_once "funciones.php";
include_once "libreria.php";
if (session_status() == PHP_SESSION_NONE) session_start();

if (!isset($_SESSION['usuarioLogeado']) || $_SESSION['usuarioLogeado'] === null || $_SESSION['usuarioLogeado'] === "existe" || $_SESSION['usuarioLogeado'] === "noexiste") {
    header("Location: login.php");
}

if (!isset($_SESSION['emails'])) {
    $_SESSION['emails'] = devolverEmails();
}

Email::actualizarImportantes();

?>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        table,
        tr,
        td,
        th {
            border: solid 1px black;
        }

        a {
            text-decoration: none;
            color: black;
        }
    </style>
</head>

<body>
    <h1>Bienvenid@ <?= $_SESSION['usuarioLogeado'] ?></h1>
    <h3>Cantidad de correos importantes: <?= Email::getImportantes() ?></h3>

    <form action="aniadirEmail.php" method="post">
        Receptor:
        <select name="receptorEmail">
            <?php
            foreach ($_SESSION['usuariosRegistrados'] as $key => $value) {
            ?>
                <option value="<?= $value ?>"><?= strtoupper($value) ?></option>
            <?php
            }
            ?>
        </select>
        Asunto:
        <input type="text" name="asuntoEmail">
        <input type="hidden" name="registrarCorreoS">
        <input type="submit" value="REGISTRAR CORREO">
    </form>

    <table>
        <tr>
            <th colspan="6">LISTADO DE EMAILS</th>
        </tr>
        <tr>
            <th>EMISOR</th>
            <th>RECEPTOR</th>
            <th>FECHA</th>
            <th>ASUNTO</th>
            <th></th>
            <th></th>
        </tr>
        <?php
        foreach ($_SESSION['emails'] as $key => $value) {
        ?>
            <tr>
                <td><?= $value->getEmisor() ?></td>
                <td><?= $value->getReceptor() ?></td>
                <td><?= $value->getFecha() ?></td>
                <?php
                if (!$value->comprobarImportante()) {
                ?>
                    <td><?= $value->getAsunto() ?></td>
                <?php
                } else {
                ?>
                    <td style="color:blueviolet;"><?= $value->getAsunto() ?></td>
                <?php
                }
                ?>

                <?php
                if ($value->getEmisor() === $_SESSION['usuarioLogeado']) {
                ?>
                    <td>
                        <button><a href="metodosemail.php?importante=<?= $key ?>">DESTACAR</a></button>
                    </td>
                    <td>
                        <button><a href="metodosemail.php?retrasar=<?= $key ?>">RETRASAR</a></button>
                    </td>
                <?php
                }
                ?>
            </tr>
        <?php
        }
        ?>
    </table>

    <form action="cerrarsesion.php">
        <input type="hidden" name="cerrarSesion">
        <input type="submit" value="CERRAR SESSION">
    </form>
</body>

</html>