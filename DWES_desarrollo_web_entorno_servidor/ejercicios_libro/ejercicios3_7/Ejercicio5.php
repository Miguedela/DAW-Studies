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
    $volumen = 3.14 * (($b / 2) * ($b / 2)) * $hora;
    echo "El volumen del cilindro es: ", $volumen;
    echo "Con el volumen que dispone, y el caudal que hay tardaremos en llenarlo: ", ($volumen * 1000)/$c, " minutos.";
    ?>
</body>

</html>