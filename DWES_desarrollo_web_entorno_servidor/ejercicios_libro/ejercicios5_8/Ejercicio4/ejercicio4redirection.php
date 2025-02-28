<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
    <?php
    $personas = unserialize(base64_decode($_REQUEST['personas']));

    ?>
    <h2>Parejas aleatorias</h2>
    <form action="" method="post">
        <input type="submit" name="orientacion" value="Heterosexual">
        <input type="submit" name="orientacion" value="Bisexual">
        <input type="submit" name="orientacion" value="Homosexual">
        <input type="hidden" name="personas" value="<?= base64_encode(serialize($personas)) ?>">
    </form>
    <?php

    if (isset($_REQUEST['orientacion'])) {
        $orientacion = $_REQUEST['orientacion'];
        // Generador de parejas heteros
        if ($orientacion == "Heterosexual") {
            do {
                $persona1 = $personas[array_rand($personas, 1)];
            } while ($persona1['orientacion'] != 'het');
            do {
                $persona2 = $personas[array_rand($personas, 1)];
            } while ($persona2['orientacion'] != 'het' || $persona1['sexo'] == $persona2['sexo'] || $persona1['nombre'] == $persona2['nombre']);
    ?>
            <h3><?= $persona1['nombre'] ?> esta saliendo con <?= $persona2['nombre'] ?></h3>
        <?php
            // Generador de parejas bisexuales
        } else if ($orientacion == "Bisexual") {
            do {
                $persona1 = $personas[array_rand($personas, 1)];
            } while ($persona1['orientacion'] != 'bis');
            do {
                $persona2 = $personas[array_rand($personas, 1)];
            } while ($persona1['nombre'] == $persona2['nombre'] && $persona2['orientacion'] != 'bis');
        ?>
            <h3><?= $persona1['nombre'] ?> esta saliendo con <?= $persona2['nombre'] ?></h3>
        <?php
            // Generador de parejas homosexuales
        } else if ($orientacion == "Homosexual") {
            do {
                $persona1 = $personas[array_rand($personas, 1)];
            } while ($persona1['orientacion'] != 'hom');
            do {
                $persona2 = $personas[array_rand($personas, 1)];
            } while (($persona2['orientacion'] != 'hom') || ($persona2['sexo'] != $persona1['sexo']) || ($persona1['nombre'] == $persona2['nombre']));
        ?>
            <h3><?= $persona1['nombre'] ?> esta saliendo con <?= $persona2['nombre'] ?></h3>
    <?php
        }
    }
    ?>
</body>

</html>