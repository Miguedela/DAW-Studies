<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
    <?php
    if (isset($_REQUEST['hora'])) {
        $hora = $_REQUEST['hora'];
        if ($hora >= 6 && $hora <= 12) {
            echo "Buenos días";
        } else if ($hora >= 13 && $hora <= 20) {
            echo "Buenos tardes";
        } else if ($hora >= 21 || $hora <= 5) {
            echo "Buenos noches";
        }
    } else {
    }
    ?>
</body>

</html>