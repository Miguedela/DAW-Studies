<!--
    Amplía el programa anterior de tal forma que se pueda ver el detalle de un producto. Para ello, cada uno de los 
    productos del catálogo deberá tener un botón Detalle que, al ser accionado, debe llevar al usuario a la vista de 
    detalle  que  contendrá  una  descripción  exhaustiva  del  producto  en  cuestión.  Se  podrán  añadir  productos  al 
    carrito tanto desde la vista de listado como desde la vista de detalle.
-->
<?php
if (isset($_REQUEST['eliminar'])) {
    $idTractor = $_REQUEST['eliminar'];
    if (isset($_SESSION['cesta'][$idTractor])) {
        unset($_SESSION['cesta'][$idTractor]);
    }

    // verifico que el carrito este vacio para eliminar su posicion en ese caso
    if (empty($_SESSION['cesta'])) {
        unset($_SESSION['cesta']);
    }
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

    <?php
    session_start();

    if (isset($_REQUEST['comprarTodo'])) {
        echo "<h1>Compra realizada, gracias!!</h1>";
        session_destroy();
        header("refresh: 3;");
    } else {
        $_SESSION['productos'] = [
            "JD001" => array(
                "nombre" => "Jhon Deere 001",
                "precio" => 10599.99,
                "imgUrl" => "img/johndeere001.jfif",
                "detalles" => "tractor potentisimo"
            ),
            "JD002" => array(
                "nombre" => "Jhon Deere 002",
                "precio" => 11599.99,
                "imgUrl" => "img/johndeere002.jfif",
                "detalles" => "tractor potentisimo"
            ),
            "JD003" => array(
                "nombre" => "Jhon Deere 003",
                "precio" => 12599.99,
                "imgUrl" => "img/johndeere003.jfif",
                "detalles" => "tractor potentisimo"
            )
        ];

        if (isset($_REQUEST['comprar'])) {
            $idTractor = $_REQUEST['comprar'];
            foreach ($_SESSION['productos'] as $key => $infoTractor) {
                if ($idTractor === $key) {
                    if (isset($_SESSION['cesta'][$key])) {
                        $_SESSION['cesta'][$key]++;
                    } else {
                        $_SESSION['cesta'][$key] = 1;
                    }
                    break;
                }
            }
        }



        echo "<h1>Productos</h1>";
        foreach ($_SESSION['productos'] as $key => $infoTractor) {
    ?>
            <form action="" method="post">
                <img src="<?= $infoTractor['imgUrl'] ?>" alt="Tractor">
                <h4>Nombre: <?= $infoTractor['nombre'] ?></h4>
                <h4>Precio: <?= $infoTractor['precio'] ?></h4>
                <input type="hidden" name="comprar" value="<?= $key ?>">
                <input type="submit" value="Comprar">
            </form>
            <form action="ejercicio6redirection.php" method="post">
                <input type="hidden" name="detalles" value="<?= $key ?>">
                <input type="submit" value="Detalles"><br><br>
            </form>
            <?php
        }

        if (isset($_SESSION['cesta'])) {
            echo "<h1>Carrito de la compra</h1>";
            $total = 0;
            foreach ($_SESSION['cesta'] as $keyCesta => $infoCesta) {
                $total += ($_SESSION['productos'][$keyCesta]['precio'] *  $infoCesta);
            ?>
                <form action="" method="post">
                    <img src="<?= $_SESSION['productos'][$keyCesta]['imgUrl'] ?>" alt="Tractor">
                    <h4>Nombre: <?= $_SESSION['productos'][$keyCesta]['nombre'] ?></h4>
                    <h4>Precio: <?= ($_SESSION['productos'][$keyCesta]['precio'] *  $infoCesta) ?></h4>
                    <h4>Cantidad: <?= $infoCesta ?></h4>
                    <input type="hidden" name="eliminar" value="<?= $keyCesta ?>">
                    <input type="submit" value="Eliminar"><br><br>
                </form>
            <?php
            }
            echo "<h3>El precio del carrito asciende a: $total</h3>";
            ?>
            <form action="" method="post">
                <input type="hidden" name="comprarTodo" value="">
                <input type="submit" value="Comprar Todo">
            </form>
    <?php
        }
    }
    ?>
</body>

</html>