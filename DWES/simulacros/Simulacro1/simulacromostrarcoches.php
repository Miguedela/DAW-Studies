<?php
session_start();
?>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        table,
        tr,
        td,
        th {
            border: solid 1px black;
        }
    </style>
</head>

<body>
    <?php
    if (isset($_REQUEST['mostrarCoches'])) {
        $tipo = $_REQUEST['tipo'];
    ?>
        <table>
            <tr>
                <th>MATRÍCULA</th>
                <th>FECHA</th>
                <th>MARCA</th>
                <th>TIPO</th>
                <th>EXTRAS</th>
            </tr>
            <?php
            if (isset($_SESSION['coches'])) {
                foreach ($_SESSION['coches'] as $matricula => $infoCoche) {
                    if ($_SESSION['coches'][$matricula]['tipo'] == $tipo) {
            ?>
                        <tr>
                            <?php
                            echo '<td>Coche:' . $matricula . '</td>';
                            foreach ($infoCoche as $key => $info) {
                                if ($key === 'extras') {
                                    echo '<td>';
                                    foreach ($info as $extra) {
                                        echo $extra . '<br>';
                                    }
                                    echo '</td>';
                                } else if ($key === 'fecha') {
                                    $diaSemana = date("w", strtotime($info));
                                    echo '<td>' .  $_SESSION['dias_semana'][$diaSemana] .  ' - ' . $info . '</td>';
                                } else {
                                    echo '<td>' . $info . '</td>';
                                }
                            }
                            ?>
                        </tr>
            <?php
                    }
                }
            }
            ?>
        </table>
        <a href="simulacro.php">Volver</a>
    <?php
    } else {
        header('Location: simulacro.php');
    }
    ?>
</body>

</html>