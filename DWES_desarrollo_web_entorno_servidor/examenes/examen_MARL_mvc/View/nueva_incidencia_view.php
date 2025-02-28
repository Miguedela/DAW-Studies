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
        <form action="registrar_incidencia_controller.php" method="post">
            <input type="hidden" name="agregarNuevaIncidencia">
            <input type="hidden" name="nombreProfesor" value="<?= $_SESSION['usuario'] ?>">
            <input type="hidden" name="estado" value="PENDIENTE">

            <label for="fecha">Fecha:</label>
            <input type="text" name="fecha" value="<?= date("d/m/Y") ?>" readonly><br>
            <label for="descripcion">Descripcion:</label>
            <textarea name="descripcion" id="descripcion"></textarea><br>

            <input type="submit" value="Añadir incidencia">
        </form>
    </div>

</body>

</html>