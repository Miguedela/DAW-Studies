<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
    <!--
    Realizar  una  aplicación web  que  permita  introducir  los  datos  de  unos  aspirantes  a  un trabajo. Para 
    ello  en  la  página  principal  se  deberá  mostrar  un  formulario  para  introducir  los  siguientes  datos: 
    Nombre, edad, años de experiencia y correo. Tendremos un botón para aceptar los datos introducidos 
    del aspirante y otro para finalizar la lista de aspirantes. La aplicación deberá ir almacenando los datos 
    de los aspirantes en un array asociativo, cuyo índice principal sea el nombre. Cuando se pulse el botón 
    Finalizar,  se  enviarán  los  datos  a  otra  página  para  mostrar  el  listado  de  los  aspirantes,  y  como  se 
    buscan un perfil joven, los mayores de 30 saldrán con el texto de color rojo. 
    Si se carga la segunda página sin enviar el listado desde la primera, se mostrará un mensaje indicando 
    que primero se deben introducir los aspirantes y un enlace a la primera página. 
    -->

    <?php
    if (isset($_REQUEST['trabajadorNuevo'])) {
        // Recojo la info del nuevo trabajador
        $trabajadorNuevo = $_REQUEST['trabajadorNuevo'];
        // Datos del nuevo empleado
        $nombre = $trabajadorNuevo[0]; // Key
        $edad = $trabajadorNuevo[1];
        $experiencia = $trabajadorNuevo[2];
        $correo = $trabajadorNuevo[3];

        // Información del nuevo empleado
        $infoNuevoEmpleado = [
            'edad' => $edad,
            'experiencia' => $experiencia,
            'correo' => $correo
        ];

        // Recojo la info de los trabaajdores actuales
        $textoEmpleados = $_REQUEST['plantillaEmpleados'];
        $plantillaEmpleados = unserialize(base64_decode($textoEmpleados));
        
        // Igualo la ultima posicion al nuevo empleado
        $plantillaEmpleados[$nombre] = $infoNuevoEmpleado;
    } else {
        $plantillaEmpleados = [];
    }

    $textoEmpleados = base64_encode(serialize($plantillaEmpleados));
    ?>
    <!-- Formulario para agregar empleado a la plantilla -->
    <form action="" method="post">
        <h3>Introduce los datos del nuevo trabajador/a:</h3>
        Nombre: <input type="texto" name="trabajadorNuevo[]"><br><!-- Nombre -->
        Edad: <input type="texto" name="trabajadorNuevo[]"><br><!-- Edad -->
        Años de experiencia: <input type="texto" name="trabajadorNuevo[]"><br><!-- Años de experiencia -->
        Correo: <input type="email" name="trabajadorNuevo[]"><br><!-- Correo -->
        <input type="hidden" name="plantillaEmpleados" value="<?= $textoEmpleados ?>">
        <input type="submit" value="Agregar a la plantilla"><br>
    </form>

    <!-- Formulario para enviar la plantilla de empleados -->
    <form action="ejercicio5redirection.php" method="post">
        <input type="hidden" name="plantillaEmpleados" value="<?= $textoEmpleados ?>">
        <br><input type="submit" value="Enviar plantilla">
    </form>
</body>

</html>