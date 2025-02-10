<?php
if (session_status() == PHP_SESSION_NONE) session_start();

if (!isset($_REQUEST['registrarCuenta'])) {
    header("Location: login.php");
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
    <h1>REGISTRO DE UNA NUEVA CUENTA DE USUARIO</h1>
    <h3>Introduzca los datos para registrar la cuenta</h3>
    <form action="registrarcuenta.php" method="post">
        USUARIO: <input type="text" name="nombreUsuario">
        <br><br>
        CONTRASEÑA: <input type="password" name="contraseniaUsuario">
        <br><br>
        <input type="hidden" name="registrarCuenta">
        <input type="submit" value="ACEPTAR">
    </form>
</body>

</html>