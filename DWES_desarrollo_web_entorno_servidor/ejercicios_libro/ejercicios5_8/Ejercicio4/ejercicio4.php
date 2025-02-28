<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
    <!--
    Vamos a realizar una página para generar parejas aleatorias según su sexo y orientación sexual. 
    Para  ello  en  una  primera  página  pediremos  de  manera  reiterada  el  nombre,  sexo  (h  o  m)  y 
    orientación (heterosexual, homosexual o  bisexual)  de  personas,  que  se  irán  almacenando en 
    un  array.  Se  dispondrá  además,  de  un  botón  para  pasar  a  la  segunda  página  que  permite 
    generar  las parejas aleatorias  con las personas introducidas.  Esta segunda página debe 
    contener tres botones para generar una pareja aleatoria de los siguientes tipos: 
    -Heterosexual: Obtendrá aleatoriamente una primera persona de cualquier sexo y orientación 
    heterosexual,  que  unirá  con  una  segunda  persona  de  distinto  sexo  que  sea  heterosexual  o 
    bisexual. 
    -Homosexual: Obtendrá aleatoriamente una primera persona de cualquier sexo y orientación 
    homosexual, que unirá con otra persona del mismo sexo y orientación. 
    -Bisexual:  Obtendrá  aleatoriamente  una  primera  persona  de  cualquier  sexto  y  orientación 
    bisexual, que unirá con otra persona que sea compatible, el perfil incompatible sería 
    homosexual de distinto sexo o heterosexual del mismo sexo.
    -->

    <?php
    if (isset($_REQUEST['nombre'])) {
        $nombre = $_REQUEST['nombre'];
        $sexo = $_REQUEST['sexo'];
        $orientacion = $_REQUEST['orientacion'];
        $personas = unserialize(base64_decode($_REQUEST['personas']));

        $infoPersona = ['nombre' => $nombre, 'sexo' => $sexo, 'orientacion' => $orientacion];

        $personas[] = $infoPersona;
    } else {
        $personas = [
            ['nombre' => 'Anita', 'sexo' => 'm', 'orientacion' => 'bis'],
            ['nombre' => 'Lolita', 'sexo' => 'm', 'orientacion' => 'bis'],
            ['nombre' => 'Pepito', 'sexo' => 'h', 'orientacion' => 'bis'],
            ['nombre' => 'Juanito', 'sexo' => 'h', 'orientacion' => 'bis'],
            ['nombre' => 'Roberto', 'sexo' => 'h', 'orientacion' => 'het'],
            ['nombre' => 'Antonio', 'sexo' => 'h', 'orientacion' => 'het'],
            ['nombre' => 'Manuela', 'sexo' => 'm', 'orientacion' => 'het'],
            ['nombre' => 'Isabel', 'sexo' => 'm', 'orientacion' => 'het'],
            ['nombre' => 'Jenifer', 'sexo' => 'm', 'orientacion' => 'hom'],
            ['nombre' => 'Susan', 'sexo' => 'm', 'orientacion' => 'hom'],
            ['nombre' => 'Peter', 'sexo' => 'h', 'orientacion' => 'hom'],
            ['nombre' => 'Mike', 'sexo' => 'h', 'orientacion' => 'hom']
        ];
    }
    $textoPersonas = base64_encode(serialize($personas));
    ?>

    <h3>Introduce los datos de la nueva persona (nombre, sexo: h/m, orientación: bis/het/hom):</h3>
    <form action="" method="post">
        Nombre: <input type="text" name="nombre"><br>
        Sexo: <input type="text" name="sexo"><br>
        orientación: <input type="text" name="orientacion"><br>
        <input type="hidden" name="personas" value="<?= $textoPersonas ?>">
        <input type="submit" value="Añadir persona">
    </form>

    <form action="ejercicio4redirection.php" method="post">
        <input type="hidden" name="personas" value="<?= $textoPersonas ?>">
        <input type="submit" value="Enviar personas">
    </form>
</body>

</html>