<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>

    <h2>Busca el tiempo:</h2>
    <form action="" method="post">
        <label for="ciudad">Ciudad:
            <input type="text" name="ciudad" id="ciudad">
        </label>
    </form>

    <?php
    if (isset($_REQUEST['ciudad'])) {
        $datos = file_get_contents('http://api.openweathermap.org/data/2.5/weather?q=' . $_REQUEST['ciudad'] . ',Spain&units=metric&appid=8f4a52ac9f07e6666bd5a4a54600b96b');

        // echo "<h3>Datos en bruto (en formato JSON): </h3>$datos<hr>";

        if ($datos !== false) {
            $tiempo = json_decode($datos);

            // echo "<h3>Datos en un objeto: </h3>";
            // print_r($tiempo);

            echo "<hr>";
            echo "<h3>Datos sueltos: </h3>";
            echo "Temperatura: " . $tiempo->main->temp . "ºC<br>";
            echo "Humedad: " . $tiempo->main->humidity . "%<br>";
            echo "Presión: " . $tiempo->main->pressure . "mb<br>";
        } else {
            echo "No se ha recibido datos.";
        }
    }
    ?>

</body>

</html>