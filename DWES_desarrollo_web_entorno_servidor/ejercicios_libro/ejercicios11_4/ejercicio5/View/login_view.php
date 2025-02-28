<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="../View/css/ejercicio3login.css" />
</head>

<body>
    <div class="container">
        <form action="../Controller/administrarweb_controller.php" method="post">
            <input type="hidden" name="logear">
            Nombre de usuario: <input type="text" name="nombreUsuario"><br>
            Contraseña: <input type="text" name="contrasenia"><br>
            <input type="submit" value="Login">
        </form>
    </div>
</body>

</html>