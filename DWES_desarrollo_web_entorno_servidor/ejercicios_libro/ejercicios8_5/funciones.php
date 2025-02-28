<?php
// LEER UN ARCHIVO
// Utilizado: ejercicio1, ejercicio5,
function leerContenidoFichero($ruta)
{
    // Verificar si el archivo existe
    if (file_exists($ruta)) {
        // Abrir el archivo en modo de lectura
        $manejador = fopen($ruta, 'r');

        // Verificar si el archivo se abrió correctamente
        if ($manejador) {
            // Leer y mostrar el contenido del archivo
            echo "<br>Contenido del archivo:" . PHP_EOL;
            while (($linea = fgets($manejador)) !== false) {
                echo "<br>" . $linea;
            }

            // Cerrar el archivo
            fclose($manejador);
        } else {
            echo "No se pudo abrir el archivo para lectura.";
        }
    } else {
        echo "El archivo no existe.";
    }
}

// ESCRIBIR NÚMERO
function escribirEnFichero($ruta, $num)
{
    // Intentar abrir el archivo en el modo adecuado
    $archivo = fopen($ruta, 'a');

    // Verificar si el archivo fue abierto correctamente
    if ($archivo === false) {
        echo "Error al abrir el archivo.";
        return;
    }

    fwrite($archivo, $num . PHP_EOL);

    fclose($archivo);
}

// ESCRIBIR ARRAY DE NÚMEROS
// Utilizado: ejercicio1,
function escribirNumeros($numeros)
{
    $archivo = 'numeros.txt';

    // Abrir el archivo en modo de escritura, crea el archivo si no existe
    $manejador = fopen($archivo, 'w');

    // Verificar si el archivo se abrió correctamente
    if ($manejador) {
        // Escribir los números en tres líneas
        for ($i = 0; $i < count($numeros); $i++) {
            fwrite($manejador, $numeros[$i] . PHP_EOL);
        }

        // Cerrar el archivo
        fclose($manejador);
        echo "Números escrito en el archivo correctamente.";
    } else {
        echo "No se pudo abrir o crear el archivo.";
    }
}

// ESCRIBIR/SOBREESCRIBIR ARRAY DE NÚMEROS
// Utilizado: ejercicio5,
function escribirNumerosMod($ruta, $numeros, $opcion)
{
    // Determinar el modo de operación: 'w' para sobreescribir y 'a' para ampliar
    $modoArchivo = ($opcion === "sobreescribir") ? 'w' : 'a';

    // Intentar abrir el archivo en el modo adecuado
    $archivo = fopen($ruta, $modoArchivo);

    // Verificar si el archivo fue abierto correctamente
    if ($archivo === false) {
        echo "Error al abrir el archivo.";
        return;
    }

    // Escribir cada número del array en el archivo, una línea por número
    foreach ($numeros as $numero) {
        fwrite($archivo, $numero . PHP_EOL);
    }

    fclose($archivo);
}

// Función para escribir en el fichero
// Utilizado: ejercicio7,
function escribirNumerosMod2($ruta, $numeros, $modo = "a")
{
    $modosValidos = ["a", "w"]; // a: agregar, w: sobreescribir
    if (!in_array($modo, $modosValidos)) {
        echo "Modo no válido. Usa 'a' para agregar o 'w' para sobreescribir.";
        return;
    }

    $file = fopen($ruta, $modo); // Abre el fichero en el modo especificado
    if ($file) {
        foreach ($numeros as $numero) {
            fwrite($file, $numero . PHP_EOL); // Escribe cada número en una nueva línea
        }
        fclose($file);
    } else {
        echo "No se pudo abrir el fichero.";
    }
}

// OBTENER SUMA
// Utilizado: ejercicio2, ejercicio4
function obtenerSuma($ruta)
{
    // Verificar si el archivo existe
    if (!file_exists($ruta)) {
        die("El archivo no existe.");
    }

    // Inicializar la suma
    $suma = 0;

    // Abrir el archivo y leer cada línea
    $archivo = fopen($ruta, "r");
    if ($archivo) {
        while (($linea = fgets($archivo)) !== false) {
            // Convertir la línea en un número y sumarlo
            $numero = floatval(trim($linea)); // Convertimos la línea en número
            $suma += $numero;
        }
        fclose($archivo); // Cerrar el archivo
    } else {
        die("No se pudo abrir el archivo.");
    }

    return $suma;
}

// OBTENER ARRAY DE ARCHIVO
// Utilizado: ejercicio3,
function obtenerArrNum($ruta)
{
    $numeros = [];

    // Verificar si el archivo existe
    if (!file_exists($ruta)) {
        throw new Exception("El archivo no existe: $ruta");
    }

    // Abrir el archivo en modo lectura
    $archivo = fopen($ruta, "r");
    if (!$archivo) {
        throw new Exception("No se pudo abrir el archivo: $archivo");
    }

    // Leer cada línea del archivo
    $indice = 0;
    while (($linea = fgets($archivo)) !== false) {
        // Extraer el número de la línea usando expresión regular
        if (preg_match('/\d+/', $linea, $coincidencias)) {
            $numeros[$indice] = intval($coincidencias[0]);
        } else {
            // Si no hay número en la línea, insertar null o un valor predeterminado
            $numeros[$indice] = null;
        }
        $indice++;
    }

    // Cerrar el archivo
    fclose($archivo);

    return $numeros;
}

// ESCRIBIR 3 NÚMEROS
// Utilizado: ejercicio4,
function escribirTresNumeros($archivo, $num1, $num2, $num3)
{
    // Intentar abrir el archivo en el modo adecuado
    $archivo = fopen("numeros.txt", 'w');

    // Verificar si el archivo fue abierto correctamente
    if ($archivo === false) {
        echo "Error al abrir el archivo.";
        return;
    }

    fwrite($archivo, $num1 . PHP_EOL);
    fwrite($archivo, $num2 . PHP_EOL);
    fwrite($archivo, $num3 . PHP_EOL);

    fclose($archivo);
}

//  ESCRIBIR FICHERO DE FORMA INTERCALADA
// Utlilizado: ejercicio9,
function escribirDosFicheros($ruta0, $ruta1, $ruta2)
{
    // Verificar si el archivo existe
    if (file_exists($ruta1) && file_exists($ruta2)) {
        // Abrir el archivo en modo de lectura
        $manejador0 = fopen($ruta0, 'w');
        $manejador1 = fopen($ruta1, 'r');
        $manejador2 = fopen($ruta2, 'r');

        if ($manejador1 && $manejador2) {
            while (($linea1 = fgets($manejador1)) !== false && ($linea2 = fgets($manejador2)) !== false) {
                fwrite($manejador0, $linea1);
                fwrite($manejador0, $linea2);
            }

            while (($linea1 = fgets($manejador1)) !== false) {
                fwrite($manejador0, $linea1);
            }

            while (($linea2 = fgets($manejador2)) !== false) {
                fwrite($manejador0, $linea2);
            }

            // Cerrar los archivos
            fclose($manejador0);
            fclose($manejador1);
            fclose($manejador2);
        } else {
            echo "No se pudo abrir el archivo para lectura.";
        }
    } else {
        echo "El archivo no existe.";
    }
}

// ORDENAR FICHERO
// Utlilizado: ejercicio10,
function ordenarFichero($ruta)
{
    // Verificar si el archivo existe
    if (file_exists($ruta)) {
        // Abrir el archivo en modo de lectura
        $manejador = fopen($ruta, 'r');
        $arrayAux = [];

        if ($manejador) {

            while (!feof($manejador)) {
                $linea = trim(fgets($manejador));
                $arrayAux[] = $linea;
            }
            sort($arrayAux);

            fclose($manejador);

            $manejador = fopen($ruta, 'w');

            foreach ($arrayAux as $value) {
                fwrite($manejador, $value . PHP_EOL);
            }

            // Cerrar los archivos
        } else {
            echo "No se pudo abrir el archivo para lectura.";
        }
    } else {
        echo "El archivo no existe.";
    }
}

// BUSCAR PALABRA EN FICHERO
// Utlilizado: ejercicio11,
function buscarPalabra($ruta, $palabra)
{
    if (file_exists($ruta)) {
        $manejador = fopen($ruta, 'r');

        if ($manejador) {
            $numeroPalabras = 0;

            while (($linea = fgets($manejador)) !== false) {
                $palabras = explode(" ", trim($linea));
                foreach ($palabras as $value) {
                    if (strtolower($palabra) ==  strtolower(trim($value))) {
                        $numeroPalabras++;
                    }
                }
            }

            fclose($manejador);

            return $numeroPalabras;
        } else {
            echo "No se pudo abrir el archivo para lectura.";
        }
    } else {
        echo "El archivo no existe.";
    }
}

// ELIMINAR LINEA DE FICHERO HTML
// Utilizado: ejercicio12,
function eliminarLineaHtml($ruta)
{
    if (file_exists($ruta)) {
        $manejador = fopen($ruta, 'r');
        $contenidoFichero1 = [];

        if ($manejador) {
            while (($linea = fgets($manejador)) !== false) {
                $partes = explode('<', $linea);

                $partes = explode('<', $linea); // Divide la línea cada vez que encuentra '<'
                $lineaSinEtiquetas = "";

                foreach ($partes as $parte) {
                    // Divide cada parte usando '>' para obtener el contenido fuera de las etiquetas
                    $subPartes = explode('>', $parte);

                    if (count($subPartes) > 1) {
                        $lineaSinEtiquetas .= $subPartes[1]; // Toma solo el texto después de '>'
                    } else {
                        $lineaSinEtiquetas .= $subPartes[0]; // Si no hay '>', toma la parte completa
                    }
                }

                if (trim($lineaSinEtiquetas) !== "") {
                    $contenidoFichero1[] = trim($lineaSinEtiquetas) . PHP_EOL;
                }
            }

            fclose($manejador);

            // Guardar el contenido limpio en un nuevo archivo
            $nuevoFichero = fopen('a', 'w');

            if ($nuevoFichero) {
                foreach ($contenidoFichero1 as $value) {
                    fwrite($nuevoFichero, $value);
                }

                fclose($nuevoFichero);

                echo "El archivo 'a' se creó correctamente.";
            } else {
                echo "No se pudo crear el archivo 'a'.";
            }
        } else {
            echo "No se pudo abrir el archivo para lectura.";
        }
    } else {
        echo "El archivo no existe.";
    }
}
