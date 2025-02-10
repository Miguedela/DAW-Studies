<!--
Diseñar una página que muestre un cuadro ‘select’ con todas las fechas disponibles en el fichero del ejercicio 
anterior, de manera que al seleccionar y enviar una fecha, se cargue en un array de sesión las mascotas 
almacenadas en la fecha seleccionada y las muestre en una tabla.  

La opción de elegir una fecha siempre estará disponible para poder mostrar las mascotas de la fecha que interese, 
es decir que se puede ir cambiando de fecha y se actualizan los datos de la tabla. 

Nota: al leer una línea de un fichero se añaden espacios al principio o al final, así que para hacer comparaciones 
debes asegurarte de quitar esos espacios.
-->
<?php
session_start();

include('../funciones.php');

if (isset($_REQUEST['fecha'])) {
    $_SESSION['mascotas'] = obtenerMascotas($_REQUEST['fecha']);
}

$fechas = obtenerFechas();
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
    <form action="#" method="post">
        <select name="fecha">
            <?php
            foreach ($fechas as $key => $value) {
            ?>
                <option value="<?= $value ?>"><?= $value ?></option>
            <?php
            }
            ?>
            <input type="submit" value="Mostrar">
        </select>
    </form>

    <table>
        <tr>
            <th>Nombre</th>
            <th>Tipo</th>
            <th>Edad</th>
        </tr>
        <?php
        if (isset($_SESSION['mascotas'])) {
            foreach ($_SESSION['mascotas'] as $nombre => $datos) {
                echo "<tr>";
        ?>
                <td><?= $nombre ?></td>
                <td><?= $datos["tipo"] ?></td>
                <td><?= $datos["edad"] ?></td>
        <?php
                echo "<tr>";
            }
        }
        ?>
    </table>
</body>

</html>