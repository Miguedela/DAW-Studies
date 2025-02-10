<!--
Crea un servicio web para pasar de euros a pesetas y de pesetas a euros. Si se pasa por la URL una cantidad en 
euros, el programa lo debe convertir en pesetas y viceversa. 
-->
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
    <?php
    if (isset($_REQUEST['pesetas']) || isset(($_REQUEST['euros']))) {
        if (isset($_REQUEST['pesetas'])) {
            $datos = @file_get_contents('http://localhost//DWES/trimestre2/tareas/EjerciciosLibro/ejercicios12_7/ejercicio1/calcular_cambio.php?pesetas=' . $_REQUEST['pesetas']);

            if ($datos !== false) {
                $conversion = json_decode($datos);

                echo "<h3>Datos sueltos: </h3>";
                echo "Datos introducidos: " . $conversion->entrada . "pts.<br>";
                echo "Conversion: " . $conversion->salida . "€.<br>";
                echo "<hr>";
            } else {
                echo "No se ha recibido datos.";
            }
        } else if (isset($_REQUEST['euros'])) {
            $datos = @file_get_contents('http://localhost//DWES/trimestre2/tareas/EjerciciosLibro/ejercicios12_7/ejercicio1/calcular_cambio.php?euros=' . $_REQUEST['euros']);

            if ($datos !== false) {
                $conversion = json_decode($datos);

                echo "<h3>Datos sueltos: </h3>";
                echo "Datos introducidos: " . $conversion->entrada . "€.<br>";
                echo "Conversion: " . $conversion->salida . "pts.<br>";
                echo "<hr>";
            } else {
                echo "No se ha recibido datos.";
            }
        }
    }
    ?>

    <!-- Formulario de pesetas a euros -->
    <h1>Cambio de pesetas a euros</h1>
    <hr>
    <form action="#" method="post">

        <label for="pesetas"></label>
        <input type="number" name="pesetas" id="pesetas">
        <input type="submit" value="Calcular">

    </form>

    <!-- Formulario de euros a pesetas -->
    <h1>Cambio de euros a pesetas</h1>
    <hr>
    <form action="#" method="post">

        <label for="euros"></label>
        <input type="number" name="euros" id="euros">
        <input type="submit" value="Calcular">

    </form>

</body>

</html>