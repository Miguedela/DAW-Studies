<?php
session_start();

// if que te manda a la pagina principal en caso de no recibir la variable necesaria
if (!isset($_REQUEST['modificarProducto'])) {
    header("Location: ejercicio3.php");
} else {
    $key = $_REQUEST['modificarProducto'];
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
    <h1>Modificar el tractor:</h1>
    <!-- Formulario para comprar el producto  -->
    <form action="ejercicio3modificar.php" method="post">
        <h4>Nombre: <?= $_SESSION['catalogo'][$key]['nombre'] ?></h4>
        <img src="img/<?= $_SESSION['catalogo'][$key]['imgUrl'] ?>.jfif" alt="Tractor"><br>
        Precio: <input type="text" name="precio" value="<?= $_SESSION['catalogo'][$key]['precio'] ?>"><br>
        Detalles: <input type="text" name="detalles" value="<?= $_SESSION['catalogo'][$key]['detalles'] ?>"><br>
        <input type="hidden" name="productoModificado" value="<?= $key ?>">
        <input type="submit" value="Realizar modificaciones"><br>
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