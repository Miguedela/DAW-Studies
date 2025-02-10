<?php
session_start();
if (isset($_REQUEST['aniadirExtra'])) {
    $key = $_REQUEST['aniadirExtra'];

    $_SESSION['coches'][$key]['extras'][] = $_REQUEST['extra'];

    setcookie('coches', base64_encode(serialize($_SESSION['coches'])), strtotime("+1 year"));
    header('Location: simulacro.php');
} else {
    header('Location: simulacro.php');
}
