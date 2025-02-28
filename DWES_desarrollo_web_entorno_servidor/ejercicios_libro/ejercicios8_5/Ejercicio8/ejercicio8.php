<!--
Crear una página que permita generar un archivo de texto con las líneas que se vayan escribiendo a través de un 
formulario de manera indefinida, hasta que se pulse un botón terminar, y a continuación mostrar el contenido del 
fichero completo en la página
-->
<?php
include '../funciones.php';

$ruta = 'ejercicio8.txt';

if (isset($_REQUEST['linea'])) {
    escribirEnFichero($ruta, $_REQUEST['linea']);
} else if (isset($_REQUEST['leer'])) {
    leerContenidoFichero($ruta);
}
?>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
    <?php
    if (!isset($_REQUEST['leer'])) {
    ?>
        <form action="" method="post">
            <input type="text" name="linea"><br>
            <input type="submit" value="Escribir en el fichero">
        </form>
        <form action="" method="post">
            <input type="hidden" name="leer"><br>
            <input type="submit" value="Terminar">
        </form>
    <?php
    }
    ?>
</body>

</html>