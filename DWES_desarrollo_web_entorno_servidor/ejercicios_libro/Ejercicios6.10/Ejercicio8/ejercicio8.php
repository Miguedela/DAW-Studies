<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
    <!--
    Pedir la fecha de nacimiento y el nombre de dos personas y mostrar la edad de cada una, así 
    como el nombre de la persona mayor.
    -->
    <form action="" method="post">
        Nombre persona1: <input type="text" name="nombrePersona1">
        Nacimiento persona1: <input type="date" name="fechaNacimiento1"><br>
        Nombre persona2: <input type="text" name="nombrePersona2">
        Nacimiento persona2: <input type="date" name="fechaNacimiento2"><br>
        <input type="submit" value="Enviar">
    </form>

    <?php
    if (isset($_REQUEST['nombrePersona1'])) {
        $nombrePersona1 = $_REQUEST['nombrePersona1'];
        $fechaNacimiento1 = $_REQUEST['fechaNacimiento1'];
        $nombrePersona2 = $_REQUEST['nombrePersona2'];
        $fechaNacimiento2 = $_REQUEST['fechaNacimiento2'];

        $fechaActual = time();
        $nacimientoPersona1 = strtotime($fechaNacimiento1);
        $nacimientoPersona2 = strtotime($fechaNacimiento2);

        $diferenciaPersona1 = $fechaActual - $nacimientoPersona1;
        $diferenciaPersona2 = $fechaActual - $nacimientoPersona2;

        $edadPersona1 = $diferenciaPersona1 / (60 * 60 * 24 * 365.25);
        $edadPersona2 = $diferenciaPersona2 / (60 * 60 * 24 * 365.25);

        if ($edadPersona1 > $edadPersona2) {
            echo "<p>$nombrePersona1 es mayor que $nombrePersona2</p>";
            echo "<p>$nombrePersona1:" . floor($edadPersona1) . "</p>";
            echo "<p>$nombrePersona2:" . floor($edadPersona2) . "</p>";
        } else {
            echo "<p>$nombrePersona2 es mayor que $nombrePersona1</p>";
            echo "<p>$nombrePersona2:" . floor($edadPersona2) . "</p>";
            echo "<p>$nombrePersona1:" . floor($edadPersona1) . "</p>";
        }
    }
    ?>
</body>

</html>