<!--
Diseñar una  aplicación web para  consultar y actualizar tu horario de  clase. Nada  más cargar la página debe 
mostrar una tabla con tu horario semanal recuperado de la base de datos. Cada asignatura mostrada en la tabla 
es realmente un botón y al pulsar el botón de cada asignatura abre otra página que contiene un formulario con 
  
un desplegable que incluye todas las asignaturas posibles, y al elegir una y darle a grabar, actualizará el horario 
y volverá a la página principal. 
Crear una base de datos llamada escuela y una tabla llamada horario con los siguientes campos: 'dia', 'primera', 
'segunda',  'tercera',  'cuarta',  'quinta',  'sexta'.  Los  campos  se  corresponden  con  la  información  del  día  de  la 
semana, y sus seis horas de clase, por lo que en la tabla habrá una fila por cada día de la semana. Todos los 
campos son de tipo varchar y la clave de la tabla es 'dia', ya que no se puede repetir.
-->
<?php
try {
    $conexion = new PDO("mysql:host=localhost;dbname=ejercicio6__10_5;charset=utf8", "root", "");
} catch (PDOException $e) {
    echo "No se ha podido establecer conexión con el servidor de bases de datos.<br>";
    die("Error: " . $e->getMessage());
}

$consulta = $conexion->query("SELECT * FROM horario");
$horas = ["primera", "segunda", "tercera", "cuarta", "quinta", "sexta"];
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
            margin: 20px auto;
            border: 1px solid #222;
        }
    </style>
</head>

<body>
    <table>
        <thead>
            <tr>
                <th>Día</th>
                <th>Primera</th>
                <th>Segunda</th>
                <th>Tercera</th>
                <th>Cuarta</th>
                <th>Quinta</th>
                <th>Sexta</th>
            </tr>
        </thead>
        <tbody>
            <?php
            while ($fila = $consulta->fetchObject()) {
            ?>
                <tr>
                    <td class="dia"><?= $fila->dia ?></td>
                    <?php
                    foreach ($horas as $key => $hora) {
                    ?>
                        <td>
                            <form action="modificar.php" method="post">
                                <input type="hidden" name="dia" value="<?= $fila->dia  ?>">
                                <input type="hidden" name="hora" value="<?= $hora ?>">
                                <input type="submit" value="<?= $fila->$hora ?>">
                            </form>
                        </td>
                    <?php
                    }
                    ?>
                </tr>
            <?php
            }
            ?>
        </tbody>
    </table>
</body>

</html>