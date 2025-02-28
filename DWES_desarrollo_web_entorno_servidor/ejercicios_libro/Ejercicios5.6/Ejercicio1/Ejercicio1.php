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
            border: solid 2px black;
            text-align: center;
        }
    </style>
</head>

<body>
    <!--
    Define tres arrays de 20 números enteros cada una, con nombres “numero”, “cuadrado” y “cubo”. Carga
    el array “numero” con valores aleatorios entre 0 y 100. En el array “cuadrado” se deben almacenar los
    cuadrados de los valores que hay en el array “numero”. En el array “cubo” se deben almacenar los cubos
    de los valores que hay en “numero”. A continuación, muestra el contenido de los tres arrays dispuesto en
    tres columnas.
    -->

    <?php
    for ($i = 0; $i < 20; $i++) {
        $numero[$i] = rand(0, 100);
        $cuadrado[$i] = pow($numero[$i], 2);
        $cubo[$i] = pow($numero[$i], 3);
    }
    ?>

    <table>
        <tr>
            <td>Número:</td>
            <td>Cubo:</td>
            <td>Cuadrado:</td>
        </tr>
        <?php
        for ($i = 0; $i < 20; $i++) {
        ?>
            <tr>
                <td><?= $numero[$i] ?></td>
                <td><?= $cuadrado[$i] ?></td>
                <td><?= $cubo[$i] ?></td>
            </tr>
        <?php
        }
        ?>
    </table>
</body>

</html>