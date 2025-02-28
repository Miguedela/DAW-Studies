<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        table,
        tr,
        td {
            border: solid 1px black;
        }

        td {
            text-align: center;
        }
    </style>
</head>

<body>
    <?php
    $personas = unserialize(base64_decode($_REQUEST['personas']));
    $textoPersonas = base64_encode(serialize($personas));
    ?>
    <h2>Generador de personas (elige una para ver con que personas es compatible)</h2>
    <form action="" method="post">
        <table>
            <tr>
                <td>Nombre</td>
                <td>Sexo</td>
                <td>Orientacion</td>
                <td>Seleccionar</td>
            </tr>
            <?php
            foreach ($personas as $key => $persona) {
            ?>
                <tr>
                    <td><?= $persona['nombre'] ?></td>
                    <td><?= $persona['sexo'] ?></td>
                    <td><?= $persona['orientacion'] ?></td>
                    <td><input type="radio" name="persona" value="<?= $key ?>"></td>
                </tr>
            <?php
            }
            ?>
        </table>

        <input type="hidden" name="personas" value="<?= $textoPersonas ?>">
        <input type="submit" value="Generar parejas compatible">
    </form>
    <?php

    if (isset($_REQUEST['persona'])) {
        $personaSeleccionada = $personas[$_REQUEST['persona']];
        // Generador de parejas heteros
        if ($personaSeleccionada['orientacion'] == "het") {
    ?>
            <table>
                <tr>Personas compatibles con:</tr>
                <tr>
                    <td><?= $personaSeleccionada['nombre'] ?></td>
                    <td><?= $personaSeleccionada['sexo'] ?></td>
                    <td><?= $personaSeleccionada['orientacion'] ?></td>
                </tr>
                <tr>
                    <td>Nombre</td>
                    <td>Sexo</td>
                    <td>Orientacion</td>
                </tr>
                <?php
                foreach ($personas as $key => $persona) {
                    if (
                        $persona['sexo'] != $personaSeleccionada['sexo'] &&
                        ($persona['orientacion'] == "het" || $persona['orientacion'] == "bis")
                    ) {
                ?>
                        <tr>
                            <td><?= $persona['nombre'] ?></td>
                            <td><?= $persona['sexo'] ?></td>
                            <td><?= $persona['orientacion'] ?></td>
                        </tr>
                <?php
                    } else {
                    }
                }
                ?>
            </table>
        <?php

            // Generador de parejas bisexuales
        } else if ($personaSeleccionada['orientacion'] == "bis") {
        ?>
            <table>
                <tr>Personas compatibles con:</tr>
                <tr>
                    <td><?= $personaSeleccionada['nombre'] ?></td>
                    <td><?= $personaSeleccionada['sexo'] ?></td>
                    <td><?= $personaSeleccionada['orientacion'] ?></td>
                </tr>
                <tr>
                    <td>Nombre</td>
                    <td>Sexo</td>
                    <td>Orientacion</td>
                </tr>
                <?php
                foreach ($personas as $key => $persona) {
                    if (
                        $persona['nombre'] != $personaSeleccionada['nombre'] &&
                        $persona['orientacion'] == "bis"
                    ) {
                ?>
                        <tr>
                            <td><?= $persona['nombre'] ?></td>
                            <td><?= $persona['sexo'] ?></td>
                            <td><?= $persona['orientacion'] ?></td>
                        </tr>
                <?php
                    }
                }
                ?>
            </table>
        <?php
            // Generador de parejas homosexuales
        } else if ($personaSeleccionada['orientacion'] == "hom") {
        ?>
            <table>
                <tr>Personas compatibles con:</tr>
                <tr>
                    <td><?= $personaSeleccionada['nombre'] ?></td>
                    <td><?= $personaSeleccionada['sexo'] ?></td>
                    <td><?= $personaSeleccionada['orientacion'] ?></td>
                </tr>
                <tr>
                    <td>Nombre</td>
                    <td>Sexo</td>
                    <td>Orientacion</td>
                </tr>
                <?php
                foreach ($personas as $key => $persona) {
                    if (
                        $persona['nombre'] != $personaSeleccionada['nombre'] &&
                        $persona['sexo'] == $personaSeleccionada['sexo'] &&
                        $persona['orientacion'] == "hom"
                    ) {
                ?>
                        <tr>
                            <td><?= $persona['nombre'] ?></td>
                            <td><?= $persona['sexo'] ?></td>
                            <td><?= $persona['orientacion'] ?></td>
                        </tr>
                <?php
                    }
                }
                ?>
            </table>
    <?php
        }
    }
    ?>
</body>

</html>