<!--
Crea un blog siguiendo las pautas que se marcan a continuación: 
a) En un blog hay como mínimo una cabecera, una serie de artículos y un pie de página. 
b) Los artículos se almacenan en una base de datos. Sobre cada artículo se debe saber al menos el título, la 
fecha de publicación (o fecha y hora) y el contenido. Además cada artículo tendrá un identificador o código 
único (puede ser un código que se auto-incremente). 
c) El identificador puede ser un número que se vaya incrementando él solo. 
d) La fecha se puede coger del sistema cuando se graba un nuevo artículo. 
e) Crea la clase BlogDB para aislar los datos de la conexión a la base de datos donde se guardan los artículos. 
f)  Crea la clase Articulo con los mismos atributos que campos hay en la tabla articulo de la base de datos. 
Esta clase debe tener implementado el constructor y opcionalmente los getter y setter (se pueden crear de 
forma automática con Alt + Insert). 
g) La  clase  Articulo  tendrá  también  los  métodos  insert  y  delete,  que  deben  insertar  y  borrar 
respectivamente un artículo de la base de datos. 
h) La clase Articulo debe tener también un método de clase getArticulos() que devuelva en un array 
todos los artículos de la base de datos.
-->
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Blog</title>
    <style>
        table,
        tr,
        td,
        th {
            border: 1px solid black;
            border-collapse: collapse;
        }
    </style>
</head>

<body>

    <h1>Blog</h1>

    <table>

        <tr>
            <th>Código</th>
            <th>Titulo</th>
            <th>Fecha y Hora</th>
            <th>Contenido</th>
            <th></th>
        </tr>

        <?php
        foreach ($data['articulos'] as $articulo) {
        ?>
            <tr>

                <td><?= $articulo->getCodigo() ?></td>
                <td><?= $articulo->getTitulo() ?></td>
                <td><?= date('d-m-Y H:i:s', strtotime($articulo->getFechaHora())) ?></td>
                <td><?= $articulo->getContenido() ?></td>

                <td>
                    <form action="../Controller/borrar_controller.php" method="post">
                        <input type="hidden" name="eliminarArticulo" value="<?= $articulo->getCodigo() ?>">
                        <input type="submit" value="Eliminar">
                    </form>
                </td>

                <td>
                    <form action="../Controller/modificar_controller.php" method="post">
                        <input type="hidden" name="modificarArticulo" value="<?= $articulo->getCodigo() ?>">
                        <input type="submit" value="Modificar">
                    </form>
                </td>

            </tr>
        <?php
        }
        ?>

        <tr>
            <td colspan="5"></td>
            <td>
                <form action="../Controller/insertar_controller.php" method="post">
                    <input type="hidden" name="insertarArticulo">
                    <input type="submit" value="Añadir artículo">
                </form>
            </td>
        </tr>

    </table>

</body>

</html>