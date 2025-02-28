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
                <th>Matricula</th>
                <th>Nombre</th>
                <th>Apellidos</th>
                <th>Curso</th>
            </tr>

            <?php
            // For each que recorre los productos del catalogo
            foreach ($data['asignaturaAlumnos'] as $key => $alumno) {
            ?>
                <tr>
                    <td><?= $alumno->getMatricula(); ?></td>
                    <td><?= $alumno->getNombre(); ?></td>
                    <td><?= $alumno->getApellidos(); ?></td>
                    <td><?= $alumno->getCurso(); ?></td>
                </tr>
            <?php
            }
            ?>

        </table>

        <a href="../Controller/index_controller.php">Volver</a>
    </div>
</body>

</html>