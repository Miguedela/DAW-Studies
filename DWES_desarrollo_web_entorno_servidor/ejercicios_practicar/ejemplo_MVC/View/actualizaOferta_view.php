<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title></title>
  </head>
  <body>
    <form action="../Controller/updateOferta.php"  enctype="multipart/form-data" method="POST">
      <input type="hidden" name="id" value="<?= $data['oferta']->getId() ?>">
      <h3>Título</h3>
      <input type="text" size="40" name="titulo" value="<?= $data['oferta']->getTitulo() ?>">
      <h3>Imagen</h3>
      <input type="hidden" name="imagenAnterior" value="<?= $data['oferta']->getImagen() ?>">
      <img src="../View/images/<?= $data['oferta']->getImagen() ?>" alt="" width="150px"><br>
      <input type="file" id="imagen" name="imagen">
      <br><h3>Descripción</h3>
      <textarea name="descripcion" cols="60" rows="6">
      <?= $data['oferta']->getDescripcion() ?>
      </textarea><hr>
      <input type="submit" value="Aceptar">
    </form>
  </body>
</html>
