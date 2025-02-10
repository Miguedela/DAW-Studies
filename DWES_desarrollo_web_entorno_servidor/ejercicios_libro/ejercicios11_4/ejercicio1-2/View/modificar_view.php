<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>

    <form action="../Controller/modificar.php" method="post">
        Codigo:
        <input type="text" name="codigo" value="<?= $data['articulo']->getCodigo() ?>" readonly>
        <br>
        Título:</label>
        <input type="text" name="titulo" value="<?= $data['articulo']->getTitulo() ?>">
        <br>
        Fecha y Hora:
        <input type="text" name="fechaHora" value="<?= $data['articulo']->getFechaHora() ?>" readonly>
        <br>
        Contenido:
        <textarea name="contenido" cols="30" rows="10"><?= $data['articulo']->getContenido() ?></textarea>
        <br>
        <input type="submit" value="Modificar">
    </form>

</body>

</html>