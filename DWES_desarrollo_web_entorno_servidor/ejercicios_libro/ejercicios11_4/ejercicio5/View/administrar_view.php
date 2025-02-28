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
        <!-- Table para imprimir los productos de la forma completa -->
        <table>

            <tr>
                <th colspan="4">ADMINISTRACIÓN</th>
            </tr>

            <tr>
                <td>Producto</td>
                <td>Precio</td>
                <td>Imágen</td>
                <th>MODIFICACIONES</th>
            </tr>

            <!-- For each que recorre los productos del catalogo -->
            <?php
            foreach ($data['catalogo'] as $key => $tractor) {
            ?>
                <tr>
                    <td><?= $tractor->getNombre(); ?></td>
                    <td><?= $tractor->getPrecio(); ?></td>
                    <td>
                        <a href="../Controller/verdetallesproducto.php?key=<?= $key ?>">
                            <img src="<?= $tractor->getImagen(); ?>" alt="">
                        </a>
                    </td>
                    <td>
                        <!-- Formulario para modificar los productos -->
                        <form action="../Controller/vermodificarproducto.php" method="post">
                            <input type="hidden" name="modificarProducto" value="<?= $key ?>">
                            <input type="submit" value="Modificar">
                        </form>

                        <!-- Formulario para modificar los productos -->
                        <form action="../Controller/eliminarproductocatalogo_controller.php" method="post">
                            <input type="hidden" name="eliminarProductoCatalogo" value="<?= $key ?>">
                            <input type="submit" value="Eliminar producto">
                        </form>
                    </td>
                </tr>
            <?php
            }
            ?>

            <tr>

                <td colspan="2">

                    <!-- Formulario para añadir los productos -->
                    <form action="../Controller/veraniadirproducto.php" method="post">
                        <input type="hidden" name="aniadirProducto">
                        <input type="submit" value="Añadir producto">
                    </form>

                </td>

                <td colspan="2">

                    <!-- Formulario para añadir los productos -->
                    <form action="../Controller/ver_agregar_usuario.php" method="post">
                        <input type="hidden" name="agregarUsuario">
                        <input type="submit" value="Añadir usuario">
                    </form>

                </td>

            </tr>
        </table>
    </div>
</body>

</html>