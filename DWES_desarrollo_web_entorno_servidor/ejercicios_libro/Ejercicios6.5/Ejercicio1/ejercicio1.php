<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        table,
        tr,
        td {
            border: solid 1px black;
        }

        input {
            margin: 5px 0;
        }

        body {
            background-color: #f4f4f4;
        }
    </style>
</head>

<body>
    <!--
    Crear una página web para generar de manera aleatoria una combinación de apuesta en la lotería primitiva. Se 
    pedirán 6 números (entre 1 y 49) y el número de serie (entre 1 y 999). El usuario podrá rellenar los números 
    pedidos  que  desee,  dejando  en  blanco  el  resto,  de  modo  que  la  combinación  generada  respete  los  números 
    elegidos  y  genere  aleatoriamente  el  resto  hasta  completar  la  combinación  (el  número  de  serie  también  es 
    opcional).  El  usuario  también  podrá  rellenar  de  manera  opcional  una  caja  de  texto  como  título  para  su 
    combinación. 
    Usar una función combinacion() que sea llamada para generar la combinación en función de los parámetros 
    recibidos y devuelva el array generado. 
    Usar una función imprimeApuesta() que reciba un array y un texto, e imprima en una tabla html con el formato 
    que quieras, el array generado con el texto de cabecera, para mostrar el resultado de la combinación generada. 
    Si la función no recibe ningún texto como cabecera imprimirá "Combinación generada para la Primitiva". 
    -->

    <?php
    if (isset($_REQUEST['numerosUsuario'])) {
        $numerosUsuario = $_REQUEST['numerosUsuario'];
        $numerosFinales = combinacion($numerosUsuario);
        $titulo = $_REQUEST['titulo'];

        if ($titulo === "") {
            imprimeApuesta($numerosFinales, $titulo);
        } else {
            imprimeApuesta($numerosFinales, $_REQUEST['titulo']);
        }
    }
    ?>
    <h2>Introduce la combinacion desada para jugar a la primitiva</h2>
    <form action="" method="post">
        Título: <input type="text" name="titulo"><br>
        Números:
        <?php
        for ($i = 0; $i < 6; $i++) {
        ?>
            <input type="number" name="numerosUsuario[<?= $i ?>]" min=1 max=49>
        <?php
        }
        ?>
        <br>Número de serie: <input type="number" name="numerosUsuario[<?= 6 ?>]" min=1 max=999>
        <br><input type="submit" value="Enviar">
    </form>
</body>

</html>

<!-------------------------------------------------FUNCIONES------------------------------------------------->
<?php
function imprimeApuesta($arrayNumeros, $cabecera = "Combinación generada para la Primitiva")
{
?>
    <table>
        <tr>
            <td colspan="7">
                <h2><?= $cabecera ?></h2>
            </td>
        </tr>
        <tr>
            <td>Números:</td>
            <?php
            for ($i = 0; $i < count($arrayNumeros) - 1; $i++) {
            ?>
                <td style="text-align: center;"><?= $arrayNumeros[$i] ?></td>
            <?php
            }
            ?>
        </tr>
        <tr>
            <td>Número de serie: </td>
            <td colspan="6" style="text-align: center;"><?= $arrayNumeros[count($arrayNumeros) - 1] ?></td>
        </tr>
    </table>
<?php
}
?>