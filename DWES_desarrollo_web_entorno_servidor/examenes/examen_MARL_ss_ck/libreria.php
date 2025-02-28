<?php
function agregarEmail($email)
{
    $rutaArchivo = "ficheros/emails.txt";

    $archivo = fopen($rutaArchivo, "a");
    $linea = $email->getEmisor() . ',' . $email->getReceptor() . ',' . $email->getFecha() . ',' . $email->getAsunto();
    fwrite($archivo, $linea . PHP_EOL);

    fclose($archivo);

    $_SESSION['emails'] = devolverEmails();
}

function actualizarFichero()
{
    $rutaArchivo = 'ficheros/emails.txt';

    $archivo = fopen($rutaArchivo, "w");
    foreach ($_SESSION['emails'] as $key => $email) {
        $linea = $email->getEmisor() . ',' . $email->getReceptor() . ',' . $email->getFecha() . ',' . $email->getAsunto();
        fwrite($archivo, $linea . PHP_EOL);
    }
    fclose($archivo);
}
