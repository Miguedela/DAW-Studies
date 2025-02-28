<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<style>
    body {
        background-color: gray;
        color: white;
    }
</style>

<body>
    <?php
    $hora = $_GET['a'];
    $b = $_GET['b'];
    $c = $_GET['c'];
    $media = ($hora + $b + $c) / 3;
    echo "La media de el producto en las tres tiendas es de: ", $media;
    echo "La diferencia de precio con la tienda1 es de: ", $media - $hora;
    echo "La diferencia de precio con la tienda2 es de: ", $media - $b;
    echo "La diferencia de precio con la tienda3 es de: ", $media - $c;
    ?>
</body>

</html>