<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
    <!--
    Pedir una fecha en un formulario con un input de fecha y mostrarla en el formato “12 de Enero 
    de 2018” (en español).
    -->
    <h2>Introduce la fecha</h2>
    <form action="" method="post">
        <input type="date" name="fecha"><br>
        <input type="submit" value="Enviar">
    </form>
    <?php
    if (isset($_REQUEST['fecha'])) {
        $fecha = $_REQUEST['fecha'];
        $meses = [" ", "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"];

        $diaSemana = date("j", strtotime($fecha));
        $mes = date("m", strtotime($fecha));
        $ano = date("Y", strtotime($fecha));

        echo "Fecha introducida: " . $diaSemana . " de " . $meses[$mes] . " de " . $ano;
    }
    ?>
</body>

</html>