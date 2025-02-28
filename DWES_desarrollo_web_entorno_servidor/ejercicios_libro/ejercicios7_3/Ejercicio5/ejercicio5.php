<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
    <!--
    Crea una tienda on-line sencilla con un catálogo de productos y un carrito de la compra. Un catálogo de cuatro 
    o cinco productos será suficiente. De cada producto se debe conocer al menos la descripción y el precio. Todos 
    los  productos  deben  tener  una  imagen  que  los  identifique.  Al  lado  de  cada  producto  del  catálogo  deberá 
    aparecer un botón Comprar que permita añadirlo al carrito. Si el usuario hace clic en el botón Comprar de un 
    producto que ya estaba en el carrito, se deberá incrementar el número de unidades de dicho producto. Para cada 
    producto que aparece en el carrito, habrá un botón Eliminar por si el usuario se arrepiente y quiere quitar un 
    producto concreto del carrito de la compra. A continuación se muestra una captura de pantalla de una posible 
    solución.
    -->

    <?php
    session_start();


    if (isset($_REQUEST['comprarTodo'])) {
        echo "<h1>Compra realizada, gracias!!</h1>";
        session_destroy();
        header("refresh: 3;");
    } else {

        $productos = [
            "JD001" => array("nombre" => "Jhon Deere 001", "precio" => 10599.99, "imgUrl" => "img/johndeere001.jfif"),
            "JD002" => array("nombre" => "Jhon Deere 002", "precio" => 11599.99, "imgUrl" => "img/johndeere002.jfif"),
            "JD003" => array("nombre" => "Jhon Deere 003", "precio" => 12599.99, "imgUrl" => "img/johndeere003.jfif")
        ];

        if (isset($_REQUEST['comprar'])) {
            $idTractor = $_REQUEST['comprar'];
            foreach ($productos as $key => $infoTractor) {
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

        echo "<h1>Productos</h1>";
        foreach ($productos as $key => $infoTractor) {
    ?>
            <form action="" method="post">
                <img src="<?= $infoTractor['imgUrl'] ?>" alt="Tractor">
                <h4>Nombre: <?= $infoTractor['nombre'] ?></h4>
                <h4>Precio: <?= $infoTractor['precio'] ?></h4>
                <input type="hidden" name="comprar" value="<?= $key ?>">
                <input type="submit" value="Comprar"><br><br>
            </form>
            <?php
        }

        if (isset($_SESSION['cesta'])) {
            echo "<h1>Carrito de la compra</h1>";
            $total = 0;
            foreach ($_SESSION['cesta'] as $keyCesta => $infoCesta) {
                $total += ($productos[$keyCesta]['precio'] *  $infoCesta);
            ?>
                <form action="" method="post">
                    <img src="<?= $productos[$keyCesta]['imgUrl'] ?>" alt="Tractor">
                    <h4>Nombre: <?= $productos[$keyCesta]['nombre'] ?></h4>
                    <h4>Precio: <?= ($productos[$keyCesta]['precio'] *  $infoCesta) ?></h4>
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