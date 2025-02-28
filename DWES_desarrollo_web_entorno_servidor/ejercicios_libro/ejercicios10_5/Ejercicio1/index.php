<?php
if (session_status() == PHP_SESSION_NONE) session_start();
?>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
    <?php
    // Conexión a la base de datos  
    try {
        $conexion = new PDO("mysql:host=localhost;dbname=banco;charset=utf8", "root", "");
    } catch (PDOException $e) {
        echo "No se ha podido establecer conexión con el servidor de bases de datos.<br>";

        die("Error: " . $e->getMessage());
    }
    $consulta = $conexion->query("SELECT dni, nombre, direccion, telefono FROM cliente");
    ?>
    <table border="1">
        <tr>
            <th>DNI</th>
            <th>Nombre</th>
            <th>Dirección</th>
            <th>Teléfono</th>
            <th>Eliminar</th>
            <th>Modificar</th>
        </tr>
        <?php
        while ($cliente = $consulta->fetchObject()) {
        ?>
            <tr>
                <td><?= $cliente->dni ?></td>
                <td><?= $cliente->nombre ?></td>
                <td><?= $cliente->direccion ?></td>
                <td><?= $cliente->telefono ?></td>
                <td>
                    <form action="eliminarcliente.php" method="post">
                        <input type="hidden" name="eliminarCliente" value="<?= $cliente->dni ?>">
                        <input type="submit" value="Eliminar">
                    </form>
                </td>

                <td>
                    <form action="modificarcliente.php" method="post">
                        <input type="hidden" name="modificarCliente">
                        <input type="hidden" name="dni" value="<?= $cliente->dni ?>">
                        <input type="hidden" name="nombre" value="<?= $cliente->nombre ?>">
                        <input type="hidden" name="direccion" value="<?= $cliente->direccion ?>">
                        <input type="hidden" name="telefono" value="<?= $cliente->telefono ?>">
                        <input type="submit" value="Modificar">
                    </form>
                </td>
            </tr>
        <?php
        }
        ?>
        <tr>
            <th colspan="6" style="text-align: center;">Número de clientes: <?= $consulta->rowCount() ?></th>
        </tr>
    </table>
    <br>
    <!-- cerramos la conexión a la BD -->
    <?php $conexion = null; ?>

    <form action="insertcliente.php" method="post">
        <h1>Formulario para añadir a un cliente</h1>

        <label for="dni">DNI:
            <input type="text" name="dni" minlength="9" maxlength="9" required>
        </label>
        <br><br>

        <label for="nombre">Nombre:
            <input type="text" name="nombre" maxlength="30" required>
        </label>
        <br><br>

        <label for="direccion">Direccion:
            <input type="text" name="direccion" maxlength="100" required>
        </label>
        <br><br>

        <label for="telefono">Teléfono:
            <input type="text" name="telefono" minlength="9" maxlength="9" required>
        </label>
        <br><br>

        <input type="hidden" name="agregarCliente">

        <input type="submit" value="Agregar cliente">
    </form>
</body>

</html>