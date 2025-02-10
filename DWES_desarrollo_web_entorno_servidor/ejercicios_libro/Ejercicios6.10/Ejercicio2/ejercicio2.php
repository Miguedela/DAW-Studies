<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Formato de Hora</title>
</head>

<body>
    <h2>Introduce la hora</h2>
    <form action="" method="post">
        Horas: <input type="number" name="horas" min="0" max="23" required><br>
        Minutos: <input type="number" name="minutos" min="0" max="59" required><br>
        <h3>Elige el formato de la hora</h3>
        <select name="formato" required>
            <option value="H:i">HH:MM (24 horas)</option>
            <option value="h:i A">HH:MM (12 horas)</option>
        </select><br>
        <input type="submit" value="Enviar">
    </form>

    <?php
    if (isset($_REQUEST['horas']) && isset($_REQUEST['minutos'])) {
        $horas = $_REQUEST['horas'];
        $minutos = $_REQUEST['minutos'];
        $formato = $_REQUEST['formato'];

        // Validar que las horas y minutos están dentro del rango correcto
        if (comprobarHora($horas, $minutos)) {
            // Crear la hora en formato Unix y dar formato
            $hora = date($formato, strtotime("$horas:$minutos"));
            echo "<p>Hora en formato seleccionado: $hora</p>";
        } else {
            echo "<p>La hora introducida no es válida. Por favor, revisa los valores.</p>";
        }
    }
    ?>
</body>

</html>

<?php
function comprobarHora($horas, $minutos)
{
    if ($horas >= 0 && $horas <= 23 && $minutos >= 0 && $minutos <= 59) {
        return true;
    } else {
        return false;
    }
}
?>