<?php
session_start();

// if que te manda a la pagina principal en caso de no tener ningun producto en el carrito
if (!isset($_SESSION['carrito'])) {
?>
    <h2>Tu carrito esta vacio, añade algo para poder hacer uso de el!!</h2>
    <!-- Formulario para volver al inicio -->
    <form action="ejercicio3.php" method="post">
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
        <style>
            table,
            tr,
            td {
                border: solid 1px #333;
                text-align: center;
            }
        </style>
    </head>

    <body>
        <!-- Table para imprimir los productos del carrito -->
        <table>
            <tr>
                <th colspan="4">PRODUCTOS DE TU CARRITO</th>
            </tr>
            <?php
            $totalProductos = 0;
            $precioTotal = 0;
            foreach ($_SESSION['carrito'] as $key  => $info) {
                $totalProductos += $info;
                $precioTotal += $_SESSION['catalogo'][$key]['precio'] * $info;
            ?>
                <tr>
                    <td><?= $_SESSION['catalogo'][$key]['nombre'] ?></td>
                    <td><?= $info ?></td>
                    <td>
                        <a href="ejercicio3detalles.php?key=<?= $key ?>">
                            <img src="img/<?= $_SESSION['catalogo'][$key]['imgUrl'] ?>.jfif" alt="">
                        </a>
                    </td>
                    <td>
                        <!-- Formulario para eliminar un producto -->
                        <form action="ejercicio3eliminarproducto.php" method="post">
                            <input type="hidden" name="eliminarProducto" value="<?= $key ?>">
                            <input type="submit" value="Eliminar">

                            <!-- Forma distinta (enlace) -->
                            <!-- <a href="ejercicio3eliminarproducto.php?eliminarProducto=<?= $key ?>"></a> -->
                        </form>
                    </td>
                </tr>
            <?php
            }
            ?>
            <tr>
                <td>Total</td>
                <td><?= $totalProductos ?></td>
                <td><?= $precioTotal ?></td>
                <td>
                    <!-- Formulario para vaciar el carrito -->
                    <form action="ejercicio3eliminarcarrito.php" method="post">
                        <input type="hidden" name="vaciarCarrito">
                        <input type="submit" value="Vaciar Carrito">
                    </form>

                    <!-- Forma distinta (enlace) -->
                    <!-- <a href="ejercicio3eliminarcarrito.php?vaciarCarrito">Vaciar Carrito</a> -->
                </td>
            </tr>
            <tr>
                <td>
                    <!-- Formulario para volver al inicio -->
                    <form action="ejercicio3.php" method="post">
                        <input type="submit" value="Volver a la tienda"><br>
                    </form>

                    <!-- Forma distinta (enlace) -->
                    <!-- <a href="ejercicio3.php">Vaciar Carrito</a> -->
                </td>
            </tr>
        </table>
    </body>

    </html>
<?php
}
?>