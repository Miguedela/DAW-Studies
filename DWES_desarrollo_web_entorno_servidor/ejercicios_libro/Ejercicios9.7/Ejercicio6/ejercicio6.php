<!--
Crea la clase Vehiculo, así como las clases Bicicleta y Coche como subclases de la primera. Para la clase 
Vehiculo, crea los métodos de clase getVehiculosCreados() y getKmTotales(); así como el método de
  
instancia getKmRecorridos(). Crea también algún método específico para cada una de las subclases. Prueba 
las clases creadas mediante una aplicación que realice, al menos, las siguientes acciones: 
•  Anda con la bicicleta
•  Haz el caballito con la bicicleta
•  Anda con el coche
•  Quema rueda con el coche
•  Ver kilometraje de la bicicleta
•  Ver kilometraje del coche
•  Ver kilometraje total
-->
<?php
include_once 'Coche.php';
include_once 'Bicicleta.php';

// Pruebas
$bicicleta = new Bicicleta();
$coche = new Coche();

$bicicleta->andar(15);
$coche->andar(50);
?>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=initial-scale=1.0">
    <title>Document</title>
</head>

<body>
    <ul>
        <li><?= $bicicleta->hacerCaballito() ?></li>
        <li><?= $coche->quemarRueda() ?></li>
        <li>Has recorrido <?= $bicicleta->getKmRecorridos() ?>km con la bicicleta</li>
        <li>Has recorrido<?= $coche->getKmRecorridos() ?>km con el coche</li>
        <li>Kilometros totales recorridos con los vehiculos <?= Vehiculo::getKmTotales() ?></li>
        <li>Vehiculos totales crados <?= Vehiculo::getVehiculosCreados() ?></li>
    </ul>
</body>

</html>