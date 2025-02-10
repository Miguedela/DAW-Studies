<?php
if (!isset($_REQUEST['modificarArticulo']) && !isset($_REQUEST['realizarModificacion'])) {
    header("Location: index.php");
}

try {
    $conexion = new PDO("mysql:host=localhost;dbname=ejercicio4__10_5;charset=utf8", "root", "");
    $codigo = $_REQUEST['codigo'];

    $sql = "SELECT codigo, descripcion, precio_compra, precio_venta, stock FROM articulo WHERE codigo = :codigo";
    $stmt = $conexion->prepare($sql);
    $stmt->execute([':codigo' => $codigo]);
    $articulo = $stmt->fetch(PDO::FETCH_ASSOC);

    if (!$articulo) {
        echo "Artículo no encontrado.";
        exit();
    }
} catch (PDOException $e) {
    echo "No se ha podido establecer conexión con el servidor de bases de datos.<br>";
    die("Error: " . $e->getMessage());
}


if (isset($_REQUEST['realizarModificacion'])) {

    try {
        $sql = "UPDATE articulo SET descripcion = :descripcion, precio_compra = :precio_compra, precio_venta = :precio_venta, stock = :stock WHERE codigo = :codigo";
        $stmt = $conexion->prepare($sql);
        $stmt->execute([
            ':descripcion' => $_REQUEST['descripcion'],
            ':precio_compra' => $_REQUEST['precio_compra'],
            ':precio_venta' => $_REQUEST['precio_venta'],
            ':stock' => $_REQUEST['stock'],
            ':codigo' => $codigo
        ]);

        header("Location: index.php");
        exit();
    } catch (PDOException $e) {
        echo "Error al modificar el artículo.<br>";
        die("Error: " . $e->getMessage());
    }
}
?>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Modificar Artículo</title>
    <style>
        table,
        tr,
        td,
        th {
            margin: 20px auto;
            border: 1px solid #222;
        }
    </style>
</head>

<body>

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
            <form action="#" method="post">
                <td><input type="text" name="codigo" value="<?= $articulo['codigo'] ?>" minlength="4" maxlength="4"></td>
                <td><input type="text" name="descripcion" value="<?= $articulo['descripcion'] ?>" maxlength="1000"></td>
                <td><input type="number" name="precioCompra" value="<?= $articulo['precio_compra'] ?>"></td>
                <td><input type="number" name="precioVenta" value="<?= $articulo['precio_venta'] ?>"></td>
                <td><input type="number" name="stock" value="<?= $articulo['stock'] ?>"></td>
                <input type="hidden" name="realizarModificacion">
                <td><input type="submit" value="Agregar"></td>
            </form>
        </tr>

    </table>
</body>

</html>