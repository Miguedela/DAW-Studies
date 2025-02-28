<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
    <!--
    Pedir una fecha en un formulario con un input de fecha y mostrar a que día de la semana 
    corresponde (en español). 
    -->
    <h2>Introduce la fecha</h2>
    <form action="" method="post">
        <input type="date" name="fecha"><br>
        <input type="submit" value="Enviar">
    </form>
    <?php
    if (isset($_REQUEST['fecha'])) {
        $fecha = $_REQUEST['fecha'];
        $_SESSION['dias_semana'] = ["Domingo", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado"];
        
        $fechaTime = strtotime($fecha);

        $diaSemana = date("w", $fechaTime);

        echo "El día de la semana es: " . $_SESSION['dias_semana'][$diaSemana];
    }
    ?>
</body>

</html>