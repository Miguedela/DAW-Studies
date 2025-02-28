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

        <form action="../Controller/aniadir_alumno_controller.php" method="post">
            Codigo de matricula: <input type="text" name="codigoMatricula"><br>
            Nombre: <input type="text" name="nombre"><br>
            Apellidos: <input type="text" name="apellidos"><br>
            Curso: <input type="text" name="curso"><br>
            <input type="hidden" name="aniadirAlumno">
            <input type="submit" value="Añadir">
        </form>

        <a href="../Controller/index_controller.php">Volver</a>
    </div>
    
</body>

</html>