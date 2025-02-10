<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="../View/css/ejercicio3formularios.css" />
</head>

<body>
    <div class="container">
        <h2>Añadir Producto</h2>
        <form action="../Controller/agregar_usuario_controller.php" method="post">
            <input type="hidden" name="registrarUsuario">
            Codigo (agrega numeros/letras aleatorios/as): <input type="text" name="codigo" value="usr" required><br>
            Nombre: <input type="text" name="nombre" required><br>
            Correo: <input type="email" name="correo" required><br>
            Telefono: <input type="numbers" name="telefono" required><br>
            Contrasenia: <input type="password" name="contrasenia" required></input><br>
            <input type="submit" value="Añadir">
        </form>
    </div>
</body>

</html>