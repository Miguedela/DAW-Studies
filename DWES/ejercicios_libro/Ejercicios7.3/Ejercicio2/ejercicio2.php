<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
    <!--
    Realiza  un  programa  que  vaya  pidiendo  números  hasta  que  se  introduzca  un  numero  negativo  y  nos  diga 
    cuantos números se han introducido, la media de los impares y el mayor de los pares. El número negativo sólo 
    se utiliza para indicar el final de la introducción de datos pero no se incluye en el cómputo. Utiliza sesiones. 
    -->
    <?php
    session_start();

    if (isset($_REQUEST['numero'])) {
        if ($_REQUEST['numero'] < 0) {
            $mediaPares = $_SESSION['acumuladorPares'] / $_SESSION['contadorPares'];
            $mediaImpares = $_SESSION['acumuladorImpares'] / $_SESSION['contadorImpares'];
            echo "<h1>La media de los números pares es $mediaPares</h1>";
            echo "<h1>La media de los números impares es $mediaImpares</h1>";

            session_destroy();
            header("refresh: 3;");
        } else {
            if ($_REQUEST['numero'] % 2 == 0) {
                if ($_REQUEST['numero'] > $_SESSION['acumuladorPares']) {
                    $_SESSION['acumuladorPares'] = $_REQUEST['numero'];
                }
                $_SESSION['contadorPares']++;
            } else {
                $_SESSION['acumuladorImpares'] += $_REQUEST['numero'];
                $_SESSION['contadorImpares']++;
            }
        }
    } else {
        $_SESSION['acumuladorPares'] = 0;
        $_SESSION['contadorPares'] = 0;
        $_SESSION['acumuladorImpares'] = 0;
        $_SESSION['contadorImpares'] = 0;
    }
    ?>
    <h2>Calculo de media para pares e impares</h2>
    <form action="" method="post">
        Añade un número<input type="number" name="numero"><br>
        <input type="submit" value="Añadir">
    </form>
</body>

</html>