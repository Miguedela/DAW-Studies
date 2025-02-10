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

    if (isset($_REQUEST['nombreUsuario'])) {
        $_SESSION['nombreUsuario'] = $_REQUEST['nombreUsuario'];
        $_SESSION['contraseniaUsuario'] = $_REQUEST['contraseniaUsuario'];
    }

    if (
        isset($_SESSION['nombreUsuario']) && isset($_SESSION['contraseniaUsuario']) &&
        ($_SESSION['nombreUsuario'] == "root" && $_SESSION['contraseniaUsuario'] == "root")
    ) {
        header("Location: ejercicio4redirection.php");
    }
    ?>
    <h2>Introduce tu nombre de usuario (root, root)</h2>
    <form action="" method="post">
        Nombre de usuario: <input type="text" name="nombreUsuario"><br>
        Contraseña de usuario: <input type="text" name="contraseniaUsuario"><br>
        <input type="submit" value="Logear">
    </form>
</body>

</html>