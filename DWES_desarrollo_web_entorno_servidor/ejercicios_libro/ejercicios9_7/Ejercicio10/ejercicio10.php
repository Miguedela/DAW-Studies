<!--
Queremos modelar una casa con muchas bombillas, de forma que cada bombilla se puede encender o apagar 
individualmente. Para ello haremos una clase Bombilla con un atributo privado que almacene si está encendida 
o apagada, otro para la potencia consumida y por último otro atributo para la ubicación (salón, cocina, etc...); 
realizar  un  método  que  nos  diga  si  una  bombilla  concreta  está  encendida,  así  como  los  getter  y  setters 
necesarios. 
Además,  queremos poner un interruptor general de  la luz, tal que, si saltan los fusibles, todas las bombillas 
quedan  apagadas.  Cuando  el  fusible  se  repara,  las  bombillas  vuelven  a  estar  encendidas  o  apagadas,  según 
estuvieran antes del percance.  
Diseñar una  página  que  genere  las bombillas de  una casa  y las almacene  en un array de sesión. Mostrar las 
bombillas de manera gráfica (desarrolla tu imaginación) dando la opción de encender y apagar cada una, así 
como de  encender  y  apagar  el  interruptor general.  Mostrar en  todo  momento  la potencia  consumida  por  las 
bombillas encendidas. 
-->
<?php
include_once 'funciones.php';
include_once 'Bombilla.php';
if (session_status() == PHP_SESSION_NONE) session_start();

if (!isset($_SESSION['bombillas'])) {
    $_SESSION['bombillas'] = obtenerBombillas();
}

if (isset($_REQUEST['agregarBombilla'])) {
    $bombilla = new Bombilla($_REQUEST['ubicacionBombilla'], $_REQUEST['potenciaBombilla']);
    $_SESSION['bombillas'][$_REQUEST['ubicacionBombilla']] = base64_encode(serialize($bombilla));
    guardarBombilla($bombilla);
}

if (isset($_REQUEST['encenderBombilla'])) {
    $bombilla = unserialize(base64_decode($_SESSION['bombillas'][$_REQUEST['encenderBombilla']]));
    $bombilla->encenderBobmilla();
    $_SESSION['bombillas'][$_REQUEST['encenderBombilla']] = base64_encode(serialize($bombilla));
} else if (isset($_REQUEST['apagarBombilla'])) {
    $bombilla = unserialize(base64_decode($_SESSION['bombillas'][$_REQUEST['apagarBombilla']]));
    $bombilla->apagarBobmilla();
    $_SESSION['bombillas'][$_REQUEST['apagarBombilla']] = base64_encode(serialize($bombilla));
}

if (isset($_REQUEST['bajarPlomos'])) {
    Bombilla::setInterruptorGeneral(false);
} else if (isset($_REQUEST['subirPlomo'])) {
    Bombilla::setInterruptorGeneral(true);
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
        tr,
        td,
        th {
            border: solid 1px black;
        }

        img {
            width: 100px;
        }
    </style>
</head>

<body>
    <table>
        <?php
        if (count($_SESSION['bombillas']) > 0) {
            foreach ($_SESSION['bombillas'] as $key => $value) {
                $value = unserialize(base64_decode($value));
        ?>
                <tr>
                    <td>
                        <?= $value->estadoBombilla() ?><br>
                        <?= $value->getUbicacionBombilla() ?><br>
                        <?= $value->getPotenciaBombilla() ?> kw<br>
                        <form action="#" method="post">
                            <input type="hidden" name="encenderBombilla" value="<?= $key ?>">
                            <input type="submit" value="Encender bombilla">
                        </form>
                        <form action="#" method="post">
                            <input type="hidden" name="apagarBombilla" value="<?= $key ?>">
                            <input type="submit" value="Apagar bombilla">
                        </form>
                    </td>
                </tr>
            <?php
            }
            ?>
            <tr>
                <th>Potencia total consumida: <?= Bombilla::getPotenciaTotalConsumida() ?> kw</th>
            </tr>
        <?php
        }
        ?>
    </table>
    <table>
        <tr>
            <th colspan="2">AGREGA AQUÍ LAS BOMBILLAS QUE DESEES</th>
        </tr>
        <tr>
            <th>Usbicacion de la bombilla</th>
            <th>Potencia de la bombilla</th>
        </tr>
        <form action="#" method="post">
            <tr>
                <td><input type="text" name="ubicacionBombilla"></td>
                <td><input type="text" name="potenciaBombilla"></td>
            </tr>
            <tr>
                <input type="hidden" name="agregarBombilla">
                <td colspan="2"><input type="submit" value="AgregarBombilla"></td>
            </tr>
        </form>
        <tr>
            <form action="#" method="post">
                <input type="hidden" name="bajarPlomos">
                <td><input type="submit" value="Bajar los plomos"></td>
            </form>
            <form action="#" method="post">
                <input type="hidden" name="subirPlomo">
                <td><input type="submit" value="Subir los plomos"></td>
            </form>
        </tr>
    </table>
</body>

</html>