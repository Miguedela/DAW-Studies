<!--
Crea las clases Animal, Mamifero, Ave, Gato, Perro, Canario, Pinguino y Lagarto. Crea, al menos, tres 
métodos  específicos  de  cada  clase  y  redefine  el/los  método/s  cuando  sea  necesario.  Prueba  las  clases  en  un 
programa  en el que  se  instancien objetos y se  les apliquen métodos. Puedes aprovechar las capacidades que 
proporciona  HTML  y  CSS  para  incluir  imágenes,  sonidos,  animaciones,  etc.  para  representar  acciones  de 
objetos; por ejemplo, si el canario canta, el perro ladra, o el ave vuela.
-->
<?php
include_once 'Animal.php';
include_once 'Mamifero.php';
include_once 'Ave.php';
include_once 'Lagarto.php';
include_once 'Perro.php';
include_once 'Gato.php';
include_once 'Canario.php';
include_once 'Pinguino.php';

// Programa de prueba
$gato = new Gato("Tom");
$perro = new Perro("Rex");
$canario = new Canario("Tweety");
$pinguino = new Pinguino("Pingu");
$lagarto = new Lagarto("Lazzy");

$animales = [$gato, $perro, $canario, $pinguino, $lagarto];

?>

<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Interacciones de Animales</title>
</head>

<body>
    <h1>Interacciones de Animales</h1>
    <?php foreach ($animales as $animal): ?>
        <div class="animal">
            <h2><?php echo get_class($animal) . ": " . $animal->comer(); ?></h2>
            <ul>
                <?php if ($animal instanceof Gato): ?>
                    <li><?php echo $animal->maullar(); ?></li>
                    <li><?php echo $animal->trepar(); ?></li>
                    <li><?php echo $animal->ronronear(); ?></li>
                <?php elseif ($animal instanceof Perro): ?>
                    <li><?php echo $animal->ladrar(); ?></li>
                    <li><?php echo $animal->cavar(); ?></li>
                    <li><?php echo $animal->moverCola(); ?></li>
                <?php elseif ($animal instanceof Canario): ?>
                    <li><?php echo $animal->cantar(); ?></li>
                    <li><?php echo $animal->volar(); ?></li>
                    <li><?php echo $animal->saltar(); ?></li>
                <?php elseif ($animal instanceof Pinguino): ?>
                    <li><?php echo $animal->nadar(); ?></li>
                    <li><?php echo $animal->deslizarse(); ?></li>
                    <li><?php echo $animal->volar(); ?></li>
                <?php elseif ($animal instanceof Lagarto): ?>
                    <li><?php echo $animal->tomarSol(); ?></li>
                    <li><?php echo $animal->mudarPiel(); ?></li>
                    <li><?php echo $animal->escalar(); ?></li>
                <?php endif; ?>
            </ul>
        </div>
    <?php endforeach; ?>
</body>

</html>