<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="../View/css/ejercicio3formularios.css" />
</head>

<body>
    <h1>Modificar el tractor:</h1>
    <!-- Formulario para comprar el producto  -->
    <form action="../Controller/modificarproducto_controller.php" method="post">
        <h4>Nombre:
            <input type="text" name="nombre" value="<?= $data['tractores'][$key]->getNombre(); ?>" readonly>
        </h4>
        <input type="text" name="imagen" value="<?= $data['tractores'][$key]->getImagen(); ?>" readonly>
        <img src="<?= $data['tractores'][$key]->getImagen(); ?>" alt="Tractor"><br>
        Precio: <input type="text" name="precio" value="<?= $data['tractores'][$key]->getPrecio(); ?>"><br>
        Detalles: <textarea name="detalles"><?= $data['tractores'][$key]->getDescripcion(); ?></textarea>
        <input type="hidden" name="productoModificado" value="<?= $key ?>">
        <input type="submit" value="Realizar modificaciones"><br>
    </form>

    <!-- Formulario para volver al inicio -->
    <form action="../Controller/administrarweb_controller.php" method="post">
        <input type="submit" value="Volver"><br>
    </form>

    <!-- Forma distinta (enlace) -->
    <!-- <a href="ejercicio3.php">Vaciar Carrito</a> -->
    <?php
    ?>
</body>

</html>