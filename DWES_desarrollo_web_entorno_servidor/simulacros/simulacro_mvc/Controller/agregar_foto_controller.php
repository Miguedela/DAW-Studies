<?php
if (session_status() == PHP_SESSION_NONE) session_start();

require_once '../Model/Foto.php';
require_once '../Model/Usuario.php';

if (isset($_REQUEST['agregarFoto'])) {
    // Manejar el formulario de subida de imagen
    $fileName = '';

    if (isset($_FILES['imagen_file']) && $_FILES['imagen_file']['error'] === UPLOAD_ERR_OK) {
        $destPath = '../img/' . $_FILES['imagen_file']['name'];
        move_uploaded_file($_FILES['imagen_file']['tmp_name'], $destPath);
        $fileName = $_FILES['imagen_file']['name']; // Guarda el nombre para el producto

        // if (move_uploaded_file($_FILES['imagen_file']['tmp_name'], $destPath)) {
        //     echo "Archivo subido exitosamente: " . $_FILES['imagen_file']['name'];
        //     $fileName = $_FILES['imagen_file']['name']; // Guarda el nombre para el producto
        // } else {
        //     echo "Error al mover el archivo.";
        // }
    } else {
        echo "Error al subir el archivo.";
    }

    $imagen = $fileName;

    $foto = new Foto(null, $imagen, Usuario::getIdUsuario($_SESSION['usuario']));
    $foto->insert();
    header('Location: ver_cuenta_controller.php');
} else {
    header('Location: index_controller.php');
}
