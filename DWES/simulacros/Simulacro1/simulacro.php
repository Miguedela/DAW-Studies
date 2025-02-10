<?php
session_start();

$_SESSION['tipoCoche'] = ['turismo', 'berlina', 'monovolumen', 'deportivo', 'furgoneta'];
$_SESSION['dias_semana'] = ["Domingo", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado"];
$_SESSION['extras'] = ['camaraTrasera', 'llantasAleacion', 'climatizador', 'autoPilot'];

if (isset($_REQUEST['eliminar'])) {
    setcookie('coches', '', -1);
    session_destroy();
    header('refresh: 0');
}

if (isset($_COOKIE['coches']) && !isset($_SESSION['coches'])) {
    $_SESSION['coches'] = unserialize(base64_decode($_COOKIE['coches']));
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
    </style>
</head>

<body>
    <!-- Formulario pare rellenar los datos del nuevo -->
    <form action="simulacroaniadircoche.php" method="post">
        Marca: <input type="text" name="marca"><br>
        Tipo:
        <select name="tipo">
            <?php
            for ($i = 0; $i < count($_SESSION['tipoCoche']); $i++) {
                echo '<option value="' . $_SESSION['tipoCoche'][$i] . '">' . $_SESSION['tipoCoche'][$i] . '</option>';
            }
            ?>
        </select><br>
        Extras:<br>
        <?php
        foreach ($_SESSION['extras'] as $extra) {
        ?>
            <input type="checkbox" name="extras[]" value="<?= $extra ?>"><?= $extra ?><br>
        <?php
        }
        ?>
        <input type="hidden" name="aniadirCoche">
        <input type="submit" value="Añadir al concesionario">
    </form>

    <!-- Mostrar los coches que voy añadiendo -->
    <table>
        <tr>
            <th>MATRÍCULA</th>
            <th>FECHA</th>
            <th>MARCA</th>
            <th>TIPO</th>
            <th>EXTRAS</th>
        </tr>
        <?php
        if (isset($_SESSION['coches'])) {
            foreach ($_SESSION['coches'] as $matricula => $infoCoche) {
        ?>
                <tr>
                    <?php
                    echo '<td>Coche: ' . $matricula . '</td>';
                    foreach ($infoCoche as $key => $info) {
                        if ($key === 'extras') {
                            echo '<td>';
                            foreach ($info as $extra) {
                                echo $extra . '<br>';
                            }
                            echo '</td>';
                        } else if ($key === 'fecha') {
                            $diaSemana = date("w", strtotime($info));
                            echo '<td>' .  $_SESSION['dias_semana'][$diaSemana] .  ' - ' . $info . '</td>';
                        } else {
                            echo '<td>' . $info . '</td>';
                        }
                    }
                    ?>
                    <td>
                        <form action="simulacroaniadirextra.php" method="post">
                            <input type="text" name="extra">
                            <input type="hidden" name="aniadirExtra" value="<?= $matricula ?>">
                            <input type="submit" value="Añadir extra">
                        </form>
                    </td>
                </tr>
        <?php
            }
        }
        ?>
    </table>

    <!-- Formulario para mostrar coches segun la busqueda del usuario -->
    Selecciona una categoría para ver los coches
    <form action="simulacromostrarcoches.php" method="post">
        <select name="tipo">
            <?php
            for ($i = 0; $i < count($_SESSION['tipoCoche']); $i++) {
                echo '<option value="' . $_SESSION['tipoCoche'][$i] . '">' . $_SESSION['tipoCoche'][$i] . '</option>';
            }
            ?>
        </select>
        <input type="hidden" name="mostrarCoches">
        <input type="submit" value="consultar">
    </form>

    <!-- Formulario para eliminar las cookies y la session -->
    <h2 style="color:red;">ELIMINAR SESSION Y COOKIES</h2>
    <form action="" method="post">
        <input type="hidden" name="eliminar">
        <input type="submit" value="Eliminar">
    </form>
</body>

</html>