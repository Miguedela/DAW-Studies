<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>

    <div class="container">

        <h1>Inicie Sesión o Registre un usuario nuevo</h1>
        <form action="../Controller/redirect_controller.php" method="post">
            <label for="usuario">Usuario: </label>
            <input type="text" name="usuario" id="usuario">

            <input type="submit" value="ACCESO USUARIO" name="acceso">
            <input type="submit" value="REGISTRO USUARIO" name="registro">
        </form>

        <?php
        if (isset($mensajeError)) {
            echo "<h1 style='color: red;'>" . $_SESSION['mensajeError'] . "</h1>";
        }
        ?>

    </div>

</body>

</html>