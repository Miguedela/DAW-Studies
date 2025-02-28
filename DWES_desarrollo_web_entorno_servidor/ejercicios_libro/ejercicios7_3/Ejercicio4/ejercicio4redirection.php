<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
    <!--
    Establece un control de acceso mediante nombre de usuario y contraseña para  el ejercicio 1 de esta relación. 
    Realiza una nueva versión del ejercicio1, de modo que si lo cargamos sin la sesión iniciada nos redirija a la 
    página  de  login,  y  en  caso  contrario  muestre  el  ejercicio  normalmente,  también  debemos  incluir  un  botón 
    “cerrar sesión” para cerrar la sesión del usuario y volver a la página de login.  
    Al cargar la página de login, si la sesión está iniciada redirige automáticamente a la página del ejercicio1 y si 
    no, mostrará el formulario de identificación con usuario y contraseña.
    -->
    <?php
    session_start();

    if (!isset($_SESSION['nombreUsuario'])) {
        header("Location: ejercicio4.php");
    }
    
    if (isset($_REQUEST['cerrarSesion'])) {
        session_destroy();
        header("refresh: 0;");
    }

    if (isset($_REQUEST['numero'])) {
        if ($_REQUEST['numero'] < 0) {
            $media = $_SESSION['acumulador'] / $_SESSION['contador'];
            echo "<h1>La media es $media</h1>";

            $_SESSION['acumulador'] = 0;
            $_SESSION['contador'] = 0;
            header("refresh: 3;");
        } else {
            $_SESSION['acumulador'] += $_REQUEST['numero'];
            $_SESSION['contador']++;
        }
    } else {
        $_SESSION['acumulador'] = 0;
        $_SESSION['contador'] = 0;
    }
    ?>
    <h2>Calculo de media</h2>
    <form action="" method="post">
        Añade un número<input type="number" name="numero">
        <input type="submit" value="Añadir"><br>
    </form>
    <form action="" method="post">
        <input type="hidden" name="cerrarSesion">
        <input type="submit" value="Cerrar sesión">
    </form>
</body>

</html>