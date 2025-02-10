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
                <th>Código</th>
                <th>Nombre</th>
            </tr>

            <?php
            // For each que recorre los productos del catalogo
            foreach ($data['asignaturasAlumno'] as $key => $asignaturaAlumno) {
            ?>
                <tr>

                    <td><?= $asignaturaAlumno->getNombre(); ?></td>
                    <td><?= $asignaturaAlumno->getCodigo(); ?></td>

                </tr>
            <?php
            }
            ?>

            <tr>

                <td colspan="2">
                    <form action="../Controller/formulario_matricular_alumno_asignaturas_controller.php" method="post">
                        <input type="hidden" name="verAsignaturasLibres" value="<?= $code ?>">
                        <input type="submit" value="Matricular de asignaturas">
                    </form>
                </td>

            </tr>

        </table>

        <a href="../Controller/index_controller.php">Volver</a>
    </div>

</body>

</html>