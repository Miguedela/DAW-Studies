<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<style>
    table,
    tr,
    td {
        border: solid 2px black;
        text-align: center;
    }
</style>

<body>
    <?php
    $numero = $_GET['numero'];

    ?>
    <table>
        <tr>
            <td>Número</td>
            <td>Producto</td>
        </tr>
        <?php
        for ($i = 1; $i <= 10; $i++) {
        ?>
            <tr>
                <td><?= $numero ?> * <?= $i ?></td>
                <td>
                    <?php
                    echo $numero * $i;
                    ?>
                </td>
            </tr>
        <?php
        }
        ?>
    </table>
</body>

</html>