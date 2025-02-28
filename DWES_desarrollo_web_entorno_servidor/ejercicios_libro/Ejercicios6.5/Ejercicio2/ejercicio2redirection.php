<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        a {
            text-decoration: none;
            color: black;
        }

        body {
            background-color: #f4f4f4;
        }
    </style>
</head>

<body>
    <?php
    $perfil = $_REQUEST['perfil'];
    $contrasena = $_REQUEST['contrasena'];

    $fila = $_REQUEST['fila'];
    $columna = $_REQUEST['columna'];
    $tarjeta = dameTarjeta($perfil);


    if (compruebaClave($tarjeta, $fila, $columna, $contrasena)) {
    ?>
        <h3>FILA: <?= $fila ?></h3>
        <h3>COLUMNA: <?= $columna ?></h3>
        <h3>VALOR: <?= $tarjeta[$fila][$columna] ?></h3>
        <h3>TARJETA: <?= $perfil ?></h3>
        <h2>Acceso Permitido</h2>
        <button><a href="https://iesruizgijon.es/">Continuar</a></button>
    <?php
    } else {
    ?>
        <h3>FILA: <?= $fila ?></h3>
        <h3>COLUMNA: <?= $columna ?></h3>
        <h3>VALOR: <?= $tarjeta[$fila][$columna] ?></h3>
        <h3>TARJETA: <?= $perfil ?></h3>
        <h2>Clave incorrecta. Acceso Restringido</h2>
        <button><a href="ejercicio2.php">Volver</a></button>
    <?php
    }
    ?>
</body>

</html>
<!-------------------------------------------------FUNCIONES------------------------------------------------->
<?php
function dameTarjeta($perfil)
{
    $tarjetaAdmin = [
        ['A1', 'A2', 'A3', 'A4', 'A5'],
        ['A6', 'A7', 'A8', 'A9', 'A10'],
        ['A11', 'A12', 'A13', 'A14', 'A15'],
        ['A16', 'A17', 'A18', 'A19', 'A20'],
        ['A21', 'A22', 'A23', 'A24', 'A25']
    ];

    $tarjetaEstandar = [
        ['E1', 'E2', 'E3', 'E4', 'E5'],
        ['E6', 'E7', 'E8', 'E9', 'E10'],
        ['E11', 'E12', 'E13', 'E14', 'E15'],
        ['E16', 'E17', 'E18', 'E19', 'E20'],
        ['E21', 'E22', 'E23', 'E24', 'E25']
    ];

    return ($perfil == 'admin') ? $tarjetaAdmin : $tarjetaEstandar;
}

function compruebaClave($arrayTarjeta, $fila, $columna, $contrasena)
{
    if ($contrasena == $arrayTarjeta[$fila][$columna]) {
        return true;
    } else {
        return false;
    }
}
?>