<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <?php
    echo "Se han recogido todos los nñumero en un array dque se enviará a otra página<br> "
    // $cadena=implode("-", $numero);
    ?>
    <a href="recibearray.php?array=<?= $cadena ?>">Enviara array de números a otra página</a>
</body>
</html>