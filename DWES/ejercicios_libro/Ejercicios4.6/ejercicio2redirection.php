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
    $ganancias = 0;

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

    if (
        $numeroGanador1 == $numero1 ||
        $numeroGanador1 == $numero2 ||
        $numeroGanador1 == $numero3 ||
        $numeroGanador1 == $numero4 ||
        $numeroGanador1 == $numero5 ||
        $numeroGanador1 == $numero6 ||
        $numeroGanador1 == $numero7 ||
        $numeroGanador1 == $numero8 ||
        $numeroGanador1 == $numero9 ||
        $numeroGanador1 == $numero10 ||
        $numeroGanador1 == $numero11 ||
        $numeroGanador1 == $numero12 ||
        $numeroGanador1 == $numero13 ||
        $numeroGanador1 == $numero14 ||
        $numeroGanador1 == $numero15 ||
        $numeroGanador1 == $numero16 ||
        $numeroGanador1 == $numero17 ||
        $numeroGanador1 == $numero18 ||
        $numeroGanador1 == $numero19 ||
        $numeroGanador1 == $numero20 ||
        $numeroGanador1 == $numero21 ||
        $numeroGanador1 == $numero22 ||
        $numeroGanador1 == $numero23 ||
        $numeroGanador1 == $numero24 ||
        $numeroGanador1 == $numero25 ||
        $numeroGanador1 == $numero26 ||
        $numeroGanador1 == $numero27 ||
        $numeroGanador1 == $numero28 ||
        $numeroGanador1 == $numero29 ||
        $numeroGanador1 == $numero30 ||
        $numeroGanador1 == $numero31 ||
        $numeroGanador1 == $numero32 ||
        $numeroGanador1 == $numero33 ||
        $numeroGanador1 == $numero34 ||
        $numeroGanador1 == $numero35 ||
        $numeroGanador1 == $numero36 ||
        $numeroGanador1 == $numero37 ||
        $numeroGanador1 == $numero38 ||
        $numeroGanador1 == $numero39 ||
        $numeroGanador1 == $numero40 ||
        $numeroGanador1 == $numero41 ||
        $numeroGanador1 == $numero42 ||
        $numeroGanador1 == $numero43 ||
        $numeroGanador1 == $numero44 ||
        $numeroGanador1 == $numero45 ||
        $numeroGanador1 == $numero46 ||
        $numeroGanador1 == $numero47 ||
        $numeroGanador1 == $numero48 ||
        $numeroGanador1 == $numero49
    ) {
        $contadorAciertos++;
    }

    if (
        $numeroGanador2 == $numero1 ||
        $numeroGanador2 == $numero2 ||
        $numeroGanador2 == $numero3 ||
        $numeroGanador2 == $numero4 ||
        $numeroGanador2 == $numero5 ||
        $numeroGanador2 == $numero6 ||
        $numeroGanador2 == $numero7 ||
        $numeroGanador2 == $numero8 ||
        $numeroGanador2 == $numero9 ||
        $numeroGanador2 == $numero10 ||
        $numeroGanador2 == $numero11 ||
        $numeroGanador2 == $numero12 ||
        $numeroGanador2 == $numero13 ||
        $numeroGanador2 == $numero14 ||
        $numeroGanador2 == $numero15 ||
        $numeroGanador2 == $numero16 ||
        $numeroGanador2 == $numero17 ||
        $numeroGanador2 == $numero18 ||
        $numeroGanador2 == $numero19 ||
        $numeroGanador2 == $numero20 ||
        $numeroGanador2 == $numero21 ||
        $numeroGanador2 == $numero22 ||
        $numeroGanador2 == $numero23 ||
        $numeroGanador2 == $numero24 ||
        $numeroGanador2 == $numero25 ||
        $numeroGanador2 == $numero26 ||
        $numeroGanador2 == $numero27 ||
        $numeroGanador2 == $numero28 ||
        $numeroGanador2 == $numero29 ||
        $numeroGanador2 == $numero30 ||
        $numeroGanador2 == $numero31 ||
        $numeroGanador2 == $numero32 ||
        $numeroGanador2 == $numero33 ||
        $numeroGanador2 == $numero34 ||
        $numeroGanador2 == $numero35 ||
        $numeroGanador2 == $numero36 ||
        $numeroGanador2 == $numero37 ||
        $numeroGanador2 == $numero38 ||
        $numeroGanador2 == $numero39 ||
        $numeroGanador2 == $numero40 ||
        $numeroGanador2 == $numero41 ||
        $numeroGanador2 == $numero42 ||
        $numeroGanador2 == $numero43 ||
        $numeroGanador2 == $numero44 ||
        $numeroGanador2 == $numero45 ||
        $numeroGanador2 == $numero46 ||
        $numeroGanador2 == $numero47 ||
        $numeroGanador2 == $numero48 ||
        $numeroGanador2 == $numero49
    ) {
        $contadorAciertos++;
    }

    if (
        $numeroGanador3 == $numero1 ||
        $numeroGanador3 == $numero2 ||
        $numeroGanador3 == $numero3 ||
        $numeroGanador3 == $numero4 ||
        $numeroGanador3 == $numero5 ||
        $numeroGanador3 == $numero6 ||
        $numeroGanador3 == $numero7 ||
        $numeroGanador3 == $numero8 ||
        $numeroGanador3 == $numero9 ||
        $numeroGanador3 == $numero10 ||
        $numeroGanador3 == $numero11 ||
        $numeroGanador3 == $numero12 ||
        $numeroGanador3 == $numero13 ||
        $numeroGanador3 == $numero14 ||
        $numeroGanador3 == $numero15 ||
        $numeroGanador3 == $numero16 ||
        $numeroGanador3 == $numero17 ||
        $numeroGanador3 == $numero18 ||
        $numeroGanador3 == $numero19 ||
        $numeroGanador3 == $numero20 ||
        $numeroGanador3 == $numero21 ||
        $numeroGanador3 == $numero22 ||
        $numeroGanador3 == $numero23 ||
        $numeroGanador3 == $numero24 ||
        $numeroGanador3 == $numero25 ||
        $numeroGanador3 == $numero26 ||
        $numeroGanador3 == $numero27 ||
        $numeroGanador3 == $numero28 ||
        $numeroGanador3 == $numero29 ||
        $numeroGanador3 == $numero30 ||
        $numeroGanador3 == $numero31 ||
        $numeroGanador3 == $numero32 ||
        $numeroGanador3 == $numero33 ||
        $numeroGanador3 == $numero34 ||
        $numeroGanador3 == $numero35 ||
        $numeroGanador3 == $numero36 ||
        $numeroGanador3 == $numero37 ||
        $numeroGanador3 == $numero38 ||
        $numeroGanador3 == $numero39 ||
        $numeroGanador3 == $numero40 ||
        $numeroGanador3 == $numero41 ||
        $numeroGanador3 == $numero42 ||
        $numeroGanador3 == $numero43 ||
        $numeroGanador3 == $numero44 ||
        $numeroGanador3 == $numero45 ||
        $numeroGanador3 == $numero46 ||
        $numeroGanador3 == $numero47 ||
        $numeroGanador3 == $numero48 ||
        $numeroGanador3 == $numero49
    ) {
        $contadorAciertos++;
    }

    if (
        $numeroGanador5 == $numero1 ||
        $numeroGanador5 == $numero2 ||
        $numeroGanador5 == $numero3 ||
        $numeroGanador5 == $numero4 ||
        $numeroGanador5 == $numero5 ||
        $numeroGanador5 == $numero6 ||
        $numeroGanador5 == $numero7 ||
        $numeroGanador5 == $numero8 ||
        $numeroGanador5 == $numero9 ||
        $numeroGanador5 == $numero10 ||
        $numeroGanador5 == $numero11 ||
        $numeroGanador5 == $numero12 ||
        $numeroGanador5 == $numero13 ||
        $numeroGanador5 == $numero14 ||
        $numeroGanador5 == $numero15 ||
        $numeroGanador5 == $numero16 ||
        $numeroGanador5 == $numero17 ||
        $numeroGanador5 == $numero18 ||
        $numeroGanador5 == $numero19 ||
        $numeroGanador5 == $numero20 ||
        $numeroGanador5 == $numero21 ||
        $numeroGanador5 == $numero22 ||
        $numeroGanador5 == $numero23 ||
        $numeroGanador5 == $numero24 ||
        $numeroGanador5 == $numero25 ||
        $numeroGanador5 == $numero26 ||
        $numeroGanador5 == $numero27 ||
        $numeroGanador5 == $numero28 ||
        $numeroGanador5 == $numero29 ||
        $numeroGanador5 == $numero30 ||
        $numeroGanador5 == $numero31 ||
        $numeroGanador5 == $numero32 ||
        $numeroGanador5 == $numero33 ||
        $numeroGanador5 == $numero34 ||
        $numeroGanador5 == $numero35 ||
        $numeroGanador5 == $numero36 ||
        $numeroGanador5 == $numero37 ||
        $numeroGanador5 == $numero38 ||
        $numeroGanador5 == $numero39 ||
        $numeroGanador5 == $numero40 ||
        $numeroGanador5 == $numero41 ||
        $numeroGanador5 == $numero42 ||
        $numeroGanador5 == $numero43 ||
        $numeroGanador5 == $numero44 ||
        $numeroGanador5 == $numero45 ||
        $numeroGanador5 == $numero46 ||
        $numeroGanador5 == $numero47 ||
        $numeroGanador5 == $numero48 ||
        $numeroGanador5 == $numero49
    ) {
        $contadorAciertos++;
    }

    if (
        $numeroGanador5 == $numero1 ||
        $numeroGanador5 == $numero2 ||
        $numeroGanador5 == $numero3 ||
        $numeroGanador5 == $numero4 ||
        $numeroGanador5 == $numero5 ||
        $numeroGanador5 == $numero6 ||
        $numeroGanador5 == $numero7 ||
        $numeroGanador5 == $numero8 ||
        $numeroGanador5 == $numero9 ||
        $numeroGanador5 == $numero10 ||
        $numeroGanador5 == $numero11 ||
        $numeroGanador5 == $numero12 ||
        $numeroGanador5 == $numero13 ||
        $numeroGanador5 == $numero14 ||
        $numeroGanador5 == $numero15 ||
        $numeroGanador5 == $numero16 ||
        $numeroGanador5 == $numero17 ||
        $numeroGanador5 == $numero18 ||
        $numeroGanador5 == $numero19 ||
        $numeroGanador5 == $numero20 ||
        $numeroGanador5 == $numero21 ||
        $numeroGanador5 == $numero22 ||
        $numeroGanador5 == $numero23 ||
        $numeroGanador5 == $numero24 ||
        $numeroGanador5 == $numero25 ||
        $numeroGanador5 == $numero26 ||
        $numeroGanador5 == $numero27 ||
        $numeroGanador5 == $numero28 ||
        $numeroGanador5 == $numero29 ||
        $numeroGanador5 == $numero30 ||
        $numeroGanador5 == $numero31 ||
        $numeroGanador5 == $numero32 ||
        $numeroGanador5 == $numero33 ||
        $numeroGanador5 == $numero34 ||
        $numeroGanador5 == $numero35 ||
        $numeroGanador5 == $numero36 ||
        $numeroGanador5 == $numero37 ||
        $numeroGanador5 == $numero38 ||
        $numeroGanador5 == $numero39 ||
        $numeroGanador5 == $numero40 ||
        $numeroGanador5 == $numero41 ||
        $numeroGanador5 == $numero42 ||
        $numeroGanador5 == $numero43 ||
        $numeroGanador5 == $numero44 ||
        $numeroGanador5 == $numero45 ||
        $numeroGanador5 == $numero46 ||
        $numeroGanador5 == $numero47 ||
        $numeroGanador5 == $numero48 ||
        $numeroGanador5 == $numero49
    ) {
        $contadorAciertos++;
    }

    if (
        $numeroGanador6 == $numero1 ||
        $numeroGanador6 == $numero2 ||
        $numeroGanador6 == $numero3 ||
        $numeroGanador6 == $numero4 ||
        $numeroGanador6 == $numero5 ||
        $numeroGanador6 == $numero6 ||
        $numeroGanador6 == $numero7 ||
        $numeroGanador6 == $numero8 ||
        $numeroGanador6 == $numero9 ||
        $numeroGanador6 == $numero10 ||
        $numeroGanador6 == $numero11 ||
        $numeroGanador6 == $numero12 ||
        $numeroGanador6 == $numero13 ||
        $numeroGanador6 == $numero14 ||
        $numeroGanador6 == $numero15 ||
        $numeroGanador6 == $numero16 ||
        $numeroGanador6 == $numero17 ||
        $numeroGanador6 == $numero18 ||
        $numeroGanador6 == $numero19 ||
        $numeroGanador6 == $numero20 ||
        $numeroGanador6 == $numero21 ||
        $numeroGanador6 == $numero22 ||
        $numeroGanador6 == $numero23 ||
        $numeroGanador6 == $numero24 ||
        $numeroGanador6 == $numero25 ||
        $numeroGanador6 == $numero26 ||
        $numeroGanador6 == $numero27 ||
        $numeroGanador6 == $numero28 ||
        $numeroGanador6 == $numero29 ||
        $numeroGanador6 == $numero30 ||
        $numeroGanador6 == $numero31 ||
        $numeroGanador6 == $numero32 ||
        $numeroGanador6 == $numero33 ||
        $numeroGanador6 == $numero34 ||
        $numeroGanador6 == $numero35 ||
        $numeroGanador6 == $numero36 ||
        $numeroGanador6 == $numero37 ||
        $numeroGanador6 == $numero38 ||
        $numeroGanador6 == $numero39 ||
        $numeroGanador6 == $numero40 ||
        $numeroGanador6 == $numero41 ||
        $numeroGanador6 == $numero42 ||
        $numeroGanador6 == $numero43 ||
        $numeroGanador6 == $numero44 ||
        $numeroGanador6 == $numero45 ||
        $numeroGanador6 == $numero46 ||
        $numeroGanador6 == $numero47 ||
        $numeroGanador6 == $numero48 ||
        $numeroGanador6 == $numero49
    ) {
        $contadorAciertos++;
    }

    echo "<table><tr><td>$numeroGanador1</td><td>$numeroGanador2</td><td>$numeroGanador3</td>
    <td>$numeroGanador4</td><td>$numeroGanador5</td><td>$numeroGanador6</td></tr></table><h1>$numeroSerieGanador</h1>";

    if ($contadorAciertos < 4 && $numeroSerie != $numeroSerieGanador) {
        echo "<h3>No te llevas nada.</h3>";
    } else if ($contadorAciertos == 4) {
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
    ?>
</body>

</html>