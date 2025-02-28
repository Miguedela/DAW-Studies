<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
    <?php
    // Realiza un programa que pida la temperatura media que ha hecho en cada mes de un determinado año y
    // que muestre a continuación un diagrama de barras horizontales con esos datos. Las barras del diagrama se
    // pueden dibujar a base de la concatenación de una imagen.
    if (!isset($_REQUEST['num0'])) {
        $meses = ["Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"];
    ?>
        <form action="" method="post">
            <?php
            for ($i = 0; $i < 12; $i++) {
            ?>
                Introduce la media de grados de <?= $meses[$i] ?>: <input type="number" name="num<?= $i ?>"><br>
            <?php
            } ?>
            <input type="submit" value="Enviar datos">
        </form>
    <?php
    } else {
        $media = [];
        for ($i = 0; $i < 12; $i++) {
            $media[$i] = $_REQUEST['num' . $i];
        }

        foreach ($media as $num) {
            for ($i = 0; $i < $num; $i++) {
                echo "*";
            }
            echo "<br>";
        }
    ?>

    <?php
    }
    ?>
</body>

</html>