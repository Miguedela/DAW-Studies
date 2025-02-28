<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Document</title>
</head>

<body>
  <!--
    Realiza el control de acceso a una caja fuerte. La combinación será un número de 4 cifras. El programa nos pedirá
    la combinación para abrirla. Si no acertamos, se nos mostrará el mensaje “Lo siento, esa no es la combinación” y
    si acertamos se nos dirá “La caja fuerte se ha abierto satisfactoriamente”. Tendremos cuatro oportunidades para
    abrir la caja fuerte.
    -->

  <h3>Abrir caja fuerte</h3>
  <?php
  // if para cargar datos la primera vez que se ejecute el programa
  if (!isset($_REQUEST['contrasena'])) {
    // Inicio las variables con los valores deseados
    $oportunidades = 4;
    $contrasena = "0";
    $contrasenaCorrecta = "1111";
  } else {
    // Recogo los valores del formulario
    $oportunidades = $_REQUEST['oportunidades'];
    $contrasena = $_REQUEST['contrasena'];
    $contrasenaCorrecta = $_REQUEST['contrasenaCorrecta'];
  }

  // if para combrobar si la contraseña es correcta
  if ($contrasena == $contrasenaCorrecta) {
    echo "Enhorabuena, has acertado el número.";
  } else {
    // if para comprobar el número de intentos que te quedan
    if ($oportunidades === 0) {
      echo "Te has quedado sin oportunidades.";
    } else {
  ?>
      Te quedan <?= $oportunidades-- ?> oportunidades para adivinar el número.<br>
      Introduce la contraseña de 4 digitos para abrir la caja fuerte:
      <form action="Ejercicio7.php" method="post">
        <input type="text" name="contrasena" minlength="4" maxlength="4" pattern="\d{4}">
        <input type="hidden" name="oportunidades" value="<?= $oportunidades ?>">
        <input type="hidden" name="contrasenaCorrecta" value="<?= $contrasenaCorrecta ?>">
        <input type="submit" value="Continuar">
      </form>

  <?php
    }
  }
  ?>
</body>

</html>