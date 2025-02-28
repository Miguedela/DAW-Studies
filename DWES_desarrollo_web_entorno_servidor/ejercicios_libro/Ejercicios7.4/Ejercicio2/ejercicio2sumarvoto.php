<?php
session_start();

// if para contabilizar los votos
if (isset($_REQUEST['si'])) {
    if (isset($_SESSION['si'])) {
        $_SESSION['si']++;
    } else {
        $_SESSION['si'] = 1;
    }
    setcookie("si", $_SESSION['si'], time() + 3600);
    header("Location: ejercicio2.php");
} else if (isset($_REQUEST['no'])) {
    if (isset($_SESSION['no'])) {
        $_SESSION['no']++;
    } else {
        $_SESSION['no'] = 1;
    }
    setcookie("no", $_SESSION['no'], time() + 3600);
    header("Location: ejercicio2.php");
} else {
    header("Location: ejercicio2.php");
}
?>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>

</body>

</html>