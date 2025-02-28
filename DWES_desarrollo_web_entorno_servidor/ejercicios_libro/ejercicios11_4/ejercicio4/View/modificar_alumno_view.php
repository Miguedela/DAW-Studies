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

        <form action="../Controller/modificar_alumno_controller.php" method="post">
            <input type="hidden" name="modificarAlumno" value="<?= $data['alumno']->getMatricula(); ?>">

            <label for="matricula">Matricula</label>
            <input type="text" name="matricula" value="<?= $data['alumno']->getMatricula(); ?>" readonly>
            <br>

            <label for="nombre">Nombre</label>
            <input type="text" name="nombre" value="<?= $data['alumno']->getNombre(); ?>" required>
            <br>

            <label for="apellidos">Apellidos</label>
            <input type="text" name="apellidos" value="<?= $data['alumno']->getApellidos(); ?>" required>
            <br>

            <label for="curso">Curso</label>
            <input type="text" name="curso" value="<?= $data['alumno']->getCurso(); ?>" required>
            <br>

            <input type="submit" value="Modificar">
        </form>

        <a href="../Controller/index_controller.php">Volver</a>
    </div>

</body>

</html>