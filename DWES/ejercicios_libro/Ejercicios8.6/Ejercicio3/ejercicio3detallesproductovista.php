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
    <link rel="stylesheet" href="css/ejercicio3formularios.css" />
</head>

<body>
    <div class="container">
        <h1>Detalles del tractor</h1>
        <h4>Nombre: <?= $_SESSION['catalogo'][$key]['nombre'] ?></h4>
        <img src="<?= $infoTractor['imgUrl'] ?>" alt="">
        <h4>Detalles: <?= $_SESSION['catalogo'][$key]['detalles'] ?></h4>
        <h4>Precio: <?= $_SESSION['catalogo'][$key]['precio'] ?></h4>

        <!-- Formulario para comprar el producto  -->
        <form action="ejercicio3aniadirproductocarrito.php" method="post">
            <input type="hidden" name="aniadirCarrito" value="<?= $key ?>">
            <input type="submit" value="Añadir al carrito"><br>
        </form>

        <!-- Formulario para volver al inicio -->
        <form action="<?= $_SERVER['HTTP_REFERER'] ?>" method="post">
            <input type="submit" value="Volver"><br>
        </form>

        <!-- Forma distinta (enlace) -->
        <!-- <a href="ejercicio3.php">Vaciar Carrito</a> -->
        <?php
        ?>
    </div>
</body>

</html>