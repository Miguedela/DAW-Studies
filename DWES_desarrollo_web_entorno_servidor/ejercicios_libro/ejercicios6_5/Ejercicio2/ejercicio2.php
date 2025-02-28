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
            text-align: center;
        }
        
        body {
            background-color: #f4f4f4;
        }
    </style>
</head>

<body>
    <!--
    Disponemos de 2 tarjetas de coordenadas para controlar el acceso a una web. Cada tarjeta corresponde a un 
    perfil de usuario ‘admin’ o ‘estandar’, cada número número registrado en la tarjeta se identifica por su fila (de 
    la 1 a la 5) y su columna (de la A a la E). Los valores registrados en cada tarjeta son fijos y os lo podéis inventar. 
    Crea una página principal que sirva de control de acceso a una segunda página. Se pedirá el perfil de usuario 
    (admin  o  estándar)  y  una  clave  aleatoria  correspondiente  a  la  tarjeta  de  coordenadas  de  su  perfil  (fila  y 
    columna),  se  comprobará  si  es  correcto  usando  2  funciones:  dameTarjeta()  a  la  que  se  le  pasa  el  perfil  y 
    devuelve una matriz correspondiente a la tarjeta de coordenadas de ese perfil, y compruebaClave() a la que se 
    le pasa la matriz de coordenadas, las coordenadas y un valor, y devolverá un booleano según sea correcto el 
    valor en la matriz de coordenadas. Ambas funciones estarán almacenadas en una librería controlAcceso.php.  
    Si el usuario se ha identificado correctamente se muestra un enlace de acceso a la página protegida (cualquiera) 
    y si no mostrará un enlace para volver a intentarlo de nuevo. 
    Usar una tercera función imprimeTarjeta() que recibe una tarjeta y la imprime en una tabla para comprobar el 
    valor de todas las coordenadas. (imprimir las tarjetas de cada perfil en la página de acceso para poder comprobar 
    el correcto funcionamiento de la página)
    -->
    <?php
    ?>
    <h2>ADMIN:</h2>
    <?php
    imprimeTarjeta(dameTarjeta("admin"));
    ?>
    <h2>USUARIO ESTANDAR:</h2>
    <?php
    imprimeTarjeta(dameTarjeta("estandar"));

    $columnas = ["A", "B", "C", "D", "E"];
    $fila = rand(1, 5);
    $columnasRand = rand(1, 5);
    ?>

    <form action="ejercicio2redirection.php" method="post">
        <br>
        Perfil:
        <select name="perfil" required>
            <option value="admin">Admin</option>
            <option value="estandar">Estandar</option>
        </select>
        <br>
        <h2>INTRODUCE LA SIGUIENTE COOREDENADA</h2>
        <h2>COORDENADSA Fila: <?= $fila ?> Columna: <?= $columnas[$columnasRand - 1] ?> <input type="text" name="contrasena"><br><br>
            <input type="hidden" name="fila" value="<?= $fila - 1 ?>">
            <input type="hidden" name="columna" value="<?= $columnasRand - 1 ?>">
            <input type="submit" value="COMPROBAR">
    </form>

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

function imprimeTarjeta($tarjeta)
{
?>
    <table>
        <tr>
            <th></th>
            <th>A</th>
            <th>B</th>
            <th>C</th>
            <th>D</th>
            <th>E</th>
        </tr>
        <?php
        foreach ($tarjeta as $i => $fila) {
        ?>
            <tr>
                <th><?= $i + 1 ?></th>
                <?php
                foreach ($fila as $valor) {
                ?>
                    <td><?= $valor ?></td>
                <?php
                }
                ?>
            </tr>
        <?php
        }
        ?>
    </table>
<?php
}
?>