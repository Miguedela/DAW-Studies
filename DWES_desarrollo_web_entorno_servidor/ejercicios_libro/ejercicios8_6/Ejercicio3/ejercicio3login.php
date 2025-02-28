<?php
session_start();

if (!isset($_REQUEST['logear'])) {
    header('Location: ejercicio3.php');
}
?>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="css/ejercicio3login.css" />
</head>

<body>
    <div class="container">
        <form action="ejercicio3administrarvista.php" method="post">
            Nombre de usuario: <input type="text" name="nombreUsuario"><br>
            Contraseña: <input type="text" name="contrasenia"><br>
            <input type="hidden" name="logear">
            <input type="submit" value="Login">
        </form>
    </div>
</body>

</html>