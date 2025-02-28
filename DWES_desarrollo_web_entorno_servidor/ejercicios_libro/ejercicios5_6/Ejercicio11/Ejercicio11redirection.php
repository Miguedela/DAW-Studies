<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
    <?php
    $palabra = $_REQUEST['palabra'];

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

    if (array_key_exists($palabra, $palabras)) {
        echo $palabras[$palabra];
    } else {
        echo "Palabra no encontrada.";
    }
    ?>
</body>

</html>