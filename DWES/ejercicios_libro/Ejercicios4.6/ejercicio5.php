<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
    <!--
    Diseñar una página que esté compuesta por una tabla de 10 filas por 10 columnas, y en cada celda
    habrá una imagen de un ojo cerrado. Cada vez que el usuario pulse un ojo, ser recargará la página con
    todos los ojos cerrados salvo el que se ha pulsado que corresponderá a un ojo abierto.
    -->

    <?php
    if (isset($_GET['x'])) {
        $x = $_GET['x'];
    } else {
        $x = 0;
    }
    if (isset($_GET['y'])) {
        $y = $_GET['y'];
    } else {
        $y = 0;
    }
    ?>

    <table>
        <?php
        for ($i = 1; $i <= 10; $i++) {
        ?>
            <tr>
                <?php
                for ($j = 1; $j <= 10; $j++) {
                ?>
                    <td>
                        <a href="ejercicio5.php?x=<?= $i ?>&y=<?= $j ?>"><img src="<?php echo ($x == $i && $y == $j) ? 'img/ojoabierto.jpg' : 'img/ojocerrado.jpg' ?>" alt="ojos"></a>
                    </td>
                <?php
                }
                ?>
            </tr>
        <?php
        }
        ?>
    </table>
</body>

</html>