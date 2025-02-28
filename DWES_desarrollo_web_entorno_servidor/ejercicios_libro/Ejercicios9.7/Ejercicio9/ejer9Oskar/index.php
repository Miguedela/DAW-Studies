<?php

include_once 'CocheLujo.php';
if (session_status() == PHP_SESSION_NONE) session_start();

if (!isset($_SESSION['garaje'])) {
    $_SESSION['garaje']=[];
}

if (isset($_REQUEST['matricula'])) {
    $matricula = $_REQUEST['matricula'];
    $modelo = $_REQUEST['modelo'];
    $precio = floatval($_REQUEST['precio']) ;
    $suplemento = null;
    if ($_REQUEST['suplemento'] !== "") {
        $suplemento = floatval($_REQUEST['suplemento']);
    }
    //Crear el coche y añadirlo
    if ($suplemento === null) {
        $nuevoVehiculo = new Coche($matricula,$modelo,$precio);
    }else {
        $nuevoVehiculo = new CocheLujo($matricula,$modelo,$precio,$suplemento);
    }

    $_SESSION['garaje'][]=serialize($nuevoVehiculo);
}

?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid #000;
            padding: 8px;
            text-align: center;
        }
    </style>
</head>
<body>
    <h3>Añadir vehiculos al garaje</h3>
    <form action="" method="post">
        <label for="">Matricula:</label>
        <input type="text" name="matricula" id="" required>
        <label for="">Modelo:</label>
        <input type="text" name="modelo" id="">
        <label for="">Precio:</label>
        <input type="number" name="precio" id="">
        <label for="">Suplemento:</label>
        <input type="number" name="suplemento" id="">
        <input type="submit" value="Añadir">
    </form>

    <h2>Vehiculo más Caro</h2>
    <?php
    echo Coche::masCaro();
    ?>

    <h2>Garaje de Coches</h2>
    <table>
        <tr>
            <th>Matricula</th>
            <th>Modelo</th>
            <th>Precio</th>
            <th>Suplemento</th>
        </tr>
        
            <?php
            foreach ($_SESSION['garaje'] as $key => $coche) {
                echo "<tr>";
                    echo "<td>". unserialize($coche) ->getMatricula() ."</td>";
                    echo "<td>". unserialize($coche)->getModelo() ."</td>";
                    echo "<td>". unserialize($coche)->getPrecio() ."</td>";
                if (unserialize($coche) instanceof CocheLujo) {
                
                    echo "<td>". unserialize($coche)->getSuplemento() ."</td>";
                }else {
                    echo "<td>(No procede)</td>";
                }
                echo "</tr>";
            }
            ?>

    </table>
</body>
</html>