<?php
// if que te manda a la pagina principal en caso de no tener ningun producto en el carrito
if ($data['cantidadProductos'] <= 0) {
?>
    <h2>Tu carrito esta vacio, añade algo para poder hacer uso de el!!</h2>
    <!-- Formulario para volver al inicio -->
    <form action="../Controller/index_controller.php" method="post">
        <input type="submit" value="Volver"><br>
    </form>
<?php
} else {
?>
    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
        <link rel="stylesheet" href="../View/css/ejercicio3tablas.css" />
    </head>

    <body>
        <div class="container">

            <!-- Table para imprimir los productos del carrito -->
            <table>
                <tr>
                    <th colspan="6">PRODUCTOS DE TU CARRITO</th>
                </tr>
                <tr>
                    <th>Nombre</th>
                    <th>Precio unidad</th>
                    <th>Cantidad</th>
                    <th colspan="2">Imágen</th>
                    <th></th>
                </tr>
                <?php
                foreach ($data['carrito'] as $key => $info) {
                ?>
                    <tr>

                        <td><?= $data['catalogo'][$key]->getNombre() ?></td>

                        <td><?= $data['catalogo'][$key]->getPrecio() ?></td>

                        <td><?= $info->getCantidad(); ?></td>

                        <td colspan="2">
                            <a href="../Controller/verdetallesproducto.php?key=<?= $key ?>">
                                <img src="<?= $data['catalogo'][$key]->getImagen() ?>" alt="">
                            </a>
                        </td>

                        <td>
                            <!-- Formulario para eliminar un producto -->
                            <form action="../Controller/eliminarproductocarrito_controller.php" method="post">
                                <input type="hidden" name="eliminarProducto" value="<?= $key ?>">
                                <input type="submit" value="Eliminar">
                            </form>
                        </td>

                    </tr>
                <?php
                }
                ?>
                <tr>
                    <th colspan="2">Total: <?= $data['cantidadProductos'] ?> productos.</th>
                    <th colspan="3">Precio: <?= $data['precioCarrito'] ?>€.</th>

                    <th>

                        <!-- Formulario para realizar la compra del carrito -->
                        <form action="../Controller/ver_factura_view.php" method="post">
                            <input type="hidden" name="comprarCarrito">
                            <input type="submit" value="Realizar Compra">
                        </form>

                    </th>
                </tr>
                <tr>
                    <th colspan="5">

                        <!-- Formulario para volver al inicio -->
                        <form action="../Controller/index_controller.php" method="post">
                            <input type="submit" value="Volver a la tienda"><br>
                        </form>

                    </th>

                    <th>

                        <!-- Formulario para vaciar el carrito -->
                        <form action="../Controller/eliminarcarrito_controller.php" method="post">
                            <input type="hidden" name="vaciarCarrito">
                            <input type="submit" value="Vaciar Carrito">
                        </form>

                    </th>
                </tr>
            </table>
        </div>
    </body>

    </html>
<?php
}
?>