<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
    <!--
    Mostrar el día de la semana que correspondería, una vez transcurridos un número de años, 
    meses, y días elegidos por el usuario, a partir de la fecha actual.
    -->
    <form action="" method="post">
        Día: <input type="number" name="dia"><br>
        Mes: <input type="number" name="mes"><br>
        Año: <input type="number" name="ano"><br>
        <input type="submit" value="Enviar">
    </form>
    <?php
    if (isset($_REQUEST['dia'])) {
        $dia = (int) $_REQUEST['dia'];
        $mes = (int) $_REQUEST['mes'];
        $ano = (int) $_REQUEST['ano'];

        $fechaActual = date("d-m-Y", time());

        $fechaModificada = date("d-m-Y", strtotime($fechaActual . "+ $ano year + $mes month + $dia days"));

        echo "<p>La fecha será: " . $fechaModificada . "</p>";
    }
    ?>
</body>

</html>