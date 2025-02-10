<?php
include_once "Reserva.php";
include_once "funciones.php";
if (session_status() == PHP_SESSION_NONE) session_start();

if (
    !isset($_SESSION['usuarioLogueado']) ||
    $_SESSION['usuarioLogueado'] === null || $_SESSION['usuarioLogueado'] === "mal" ||
    $_SESSION['usuarioLogueado'] === "existe" || $_SESSION['usuarioLogueado'] === "registrado"
) {
    header("Location: login.php");
}

if (!isset($_SESSION['reservas'])) {
    $_SESSION['reservas'] = recogerReservas();
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

        a {
            text-decoration: none;
            color: black;
        }
    </style>
</head>

<body>
    <h1>Bienvenid@ <?= $_SESSION['usuarioLogueado'] ?></h1>
    <h3>Reservas pendientes de confirmar: <?= Reserva::getTotalPendientes() ?></h3>

    <!-- Formulario para realizar reservas -->
    <form action="agregarreserva.php" method="post">
        Sala que quiere reservar: <input type="text" name="salaReserva">
        Fecha y hora de la reserva: <input type="datetime-local" name="fechaHoraReserva">
        <input type="hidden" name="realizarReserva">
        <input type="submit" value="RESERVAR">
    </form>
    <br><br>

    <!-- Select para elegir el filtrado de las reservas -->
    <form action="#" method="post">
        <input type="radio" name="filtrado" value="TODOS"> TODOS
        <input type="radio" name="filtrado" value="PENDIENTE"> PENDIENTES
        <input type="radio" name="filtrado" value="CONFIRMADA"> CONFIRMADAS
        <input type="radio" name="filtrado" value="CANCELADA"> ANULADAS
        <input type="submit" value="FILTRAR">
    </form>
    <br><br>

    <?php
    if (count($_SESSION['reservas']) > 0) {
    ?>
        <table>
            <tr>
                <th colspan="6">LISTADO DE RESERVAS</th>
            </tr>
            <tr>
                <th>SALA</th>
                <th>FECHA</th>
                <th>HORA</th>
                <th colspan="3">ESTADO</th>
            </tr>
            <?php
            foreach ($_SESSION['reservas'] as $key => $value) {
                $value = unserialize(base64_decode($value));
                if (isset($_REQUEST['filtrado']) && $_REQUEST['filtrado'] != "TODOS") {
                    $filtrador = $_REQUEST['filtrado'];
                    if ($value->getEstado() === $filtrador) {
            ?>
                        <tr>
                            <td><?= $value->getSala() ?></td>
                            <td><?= $value->getFecha() ?></td>
                            <td><?= $value->getHora() ?></td>
                            <td><?= $value->getEstado() ?></td>
                            <td>
                                <?php
                                if ($value->getEstado() === "PENDIENTE") {
                                ?>
                                    <button><a href="confirmarreserva.php?confirmarReserva=<?= $key ?>">CONFIRMAR</a></button>
                                <?php
                                }
                                ?>
                            </td>
                            <td>
                                <?php
                                if ($value->getEstado() === "PENDIENTE") {
                                ?>
                                    <button><a href="cancelarreserva.php?cancelarReserva=<?= $key ?>">CANCELAR</a></button>
                                <?php
                                }
                                ?>
                            </td>
                        </tr>
                    <?php
                    }
                } else {
                    ?>
                    <tr>
                        <td><?= $value->getSala() ?></td>
                        <td><?= $value->getFecha() ?></td>
                        <td><?= $value->getHora() ?></td>
                        <td><?= $value->getEstado() ?></td>
                        <td>
                            <?php
                            if ($value->getEstado() == "PENDIENTE") {
                            ?>
                                <button><a href="confirmarreserva.php?confirmarReserva=<?= $key ?>">CONFIRMAR</a></button>
                            <?php
                            }
                            ?>
                        </td>
                        <td>
                            <?php
                            if ($value->getEstado() == "PENDIENTE") {
                            ?>
                                <button><a href="cancelarreserva.php?cancelarReserva=<?= $key ?>">CANCELAR</a></button>
                            <?php
                            }
                            ?>
                        </td>
                    </tr>
            <?php
                }
            }
            ?>
        </table>
    <?php
    } else {
    ?>
        <h3>Aún no hay reservas realizadas</h3>
    <?php
    }
    ?>

    <form action="cerrarSesion.php" method="post">
        <input type="hidden" name="cerrarSesion">
        <br><br><br>
        <input type="submit" value="CERRAR SESION">
    </form>
</body>

</html>