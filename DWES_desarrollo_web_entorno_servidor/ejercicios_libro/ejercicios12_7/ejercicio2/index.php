<!--
Crea un servicio web que proporcione de forma aleatoria un mazo de cartas de la baraja española. Por la URL se 
pasa el número de cartas que se quiere obtener y la aplicación provee el palo y la figura de cada una de las cartas. 
Se supone que el mazo se obtiene de una baraja, por tanto, las cartas no se pueden repetir. Si el número que se pasa 
en la URL es menor que 1 o mayor que 40, se debe devolver un error.
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
    if (isset($_REQUEST['cantidadCartas'])) {
        $datos = @file_get_contents('http://localhost//DWES/trimestre2/tareas/EjerciciosLibro/ejercicios12_7/ejercicio2/devolver_cartas.php?cantidadCartas=' . $_REQUEST['cantidadCartas']);

        $barajaCartas = json_decode($datos);

        for ($i = 0; $i < count($barajaCartas->baraja); $i++) {
            echo ($i + 1) . ": " . $barajaCartas->baraja[$i] . "<br>";
        }
    }
    ?>

    <form action="#" method="post">
        <label for="cantidadCartas">Cantidad de cartas (1-40): </label>
        <input type="number" name="cantidadCartas" id="cantidadCartas">
        <input type="submit" value="Generar">
    </form>

</body>

</html>