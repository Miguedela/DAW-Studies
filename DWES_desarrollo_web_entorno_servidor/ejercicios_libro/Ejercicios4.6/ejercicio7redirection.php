<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        body {
            display: flex;
            flex-direction: column;
            align-items: center;
        }

        table {
            border-spacing: 0px;
        }

        td,
        tr {
            border: 1px solid black;
        }
    </style>
</head>

<body>
    <?php
    $numeroGanador1 = rand(1, 49);
    $numeroGanador2 = rand(1, 49);
    $numeroGanador3 = rand(1, 49);
    $numeroGanador4 = rand(1, 49);
    $numeroGanador5 = rand(1, 49);
    $numeroGanador6 = rand(1, 49);
    $numeroSerieGanador = 33;

    $numeroSerie = $_REQUEST['numeroSerie'];
    $contadorAciertos = 0;
    $contadorSeleccionados = 0;
    $ganancias = 0;

    // Inicio las variables de los números
    (isset($_REQUEST['numero1'])) ? $numero1 = $_REQUEST['numero1'] : $numero1 = null;
    (isset($_REQUEST['numero2'])) ? $numero2 = $_REQUEST['numero2'] : $numero2 = null;
    (isset($_REQUEST['numero3'])) ? $numero3 = $_REQUEST['numero3'] : $numero3 = null;
    (isset($_REQUEST['numero4'])) ? $numero4 = $_REQUEST['numero4'] : $numero4 = null;
    (isset($_REQUEST['numero5'])) ? $numero5 = $_REQUEST['numero5'] : $numero5 = null;
    (isset($_REQUEST['numero6'])) ? $numero6 = $_REQUEST['numero6'] : $numero6 = null;
    (isset($_REQUEST['numero7'])) ? $numero7 = $_REQUEST['numero7'] : $numero7 = null;
    (isset($_REQUEST['numero8'])) ? $numero8 = $_REQUEST['numero8'] : $numero8 = null;
    (isset($_REQUEST['numero9'])) ? $numero9 = $_REQUEST['numero9'] : $numero9 = null;
    (isset($_REQUEST['numero10'])) ? $numero10 = $_REQUEST['numero10'] : $numero10 = null;
    (isset($_REQUEST['numero11'])) ? $numero11 = $_REQUEST['numero11'] : $numero11 = null;
    (isset($_REQUEST['numero12'])) ? $numero12 = $_REQUEST['numero12'] : $numero12 = null;
    (isset($_REQUEST['numero13'])) ? $numero13 = $_REQUEST['numero13'] : $numero13 = null;
    (isset($_REQUEST['numero14'])) ? $numero14 = $_REQUEST['numero14'] : $numero14 = null;
    (isset($_REQUEST['numero15'])) ? $numero15 = $_REQUEST['numero15'] : $numero15 = null;
    (isset($_REQUEST['numero16'])) ? $numero16 = $_REQUEST['numero16'] : $numero16 = null;
    (isset($_REQUEST['numero17'])) ? $numero17 = $_REQUEST['numero17'] : $numero17 = null;
    (isset($_REQUEST['numero18'])) ? $numero18 = $_REQUEST['numero18'] : $numero18 = null;
    (isset($_REQUEST['numero19'])) ? $numero19 = $_REQUEST['numero19'] : $numero19 = null;
    (isset($_REQUEST['numero20'])) ? $numero20 = $_REQUEST['numero20'] : $numero20 = null;
    (isset($_REQUEST['numero21'])) ? $numero21 = $_REQUEST['numero21'] : $numero21 = null;
    (isset($_REQUEST['numero22'])) ? $numero22 = $_REQUEST['numero22'] : $numero22 = null;
    (isset($_REQUEST['numero23'])) ? $numero23 = $_REQUEST['numero23'] : $numero23 = null;
    (isset($_REQUEST['numero24'])) ? $numero24 = $_REQUEST['numero24'] : $numero24 = null;
    (isset($_REQUEST['numero25'])) ? $numero25 = $_REQUEST['numero25'] : $numero25 = null;
    (isset($_REQUEST['numero26'])) ? $numero26 = $_REQUEST['numero26'] : $numero26 = null;
    (isset($_REQUEST['numero27'])) ? $numero27 = $_REQUEST['numero27'] : $numero27 = null;
    (isset($_REQUEST['numero28'])) ? $numero28 = $_REQUEST['numero28'] : $numero28 = null;
    (isset($_REQUEST['numero29'])) ? $numero29 = $_REQUEST['numero29'] : $numero29 = null;
    (isset($_REQUEST['numero30'])) ? $numero30 = $_REQUEST['numero30'] : $numero30 = null;
    (isset($_REQUEST['numero31'])) ? $numero31 = $_REQUEST['numero31'] : $numero31 = null;
    (isset($_REQUEST['numero32'])) ? $numero32 = $_REQUEST['numero32'] : $numero32 = null;
    (isset($_REQUEST['numero33'])) ? $numero33 = $_REQUEST['numero33'] : $numero33 = null;
    (isset($_REQUEST['numero34'])) ? $numero34 = $_REQUEST['numero34'] : $numero34 = null;
    (isset($_REQUEST['numero35'])) ? $numero35 = $_REQUEST['numero35'] : $numero35 = null;
    (isset($_REQUEST['numero36'])) ? $numero36 = $_REQUEST['numero36'] : $numero36 = null;
    (isset($_REQUEST['numero37'])) ? $numero37 = $_REQUEST['numero37'] : $numero37 = null;
    (isset($_REQUEST['numero38'])) ? $numero38 = $_REQUEST['numero38'] : $numero38 = null;
    (isset($_REQUEST['numero39'])) ? $numero39 = $_REQUEST['numero39'] : $numero39 = null;
    (isset($_REQUEST['numero40'])) ? $numero40 = $_REQUEST['numero40'] : $numero40 = null;
    (isset($_REQUEST['numero41'])) ? $numero41 = $_REQUEST['numero41'] : $numero41 = null;
    (isset($_REQUEST['numero42'])) ? $numero42 = $_REQUEST['numero42'] : $numero42 = null;
    (isset($_REQUEST['numero43'])) ? $numero43 = $_REQUEST['numero43'] : $numero43 = null;
    (isset($_REQUEST['numero44'])) ? $numero44 = $_REQUEST['numero44'] : $numero44 = null;
    (isset($_REQUEST['numero45'])) ? $numero45 = $_REQUEST['numero45'] : $numero45 = null;
    (isset($_REQUEST['numero46'])) ? $numero46 = $_REQUEST['numero46'] : $numero46 = null;
    (isset($_REQUEST['numero47'])) ? $numero47 = $_REQUEST['numero47'] : $numero47 = null;
    (isset($_REQUEST['numero48'])) ? $numero48 = $_REQUEST['numero48'] : $numero48 = null;
    (isset($_REQUEST['numero49'])) ? $numero49 = $_REQUEST['numero49'] : $numero49 = null;

    // Contador de aciertos
    for ($i = 1; $i <= 6; $i++) {
        $numeroGanador = ${'numeroGanador' . $i};
        for ($j = 1; $j <= 49; $j++) {
            $numero = ${'numero' . $j};
            if ($numeroGanador == $numero) {
                $contadorAciertos++;
            }
        }
    }

    // Contador de números seleccionados
    for ($i = 1; $i <= 49; $i++) {
        $numero = ${'numero' . $i};
        if ($numero != null) {
            $contadorSeleccionados++;
        }
    }

    if ($contadorSeleccionados > 6) {
        echo "<h1>Estas haciendo trampas.</h1>";
    } else {
    ?>
        <!-- Tabla colorida -->
        <table>
            <?php
            $indice = 0;
            for ($i = 0; $i < 7; $i++) {
            ?>
                <tr>
                    <?php
                    for ($j = 0; $j < 7; $j++) {
                        $indice++;
                    ?>
                        <?php
                        if (
                            $indice == $numeroGanador1 && $indice != ${'numero' . $indice} || $indice == $numeroGanador2 && $indice != ${'numero' . $indice} || $indice == $numeroGanador3 && $indice != ${'numero' . $indice}
                            || $indice == $numeroGanador4 && $indice != ${'numero' . $indice} || $indice == $numeroGanador5 && $indice != ${'numero' . $indice} || $indice == $numeroGanador6 && $indice != ${'numero' . $indice}
                        ) {
                        ?>
                            <td style="color: red;"><?= $indice ?></td>
                        <?php
                        } else if (
                            $indice == $numeroGanador1 && $indice == ${'numero' . $indice} || $indice == $numeroGanador2 && $indice == ${'numero' . $indice} || $indice == $numeroGanador3 && $indice == ${'numero' . $indice}
                            || $indice == $numeroGanador4 && $indice == ${'numero' . $indice} || $indice == $numeroGanador5 && $indice != ${'numero' . $indice} || $indice == $numeroGanador6 && $indice == ${'numero' . $indice}
                        ) {
                        ?>
                            <td style="color: green;"><?= $indice ?></td>
                        <?php
                        } else if (
                            $indice != $numeroGanador1 && $indice != ${'numero' . $indice} || $indice != $numeroGanador2 && $indice != ${'numero' . $indice} || $indice != $numeroGanador3 && $indice != ${'numero' . $indice}
                            || $indice != $numeroGanador4 && $indice != ${'numero' . $indice} || $indice != $numeroGanador5 && $indice != ${'numero' . $indice} || $indice != $numeroGanador6 && $indice != ${'numero' . $indice}
                        ) {
                        ?>
                            <td style="color: gray;"><?= $indice ?></td>
                        <?php
                        } else {
                        ?>
                            <td style="color: black;"><?= $indice ?></td>
                        <?php
                        }
                        ?>
                    <?php
                    }
                    ?>
                </tr>
            <?php
            }
            ?>
        </table>
        <h3>Numero de serie elegido: <?= $numeroSerie ?></h3>
        <h3>Numero de serie ganador: <?= $numeroSerieGanador ?></h3>
    <?php
        // Mensajes de ganancias
        if ($contadorAciertos < 4 && $numeroSerie != $numeroSerieGanador) {
            echo "<h3>No te llevas nada.</h3>";
        } else if ($contadorAciertos > 4) {
            echo "<h3>Te llevas el dinero vuelto.</h3>";
        } else if ($contadorAciertos == 5) {
            $ganancias += 30;
            echo "<h3>Te llevas 30€.</h3>";
            $ganancias += 100;
        } else if ($contadorAciertos == 6) {
            echo "<h3>Te llevas 100€.</h3>";
        }

        if ($numeroSerie == $numeroSerieGanador) {
            $ganancias += 500;
            echo "<h3>Por haber hacertado el número de serie te llevaras un total de $ganancias</h3>";
        }
    }
    ?>
</body>

</html>