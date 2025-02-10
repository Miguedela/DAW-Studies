<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <?php
    if (isset($_GET['num'])) {
    ?>
        <meta http-equiv='Refresh' content='1;url=ejercicio1.html'>
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
            <a type="button" href="ejercicio1.html">
                <h2>Volver</h2>
            </a>
        <?php
        }
        if (isset($_GET['num'])) {
            $num = $_GET['num'];
        ?>
            <table>
                <tr>
                    <td>
                        <div>
                            <?php
                            if ($num == 1) {
                            ?>
                                <img src="img/1.jpg" alt="">
                            <?php
                            }
                            ?>
                        </div>
                    </td>
                    <td>
                        <div>
                            <?php
                            if ($num == 2) {
                            ?>
                                <img src="img/2.jpg" alt="">
                            <?php
                            }
                            ?>
                        </div>
                    </td>
                    <td>
                        <div>
                            <?php
                            if ($num == 3) {
                            ?>
                                <img src="img/3.jpg" alt="">
                            <?php
                            }
                            ?>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>
                        <div>
                            <?php
                            if ($num == 4) {
                            ?>
                                <img src="img/4.jpg" alt="">
                            <?php
                            }
                            ?>
                        </div>
                    </td>
                    <td>
                        <div>
                            <?php
                            if ($num == 5) {
                            ?>
                                <img src="img/5.jpg" alt="">
                            <?php
                            }
                            ?>
                        </div>
                    </td>
                    <td>
                        <div>
                            <?php
                            if ($num == 6) {
                            ?>
                                <img src="img/6.jpg" alt="">
                            <?php
                            }
                            ?>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>
                        <div>
                            <?php
                            if ($num == 7) {
                            ?>
                                <img src="img/7.jpg" alt="">
                            <?php
                            }
                            ?>
                        </div>
                    </td>
                    <td>
                        <div>
                            <?php
                            if ($num == 8) {
                            ?>
                                <img src="img/8.jpg" alt="">
                            <?php
                            }
                            ?>
                        </div>
                    </td>
                    <td>
                        <div>
                            <?php
                            if ($num == 9) {
                            ?>
                                <img src="img/9.jpg" alt="">
                            <?php
                            }
                            ?>
                        </div>
                    </td>
                </tr>
            </table>
    <?php
        }
    }
    ?>
</body>

</html>