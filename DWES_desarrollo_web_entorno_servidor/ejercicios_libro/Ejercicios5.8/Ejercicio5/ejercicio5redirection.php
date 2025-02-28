<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
    <?php
    $textoEmpleados = $_REQUEST['plantillaEmpleados'];
    $plantillaEmpleados = unserialize(base64_decode($textoEmpleados));

    if (count($plantillaEmpleados) == 0) {
    ?>
        <h1>No hay empleados agragados a la plantilla</h1>
        <a href="ejercicio5.php">Volver</a>
    <?php
    } else {
        foreach ($plantillaEmpleados as $nombre => $datos) {
            if ($datos['edad'] > 30) {
                ?>
                <h4 style="color: red;"><?= $nombre ?></h4>
                <?php
                foreach ($datos as $key => $dato) {
                    ?>
                    <p style="color: red;"><?= $key ?>: <?= $dato ?></p>
                    <?php
                }
            } else {
                ?>
                <h4><?= $nombre ?></h4>
                <?php
                foreach ($datos as $key => $dato) {
                    ?>
                    <p><?= $key ?>: <?= $dato ?></p>
                    <?php
                }
            }
        }
    }
    ?>
</body>

</html>