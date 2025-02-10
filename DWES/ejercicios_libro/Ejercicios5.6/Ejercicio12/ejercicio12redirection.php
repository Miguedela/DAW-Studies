<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
    <?php
    $traducciones = $_REQUEST['traducciones'];
    $palabrasElegidas = $_REQUEST['textoElegido'];

    $arrayElegidas = unserialize(base64_decode($palabrasElegidas));

    $palabras = array(
        'Hola' => 'Hello',
        'Adiós' => 'Goodbye',
        'Amor' => 'Love',
        'Familia' => 'Family',
        'Amigo' => 'Friend',
        'Perro' => 'Dog',
        'Gato' => 'Cat',
        'Casa' => 'House',
        'Cielo' => 'Sky',
        'Comida' => 'Food',
        'Feliz' => 'Happy',
        'Triste' => 'Sad',
        'Rápido' => 'Fast',
        'Lento' => 'Slow',
        'Agua' => 'Water',
        'Fuego' => 'Fire',
        'Tierra' => 'Earth',
        'Aire' => 'Air',
        'Libro' => 'Book',
        'Sol' => 'Sun'
    );

    foreach ($traducciones as $i => $elegida) {
        if ($palabras[$arrayElegidas[$i]] == $elegida) {
            echo 'Has acertado la traducción de la palabra: ' . $arrayElegidas[$i] . ' - ' . $elegida . '<br>';
        } else {
            echo 'No has acertado la traducción de la palabra: ' . $arrayElegidas[$i] . '<br>';
        }
    }
    ?>
</body>

</html>