<!--
Escribe  un  programa  que  guarde  en  una  cookie  el  color  de  fondo  (propiedad  background-color)  de  una 
página. Esta página debe tener únicamente algo de texto y un formulario para cambiar el color.
-->
<?php
// if para igualar el color de fondo a las cookies
if (isset($_COOKIE["backgrounColor"])) {
    $color = $_COOKIE["backgrounColor"];
}

// if que recoje el color de fondo de recibirlo del formulario
if (isset($_REQUEST['color'])) {
    $color = $_REQUEST['color'];
    setcookie("backgrounColor", $color, time() + 3600);
}

// if para eliminar las cookies
if (isset($_REQUEST['elimarCookies'])) {
    setcookie("backgrounColor", "", -1);
    unset($backgrounColor);
    header("refresh: 0;");
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
    </style>
</head>

<body>
    <?php
    $colores = [
        "rojo" => "red",
        "azul" => "blue"
    ];
    ?>

    <h2>Elige el fondo de pantalla de la pagina web</h2>
    <form action="" method="post">
        <select name="color">
            <?php
            foreach ($colores as $key => $value) {
            ?>
                <option value="<?= $value ?>"><?= $key ?></option>
            <?php
            }
            ?>
        </select>
        <input type="submit" value="Actualizar backgraund">
    </form>
    <form action="" method="post">
        <input type="hidden" name="elimarCookies">
        <input type="submit" value="eliminar">
    </form>
    <?php
    ?>
</body>

</html>