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
            <th>Descripción</th>
            <th>Profesor</th>
            <th>Fecha</th>
        </tr>

        <?php
        foreach ($data['incidenciasReparadasAdmin'] as $incidencia) {
        ?>
            <tr>
                <td><?= $incidencia->getDescripcion() ?></td>
                <td><?= $incidencia->getProfesor() ?></td>
                <td><?= $incidencia->getFecha() ?></td>
            </tr>
        <?php
        }
        ?>

        <tr>
            <th colspan="6">
                <a href="cerrar_sesion_controller.php?cerrarSesion">Cerrar sesión usuario</a>
            </th>
        </tr>

    </table>

</body>

</html>