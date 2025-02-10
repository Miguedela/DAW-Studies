<?php
session_start();
if (isset($_REQUEST['detalles'])) {
    $codigo = $_REQUEST['detalles'];
    $catalogo = unserialize(base64_decode($_COOKIE['catalogo']));
} else {
    header("Location: ejercicio9.php");
}
?>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
    <?php
    echo "<h1>Productos</h1>";
    ?>
    <form action="ejercicio9.php" method="post">
        <h4>Nombre: <?= $catalogo[$codigo]['nombre'] ?></h4>
        <img src="<?= $catalogo[$codigo]['imgUrl'] ?>" alt="Tractor">
        <h4>Detalles: <?= $catalogo[$codigo]['detalles'] ?></h4>
        <h4>Precio: <?= $catalogo[$codigo]['precio'] ?></h4>
        <input type="hidden" name="comprar" value="<?= $codigo ?>">
        <input type="submit" value="Comprar"><br>
    </form>
    <a href="ejercicio9.php">Volver</a>
    <?php
    ?>
</body>

</html>