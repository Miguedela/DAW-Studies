<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <?php 
    $hora = $_GET['a'];
    echo "La conversion de pesetas a euros es: ", $hora / 166, "€.";
    ?>
</body>
</html>