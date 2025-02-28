<!--
Realizar una aplicación web en php siguiendo el MVC. La aplicación muestra en su página principal un listado 
de alumnos (matricula, nombre, apellidos, curso). Debe existir un botón “Añadir Alumno” para dirigirnos a un 
formulario  de  alta  de  un  nuevo  alumno.  También debe haber un botón “Asignaturas” que dirija hacia otra 
página con el listado de asignaturas (código autonumérico y nombre) y que ofrezca la posibilidad de añadir y 
eliminar asignaturas. 
En  la  página  principal  junto  a  cada  alumno  debe  aparecer  un  botón  detalles,  que  abrirá  una  página  con  las 
asignaturas en las que está matriculado. Junto a cada una de ellas debe aparecer un botón para desmatricular al 
alumno de esa asignatura. También habrá un formulario con un desplegable que incluya todas las asignaturas 
disponibles para poder matricular al alumno en una nueva asignatura. 
Crear  una  BD  “escuela”  que  permita  almacenar  la  información  de  la  aplicación  con  las  tablas  alumno 
(matricula,  nombre,  apellidos,  curso),  asignatura  (código  autonumérico  y  nombre)  y  alumno-asignatura 
(matricula y código-asignatura).
-->
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
                <th></th>
                <th></th>
                <th>Matricula</th>
                <th>Nombre</th>
                <th>Apellidos</th>
                <th>Curso</th>
                <th></th>
            </tr>

            <?php
            // For each que recorre los productos del catalogo
            foreach ($data['alumnos'] as $key => $alumno) {
            ?>
                <tr>
                    <td>
                        <form action="../Controller/eliminar_alumno_controller.php" method="post">
                            <input type="hidden" name="eliminarAlumno" value="<?= $key ?>">
                            <input type="submit" value="Eliminar">
                        </form>
                    </td>

                    <td>
                        <form action="../Controller/formulario_modificar_alumno.php" method="post">
                            <input type="hidden" name="modificarAlumno" value="<?= $key ?>">
                            <input type="submit" value="Modificar">
                        </form>
                    </td>

                    <td><?= $alumno->getMatricula(); ?></td>
                    <td><?= $alumno->getNombre(); ?></td>
                    <td><?= $alumno->getApellidos(); ?></td>
                    <td><?= $alumno->getCurso(); ?></td>

                    <td>
                        <form action="../Controller/asignaturas_alumno_controller.php" method="post">
                            <input type="hidden" name="verAsignaturasAlumno" value="<?= $alumno->getMatricula(); ?>">
                            <input type="submit" value="Ver asignatura">
                        </form>
                    </td>
                </tr>
            <?php
            }
            ?>

            <tr>

                <td colspan="4">
                    <form action="../Controller/formulario_aniadir_alumno_controller.php" method="post">
                        <input type="hidden" name="nuevoAlumno">
                        <input type="submit" value="Nuevo Alumno">
                    </form>
                </td>

                <td colspan="3">
                    <form action="../Controller/formulario_asignaturas.php" method="post">
                        <input type="hidden" name="verAsignaturas">
                        <input type="submit" value="Asignaturas">
                    </form>
                </td>

            </tr>
        </table>

    </div>

</body>

</html>