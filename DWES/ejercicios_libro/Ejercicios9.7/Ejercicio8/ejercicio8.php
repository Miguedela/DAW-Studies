<!--
Queremos gestionar la venta de entradas (no numeradas) del Circo del Sol, que tiene 3 zonas, la zona principal 
con 1000 entradas disponibles a un precio de 20€, la zona de compra-venta con 200 entradas disponibles a un 
precio de 35€,  y  la  zona  vip  con  25  entradas  disponibles  a un precio de 50€.  Define  la  clase  Zona  con  sus 
atributos y métodos correspondientes, de manera que permita tener información del ingreso total de ventas de 
todas las entradas (hay que controlar que existen entradas disponibles antes de venderlas), y crea un programa 
que  permita  vender  las  entradas.  En  la  pantalla  principal  debe  aparecer  información  sobre  las  entradas 
disponibles en cada zona, así como su precio y un formulario para vender entradas de la zona seleccionada. 
Debemos indicar para qué zona queremos las entradas y la cantidad de ellas. Lógicamente, el programa debe 
controlar que no se puedan vender más entradas de la cuenta.
-->
<?php
include_once 'Zona.php';
if (session_status() == PHP_SESSION_NONE) session_start();

if (!isset($_SESSION['circoDelSol'])) {
    $_SESSION['circoDelSol'] = [
        "Principal" => new Zona("Principal", 1000, 20),
        "Compra-Venta" => new Zona("Compra-Venta", 200, 35),
        "VIP" => new Zona("VIP", 25, 50),
    ];
    $_SESSION['ingresosTotales'] = Zona::getIngresoTotal();
} else if (isset($_SESSION['ingresosTotales'])) {
    Zona::setIngresoTotal($_SESSION['ingresosTotales']);
}
?>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        table,
        th,
        tr,
        td {
            border: solid 1px black;
        }
    </style>
</head>

<body>
    <h1>Circo del Sol</h1>

    <?php
    if (isset($_REQUEST['vender'])) {
    ?>
        <p><?= $_SESSION['circoDelSol'][$_REQUEST['zona']]->venderEntradas((int) $_REQUEST['cantidad']); ?></p>
    <?php
        $_SESSION['ingresosTotales'] = Zona::getIngresoTotal();
    }
    ?>

    <!-- FOMRULARIO DE INFORMACION DE LAS ENTRADASD -->
    <h2>Información de Zonas</h2>
    <table>
        <tr>
            <th>Zona</th>
            <th>Entradas Disponibles</th>
            <th>Precio por Entrada</th>
        </tr>
        <?php foreach (
            $_SESSION['circoDelSol'] as $zona
        ) { ?>
            <tr>
                <td><?= $zona->getNombre() ?></td>
                <td><?= $zona->getDisponibles() ?></td>
                <td><?= $zona->getPrecio() ?>€</td>
            </tr>
        <?php } ?>
    </table>

    <!-- FORMULARIO PARA REALIZAR LAS COMPRAS -->
    <h2>Vender Entradas</h2>
    <form method="post">
        Selecciona la Zona:
        <select name="zona" id="zona" required>
            <?php foreach ($_SESSION['circoDelSol'] as $zona) {
            ?>
                <option value="<?= $zona->getNombre() ?>"><?= $zona->getNombre() ?></option>
            <?php
            } ?>
        </select>
        <br><br>

        Cantidad de Entradas: <input type="number" name="cantidad" id="cantidad" min="1" required>
        <br><br>

        <input type="hidden" name="vender">
        <button type="submit">Vender</button>
    </form>

    <!-- MUESTRO EL SUMATORIO DEL PRECIO DE LAS VENTAS -->
    <h2>Ingresos Totales</h2>
    <p>Circo del Sol: <?= Zona::getIngresoTotal() ?>€</p>
</body>

</html>