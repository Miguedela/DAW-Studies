<?php
session_start();


if (!isset($_SESSION['paletaColores'])) {
    header("Location: ejercicio1.php");
} else if (isset($_SESSION['paletaColores']) && isset($_REQUEST['colorElegido'])) {
    $color = $_REQUEST['colorElegido'];
} else if (isset($_SESSION['paletaColores']) && isset($_REQUEST['mostrarPaleta'])) {
    $color = $_REQUEST['mostrarPaleta'];
}


?>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        body {
            background-color: <?= $color ?>;
        }

        td {
            height: 100px;
            width: 100px;
            border: solid 4px #333;
            border-radius: 3px;
        }

        a {
            display: block;
            height: 100%;
            width: 100%;
        }
    </style>
</head>

<body>
    <h2>Elige el color que deseas poner</h2>
    <table>
        <?php
        for ($i = 0; $i < count($_SESSION['paletaColores']); $i++) {
            // Abrir fila al inicio o cada múltiplo de 5
            if ($i % 5 == 0) {
                echo "<tr>";
            }
        ?>
            <td style="background-color: <?= $_SESSION['paletaColores'][$i] ?>">
                <a href="ejercicio1mostrarpaleta.php?colorElegido=<?= $_SESSION['paletaColores'][$i] ?>"></a>
            </td>
        <?php
            // Cerrar fila al final de un grupo de 5 celdas
            if (($i + 1) % 5 == 0 || $i == count($_SESSION['paletaColores']) - 1) {
                echo "</tr>";
            }
        }
        ?>
    </table>
    <a href="ejercicio1.php?colorElegido=<?= $color ?>">Volver</a>

    <!-- Formulario para destruir la session -->
    <h2 style="color: red; -webkit-text-stroke: 1px black;">Generar nueva paleta de colores</h2>
    <form action="ejercicio1.php" merthod="post">
        <input type="hidden" name="eliminarSession">
        <input type="submit" value="Generar nueva paleta">
    </form>
</body>

</html>