<!--
Amplía  el  ejercicio  6  de  tal  forma  que  los  productos  que  se  pueden  elegir  para  comprar,  se  almacenen  en 
cookies (solo los productos, no almacenar el contenido de la cesta). La aplicación debe ofrecer, por tanto, las 
opciones de alta, baja y modificación de productos.
Cuando no hay productos almacenados en la cookie, se toman los productos por defecto usados en el ejercicio 
6,  asignándolos  en  código  y  además  se  almacenan  en  la  cookie,  para  que  estén  disponibles  para  las  futuras 
cargas de la página. Por tanto cada vez que se cargue la página principal, se cargará una array en la sesión con 
todos los productos de la tienda recuperados de la cookie, y cada vez que se actualicen los productos en dicho 
array (alta, baja o modificación) también debe actualizarse la cookie para que dichos cambios estén disponibles 
en la siguiente carga de la página.
También debemos añadir un botón para inicializar los productos por defectos (los del ejercicio 6) deshaciendo 
todos los cambios realizados en los productos. Añadir un botón Administrar productos en la página principal, 
que lleve a una segunda página, donde se realizarán todas las operaciones de mantenimiento de los productos.
-->
<?php
session_start();

// If que elimina las cookies en caso de solicitarlo
if (isset($_REQUEST['elimarCookies'])) {
    setcookie("catalogo", "", -1);
    session_destroy();
    header("refresh: 0;");
}

// en caso de no tener el catalogo guradado en las cokies lo creo
if (!isset($_COOKIE['catalogo'])) {
    // creo el array de los productos
    $catalogo = [
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
    setcookie('catalogo', base64_encode(serialize($catalogo)), time() + 3600);
} else {
    $catalogo = unserialize(base64_decode($_COOKIE['catalogo']));
}

// elimino un producto de la session 'carrito'
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

if (isset($_REQUEST['comprarTodo'])) {
    echo "<h1>Compra realizada, gracias!!</h1>";
    setcookie("catalogo", "", -1);
    unset($catalogo);
    session_destroy();
    header("refresh: 3;");
}

if (isset($_REQUEST['comprar'])) {
    $key = $_REQUEST['comprar'];

    if (isset($_SESSION['cesta'][$key])) {
        $_SESSION['cesta'][$key]++;
    } else {
        $_SESSION['cesta'][$key] = 1;
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
        // formulario para acceder a administracion
        ?>
        <h1>Administrar catalogo:</h1>
        <form action="ejercicio9administrar.php" method="post">
            <input type="submit" value="Administrar productos">
        </form>
        <?php

        // Muestro los productos disponibles de la página
        echo "<h2>Productos</h2>";
        foreach ($catalogo as $key => $infoTractor) {
        ?>
            <h4>Nombre: <?= $infoTractor['nombre'] ?></h4>
            <img src="<?= $infoTractor['imgUrl'] ?>" alt="Tractor">
            <h4>Precio: <?= $infoTractor['precio'] ?></h4>
            <form action="" method="post">
                <input type="hidden" name="comprar" value="<?= $key ?>">
                <input type="submit" value="Comprar">
            </form>
            <form action="ejercicio9descripcion.php" method="post">
                <input type="hidden" name="detalles" value="<?= $key ?>">
                <input type="submit" value="Detalles"><br><br>
            </form>
        <?php
        }

        // formulario para acceder a la administracion del catalogo
        ?>
        <form action=""></form>
        <?php

        // if que se encarga de mostrar el carrito en caso de tener algo añadido
        if (isset($_SESSION['cesta'])) {
            echo "<h1>Carrito de la compra</h1>";
            $total = 0;
            foreach ($_SESSION['cesta'] as $keyCesta => $infoCesta) {
                $total += ($catalogo[$keyCesta]['precio'] * $infoCesta);
        ?>
                <form action="" method="post">
                    <h4>Nombre: <?= $catalogo[$keyCesta]['nombre'] ?></h4>
                    <img src="<?= $catalogo[$keyCesta]['imgUrl'] ?>" alt="Tractor">
                    <h4>Precio: <?= ($catalogo[$keyCesta]['precio'] *  $infoCesta) ?></h4>
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
        ?>
        <!-- Formulario para eliminar las cookies -->
        <h2 style="color: red;">RESETEAR cookies y ELIMINAR session</h2>
        <form action="" method="post">
            <input type="hidden" name="elimarCookies">
            <input type="submit" value="eliminar">
        </form>
    <?php
}
    ?>
    </body>

    </html>