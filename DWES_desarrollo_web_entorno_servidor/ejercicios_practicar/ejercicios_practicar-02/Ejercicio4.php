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
    echo "La suma de $hora mas $b es ", $hora + $b, "<br>";
    echo "La reta de $hora menos $b es ", $hora - $b, "<br>";
    echo "La multiplicacion de $hora por $b es ", $hora * $b, "<br>";
    echo "La division de $hora entre $b es ", $hora / $b;
    ?>
</body>
</html>