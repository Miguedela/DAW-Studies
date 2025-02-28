<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
    <?php
    $hora = $_GET['a'];
    $b = $_GET['b'];
    $c = $_GET['c'];
    $d = $_GET['d'];
    $e = $_GET['e'];
    ?>

    <style>
        body {
            background-color: <?= $hora ?>;
            color: <?= $e ?>;
            font-weight: <?= $b ?>;
            text-align: <?= $c ?>
        }
    </style>

    <h1>Tú página</h1>
    <h2>BANNER</h2>
    <img src="img/<?= $d ?>" alt="Imagen de banner">
</body>

</html>