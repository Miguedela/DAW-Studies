<!--
Crear una aplicación web para mantener un fichero mascotas.txt de los animales inscritos diariamente 
en una clínica veterinaria, con la siguiente estructura:

    #02-03-2019# 
    pepe-canario-2 
    luna-perro-4 
    duque-gato-6 
    #15-11-2019# 
    princesa-hamster-1 
    venus-perro-12 
    ... 
Al entrar en la aplicación, la fecha seleccionada automáticamente es la fecha actual, por lo que las 
mascotas son grabadas forzosamente en el día en que nos encontramos. 
Crear una página para añadir mascotas en un array de sesión donde la clave es el nombre de la mascota 
y el valor es otro array con los datos correspondientes al tipo de animal y su edad. Las mascotas que se 
van añadiendo se van mostrando en una tabla.  
Incluir un formulario para añadir los datos de una nueva mascota. 
Incluir un botón para grabar todas las mascotas añadidas en el fichero mascotas.txt, con la cabecera de 
la fecha actual tal como se ve en el ejemplo (el fichero debe mantener la información previa y añadir las 
líneas de las mascotas nuevas al final del mismo), limpiando la tabla de mascotas añadidas hasta ese 
momento. Si no se han añadido mascotas previamente ese mismo día habrá que incluir la cabecera con 
la fecha actual, pero en caso contrario solo hay que añadir las mascotas al final, sin duplicar la cabecera.
-->
<?php
session_start();

include('../funciones.php');

if (!isset($_SESSION['mascota'])) {
    $_SESSION['mascota'] = [];
}

if (isset($_REQUEST['aniadirMascota'])) {
    $_SESSION['mascota'][$_REQUEST['nombre']]["tipo"] = $_REQUEST['tipo'];
    $_SESSION['mascota'][$_REQUEST['nombre']]["edad"] = $_REQUEST['edad'];
}

if (isset($_REQUEST['guardar'])) {
    guardar();
    unset($_SESSION['mascota']);
}
?>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        tr,
        td,
        th,
        table {
            border: solid 1px black;
            text-align: center;
        }
    </style>
</head>

<body>
    <?php
    $hoy = date("d-m-Y");
    ?>
    <h2>Añadir animal a la lista</h2>
    <table>

        <form action="" method="post">
            <tr>
                <td colspan="3">Nombre: <input type="text" name="nombre"></td>
            </tr>
            <tr>
                <td colspan="3">Tipo: <input type="text" name="tipo"></td>
            </tr>
            <tr>
                <td colspan="3">Edad: <input type="number" name="edad"></td>
            </tr>

            <input type="hidden" name="aniadirMascota">

            <tr>
                <td colspan="3"><input type="submit" value="Añadir"></td>
            </tr>
        </form>
        </tr>

        <tr>
            <th colspan="3">#<?= $hoy ?>#</th>
        </tr>

        <tr>
            <th>Nombre</th>
            <th>Tipo</th>
            <th>Edad</th>
        </tr>

        <?php
        if (isset($_SESSION['mascota'])) {
            foreach ($_SESSION['mascota'] as $nombre => $datos) {
                echo "<tr>";
        ?>
                <td><?= $nombre ?></td>
                <td><?= $datos["tipo"] ?></td>
                <td><?= $datos["edad"] ?></td>
        <?php
            }
        }
        ?>
    </table>
    <form action="#" method="post">
        <input type="submit" value="Guardar">
        <input type="hidden" name="guardar">
    </form>
</body>

</html>