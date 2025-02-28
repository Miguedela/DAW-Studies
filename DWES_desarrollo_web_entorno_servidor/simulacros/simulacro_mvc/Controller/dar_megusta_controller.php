<?php
if (session_status() == PHP_SESSION_NONE) session_start();

require_once '../Model/Like.php';

if (isset($_REQUEST['darLike'])) {
    $like = new Like($_REQUEST['idImagen'], $_REQUEST['idUsuario']);
    $like->insert();
    header('Location: index_controller.php');
} else {
    header('Location: index_controller.php');
}
