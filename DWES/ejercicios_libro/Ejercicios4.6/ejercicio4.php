<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<!--
Diseñar una página web que muestre una tabla con 3 columnas, la primera corresponde al número de
bloque, la segunda al piso y en la tercera hay un botón llamar. En total hay 10 bloques y cada bloque
tiene 7 pisos. Cuando se pulse llamar en un piso de un bloque, mostrará en otra página el mensaje del
tipo “Usted ha llamado al piso 3 del bloque 6”. Utiliza estructuras repetitivas para generar la tabla. 
-->

<style>
    table,
    tr,
    td {
        border: solid 2px black;
    }
</style>

<body>
    <table>
        <?php
        for ($i = 1; $i <= 10; $i++) {
            for ($j = 1; $j <= 7; $j++) {
        ?>
                <tr>
                    <td>
                        Bloque: <?= $i ?>
                    </td>
                    <td>
                        Piso: <?= $j ?>
                    </td>
                    <td>
                        <a href="ejercicio4redirect.php?bloque=<?= $i ?>&piso=<?= $j ?>"><button>Llamar</button></a>
                    </td>
                </tr>
        <?php
            }
        }
        ?>
    </table>
</body>

</html>