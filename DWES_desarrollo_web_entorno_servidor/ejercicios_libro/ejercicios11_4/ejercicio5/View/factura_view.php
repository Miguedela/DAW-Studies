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
                <th colspan="4">PRODUCTOS DE TU CARRITO</th>
            </tr>
            <tr>
                <th>Nombre</th>
                <th>Cantidad</th>
                <th colspan="2">Imágen</th>
            </tr>
            <?php
            foreach ($data['carritoUsuario'] as $key => $info) {
            ?>
                <tr>

                    <td><?= $data['catalogo'][$key]->getNombre() ?></td>

                    <td><?= $info->getCantidad(); ?></td>

                    <td colspan="3">
                        <a href="../Controller/verdetallesproducto.php?key=<?= $key ?>">
                            <img src="<?= $data['catalogo'][$key]->getImagen() ?>" alt="">
                        </a>
                    </td>

                </tr>
            <?php
            }
            ?>
            <tr>
                <th colspan="2">Productos totales: <?= $data['cantidadProductos'] ?> productos.</th>
                <th colspan="2">Precio total (IVA incluido): <?= $data['precioCarrito'] * 1.21 ?>€.</th>
            </tr>
            <tr>
                <td colspan="2">

                    <!-- Formulario para volver al inicio -->
                    <form action="../Controller/index_controller.php" method="post">
                        <input type="submit" value="Volver a la tienda">
                    </form>

                </td>

                <td colspan="2">

                    <!-- Formulario para volver al inicio -->
                    <form action="../Controller/comprar_carrito_controller.php" method="post">
                        <input type="hidden" name="comprarCarrito">
                        <input type="submit" value="Realizar compra">
                    </form>

                </td>
            </tr>
        </table>
    </div>
</body>

</html>