<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <?php
    if (isset($_GET['num'])) {
    ?>
        <meta http-equiv='Refresh' content='1;url=ejercicio6.php'>
    <?php
    }
    ?>
</head>

<style>
    table,
    tr,
    td {
        border: solid 2px black;
    }

    div {
        background-color: #333;
        height: 200px;
        width: 200px;
    }

    img {
        height: 200px;
        width: 200px;
    }
</style>

<body>
    <?php
    $nombreCorrecto = "Miguelito erMakina";

    if (isset($_GET['nombre'])) {
        $nombre = $_GET['nombre'];
    }

    if (isset($_GET['num'])) {
        $num = $_GET['num'];
    }

    if (isset($_GET['nombre']) && $nombreCorrecto == $nombre) {
        echo "<h4>Has acertado.</h4>";
        ?>
        <img style="height: 600px; width: 600px;" src="img/descarga.jpg" alt="migueermakina">
        <?php
    } else {
    ?>
        <?php
        if (isset($_GET['nombre'])) {
        ?>
            <h4>Nombre incorrecto.</h4>
            <a type="button" href="ejercicio6.php">
                <h2>Volver</h2>
            </a>
        <?php
        }
        if (isset($_GET['num'])) {
            $num = $_GET['num'];
        ?>
            <table>
                <?php
                $indice = 0;
                for ($i = 0; $i < 3; $i++) {
                ?>
                    <tr>
                        <?php
                        for ($j = 0; $j < 3; $j++) {
                            $indice++;
                        ?>
                            <td>
                                <div>
                                    <img src="<?php echo ($indice == $num) ? 'img/' . $num . '.jpg' : ''; ?>" alt="">
                                </div>
                            </td>
                        <?php
                        }
                        ?>
                    </tr>
                <?php
                }
                ?>
            </table>
    <?php
        }
    }
    ?>
</body>

</html>