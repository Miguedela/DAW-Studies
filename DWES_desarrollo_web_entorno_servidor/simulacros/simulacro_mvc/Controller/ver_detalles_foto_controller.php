<?php
if (session_status() == PHP_SESSION_NONE) session_start();

require_once '../Model/Foto.php';
require_once '../Model/Like.php';
require_once '../Model/Usuario.php';

if (isset($_REQUEST['idFoto'])) {
    $data['foto'] = Foto::getFotosPorId($_REQUEST['idFoto']);
    $data['likesFoto'] = Like::getLikesDeFoto($_REQUEST['idFoto']);
    include '../View/detalles_foto_view.php';
} else {
    header('Location: index_controller.php');
}
