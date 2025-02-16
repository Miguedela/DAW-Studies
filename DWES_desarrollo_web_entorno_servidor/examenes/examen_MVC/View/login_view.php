<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        .container {
            width: 40%;
            height: 20vh;
            margin: 0 auto;
            padding: 4rem 4rem;
            box-shadow: 2px 2px 10px #222;
            border-radius: 10px;
            border: 1px solid black;
            margin: 0 auto;

            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
        }
    </style>
</head>

<body>

    <div class="container">

        <h3>Introduce un usuario para entrar en la aplicación</h3>
        <form action="../Controller/redirect_controller.php" method="post">
            <input type="hidden" name="accederCuenta">

            <label for="nombreUsuario">Entrar: </label>
            <input type="text" name="nombreUsuario" id="nombreUsuario">

            <input type="submit" value="ENTRAR">
        </form>

    </div>

</body>

</html>