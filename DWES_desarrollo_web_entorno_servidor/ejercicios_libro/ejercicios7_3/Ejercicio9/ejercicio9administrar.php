<?php
session_start();

if (!isset($_COOKIE['catalogo'])) {
    header('Location: ejercicio9.php');
} else {
    $catalogo = unserialize(base64_decode($_COOKIE['catalogo']));
}

// en caso de añadir un producto lo agrego
if (isset($_REQUEST['aniadirProducto'])) {
    $nombre = $_REQUEST['nombre'];
    $precio = (float) $_REQUEST['precio'];
    $imgUrl = $_REQUEST['imgUrl'];
    $detalles = $_REQUEST['detalles'];

    $catalogo["0000000"] = [
        "nombre" => $nombre,
        "precio" => $precio,
        "imgUrl" => 'img/' . $imgUrl,
        "detalles" => $detalles
    ];

    setcookie('catalogo', base64_encode(serialize($catalogo)), time() + 3600);
}

// en caso de eliminar un producto
if (isset($_REQUEST['eliminarProducto'])) {
    $key = $_REQUEST['eliminarProducto'];

    unset($catalogo[$key]);

    setcookie('catalogo', base64_encode(serialize($catalogo)), time() + 3600);
}

// en caso de modificar un producto
if (isset($_REQUEST['modificarProducto'])) {
    $key = $_REQUEST['modificarProducto'];
    $infoProducto = $_REQUEST['infoProducto'];

    $aux = ["nombre", "precio", "imgUrl", "detalles"];

    for ($i = 0; $i < count($infoProducto); $i++) {
        if ($infoProducto[$i] != null || $infoProducto[$i] != "") {
            if ($i === 1) {
                $infoProducto[$i] = (float) $infoProducto[$i];
            }
            $catalogo[$key][$aux[$i]] = $infoProducto[$i];
        }
    }

    setcookie('catalogo', base64_encode(serialize($catalogo)), time() + 3600);
}
?>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
    <!-- Formulario para añadir productos -->
    <h2>Añadir producto</h2>
    <form action="" method="post">
        Nombre: <input type="text" name="nombre"><br>
        Precio: <input type="text" name="precio"><br>
        URL de la imágen<input type="text" name="imgUrl"><br>
        Detalles: <input type="text" name="detalles"><br>
        <input type="hidden" name="aniadirProducto">
        <input type="submit" value="Añadir producto">
    </form>
    <br>

    <!-- Formulario para eliminar un producto seleccionado -->
    <h2>Eliminar un producto del catalogo</h2>
    <form action="" method="post">
        <select name="eliminarProducto">
            <?php
            foreach ($catalogo as $key => $infoTractor) {
            ?>
                <option value="<?= $key ?>"><?= $catalogo[$key]['nombre'] ?></option>
            <?php
            }
            ?>
        </select>
        <input type="submit" value="Eliminar"><br><br>
    </form>

    <!-- Formulario para modificar un producto seleccionado -->
    <h2>Modificar un producto del catalogo</h2>
    <form action="" method="post">
        <select name="modificarProducto">
            <?php
            foreach ($catalogo as $key => $infoTractor) {
            ?>
                <option value="<?= $key ?>"><?= $catalogo[$key]['nombre'] ?></option>
            <?php
            }
            ?>
        </select><br>
        Nombre: <input type="text" name="infoProducto[]"><br>
        Precio: <input type="text" name="infoProducto[]"><br>
        URL de la imágen<input type="text" name="infoProducto[]"><br>
        Detalles: <input type="text" name="infoProducto[]"><br>
        <input type="submit" value="Modificar"><br><br>
    </form>

    <a href="ejercicio9.php">Volver</a>
</body>

</html>