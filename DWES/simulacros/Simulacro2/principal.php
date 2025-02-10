<?php
include_once "Nota.php";
if (session_status() == PHP_SESSION_NONE) session_start();

if (!isset($_SESSION['usuario']) || $_SESSION['usuario'] === null || $_SESSION['usuario'] === "mal") {
    header("Location: login.php");
}
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
    </style>
</head>

<body>
    <h4>Ultima nota creada: <span><?= Nota::getUltimaNota() ?></span></h4>
    <?php
    $fechaHora = date("d/m/Y - H:i:s", Nota::getFechaUltimaNota());
    ?>
    <h4>Fecha: <?= $fechaHora ?></h4>

    <table>
        <tr>
            <td>
                <table>
                    <th>Titulo</th>
                    <th>fecha</th>
                    <th>hora</th>
                    <?php
                    if (isset($_SESSION['notas'][$_SESSION['usuario']]) && count($_SESSION['notas'][$_SESSION['usuario']]) > 0) {
                        foreach ($_SESSION['notas'][$_SESSION['usuario']] as $key => $value) {
                            $value = unserialize(base64_decode($value));
                            $fecha = date("d/m/Y", $value->getFechaHora());
                            $hora = date("H:i:s", $value->getFechaHora());
                    ?>
                            <tr>
                                <td>
                                    <a href="principal.php?notaMostrar=<?= base64_encode(serialize($value)); ?>">
                                        <?= $value->getTítulo() ?>
                                    </a>
                                </td>
                                <td><?= $fecha ?></td>
                                <td><?= $hora ?></td>
                            </tr>
                    <?php
                        }
                    }
                    ?>
                </table>
            </td>
            <td style="text-align: center;">
                <?php
                if (isset($_REQUEST['notaMostrar'])) {
                    $notaMostrar = unserialize(base64_decode($_REQUEST['notaMostrar']));
                    $fechaHora = date("d/m/Y - H:i:s", Nota::getFechaUltimaNota());
                ?>
                    <h2><?= $notaMostrar->getTítulo() ?></h2>
                    <p><?= nl2br($notaMostrar->getTexto()) ?></p>
                    <h4><?= $fechaHora ?></h4>
                <?php
                }
                ?>
            </td>
        </tr>
    </table>

    <h2>Añadir nueva nota</h2>
    <form action="aniadirnota.php" method="post">
        TITULO: <input type="text" name="tituloNota">
        <br><br>
        TEXTO: <textarea name="textoNota"></textarea>
        <br><br>
        <input type="hidden" name="aniadirNota">
        <input type="submit" value="AÑADIR">
        <br><br>
    </form>

    <form action="cerrarsesion.php" method="post">
        <input type="hidden" name="cerrarSesion">
        <input type="submit" value="CERRAR SESIÓN">
    </form>
</body>

</html>