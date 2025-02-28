<!--
    ·MODIFICACIONES 1
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


    ·MODIFICACIONES 2
Modifica el ejercicio del carrito de la compra del tema anterior, para que los productos se almacenen en un 
fichero. Debes crear una página para administrar (insertar y eliminar) los productos de la tienda (que están 
almacenados en dicho fichero). Puedes trabajar con los productos en un array de sesión, pero cuando se añada o 
se borre un producto de la tienda, será necesario actualizar el fichero. También se debe seguir guardando la cesta 
de la compra en una cookie, de manera que se pueda retomar la compra, aunque se cierre el navegador, aunque 
esa funcionalidad ya la tenemos implementada.
-->
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
                <th colspan="4">Tienda "John Deere"</th>
                <th>
                    <a href="../Controller/vercarrito.php">Carrito</a>
                    <?php
                    if (isset($_SESSION['carrito'])) {
                        $totalProductos = 0;
                        foreach ($_SESSION['carrito'] as $key  => $info) {
                            $totalProductos += $info;
                        }
                        echo $totalProductos;
                    }
                    ?>
                </th>
            </tr>

            <tr>
                <th>Producto</th>
                <th>Precio</th>
                <th>Imágen</th>
                <th>Stock</th>
                <th><a href="../Controller/verlogin.php?logear">ADMINISTRAR</a></th>
            </tr>

            <?php
            // For each que recorre los productos del catalogo
            foreach ($data['tractores'] as $key => $tractor) {
            ?>

                <tr>
                    <td><?= $tractor->getNombre(); ?></td>
                    <td><?= $tractor->getPrecio(); ?>€</td>
                    <td>
                        <a href="../Controller/verdetallesproducto.php?key=<?= $key ?>">
                            <img src="<?= $tractor->getImagen(); ?>" alt="">
                        </a>
                    </td>
                    <td><?= $tractor->getStock(); ?></td>
                    <td>
                        <!-- Formulario para añadir productos al carrito -->
                        <form action="../Controller/aniadir_controller.php" method="post">
                            <input type="hidden" name="aniadirCarrito" value="<?= $key ?>">
                            <input type="submit" value="Añadir al carrito">
                        </form>
                    </td>
                </tr>

            <?php
            }
            ?>
        </table>
    </div>
</body>

</html>