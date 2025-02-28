<?php
if (session_status() == PHP_SESSION_NONE) session_start();

require_once '../Model/Foto.php';
require_once '../Model/Like.php';
require_once '../Model/Usuario.php';

$data['fotos'] = Foto::getFotos();

include '../View/index_view.php';
