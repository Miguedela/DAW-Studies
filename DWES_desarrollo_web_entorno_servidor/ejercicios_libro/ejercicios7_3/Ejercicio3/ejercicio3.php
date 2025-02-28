<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
    <!--
    Escribe un programa que permita ir introduciendo una serie indeterminada de números mientras su suma no 
    supere  el  valor  10000.  Cuando  esto  último  ocurra,  se  debe  mostrar  el  total  acumulado,  el  contador  de  los 
    números introducidos y la media. Utiliza sesiones.
    -->
    <?php
    session_start();

    if (isset($_REQUEST['numero'])) {
        $_SESSION['contador']++;
        $_SESSION['maximo'] += $_REQUEST['numero'];
        $aux = $_SESSION['maximo'];
        echo "<h1>Llevas $aux </h1>";

        if ($_SESSION['maximo'] > 10000) {
            $maximo = $_SESSION['maximo'];
            $contador = $_SESSION['contador'];
            $media = $_SESSION['maximo'] / $_SESSION['contador'];
            echo "<h1>El total acumulado es $maximo</h1>";
            echo "<h1>La cantidad de números introducidos es $contador</h1>";
            echo "<h1>La media es $media</h1>";

            session_destroy();
            header("refresh: 6;");
        }
    } else {
        $_SESSION['maximo'] = 0;
        $_SESSION['contador'] = 0;
    }
    ?>
    <h2>Sumatorio de 10000</h2>
    <form action="" method="post">
        Añade un número<input type="number" name="numero"><br>
        <input type="submit" value="Añadir">
    </form>
</body>

</html>