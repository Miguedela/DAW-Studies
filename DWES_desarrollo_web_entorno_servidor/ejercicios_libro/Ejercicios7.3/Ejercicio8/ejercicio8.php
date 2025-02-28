<!--
Realiza un programa que escoja al azar 5 palabras en inglés de un mini-diccionario. El programa pedirá que el 
usuario teclee la traducción al español de cada una de las palabras y comprobará si son correctas. Al final, el 
programa  deberá  mostrar  cuántas  respuestas  son  válidas  y  cuántas  erróneas.  La  aplicación  debe  tener  una 
opción para introducir los pares de palabras (inglés - español) que se deben guardar en cookies; de esta forma, 
si  de  vez  en  cuando  se  dan  de  alta  nuevas  palabras,  la  aplicación  puede  llegar  a  contar  con  un  número 
considerable de entradas en el mini-diccionario.
-->
<?php
// If que elimina las cookies en caso de solicitarlo
if (isset($_REQUEST['elimarCookies'])) {
    setcookie("miniDiccionario", "", -1);
    unset($miniDiccionario);
    setcookie("palabrasIngles", "", -1);
    unset($palabrasIngles);
    header("refresh: 0;");
}

// If que elimina las cpalabras elegidas
if (isset($_REQUEST['elimarPalabras'])) {
    setcookie("palabrasIngles", "", -1);
    unset($palabrasIngles);
}

// if que crea el diccionario en caso de no tenerlo guardado en las cookies
if (!isset($_COOKIE["miniDiccionario"])) {
    $miniDiccionario = [
        'hello' => 'hola',
        'world' => 'mundo',
        'house' => 'casa',
        'dog' => 'perro',
        'cat' => 'gato',
        'book' => 'libro',
        'love' => 'amor',
        'food' => 'comida',
        'school' => 'escuela',
        'family' => 'familia'
    ];

    setcookie("miniDiccionario", base64_encode(serialize($miniDiccionario)), time() + 3600);
} else if (isset($_COOKIE["miniDiccionario"])) {
    $miniDiccionario = unserialize(base64_decode($_COOKIE["miniDiccionario"]));
}

if (isset($_REQUEST['espaniol'])) {
    $espaniol = $_REQUEST['espaniol'];
    $ingles = $_REQUEST['ingles'];

    $miniDiccionario[$ingles] = $espaniol;

    setcookie("miniDiccionario", base64_encode(serialize($miniDiccionario)), time() + 3600);
}

var_dump($miniDiccionario);

$randomsDiccionario = [];
$iteradorAux = 0;

$palabrasIngles = array_rand($miniDiccionario, 5);
setcookie("palabrasIngles", base64_encode(serialize($palabrasIngles)),  time() + 3600);
?>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
    <!-- Form para realizar los intentos de las traducciones -->
    <h2>Escribe las traducciones de las siguientes palabras:</h2>
    <form action="" method="post">
        <?php
        foreach ($palabrasIngles as $value) {
        ?>
            <!-- añadir required en caso de ser necesario -->
            <?= $value ?>: <input type="text" name="traduccionesUsuario[]"><br>
        <?php
        }
        ?>
        <input type="submit" value="Comprobar">
    </form>

    <!-- Formulario para añadir palabras -->
    <h2>Añadir palabra al diccionario</h2>
    <form action="" method="post">
        Inglés: <input type="text" name="espaniol" required><br>
        Español: <input type="text" name="ingles" required><br>
        <input type="submit" value="Añadir palabras">
    </form>

    <!-- Formulario para generar nuevas palabras en ingles -->
    <h2 style="color: red;">Generar nuevas palabras</h2>
    <form action="" method="post">
        <input type="hidden" name="elimarPalabras">
        <input type="submit" value="eliminar">
    </form>

    <!-- Formulario para eliminar las cookies -->
    <h2 style="color: red;">Resetear las cookies</h2>
    <form action="" method="post">
        <input type="hidden" name="elimarCookies">
        <input type="submit" value="eliminar">
    </form>


    <?php
    if (isset($_REQUEST['traduccionesUsuario'])) {
        $traduccionesUsuario = $_REQUEST['traduccionesUsuario'];
        $palabrasInglesComprobar = unserialize(base64_decode($_COOKIE['palabrasIngles']));

        $contador = 0;

        for ($i = 0; $i < count($palabrasInglesComprobar); $i++) {
            if ($miniDiccionario[$palabrasInglesComprobar[$i]] === $traduccionesUsuario[$i]) {
                $contador++;
            }
        }

        echo '<h3>Has acertado ', $contador, " palabras</h3>";
    }
    ?>
</body>

</html>