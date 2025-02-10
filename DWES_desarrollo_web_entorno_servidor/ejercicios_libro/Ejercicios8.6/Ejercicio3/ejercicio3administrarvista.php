<?php
session_start();

if (isset($_REQUEST['logear'])) {
    $nombre = $_REQUEST['nombreUsuario'];
    $contrasenia = $_REQUEST['contrasenia'];

    if (!$nombre = 'root' && $contrasenia == 'root') {
        header('Location: ejercicio3.php');
    }
}
?>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="css/ejercicio3tablas.css" />
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
            foreach ($_SESSION['catalogo'] as $key => $infoTractor) {
            ?>
                <tr>
                    <td><?= $infoTractor['nombre'] ?></td>
                    <td><?= $infoTractor['precio'] ?></td>
                    <td>
                        <a href="ejercicio3detallesproductovista.php?key=<?= $key ?>">
                            <img src="<?= $infoTractor['imgUrl'] ?>" alt="">
                        </a>
                    </td>
                    <td>
                        <!-- Formulario para modificar los productos -->
                        <form action="ejercicio3modificarvista.php" method="post">
                            <input type="hidden" name="modificarProducto" value="<?= $key ?>">
                            <input type="submit" value="Modificar">
                        </form>

                        <!-- Formulario para modificar los productos -->
                        <form action="ejercicio3eliminarproductocatalogo.php" method="post">
                            <input type="hidden" name="eliminarProductoCatalogo" value="<?= $key ?>">
                            <input type="submit" value="Eliminar producto">
                        </form>
                    </td>
                </tr>
            <?php
            }
            ?>

            <tr>
                <td colspan="4">
                    <!-- Formulario para añadir los productos -->
                    <form action="ejercicio3aniadirproductovista.php" method="post">
                        <input type="hidden" name="aniadirProducto">
                        <input type="submit" value="Añadir producto">
                    </form>
                </td>
            </tr>

            <tr>
                <td colspan="4"><a href="ejercicio3.php">Volver</a></td>
            </tr>
        </table>

        <br><br>
        <!-- Formulario para eliminar las cookies y session -->
        <h2 style="color: red;">RESETEAR cookies y ELIMINAR session y cookies</h2>
        <form action="ejercicio3eliminarcookiessession.php" method="post">
            <input type="hidden" name="elimarCookiesSession">
            <input type="submit" value="eliminar">
        </form>
    </div>
</body>

</html>