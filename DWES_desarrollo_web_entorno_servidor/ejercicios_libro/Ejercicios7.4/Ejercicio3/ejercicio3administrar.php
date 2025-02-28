<?php
session_start();

if (!isset($_REQUEST['logear'])) {
    header('Location: ejercicio3.php');
} else {
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
    <style>
        table,
        tr,
        td,
        th {
            border: solid 1px #333;
            text-align: center;
        }
    </style>
</head>

<body>
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

        <?php
        // For each que recorre los productos del catalogo
        foreach ($_SESSION['catalogo'] as $key => $infoTractor) {
        ?>

            <tr>
                <td><?= $infoTractor['nombre'] ?></td>
                <td><?= $infoTractor['precio'] ?></td>
                <td><a href="ejercicio3detalles.php?key=<?= $key ?>"><img src="img/<?= $infoTractor['imgUrl'] ?>.jfif" alt=""></a></td>
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

    </table>
</body>

</html>