<!--
Crea el programa GESTISIMAL (GESTIón SIMplifcada de ALmacén) para llevar el control de los artículos 
de un almacén. De cada artículo se debe saber el código, la descripción, el precio de compra, el precio de venta 
y el stock (número de  unidades). La  entrada  y salida  de  mercancía  supone  respectivamente el incremento y 
decremento de stock de un determinado artículo. Hay que controlar que no se pueda sacar más mercancía de la 
que  hay en el almacén. El programa debe  tener, al menos, las siguientes funcionalidades: listado, alta, baja, 
modificación, entrada de mercancía y salida de mercancía.
-->
<?php
include('funciones.php');
// Conexión a la base de datos  
$conexion = conexion();

// Variables de paginación
$articulosPorPagina = 5; // Número de artículos por página
$totalArticulos = $conexion->query("SELECT COUNT(*) FROM articulo")->fetchColumn(); // Total de artículos
$totalPaginas = ceil($totalArticulos / $articulosPorPagina); // Total de páginas

// Determinar la página actual
if (isset($_REQUEST['pagina'])) {
    $paginaActual = (int)$_REQUEST['pagina'];
    if ($paginaActual < 1) {
        $paginaActual = 1;
    } elseif ($paginaActual > $totalPaginas) {
        $paginaActual = $totalPaginas;
    }
} else {
    $paginaActual = 1;
}

// Calcular el OFFSET para la consulta
$offset = ($paginaActual - 1) * $articulosPorPagina;

// Consulta para obtener los artículos con límite de paginación
$consulta = $conexion->prepare("SELECT * FROM articulo LIMIT :offset, :limite");
$consulta->bindValue(':offset', $offset, PDO::PARAM_INT);
$consulta->bindValue(':limite', $articulosPorPagina, PDO::PARAM_INT);
$consulta->execute();
?>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        table,
        tr,
        td,
        th {
            margin: 20px auto;
            border: 1px solid #222;
        }

        a {
            display: block;
            text-decoration: none;
            color: #222;
            background-color: lightgray;
            padding: 5px;
            border-radius: 5px;
        }
    </style>
</head>

<body>

    <!-- Tabla donde se visualiza los artículo de la base de datos -->
    <table>

        <tr>
            <th>Código</th>
            <th>Descripción</th>
            <th>Precio de Compra</th>
            <th>Precio de Venta</th>
            <th>Stock</th>
            <th></th>
            <th></th>
            <th></th>
            <th></th>
        </tr>

        <?php
        while ($articulo = $consulta->fetchObject()) {
        ?>
            <tr>

                <td><?= $articulo->codigo ?></td>
                <td><?= $articulo->descripcion ?></td>
                <td><?= $articulo->precio_compra ?></td>
                <td><?= $articulo->precio_venta ?></td>
                <td><?= $articulo->stock ?></td>
                <td>
                    <form action="eliminararticulo.php" method="post">
                        <input type="hidden" name="eliminarArticulo">
                        <input type="hidden" name="codigo" value="<?= $articulo->codigo ?>">
                        <input type="submit" value="Eliminar">
                    </form>
                </td>

                <td>
                    <form action="modificararticulo.php" method="post">
                        <input type="hidden" name="modificarArticulo">
                        <input type="hidden" name="codigo" value="<?= $articulo->codigo ?>">
                        <input type="submit" value="Modificar">
                    </form>
                </td>

                <td>
                    <form action="entradaarticulo.php" method="post">
                        <input type="hidden" name="entradaArticulo">
                        <input type="hidden" name="codigo" value="<?= $articulo->codigo ?>">
                        <input type="submit" value="Entrada">
                    </form>
                </td>

                <td>
                    <form action="salidaarticulo.php" method="post">
                        <input type="hidden" name="salidaArtculo">
                        <input type="hidden" name="codigo" value="<?= $articulo->codigo ?>">
                        <input type="submit" value="Salida">
                    </form>
                </td>

            </tr>
        <?php
        }
        ?>

    </table>

    <!-- Tabla para navegar entre las distintas paginas de los articulos -->
    <table>

        <tr>
            <th><?= $paginaActual ?> de <?= $totalPaginas ?></th>
            <td>
                <a href="?pagina=<?= max(1, $paginaActual - 1) ?>">Anterior</a>
            </td>
            <td>
                <a href="?pagina=<?= min($totalPaginas, $paginaActual + 1) ?>">Siguiente</a>
            </td>
            <td>
                <a href="?pagina=1">Principio</a>
            </td>
            <td>
                <a href="?pagina=<?= $totalPaginas ?>">Última</a>
            </td>
        </tr>

    </table>

    <!-- Table para agregar articulos -->
    <table>

        <tr>
            <th>Código</th>
            <th>Descripción</th>
            <th>Precio de Compra</th>
            <th>Precio de Venta</th>
            <th>Stock</th>
            <th></th>
        </tr>

        <tr>
            <!-- Formulario para añadir producto -->
            <form action="insertararticulo.php" method="post">
                <td><input type="text" name="codigo" minlength="4" maxlength="4"></td>
                <td><input type="text" name="descripcion" maxlength="1000"></td>
                <td><input type="number" name="precioCompra"></td>
                <td><input type="number" name="precioVenta"></td>
                <td><input type="number" name="stock"></td>
                <input type="hidden" name="agregarArticulo">
                <td><input type="submit" value="Agregar"></td>
            </form>
        </tr>

    </table>

</body>

</html>