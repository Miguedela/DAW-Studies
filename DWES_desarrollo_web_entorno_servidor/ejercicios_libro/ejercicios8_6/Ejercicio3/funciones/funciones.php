<?php
// Función para guardar los tractores en un fichero de texto
// Función para guardar los productos en el archivo
function guardarTractores($catalogo, $ruta)
{
    $archivo = fopen($ruta, 'w');
    if ($archivo === false) {
        echo "Error al abrir el archivo.";
        return;
    }

    // Guardar los productos en el archivo
    foreach ($catalogo as $key => $producto) {
        $linea = implode(';', [$key, $producto['nombre'], $producto['precio'], $producto['imgUrl'], $producto['detalles']]);
        fwrite($archivo, $linea . PHP_EOL);
    }

    fclose($archivo);
}


// Función para sacar la informacion de un fichero de texto
function extraerTractores($ruta)
{
    // Verificar si el archivo existe
    if (file_exists($ruta)) {
        // Abrir el archivo en modo de lectura
        $archivo = fopen($ruta, 'r');

        // Verificar si el archivo se abrió correctamente
        if ($archivo) {
            $tractores = [];

            // Leer cada línea del archivo
            while (($linea = fgets($archivo)) !== false) {
                // Limpiar la línea y separarla por ";"
                $tractorDatos = explode(';', trim($linea));

                // Los datos del tractor (nombre, precio, imgUrl, detalles) los almacenamos en un subarray
                $tractores[$tractorDatos[0]] = [
                    "nombre" => $tractorDatos[1],
                    "precio" => (float)$tractorDatos[2],
                    "imgUrl" => $tractorDatos[3],
                    "detalles" => $tractorDatos[4]
                ];
            }

            // Cerrar el archivo
            fclose($archivo);

            return $tractores;
        } else {
            echo "No se pudo abrir el archivo para lectura.";
        }
    } else {
        echo "El archivo no existe.";
    }
}




// Función para verificar si el archivo está vacío
function esFicheroVacio($ruta)
{
    // Verificar si el archivo existe
    if (file_exists($ruta)) {
        // Obtener el tamaño del archivo
        $tamañoArchivo = filesize($ruta);

        // Si el tamaño es 0, está vacío
        return $tamañoArchivo === 0;
    } else {
        echo "El archivo no existe.";
        return true; // Consideramos un archivo inexistente como vacío
    }
}

// Función para vaciar el archivo
function vaciarFichero($ruta)
{
    // Verificar si el archivo existe
    if (file_exists($ruta)) {
        // Abrir el archivo en modo de escritura para truncarlo
        $archivo = fopen($ruta, 'w');

        // Verificar si el archivo fue abierto correctamente
        if ($archivo) {
            // Cerrar el archivo inmediatamente para vaciarlo
            fclose($archivo);
        } else {
            echo "No se pudo abrir el archivo para vaciarlo.";
        }
    } else {
        echo "El archivo no existe.";
    }
}
