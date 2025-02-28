<!--
Crear una página que simula una  encuesta.  Se  realizará una  pregunta, con dos botones para  responder, cada 
vez que se pulse un botón se irán contabilizando (usa sesiones) los votos y actualizando una barra que muestre 
el número de votos de cada respuesta. Este resultado se irá almacenando también en una cookie, de manera que 
si se cierra el navegador, al abrir la página de nuevo se mostrarán los resultados hasta el momento en que se 
cerró. Crear la cookie para 3 meses.
-->
<?php
session_start();

if (isset($_REQUEST['restaurarVotos'])) {
    unset($_SESSION['si']);
    unset($_SESSION['no']);
    setcookie("si", "", -1);
    setcookie("no", "", -1);
    session_destroy();
    header("refresh: 0;");
}

if (isset($_COOKIE['si'])) {
    $_SESSION['si'] = $_COOKIE['si'];
}

if (isset($_COOKIE['no'])) {
    $_SESSION['no'] = $_COOKIE['no'];
}

// if (isset($_SESSION['si'])) {
//     var_dump($_SESSION['si']);
// }
// if (isset($_SESSION['no'])) {
//     var_dump($_SESSION['no']);
// }
?>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        img {
            height: 15px;
            width: 15px;
        }

        p {
            font-size: 20px;
            display: inline;
        }
    </style>
</head>

<body>
    <!-- Mostrar datos de los votos por pantalla -->
    <h2>¿Él actual presidente del gobierno de España, es merecedor de su puesto?</h2>
    <?php
    echo "<p>Sí: </p>";
    if (isset($_SESSION['si'])) {
        for ($i = 0; $i < $_SESSION['si']; $i++) {
    ?>
            <img src="img/verde.png" alt="">
        <?php
        }
    }
    echo "<br><p>No: </p>";
    if (isset($_SESSION['no'])) {
        for ($i = 0; $i < $_SESSION['no']; $i++) {
        ?>
            <img src="img/rojo.png" alt="">
    <?php
        }
    }
    ?>

    <!-- Formulario de afirmacion -->
    <form action="ejercicio2sumarvoto.php" method="post">
        <input type="hidden" name="si">
        <input type="submit" value="Sí">
    </form>

    <!-- Formulario de negación -->
    <form action="ejercicio2sumarvoto.php" method="post">
        <input type="hidden" name="no">
        <input type="submit" value="No">
    </form>

    <!-- Formulario de reseteo de cookies -->
    <h2>Restaurar votos</h2>
    <form action="" method="post">
        <input type="hidden" name="restaurarVotos">
        <input type="submit" value="Restaurar">
    </form>
</body>

</html>