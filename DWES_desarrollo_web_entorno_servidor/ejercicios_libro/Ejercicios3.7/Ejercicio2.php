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
    <h3>Combinación elegida</h3>
    <?php
    echo $_GET['n1'], " ";
    echo $_GET['n2'], " ";
    echo $_GET['n3'], " ";
    echo $_GET['n4'], " ";
    echo $_GET['n5'], " ";
    echo $_GET['n6'];
    ?>
    <h3>Número de serie elegido</h3>
    <?php
    echo $_GET['ser'];
    ?>
    <h3>Combinación ganadora</h3>
    <?php
    echo rand(1, 49), " ";
    echo rand(1, 49), " ";
    echo rand(1, 49), " ";
    echo rand(1, 49), " ";
    echo rand(1, 49), " ";
    echo rand(1, 49);
    ?>
    <h3>Número de serie ganador</h3>
    <?php
    echo rand(1, 999);
    ?>
</body>

</html>