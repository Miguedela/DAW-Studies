<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
    <!--
    Realiza un programa que escoja al azar 5 palabras en español del mini-diccionario del ejercicio anterior.
    El programa pedirá que el usuario teclee la traducción al inglés de cada una de las palabras y comprobará
    si son correctas. Al final, el programa deberá mostrar cuántas respuestas son válidas y cuántas erróneas.
    -->
    <?php
    $palabras = [
        'Hola',
        'Adiós',
        'Amor',
        'Familia',
        'Amigo',
        'Perro',
        'Gato',
        'Casa',
        'Cielo',
        'Comida',
        'Feliz',
        'Triste',
        'Rápido',
        'Lento',
        'Agua',
        'Fuego',
        'Tierra',
        'Aire',
        'Libro',
        'Sol'
    ];

    // Inicio algunas variables necesarias
    $cantidad = 5;
    $palabrasElegidas = [];
    
    // Metodo para elegir 5 palabras aleatorias sin repetir
    for ($i = 0; $i < $cantidad; $i++) {
        do {
            $palabraRand = rand(0, count($palabras) - 1);
            $palabra = $palabras[$palabraRand];
            // Metodo para comprobar que el array no tiene la palabra elegida
        } while (in_array($palabra, $palabrasElegidas));
        $palabrasElegidas[] = $palabra; // Añado la palabra al array
    }

    $textoElegido = base64_encode(serialize($palabrasElegidas));


    echo "<h2>Escribe la traduccion de las siguientes palabras</h2>";
    ?>
    <form action="ejercicio12redirection.php" method="post">
        <?php
        for ($i = 0; $i < count($palabrasElegidas); $i++) {
        ?>
            Traduce <?= $palabrasElegidas[$i] ?><input type="text" name="traducciones[]" value="1"><br>
        <?php
        }
        ?>
        <input type="hidden" name="textoElegido" value="<?= $textoElegido ?>">
        <input type="submit" value="Comprobar">
    </form>
</body>

</html>