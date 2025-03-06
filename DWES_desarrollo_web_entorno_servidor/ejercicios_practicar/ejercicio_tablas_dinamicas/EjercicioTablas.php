<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<style>
    div {
        margin: auto;
        width: 500px;
    }

    table,
    tr,
    td {
        border: solid 1px black;
    }
</style>

<body>
    <?php
    $altura = $_REQUEST['altura'];
    $anchura = $_REQUEST['anchura'];
    ?>
    <div>
        <table>
            <?php
            for ($i = 0; $i < $altura; $i++) {
            ?>
                <tr>
                    <?php
                    for ($j = 0; $j < $altura; $j++) {
                    ?>
                        <td>
                            <?php
                            echo rand(0, 100);
                            ?>
                        </td>
                    <?php
                    }
                    ?>
                </tr>
            <?php
            }
            ?>
        </table>
    </div>
</body>

</html>