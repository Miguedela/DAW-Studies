<?php
if (session_status() == PHP_SESSION_NONE) session_start();

require_once '../Model/Like.php';

if (isset($_REQUEST['quitarLike'])) {
    $like = new Like($_REQUEST['idImagen'], $_REQUEST['idUsuario']);
    $like->delete();
    header('Location: index_controller.php');
} else {
    header('Location: index_controller.php');
}
