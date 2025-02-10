<?php
session_start();

// if que te manda a la pagina principal en caso de no recibir la variable necesaria
if (!isset($_REQUEST['key'])) {
    header("Location: ejercicio3.php");
} else {
    $key = $_REQUEST['key'];
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
    <h1>Detalles del tractor</h1>
    <h4>Nombre: <?= $_SESSION['catalogo'][$key]['nombre'] ?></h4>
    <img src="img/<?= $_SESSION['catalogo'][$key]['imgUrl'] ?>.jfif" alt="Tractor">
    <h4>Detalles: <?= $_SESSION['catalogo'][$key]['detalles'] ?></h4>
    <h4>Precio: <?= $_SESSION['catalogo'][$key]['precio'] ?></h4>

    <!-- Formulario para comprar el producto  -->
    <form action="ejercicio3aniadir.php" method="post">
        <input type="hidden" name="aniadirCarrito" value="<?= $key ?>">
        <input type="submit" value="Añadir al carrito"><br>
    </form>

    <!-- Formulario para volver al inicio -->
    <form action="ejercicio3.php" method="post">
        <input type="submit" value="Volver"><br>
    </form>

    <!-- Forma distinta (enlace) -->
    <!-- <a href="ejercicio3.php">Vaciar Carrito</a> -->
    <?php
    ?>
</body>

</html>