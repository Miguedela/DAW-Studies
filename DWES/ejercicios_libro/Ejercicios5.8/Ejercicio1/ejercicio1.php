<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
    <!--
    Diseñar una página que esté compuesta por una tabla de 10 filas por 10 columnas, y en cada 
    celda habrá una imagen de un ojo cerrado. Cada vez que el usuario pulse un ojo, ser recargará 
    la página con todos los ojos cerrados salvo los que se han ido pulsando que corresponderá a un 
    ojo abierto. Conforme se vayan pulsando más ojos se irá completando la tabla de ojos abiertos. 
    Si  se  pulsa  en  un  ojo  abierto  se  volverá  a  cerrar.  Usar  la  función  explode()  para
    pasar  arrays como cadenas. 
    -->
    <table>
        <?php
        if (isset($_REQUEST['posiciones'])) {
            $textoArray = $_REQUEST['posiciones'];
            $aux = $_REQUEST['aux'];
            $posiciones = explode(",", $textoArray);

            $posiciones[$aux] = ($posiciones[$aux] == 0) ? 1 : 0;
        } else {
            for ($i = 0; $i < 100; $i++) {
                $posiciones[$i] = 0;
            }
        }
        $textoArrayPosiciones = implode(",", $posiciones);
        $aux = 0;
        for ($i = 1; $i <= 10; $i++) {
        ?>
            <tr>
                <?php
                for ($j = 1; $j <= 10; $j++) {
                ?>
                    <td>
                        <a href="ejercicio1.php?posiciones=<?= $textoArrayPosiciones ?>&aux=<?= $aux ?>"><img src="<?php echo ($posiciones[$aux] == 1) ? 'img/ojoabierto.jpg' : 'img/ojocerrado.jpg' ?>" alt="ojos"></a>
                    </td>
                <?php
                    $aux++;
                }
                ?>
            </tr>
        <?php
        }
        ?>
    </table>
</body>

</html>