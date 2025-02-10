<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="../View/css/ejercicio3formularios.css" />
</head>

<body>
    <div class="container">
        <h1>Detalles del tractor</h1>
        <h4>Nombre: <?= $data['tractor']->getNombre(); ?></h4>
        <img src="<?= $data['tractor']->getImagen(); ?>" alt="">
        <h4>Precio: <?= $data['tractor']->getPrecio(); ?></h4>
        <h4>Detalles: <?= $data['tractor']->getDescripcion(); ?></h4>

        <!-- Formulario para comprar el producto  -->
        <form action="../Controller/aniadir_controller.php" method="post">
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