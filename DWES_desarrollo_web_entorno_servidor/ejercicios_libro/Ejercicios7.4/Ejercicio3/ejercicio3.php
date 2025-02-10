<!--
Realizar  una  tienda  con  un  carrito  de  la  compra  más  completo  que  el  realizado  en  el  boletín.  En  la  página 
principal tendremos un listado compuesto por una tabla con 4 columnas, nombre del producto, precio, imagen 
y  botón  para  añadir  a  la  cesta,  si  se  añade  más  de  una  vez se  aumenta  la  cantidad  del  producto  en  la  cesta. 
También se mostrará cuantos productos hay en la cesta en todo momento y un enlace para acceder a dicha cesta 
que mostrará otro listado de los productos añadidos y su cantidad, junto a cada producto habrá un botón eliminar 
que permita quitar una unidad de ese producto y si se llega a 0 se elimina el producto de la cesta. Al final de la 
cesta se mostrará el importe total de todos los productos y un botón o enlace para cerrar la cesta y volver a la 
página principal. 
Por último, en la página principal al pulsar sobre la imagen de un producto se abrirá en otra página la imagen 
a  tamaño  original  (algo  más  grande)  junto  con  los  datos  del  producto  y  el  detalle  del  mismo  (una  breve 
descripción). 
 
Crear manualmente en código, un array de sesión con todos los productos la primera vez que se carga la página 
en una sesión nueva (con 3 o 4 productos es suficiente). El array puede ser asociativo con clave ‘nombre del 
producto’ y valor un array con los valores ‘precio, detalle’ y la imagen puede coincidir con el nombre del 
producto más la extensión.

Los productos añadidos en la cesta deben almacenarse en una cookie por si se cierra el navegador y se abre de 
nuevo se recuperen automáticamente los productos añadidos a la cesta.
-->
<?php
session_start();

// en caso de no tener el catalogo creado, redirijo a la página encargada de hacerlo
if (!isset($_SESSION['catalogo'])) {
    header("Location: ejercicio3iniciarapp.php");
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
            <th colspan="3">Tienda "John Deere"</th>
            <td>
                <a href="ejercicio3productoscarrito.php">Carrito</a>
                <?php
                if (isset($_SESSION['carrito'])) {
                    $totalProductos = 0;
                    foreach ($_SESSION['carrito'] as $key  => $info) {
                        $totalProductos += $info;
                    }
                    echo $totalProductos;
                }
                ?>
            </td>
        </tr>

        <tr>
            <td>Producto</td>
            <td>Precio</td>
            <td>Imágen</td>
            <td><a href="ejercicio3login.php?logear">ADMINISTRAR</a></td>
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
                    <!-- Formulario para añadir productos al carrito -->
                    <form action="ejercicio3aniadir.php" method="post">
                        <input type="hidden" name="aniadirCarrito" value="<?= $key ?>">
                        <input type="submit" value="Añadir al carrito">
                    </form>
                </td>
            </tr>

        <?php
        }
        ?>

    </table>

    <br><br>
    <!-- Formulario para eliminar las cookies y session -->
    <h2 style="color: red;">RESETEAR cookies y ELIMINAR session</h2>
    <form action="ejercicio3eliminarcookiessession.php" method="post">
        <input type="hidden" name="elimarCookiesSession">
        <input type="submit" value="eliminar">
    </form>
</body>

</html>