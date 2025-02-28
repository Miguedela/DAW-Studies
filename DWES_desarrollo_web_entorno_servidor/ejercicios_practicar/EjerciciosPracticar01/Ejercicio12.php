<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
    <?php
    for ($i = 5; $i >= 1; $i--) {
        for ($j = $i; $j < 5; $j++) {
            echo ". ";
        }
        for ($k = 1; $k <= (2 * $i - 1); $k++) {
            if ($k == 1 || $k == (2 * $i - 1) || $i == 5) {
                echo "*";
            } else {
                echo ". ";
            }
        }
        echo "<br>";
    }
    ?>
</body>

</html>