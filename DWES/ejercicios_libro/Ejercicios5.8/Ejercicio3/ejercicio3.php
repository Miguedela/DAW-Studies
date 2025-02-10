<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        table {
            background-image: url(img/cristiano-ronaldo-el-cuerpo-del-delito.jpg);
            background-repeat: no-repeat;
            border-collapse: collapse;
        }

        tr,
        td {
            border: solid 1px black;
        }

        .oculto {
            background-color: #333;
            height: 80px;
            width: 90px;
        }

        .visible {
            background-color: transparent;
        }

        a {
            display: block;
            height: 100%;
            width: 100%;
        }
    </style>
</head>

<body>
    <!--
    Vamos  a  hacer  el  ejercicio  de  adivinar  la  imagen  oculta  del  tema  3  más  interesante.  Para 
    empezar, vamos a hacer el mosaico un poco más grande, de 10x10. Además la imagen no se va 
    a dividir sino que formará parte del fondo de la tabla y para ocultar o mostrar cada parte del 
    mosaico, el fondo de cada celda será transparente u opaco. Cada vez que se pulse un cuadrado, 
    la parte de la imagen correspondiente a ese cuadrado se mostrará de manera definitiva, así que 
    cada vez se irán mostrando más partes de la imagen. Por último, para rematar y hacerlo todavía 
    más interesante, vamos a poner un límite en el número de cuadrados volteados, de modo que, 
    si no se adivina la imagen antes de superar ese límite, se mostrará un mensaje indicando que 
    ha  perdido  junto  a  la  imagen  completa.  Si  se  acierta  introduciendo  el  nombre  correcto  en  la 
    caja de texto antes de superar el límite, también se indicará con un mensaje junto a la imagen 
    completa. Ayuda: La tabla con las partes visibles y no visibles de la imagen, se encuentra en una 
    única página que se recarga con cada pulsación, pero el resultado del juego tanto si ha ganado 
    como si ha perdido, se puede realizar en otra página distinta. Almacenar en un array la situación 
    de cada celda (vista u oculta) y pasar el array con la función serialize para mayor comodidad.
    -->
    <?php
    if (isset($_REQUEST['posiciones'])) {
        $posiciones = unserialize(base64_decode($_REQUEST['posiciones']));
        $contador = $_REQUEST['contador'];

        if (isset($_REQUEST['aux'])) {
            $aux = $_REQUEST['aux'];

            if ($posiciones[$aux] == 0) {
                $posiciones[$aux] = 1;
                $contador -= 1;
            }
        }
    } else {
        for ($i = 0; $i < 100; $i++) {
            $posiciones[$i] = 0;
        }
        $contador = 10;
    }

    $textoPosiciones = base64_encode(serialize($posiciones));

    if ($contador <= 0) {
    ?>
        <h2>No te quedan intentos, has perdido, el personaje era CR7 SIUUUU!!!!</h2>
        <img src="img/cristiano-ronaldo-el-cuerpo-del-delito.jpg" alt="CR7">
    <?php
    } else {
    ?>
        <table>
            <h1>Adivina el personaje</h1>
            <h3>Te quedan <?= $contador ?> intentos.</h3>
            <?php
            $aux = 0;
            for ($i = 0; $i < 10; $i++) {
            ?>
                <tr>
                    <?php
                    for ($j = 0; $j < 10; $j++) {
                    ?>
                        <td class="<?php echo ($posiciones[$aux] == 0) ? 'oculto' : 'trasparente' ?>">
                            <a href='ejercicio3.php?posiciones=<?= $textoPosiciones ?>&aux=<?= $aux ?>&contador=<?= $contador ?>'></a>
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

        <form action="ejercicio3redirection.php" method="post">
            <input type="text" name="nombrePersonaje"><br>
            <input type="hidden" name="posiciones" value="<?= $textoPosiciones ?>">
            <input type="hidden" name="contador" value="<?= $contador ?>">
            <input type="submit" value="Adivinar">
        </form>
    <?php
    }
    ?>
</body>

</html>