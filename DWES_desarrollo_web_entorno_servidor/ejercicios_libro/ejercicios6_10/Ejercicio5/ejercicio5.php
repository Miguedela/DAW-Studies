<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
    <!--
    Pedir un día de la semana en un formulario, seleccionándolo desde una lista desplegable. 
    Mostrar la fecha correspondiente al próximo día de la semana elegido por el usuario. 
    -->
    <h3>Elige el día de la semana</h3>
    <form action="" method="post">
        <select name="diaSemana" required>
            <option value="monday">Lunes</option>
            <option value="tuesday">Martes</option>
            <option value="wednesday">Miércoles</option>
            <option value="thursday">Jueves</option>
            <option value="friday">Viernes</option>
            <option value="saturday">Sábado</option>
            <option value="sunday">Domingo</option>
        </select><br>
        <input type="submit" value="Enviar">
    </form>

    <?php
    if (isset($_REQUEST['diaSemana'])) {
        $diaSemana = $_REQUEST['diaSemana'];

        $fechaActual = date("d-m-Y", time());
        $proximoDia = date("d-m-Y", strtotime("next $diaSemana", strtotime($fechaActual)));


        echo "<p>El próximo $diaSemana será: $proximoDia</p>";
    }
    ?>
</body>

</html>