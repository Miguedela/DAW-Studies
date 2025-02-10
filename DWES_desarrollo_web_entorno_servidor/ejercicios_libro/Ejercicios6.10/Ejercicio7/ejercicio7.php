<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
    <!--
    Pedir al usuario su fecha de nacimiento y una fecha futura, y mostrar la edad que tendrá en esa 
    fecha (un año tiene 60*60*24*365.25 segundos)
    -->
    <h2>Introduce las fecha</h2>
    <form action="" method="post">
        Nacimiento: <input type="date" name="fechaNacimiento"><br>
        Fecha futura: <input type="date" name="fechaFutura"><br>
        <input type="submit" value="Enviar">
    </form>

    <?php
    if (isset($_REQUEST['fechaNacimiento'])) {
        $fechaNacimiento = $_REQUEST['fechaNacimiento'];
        $fechaFutura = $_REQUEST['fechaFutura'];

        $nacimiento = strtotime($fechaNacimiento);
        $futura = strtotime($fechaFutura);

        $diferencia = $futura - $nacimiento;

        $edad = $diferencia / (60 * 60 * 24 * 365.25);

        echo "Tendrás: " . floor($edad) . "años.";
    }
    ?>
</body>

</html>