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

        <form action="../Controller/aniadir_asignatura_controller.php" method="post">
            Nombre de la asignatura: <input type="text" name="nombre"><br>
            <input type="hidden" name="aniadirAsignatura">
            <input type="submit" value="Añadir asignatura">
        </form>

        <a href="../Controller/index_controller.php">Volver</a>
    </div>
    
</body>

</html>