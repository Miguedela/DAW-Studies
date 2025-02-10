<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Document</title>
</head>

<style>
  table,
  tr,
  td {
    border: solid 2px black;
  }

  div {
    background-color: #333;
    height: 200px;
    width: 200px;
  }
</style>

<body>

  <?php
  if (!isset($_GET['contador'])) {
    $contador = 0;
  } else {
    $contador = $_GET['contador'];
  }
  ?>

  <table>
    <tr>
      <td>
        <a href="ejercicio3redirect.php?num=1&contador=<?= $contador ?>">
          <div></div>
        </a>
      </td>
      <td>
        <a href="ejercicio3redirect.php?num=2&contador=<?= $contador ?>">
          <div></div>
        </a>
      </td>
      <td>
        <a href="ejercicio3redirect.php?num=3&contador=<?= $contador ?>">
          <div></div>
        </a>
      </td>
    </tr>
    <tr>
      <td>
        <a href="ejercicio3redirect.php?num=4&contador=<?= $contador ?>">
          <div></div>
        </a>
      </td>
      <td>
        <a href="ejercicio3redirect.php?num=5&contador=<?= $contador ?>">
          <div></div>
        </a>
      </td>
      <td>
        <a href="ejercicio3redirect.php?num=6&contador=<?= $contador ?>">
          <div></div>
        </a>
      </td>
    </tr>
    <tr>
      <td>
        <a href="ejercicio3redirect.php?num=7&contador=<?= $contador ?>">
          <div></div>
        </a>
      </td>
      <td>
        <a href="ejercicio3redirect.php?num=8&contador=<?= $contador ?>">
          <div></div>
        </a>
      </td>
      <td>
        <a href="ejercicio3redirect.php?num=9&contador=<?= $contador ?>">
          <div></div>
        </a>
      </td>
    </tr>
    <tr>Contador <?php echo $contador; ?> </tr>
  </table>

  <h2>Introduce el nombre del artista:</h2>
  <form action="ejercicio3redirect.php" method="get">
    <input type="hidden" name="contador" value="<?= $contador ?>" />
    <input type="text" name="nombre" />
    <input type="submit" value="Continuar" />
  </form>
</body>

</html>