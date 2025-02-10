<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        body {
            background-color: #f4f4f4;
        }
    </style>
</head>

<body>
    <!--
    Crea un formulario donde el usuario introduce una fecha a través de 3 cajas de texto, si no es 
    correcta se debe indicar en un mensaje; si es correcta se debe mostrar en el formato elegido. 
    Crea una lista desplegable con todas las posibilidades de formato que se te ocurran.
    -->
    <h2>Introduce la fecha</h2>
    <form action="" method="post">
        Día: <input type="number" name="dia" required><br>
        Mes: <input type="number" name="mes" required><br>
        Año: <input type="number" name="ano" required><br>
        <h3>Elige el formato de la fecha</h3>
        <select name="formato" required>
            <option value="d-m-Y">DD-MM-YYYY</option>
            <option value="d-m-y">DD-MM-YY</option>
            <option value="m-d-Y">MM-DD-YYYY</option>
            <option value="Y-m-d">YYYY-MM-DD</option>
        </select><br>
        <input type="submit" value="Enviar">
    </form>
    <?php
    if (isset($_REQUEST['dia'])) {
        $dia = $_REQUEST['dia'];
        $mes = $_REQUEST['mes'];
        $ano = $_REQUEST['ano'];
        $formato = $_REQUEST['formato'];

        // Validar la fecha
        if (checkdate($mes, $dia, $ano)) {
            // Crear la fecha con mktime y dar formato
            $fecha = date($formato, strtotime("$mes-$dia-$ano"));
            echo "<p>Fecha en formato seleccionado: $fecha</p>";
        } else {
            echo "<p>La fecha introducida no es válida. Por favor, revisa los valores.</p>";
        }
    }
    ?>
</body>

</html>