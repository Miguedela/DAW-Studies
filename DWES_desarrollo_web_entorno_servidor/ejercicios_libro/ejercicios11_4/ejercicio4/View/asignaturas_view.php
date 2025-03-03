<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="../View/css/estilo_pagina.css">
</head>

<body>

    <div class="container">
        <!-- Table para imprimir los productos de la forma completa -->
        <table>

            <tr>
                <th>Codigo asignatura</th>
                <th>Nombre asignatura</th>
            </tr>

            <?php
            // For each que recorre los productos del catalogo
            foreach ($data['asignaturas'] as $key => $asignatura) {
            ?>
                <tr>
                    <td><?= $asignatura->getCodigo(); ?></td>
                    <td><a href="../Controller/alumnos_asignaturas_controller.php?verAlumnosAsignatura=<?= $asignatura->getCodigo(); ?>"><?= $asignatura->getNombre(); ?></a></td>
                </tr>
            <?php
            }
            ?>

            <tr>

                <td colspan="2">
                    <form action="../Controller/formulario_aniadir_asignatura_controller.php" method="post">
                        <input type="hidden" name="aniadirAsignatura">
                        <input type="submit" value="Nueva Asignatura">
                    </form>
                </td>

            </tr>
        </table>

        <a href="../Controller/index_controller.php">Volver</a>
    </div>

</body>

</html>