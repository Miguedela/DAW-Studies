<!--
Una función (tipo procedimiento, no hay valor devuelto) denominada escribirTresNumeros que reciba tres números 
enteros como parámetros y proceda a escribir dichos números en tres líneas en un archivo denominado 
datosEjercicio.txt. Si el archivo no existe, debe crearlo
-->
<?php
include '../funciones.php';

$ruta = 'ejercicio1.txt';

if (isset($_REQUEST['verArchivo'])) {
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
    <form action="ejercicio1escribirfichero.php" method="post">
        <?php
        for ($i = 0; $i < 3; $i++) {
        ?>
            Número<?= $i ?>: <input type="number" name="numeros[]"><br>
        <?php
        }
        ?>
        <input type="submit" value="Escribir números en el fichero">
    </form>
</body>

</html>