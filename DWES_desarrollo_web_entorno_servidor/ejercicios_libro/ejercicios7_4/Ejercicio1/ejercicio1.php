<!--
Crear  una  página  principal  con  un  botón  'Añadir  color'  para  generar  un  color  aleatorio  que  además  se 
establecerá como color de fondo de la página, cada vez que se pulsa irá generando un color nuevo (actualizando 
el fondo), que se irán almacenando en un array de sesión. Habrá un segundo botón 'Mostrar paleta creada' que 
dirige a una segunda página que mostrará una paleta con los colores generados. Esta paleta no es más que una 
tabla con un máximo de 5 celdas por cada fila, y en cada celda se muestra un color de los generados. Debajo 
de la tabla tendremos 2 botones uno para volver a la página principal y seguir añadiendo colores a la paleta y 
otro para destruir la sesión y generar una paleta nueva. Además al pulsar en cada celda de la tabla el color de 
fondo de la página cambiará al color de la celda pulsada.
-->
<?php
session_start();

// if para eliminar la session en caso de que se requiera
if (isset($_REQUEST['eliminarSession'])) {
    unset($_SESSION['paletaColores']);
    session_destroy();
}

// if para asignar el fondo de color
if (isset($_SESSION['paletaColores']) && !isset($_REQUEST['colorElegido'])) {
    $color = $_SESSION['paletaColores'][count($_SESSION['paletaColores']) - 1];
} else if (isset($_SESSION['paletaColores']) && isset($_REQUEST['colorElegido'])) {
    $color = $_REQUEST['colorElegido'];
} else {
    $color = "#f4f4f4";
}
?>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        body {
            background-color: <?= $color ?>;
        }
    </style>
</head>

<body>
    <?php
    // if (isset($_SESSION['paletaColores'])) {
    //     var_dump($_SESSION['paletaColores']);
    // }
    ?>
    <!-- Formulario para crear nuevo color -->
    <h2>Generar nuevo color de fondo</h2>
    <form action="ejercicio1crearcolor.php" merthod="post">
        <input type="hidden" name="generarColor">
        <input type="submit" value="Generar nuevo color">
    </form>

    <!-- Formulario para ver la paleta de colores -->
    <h2>Ver la paleta de colores generada</h2>
    <form action="ejercicio1mostrarpaleta.php" merthod="post">
        <input type="hidden" name="mostrarPaleta" value="<?= $color ?>">
        <input type="submit" value="Ver paleta de colores">
    </form>
</body>

</html>