<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
    <?php
    include 'funciones.php';
    echo esCapicua(121), "<br>";
    echo esCapicua(123), "<br>";
    echo esPrimo(5), "<br>";
    echo siguientePrimo(13), "<br>";
    echo potencia(5, 3), "<br>";
    echo digitos(3333), "<br>";
    echo voltea(12345), "<br>";
    echo digitoN(12345, 2), "<br>";
    echo posicionDeDigito(12435, 3), "<br>";
    echo quitaPorDetras(12345, 2), "<br>";
    echo quitaPorDelante(12345, 2), "<br>";
    echo pegaPorDetras(12345, 2), "<br>";
    echo pegaPorDelante(12345, 2), "<br>";
    echo trozoDeNumero(12345, 2, 4), "<br>";
    echo juntaNumeros(50, 11);
    ?>
</body>

</html>