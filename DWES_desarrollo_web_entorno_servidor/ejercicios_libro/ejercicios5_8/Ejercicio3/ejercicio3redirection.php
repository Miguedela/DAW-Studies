<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
    <?php
    $nombreCorrecto = "CR7";

    $posiciones = unserialize(base64_decode($_REQUEST['posiciones']));
    $textoPosiciones = base64_encode(serialize($posiciones));
    $nombrePersonaje = $_REQUEST['nombrePersonaje'];
    $contador = $_REQUEST['contador'];

    if ($nombreCorrecto == $nombrePersonaje) {
    ?>
        <h2>Has acertado el personaje de la foto en <?= (10 - $contador) ?> intentos. SIUUU!!!</h2>
        <img src="img/cristiano-ronaldo-el-cuerpo-del-delito.jpg" alt="CR7">
    <?php
    } else {
    ?>
        <h2>Ese no es el personaje, sigue intentandolo</h2>
        <a href='ejercicio3.php?posiciones=<?= $textoPosiciones ?>&contador=<?= $contador ?>'>Volver</a>
    <?php
    }
    ?>
</body>

</html>