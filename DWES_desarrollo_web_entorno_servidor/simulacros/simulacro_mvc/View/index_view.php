<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        table {
            margin: 0 auto;
        }

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

    <table>
        <tr>
            <th>
                <?php
                if (isset($_SESSION['usuario'])) {
                    echo "<a href='../Controller/ver_cuenta_controller.php'>" . $_SESSION['usuario'] . "</a>";
                } else {
                    echo "<a href='../Controller/redirect_controller.php?iniciarSesionORegistro=true'>Iniciar sesión / Registro</a>";
                }
                ?>
            </th>
        </tr>
        <tr>
            <th>IMÁGEN</th>
            <th>autor</th>
            <th>likes</th>
        </tr>
        <?php
        foreach ($data['fotos'] as $foto) {
        ?>
            <tr>
                <td>
                    <a href="../Controller/ver_detalles_foto_controller.php?idFoto=<?= $foto->getId() ?>">
                        <img src="../img/<?= $foto->getImagen() ?>" alt="">
                    </a>
                </td>

                <td>
                    <h4><?= Usuario::getNombreUsuario($foto->getId_usuario()) ?></h4>
                </td>

                <td>
                    <?= Like::getLikes($foto->getId()) ?>
                </td>

                <?php
                if (
                    isset($_SESSION['usuario']) &&
                    !Like::comprobarLike(
                        $foto->getId(),
                        Usuario::getIdUsuario($_SESSION['usuario'])
                    )
                ) {
                ?>
                    <td>
                        <form action="../Controller/dar_megusta_controller.php" method="post">
                            <input type="hidden" name="darLike">

                            <input type="hidden" name="idImagen" value="<?= $foto->getId() ?>">
                            <input type="hidden" name="idUsuario" value="<?= Usuario::getIdUsuario($_SESSION['usuario']) ?>">

                            <input type="submit" value="Dar like">
                        </form>
                    </td>
                <?php
                } else if (
                    isset($_SESSION['usuario']) &&
                    Like::comprobarLike(
                        $foto->getId(),
                        Usuario::getIdUsuario($_SESSION['usuario'])
                    )
                ) {
                ?>
                    <td>
                        <form action="../Controller/quitar_megusta_controller.php" method="post">
                            <input type="hidden" name="quitarLike">

                            <input type="hidden" name="idImagen" value="<?= $foto->getId() ?>">
                            <input type="hidden" name="idUsuario" value="<?= Usuario::getIdUsuario($_SESSION['usuario']) ?>">

                            <input type="submit" value="Quitar like">
                        </form>
                    </td>
                <?php
                }
                ?>

            </tr>
        <?php
        }
        ?>
    </table>

</body>

</html>