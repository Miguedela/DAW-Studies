<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
    <?php
    // Escribe un programa que lea 15 números por teclado y que los almacene en un array. Rota los elementos
    // de ese array, es decir, el elemento de la posición 0 debe pasar a la posición 1, el de la 1 a la 2, etc. El
    // número que se encuentra en la última posición debe pasar a la posición 0. Finalmente, muestra el contenido
    // del array.


    if (!isset($_REQUEST['numeros'])) {
    ?>
        <form action="" method="post">
            <?php
            for ($i = 0; $i < 15; $i++) {
            ?>
                Introduce el número <?= $i + 1 ?>: <input type="number" name="numeros[]" value="<?= $i ?>"><br>
            <?php
            } ?>
            <input type="submit" value="Enviar numeros">
        </form>
    <?php
    } else {
        $numeros = $_REQUEST['numeros'];

        // Muestra el contenido del array original
        echo "Array original: ";
        foreach ($numeros as $numero) {
            echo $numero . " ";
        }
        echo "\n";
    ?>
        <br>
    <?php
        // Rota los elementos del array
        for ($i = 0; $i < count($numeros); $i++) {
            $aux = $numeros[$i];
            $numeros[$i] = $numeros[count($numeros) - 1];
            $numeros[count($numeros) - 1] = $aux;
        }

        // Muestra el contenido del array rotado
        echo "Array rotado: ";
        foreach ($numeros as $numero) {
            echo $numero . " ";
        }
        echo "\n";
    }
    ?>
</body>

</html>