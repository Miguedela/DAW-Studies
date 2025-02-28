<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
    <?php
    session_start();

    $codigo = $_REQUEST['detalles'];

    echo "<h1>Productos</h1>";
    ?>
    <form action="ejercicio6.php" method="post">
        <img src="<?= $_SESSION['productos'][$codigo]['imgUrl'] ?>" alt="Tractor">
        <h4>Nombre: <?= $_SESSION['productos'][$codigo]['nombre'] ?></h4>
        <h4>Detalles: <?= $_SESSION['productos'][$codigo]['detalles'] ?></h4>
        <h4>Precio: <?= $_SESSION['productos'][$codigo]['precio'] ?></h4>
        <input type="hidden" name="comprar" value="<?= $codigo ?>">
        <input type="submit" value="Comprar"><br>
    </form>
    <a href="ejercicio6.php">Volver</a>
    <?php
    ?>
</body>

</html>