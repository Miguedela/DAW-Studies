<?php
if (!isset($_REQUEST['insertarArticulo'])) {
    header('Location: index_view.php');
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

    <form action="../Controller/insertar.php" method="post">
        <label for="titulo">Título:</label>
        <input type="text" name="titulo" id="titulo" required>
        <br>
        <label for="contenido">Contenido:</label>
        <textarea name="contenido" id="contenido" cols="30" rows="10" required></textarea>
        <br>
        <input type="submit" value="Insertar">
    </form>

</body>

</html>