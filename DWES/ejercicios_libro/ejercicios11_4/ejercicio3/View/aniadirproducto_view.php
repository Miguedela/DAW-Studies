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
        <form action="../Controller/aniadirproductocatalogo_controller.php" method="POST" enctype="multipart/form-data">
            Nombre: <input type="text" name="nombre" required><br>
            Precio: <input type="number" name="precio" required><br>
            Imagen: <input type="file" name="imagen" required><br>
            Detalles del producto:<br>
            <textarea name="detallesProducto" required></textarea><br>
            Stock: <input type="number" name="stock" required></input><br>
            <input type="hidden" name="agregarProcutoCatalogo" value="true">
            <input type="submit" value="Añadir">
        </form>
    </div>
</body>

</html>