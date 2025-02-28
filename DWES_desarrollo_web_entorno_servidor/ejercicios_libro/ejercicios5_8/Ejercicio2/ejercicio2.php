<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
    <!--
    Realizar  una  página  web  para  realizar  pedidos  de  comida  rápida.  Tenemos  varios  tipos  de 
    comida: Pizza: jamon, atun, bacon, pepperoni; Hamburguesa: lechuga, tomate, queso; Perrito 
    caliente: lechuga, cebolla, patata; etc (la carta con todas las comidas y sus ingredientes estará 
    almacenada en un array). A través de formularios distintos, uno para cada tipo de comida se va 
    añadiendo  comida  al  pedido  con  sus  respectivos  ingredientes,  hasta  que  se  pulse  el  botón 
    finalizar pedido (en otro formulario), con lo que se mostrará el pedido completo en una tabla, 
    con  toda  la  comida  y  los  ingredientes  seleccionados  de  cada  una.  Usa  la  función  serialize()  y 
    unserialize() para pasar arrays como cadenas Nota: con arrays de 2 dimensiones la serialización 
    se corrompe, así que hay que usar la función en combinación con otra de la siguiente forma:  
        
    $cadenaTexto=base64_encode(serialize($array)); 
    $array=unserialize(base64_decode($cadenaTexto));
    -->

    <?php
    if (isset($_REQUEST['comidaPedida'])) {
        $comidaPedida = $_REQUEST['comidaPedida'];
        $textoPedidos = $_REQUEST['pedidos'];
        $pedidos = unserialize(base64_decode($textoPedidos));
        $pedidos[] = $comidaPedida;
    } else {
        $pedidos = [];
    }

    $textoPedidos = base64_encode(serialize($pedidos));

    $menu = [
        'Pizza' => ['jamon', 'atun', 'bacon', 'pepperoni'],
        'Hamburguesa' => ['lechuga', 'tomate', 'queso'],
        'Perrito caliente' => ['legucha', 'cebolla', 'patata']
    ];

    foreach ($menu as $key => $conjuntoIngrediente) {
    ?>
        <form action="" method="post">
            <h3><?= $key ?></h3>
            <input type="hidden" name="comidaPedida[]" value="<?= $key ?>">
            <input type="hidden" name="pedidos" value="<?= $textoPedidos ?>">
            <?php
            foreach ($conjuntoIngrediente as $ingrediente) {
            ?>
                <?= $ingrediente ?><input type="checkbox" name="comidaPedida[]" value="<?= $ingrediente ?>">
            <?php
            }
            ?>
            <br><input type="submit" value="Pedir">
        </form>
    <?php
    }
    ?>
    <form action="ejercicio2redirection.php" method="post">
        <input type="hidden" name="pedidos" value="<?= $textoPedidos ?>">
        <input type="submit" value="Enviar pedido">
    </form>
</body>

</html>