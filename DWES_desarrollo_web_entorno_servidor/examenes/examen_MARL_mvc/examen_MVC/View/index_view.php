<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        table {
            margin: 0 auto;
            padding: 4rem 4rem;
            box-shadow: 2px 2px 10px #222;
            border-radius: 10px;
            border: 1px solid black;
        }
        tr,
        th,
        td {
            padding: 0.7rem 0.7rem;
            border: 1px solid black;
            border-radius: 5px;
        }
    </style>
</head>

<body>

    <table>

        <tr>
            <?php
            if (isset($_SESSION['admin'])) {
            ?>
                <th colspan="6">Perfil de administrador: <?= $_SESSION['usuario'] ?></th>
            <?php
            } else {
            ?>
                <th colspan="3">Perfil de usuario: <?= $_SESSION['usuario'] ?></th>
            <?php
            }
            ?>
        </tr>

        <tr>
            <th>Descripción</th>
            <th>Profesor</th>
            <th>Fecha</th>
            <?php
            if (isset($_SESSION['admin'])) {
            ?>
                <th>Estado</th>
                <th colspan='2'>Accion</th>
            <?php
            }
            ?>
        </tr>

        <?php
        foreach ($data['incidencias'] as $incidencia) {
            if (
                $incidencia->getEstado() == 'PENDIENTE' ||
                ($incidencia->getEstado() == 'REPARANDO' &&
                    $incidencia->getAdmin() == Usuario::getIdUsuario($_SESSION['usuario']))
            ) {
        ?>
                <tr>
                    <td><?= $incidencia->getDescripcion() ?></td>
                    <td><?= $incidencia->getProfesor() ?></td>
                    <td><?= $incidencia->getFecha() ?></td>

                    <?php
                    if (isset($_SESSION['admin'])) {
                    ?>

                        <td><?= $incidencia->getEstado() ?></td>
                    <?php
                    }
                    ?>

                    <?php
                    if (isset($_SESSION['admin'])) {
                    ?>
                        <td>
                            <form action="finalizar_incidencia_controller.php" method="post">
                                <input type="hidden" name="finalizarIncidencia" value="<?= $incidencia->getId() ?>">
                                <input <?php if ($incidencia->getEstado() != 'REPARANDO') { ?> disabled <?php } ?> type="submit" value="FINALIZADA">
                            </form>
                        </td>

                        <?php
                        if ($incidencia->getEstado() == 'PENDIENTE') {
                        ?>
                            <td>
                                <form action="reparar_incidencia_controller.php" method="post">
                                    <input type="hidden" name="repararIncidencia" value="<?= $incidencia->getId() ?>">
                                    <input type="submit" value="REPARAR">
                                </form>
                            </td>
                        <?php
                        } else if ($incidencia->getEstado() == 'REPARANDO') {
                        ?>
                            <td>
                                <form action="reparar_incidencia_controller.php" method="post">
                                    <input type="hidden" name="soltarIncidencia" value="<?= $incidencia->getId() ?>">
                                    <input type="submit" value="SOLTAR">
                                </form>
                            </td>
                        <?php
                        }
                        ?>

                    <?php
                    }
                    ?>

                </tr>
        <?php
            }
        }
        ?>

        <tr>


            <?php
            if (isset($_SESSION['admin'])) {
            ?>
                <th colspan="6">
                    <form action="historial_incidencias_controller.php" method="post">
                        <input type="hidden" name="verHistorial">
                        <input type="submit" value="Historial de incidencias">
                    </form>
                </th>
            <?php
            } else {
            ?>
                <th colspan="3">
                    <form action="registrar_incidencia_controller.php" method="post">
                        <input type="hidden" name="nuevaIncidencia">
                        <input type="submit" value="Registrar nueva incidencia">
                    </form>
                </th>
            <?php
            }
            ?>

        </tr>

        <tr>
            <th colspan="6">
                <a href="cerrar_sesion_controller.php?cerrarSesion">Cerrar sesión usuario</a>
            </th>
        </tr>

    </table>

</body>

</html>