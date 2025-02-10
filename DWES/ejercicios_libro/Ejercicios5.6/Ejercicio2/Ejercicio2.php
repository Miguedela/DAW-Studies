<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
    <!--
    Escribe un programa que pida 10 números por teclado y que luego muestre los números introducidos junto
    con las palabras “máximo” y “mínimo” al lado del máximo y del mínimo respectivamente.
    -->

    <form action="Ejercicio2redirection.php" method="request">
        <h3>Introduce 10 números:</h3>
        <?php
        for ($i = 0; $i < 10; $i++) {
        ?>
            Numero<?= $i ?>: <input type="number" name="numero<?= $i ?>" required><br>
        <?php
        }
        ?>
        <input type="submit" value="Enviar">
    </form>
</body>

</html>