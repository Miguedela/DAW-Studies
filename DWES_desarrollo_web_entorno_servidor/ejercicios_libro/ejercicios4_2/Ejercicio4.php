<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
    <?php
    $horasTrabajadas = $_GET['horasTrabajadas'];
    $sueldo = 0;

    if ($horasTrabajadas > 40) {
        $sueldo = ($horasTrabajadas - 40) * 16 + (40 * 12);
    } else {
        $sueldo *= 12;
    }

    echo "El sueldo del empleado es: ", $sueldo, " debido a que ha trabajado ", $horasTrabajadas, " horas.";
    ?>
</body>

</html>