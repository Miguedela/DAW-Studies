<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        table,
        tr,
        th,
        td {
            border: 1px solid black;
        }

        img {
            max-width: 350px;
        }
    </style>
</head>

<body>
    <h1>Perfil de usuario de <?= $_SESSION['usuario'] ?></h1>

    <form style="display: inline;" action="../Controller/cerrar_sesion_controller.php" method="post">
        <input type="hidden" name="cerrarSesion">
        <input type="submit" value="Cerrar sesión">
    </form>

    <form style="display: inline;" action="../Controller/index_controller.php" method="post">
        <input type="submit" value="Página principal">
    </form>

    <p>Subir una imágen</p>
    <form action="../Controller/agregar_foto_controller.php" method="post" enctype="multipart/form-data">
        <input type="hidden" name="agregarFoto">

        <input type="file" name="imagen_file" id="imagen">
        <input type="submit" value="Aceptar">
    </form>

    <table>
        <tr>
            <th colspan="2">Tus Fotos</th>
        </tr>
        <tr>
            <th>IMÁGEN</th>
            <th>Likes acumulados</th>
        </tr>

        <?php
        foreach ($data['fotosUsuario'] as $foto) {
        ?>
            <tr>
                <td>
                    <img src="../img/<?= $foto->getImagen() ?>" alt="">
                </td>

                <td>
                    <?= Like::getLikes($foto->getId()) ?>
                </td>

                <td>
                    <form action="../Controller/eliminar_foto_controller.php" method="post" enctype="multipart/form-data">
                        <input type="hidden" name="eliminarFoto">
                        <input type="hidden" name="idFoto" value="<?= $foto->getId() ?>">

                        <input type="submit" value="Eliminar foto">
                    </form>
                </td>
            </tr>
        <?php
        }
        ?>
    </table>

</body>

</html>