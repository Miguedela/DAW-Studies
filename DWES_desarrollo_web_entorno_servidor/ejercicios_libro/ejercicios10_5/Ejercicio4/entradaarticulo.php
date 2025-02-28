<?php
if (!isset($_REQUEST['entradaArticulo'])) {
    header("Location: index.php");
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

    <form action="#" method="post">
        Stock:
        <input type="number" name="stock" required>
        <input type="hidden" name="codigo" value="<?= $_REQUEST['codigo'] ?>">
        <input type="hidden" name="realizarModificacion">
        <input type="submit" value="Agregar">
    </form>

</body>

</html>