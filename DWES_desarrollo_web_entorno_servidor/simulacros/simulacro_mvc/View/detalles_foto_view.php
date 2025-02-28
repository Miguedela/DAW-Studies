<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        img {
            max-width: 500px;
        }
    </style>
</head>

<body>

    <h1>Detalle de la imágen</h1>

    <img src="../img/<?= $data['foto']->getImagen() ?>" alt="">

    <h2>Autor: <?= Usuario::getNombreUsuario($data['foto']->getId_usuario()) ?></h2>
    <hr>

    <h2>Ususarios que han dado like:</h2>

    <?php
    foreach ($data['likesFoto'] as $like) {
        echo Usuario::getNombreUsuario($like->getId_usuario()) . "<br>";
    }
    ?>
    <hr>

    <form style="display: inline;" action="../Controller/index_controller.php" method="post">
        <input type="submit" value="Página principal">
    </form>

</body>

</html>