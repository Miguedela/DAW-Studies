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
    }

    div {
        background-color: #333;
        height: 200px;
        width: 200px;
    }
</style>

<body>
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
                        <a href="ejercicio6redirect.php?num=<?= $indice ?>">
                            <div></div>
                        </a>
                    </td>
                <?php
                }
                ?>
            </tr>
        <?php
        }
        ?>
    </table>
    <h2>Introduce el nombre del artista: </h2>
    <form action="ejercicio6redirect.php" action="post">
        <input type="text" name="nombre">
        <input type="submit" value="Continuar">
    </form>
</body>

</html>