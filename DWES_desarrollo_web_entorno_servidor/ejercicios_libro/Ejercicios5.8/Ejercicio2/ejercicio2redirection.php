<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
    <?php
    $pedidos = unserialize(base64_decode($_REQUEST['pedidos']));

    if (count($pedidos) == 0) {
    ?>
        <h2>Antes de mostrar los pedidos debe de añadir alguno a su cuenta.</h2>
        <a href="ejercicio2.php">Volver</a>
        <?php
    } else {
        foreach ($pedidos as $pedido) {
        ?>
            <h3><?= $pedido[0] ?></h3>
            <p>
                <?php
                for ($i = 0; $i < count($pedido); $i++) {
                ?>
                    <?= $pedido[$i] ?>
                <?php
                }
                ?>
            </p>
    <?php
        }
    }
    ?>
</body>

</html>