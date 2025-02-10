<!--
Crea la clase DadoPoker. Las caras de un dado de poker tienen las siguientes figuras: As, K, Q, J, 7 y 8 . Crea 
el método tira() que no hace otra cosa que tirar el dado, es decir, genera un valor aleatorio para el objeto al 
que se le aplica el método. Crea también el método nombreFigura(), que diga cuál es la figura que ha salido 
en la última tirada del dado en cuestión. Crea, por último, el método getTiradasTotales() que debe mostrar 
el número total de tiradas entre todos los dados. Realiza una aplicación que permita tirar un cubilete con cinco 
dados de poker.
-->
<?php
include_once 'DadoPoker.php';
session_start();

if (!isset($_SESSION['dado'])) {
    for ($i = 0; $i < 5; $i++) {
        $_SESSION['dado'][$i] = new DadoPoker();
        $_SESSION['dado'][$i]->tira();
    }
    $_SESSION['dado']['tiradasTotales'] = DadoPoker::getTiradasTotales();
}

if (isset($_REQUEST['tirarDados'])) {
    for ($i = 0; $i < 5; $i++) {
        $_SESSION['dado'][$i]->tira();
    }
    $_SESSION['dado']['tiradasTotales'] += DadoPoker::getTiradasTotales();
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
    <table>
        <tr>
            <th>Dado 1</th>
            <th>Dado 2</th>
            <th>Dado 3</th>
            <th>Dado 4</th>
            <th>Dado 5</th>
        </tr>
        <tr>
            <?php
            for ($i = 0; $i < 5; $i++) {
                echo "<td>" . $_SESSION['dado'][$i]->getTirada() . "</td>";
            }
            ?>
        </tr>
        <tr>
            <td colspan="5">
                <?php echo "Tiradas totales: " . $_SESSION['dado']['tiradasTotales'] . "<br>"; ?>
            </td>
        </tr>
    </table>
    <form action="#" method="post">
        <input type="hidden" name="tirarDados">
        <input type="submit" value="Tirar">
    </form>
</body>

</html>