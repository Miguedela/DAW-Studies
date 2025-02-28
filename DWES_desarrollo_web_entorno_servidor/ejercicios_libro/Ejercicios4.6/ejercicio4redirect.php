<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
    <?php
    $bloque = $_GET['bloque'];
    $piso = $_GET['piso'];
    ?>
    <h4>Usted ha llamado al piso <?= $piso ?> del bloque <?= $bloque ?>.</h4>
</body>

</html>