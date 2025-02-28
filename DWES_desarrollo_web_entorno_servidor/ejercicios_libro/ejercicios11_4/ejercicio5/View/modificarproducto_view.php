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
        <input type="hidden" name="productoModificado" value="<?= $key ?>">
        <h4>Nombre:
            <input type="text" name="nombre" value="<?= $data['catalogo'][$key]->getNombre(); ?>" readonly>
        </h4>
        <input type="text" name="imagen" value="<?= $data['catalogo'][$key]->getImagen(); ?>" readonly>
        <img src="<?= $data['catalogo'][$key]->getImagen(); ?>" alt="Tractor"><br>
        Precio: <input type="text" name="precio" value="<?= $data['catalogo'][$key]->getPrecio(); ?>"><br>
        Detalles: <textarea name="detalles"><?= $data['catalogo'][$key]->getDescripcion(); ?></textarea>
        Stock: <input type="number" name="stock" value="<?= $data['catalogo'][$key]->getStock(); ?>">
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