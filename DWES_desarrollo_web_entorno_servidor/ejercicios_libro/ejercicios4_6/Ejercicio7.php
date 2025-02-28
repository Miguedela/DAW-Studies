<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Tablero de Lotería</title>
    <style>
        body {
            display: flex;
            flex-direction: column;
            align-items: center;
        }

        table {
            border-spacing: 10px;
        }

        td {
            font-weight: bold;
            font-size: 21px;
        }

        body {
            display: flex;
            flex-direction: column;
            align-items: center;
        }
    </style>
</head>

<body>
    <h1>Selecciona tus números de la lotería</h1>

    <!-- Formulario que envía las selecciones mediante POST -->
    <form action="Ejercicio7redirection.php" method="post">
        <table>
            <?php
            $indice = 0;
            for ($i = 0; $i < 7; $i++) {
            ?>
                <tr>
                    <?php
                    for ($j = 0; $j < 7; $j++) {
                        $indice++;
                    ?>
                        <td><label><input type="checkbox" name="numero<?= $indice ?>" value="<?= $indice ?>" /> <?= $indice ?></label></td>
                    <?php
                    }
                    ?>
                </tr>
            <?php
            }
            ?>
        </table>
        <input type="number" name="numeroSerie" />
        <input type="submit" value="Enviar" />
    </form>
</body>

</html>