<!--
Realiza  una  aplicación  que  haga  uso  de  cualquier  API  Rest  gratuita  que  encontréis  y  que  proporcione  alguna 
información,  debéis  procesar  esa  información  y  mostrarla  formateada  correctamente.  Si  tenéis  dificultad  para 
encontrar  un  servicio  gratuito,  podéis  usar  el  de  la  página  football-data.org,  que  ofrece  información  de  fútbol 
completísima, de manera gratuita, de todas las ligas del mundo, resultados, equipos, jugadores, etc..., además la 
página contiene mucha información de la API y ejemplos de uso.
-->
<?php
if (session_status() == PHP_SESSION_NONE) session_start();

if (!isset($_SESSION['verTodosPersonajes'])) {
    $_SESSION['verTodosPersonajes'] = 1;
} else if ($_SESSION['verTodosPersonajes'] > 1 && isset($_REQUEST['lastPagePersonajes'])) {
    $_SESSION['verTodosPersonajes'] -= $_REQUEST['lastPagePersonajes'];
} else if ($_SESSION['verTodosPersonajes'] < 42 && isset($_REQUEST['nextPagePersonajes'])) {
    $_SESSION['verTodosPersonajes'] += $_REQUEST['nextPagePersonajes'];
} else if (isset($_REQUEST['primeraPersonajes'])) {
    $_SESSION['verTodosPersonajes'] = $_REQUEST['primeraPersonajes'];
} else if (isset($_REQUEST['ultimaPersonajes'])) {
    $_SESSION['verTodosPersonajes'] = $_REQUEST['ultimaPersonajes'];
}

if (!isset($_SESSION['verTodosPlanetas'])) {
    $_SESSION['verTodosPlanetas'] = 1;
} else if ($_SESSION['verTodosPlanetas'] > 1 && isset($_REQUEST['lastPagePlanetas'])) {
    $_SESSION['verTodosPlanetas'] -= $_REQUEST['lastPagePlanetas'];
} else if ($_SESSION['verTodosPlanetas'] < 7 && isset($_REQUEST['nextPagePlanetas'])) {
    $_SESSION['verTodosPlanetas'] += $_REQUEST['nextPagePlanetas'];
} else if (isset($_REQUEST['primeraPlanetas'])) {
    $_SESSION['verTodosPlanetas'] = $_REQUEST['primeraPlanetas'];
} else if (isset($_REQUEST['ultimaPlanetas'])) {
    $_SESSION['verTodosPlanetas'] = $_REQUEST['ultimaPlanetas'];
}

if (!isset($_SESSION['verTodosCapitulos'])) {
    $_SESSION['verTodosCapitulos'] = 1;
} else if ($_SESSION['verTodosCapitulos'] > 1 && isset($_REQUEST['lastPageCapitulos'])) {
    $_SESSION['verTodosCapitulos'] -= $_REQUEST['lastPageCapitulos'];
} else if ($_SESSION['verTodosCapitulos'] < 3 && isset($_REQUEST['nextPageCapitulos'])) {
    $_SESSION['verTodosCapitulos'] += $_REQUEST['nextPageCapitulos'];
} else if (isset($_REQUEST['primeraCapitulos'])) {
    $_SESSION['verTodosCapitulos'] = $_REQUEST['primeraCapitulos'];
} else if (isset($_REQUEST['ultimaCapitulos'])) {
    $_SESSION['verTodosCapitulos'] = $_REQUEST['ultimaCapitulos'];
}
?>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="css/style.css">
</head>

<body>


    <div class="form ccc">

        <div>
            <h2 style="max-width: 80%; margin: 0 auto;">PERSONAJE</h2>
            <form class="form" action="" method="post">
                <label for="personaje">ID (001- 826).
                    <input type="text" name="personaje" id="personaje" minlength="3" maxlength="3">
                </label><br>
                <input type="submit" value="Enviar">
            </form>
        </div>

        <div>
            <h2 style="max-width: 80%; text-align: center; margin: 0 auto;">PLANETA</h2>
            <form class="form" action="" method="post">
                <label for="localizacion">ID (001- 126).
                    <input type="text" name="localizacion" id="localizacion" minlength="3" maxlength="3">
                </label><br>
                <input type="submit" value="Enviar">
            </form>
        </div>

        <div>
            <h2 style="max-width: 80%; text-align: center; margin: 0 auto;">CAPITULO</h2>
            <form class="form" action="" method="post">
                <label for="capitulo">ID (001- 051).
                    <input type="text" name="capitulo" id="capitulo" minlength="3" maxlength="3">
                </label><br>
                <input type="submit" value="Enviar">
            </form>
        </div>

    </div>

    <div class="form ccc">
        <div class="bbb">
            <h2>TODOS LOS PERSONAJES</h2>
            <form action="" method="post">
                <input type="hidden" name="verTodosPersonajes">
                <input type="submit" value="Ver todos los personajes">
            </form>
        </div>

        <div class="bbb">
            <h2>TODOS LOS PLANETAS</h2>
            <form action="" method="post">
                <input type="hidden" name="verTodosPlanetas">
                <input type="submit" value="Ver todos los planetas">
            </form>
        </div>

        <div class="bbb">
            <h2>TODOS LOS CAPITULOS</h2>
            <form action="" method="post">
                <input type="hidden" name="verTodosCapitulos">
                <input type="submit" value="Ver todos los capitulos">
            </form>
        </div>

    </div>

    <?php
    if (isset($_REQUEST['personaje'])) {
        $datos = file_get_contents('https://rickandmortyapi.com/api/character/' . $_REQUEST['personaje']);

        if ($datos !== false) {
            $personaje = json_decode($datos);

            echo "<hr>";
            echo "<h2>Personaje: </h2>";
            echo "<h4>ID: " . $personaje->id . "</h4><br>";
            echo '<img src=' . $personaje->image . ' alt=""><br>';
            echo "<h4>Nombre: " . $personaje->name . "</h4><br>";
            echo "<h4>Especie: " . $personaje->species . "</h4><br>";
            echo "<h4>Estado: " . $personaje->status . "</h4><br>";
            echo "<h4>Genero: " . $personaje->gender . "</h4><br>";
            echo "<h4>Origen: " . $personaje->origin->name . "</h4><br>";
        } else {
            echo "No se ha recibido datos.";
        }
    } else if (isset($_REQUEST['localizacion'])) {
        $datos = file_get_contents('https://rickandmortyapi.com/api/location/' . $_REQUEST['localizacion']);

        if ($datos !== false) {
            $location = json_decode($datos);

            echo "<hr>";
            echo "<h2>La localización seleccionada seria: </h2>";
            echo "<h4>ID: " . $location->id . "</h4><br>";
            echo "<h4>Nombre: " . $location->name . "</h4><br>";
            echo "<h4>Tipo: " . $location->type . "</h4><br>";
            echo "<h4>Dimension: " . $location->dimension . "</h4><br>";

            echo "<h3>Habitantes:</h3><br>";
            echo '<div class="wrap">';
            foreach ($location->residents as $value) {
                $datos = file_get_contents($value);
                $personaje = json_decode($datos);

                echo '<img src=' . $personaje->image . ' alt=""><br>';
            }
            echo "</div>";
        } else {
            echo "No se ha recibido datos.";
        }
    } else if (isset($_REQUEST['capitulo'])) {
        $datos = file_get_contents('https://rickandmortyapi.com/api/episode/' . $_REQUEST['capitulo']);

        if ($datos !== false) {
            $episodio = json_decode($datos);

            echo "<hr>";
            echo "<h3>Capítulo: </h3>";
            echo "<h4>ID: " . $episodio->id . "</h4><br>";
            echo "<h4>Nombre: " . $episodio->name . "</h4><br>";
            echo "<h4>Fecha: " . $episodio->air_date . "</h4><br>";
            echo "<h4>Episode: " . $episodio->episode . "</h4><br>";

            echo "<h3>Actores:</h3><br>";
            echo '<div class="wrap">';
            foreach ($episodio->characters as $value) {
                $datos = file_get_contents($value);
                $personaje = json_decode($datos);

                echo '<img src=' . $personaje->image . ' alt=""><br>';
            }
            echo "</div>";
        } else {
            echo "No se ha recibido datos.";
        }
    } else if (isset($_REQUEST['verTodosPersonajes'])) {
        $datos = file_get_contents('https://rickandmortyapi.com/api/character?page=' . $_SESSION['verTodosPersonajes']);

        if ($datos !== false) {

            $characters = json_decode($datos);

            echo "<hr>";
            echo "<h3>Personajes: </h3>";
            echo '<div class="wrap">';
            foreach ($characters->results as $character) {
                echo '<div class="aaa">';
                echo "<h4>ID: " . $character->id . "</h4><br>";
                echo '<img src=' . $character->image . ' alt=""><br>';
                echo "<h4>Nombre: " . $character->name . "</h4><br>";
                echo "<h4>Especie: " . $character->species . "</h4><br>";
                echo "<h4>Estado: " . $character->status . "</h4><br>";
                echo "<h4>Genero: " . $character->gender . "</h4><br>";
                echo "<h4>Origen: " . $character->origin->name . "</h4><br>";
                echo "</div>";
            }
            echo "</div>";

    ?>
            <form action="" method="post" style="display: inline;">
                <input type="hidden" name="verTodosPersonajes">
                <input type="hidden" name="primeraPersonajes" value="1">
                <input type="submit" value="Primera">
            </form>

            <form action="" method="post" style="display: inline;">
                <input type="hidden" name="verTodosPersonajes">
                <input type="hidden" name="lastPagePersonajes" value="1">
                <input type="submit" value="Anterior">
            </form>

            <form action="" method="post" style="display: inline;">
                <input type="hidden" name="verTodosPersonajes">
                <input type="hidden" name="nextPagePersonajes" value="1">
                <input type="submit" value="Siguiente">
            </form>

            <form action="" method="post" style="display: inline;">
                <input type="hidden" name="verTodosPersonajes">
                <input type="hidden" name="ultimaPersonajes" value="42">
                <input type="submit" value="Ultima">
            </form>
        <?php
        } else {
            echo "No se ha recibido datos.";
        }
    } else if (isset($_REQUEST['verTodosPlanetas'])) {
        $datos = file_get_contents('https://rickandmortyapi.com/api/location?page=' . $_SESSION['verTodosPlanetas']);

        if ($datos !== false) {

            $locations = json_decode($datos);

            echo "<hr>";
            echo "<h2>Localizaciones: </h2>";
            echo '<div class="wrap">';
            foreach ($locations->results as $location) {
                echo '<div class="aaa">';
                echo "<hr>";
                echo "<h4>ID: " . $location->id . "</h4><br>";
                echo "<h4>Nombre: " . $location->name . "</h4><br>";
                echo "<h4>Tipo: " . $location->type . "</h4><br>";
                echo "<h4>Dimension: " . $location->dimension . "</h4><br>";
                echo "</div>";
            }
            echo "</div>";

        ?>
            <form action="" method="post" style="display: inline;">
                <input type="hidden" name="verTodosPlanetas">
                <input type="hidden" name="primeraPlanetas" value="1">
                <input type="submit" value="Primera">
            </form>

            <form action="" method="post" style="display: inline;">
                <input type="hidden" name="verTodosPlanetas">
                <input type="hidden" name="lastPagePlanetas" value="1">
                <input type="submit" value="Anterior">
            </form>

            <form action="" method="post" style="display: inline;">
                <input type="hidden" name="verTodosPlanetas">
                <input type="hidden" name="nextPagePlanetas" value="1">
                <input type="submit" value="Siguiente">
            </form>

            <form action="" method="post" style="display: inline;">
                <input type="hidden" name="verTodosPlanetas">
                <input type="hidden" name="ultimaPlanetas" value="7">
                <input type="submit" value="Ultima">
            </form>
        <?php
        } else {
            echo "No se ha recibido datos.";
        }
    } else if (isset($_REQUEST['verTodosCapitulos'])) {
        $datos = file_get_contents('https://rickandmortyapi.com/api/episode?page=' . $_SESSION['verTodosCapitulos']);

        if ($datos !== false) {

            $episodes = json_decode($datos);

            echo "<hr>";
            echo "<h3>Capítulos: </h3>";
            echo '<div class="wrap">';
            foreach ($episodes->results as $episode) {
                echo '<div class="aaa">';
                echo "<hr>";
                echo "<h4>ID: " . $episode->id . "</h4><br>";
                echo "<h4>Nombre: " . $episode->name . "</h4><br>";
                echo "<h4>Fecha: " . $episode->air_date . "</h4><br>";
                echo "<h4>Episode: " . $episode->episode . "</h4><br>";
                echo "</div>";
            }
            echo "</div>";

        ?>
            <form action="" method="post" style="display: inline;">
                <input type="hidden" name="verTodosCapitulos">
                <input type="hidden" name="primeraCapitulos" value="1">
                <input type="submit" value="Primera">
            </form>

            <form action="" method="post" style="display: inline;">
                <input type="hidden" name="verTodosCapitulos">
                <input type="hidden" name="lastPageCapitulos" value="1">
                <input type="submit" value="Anterior">
            </form>

            <form action="" method="post" style="display: inline;">
                <input type="hidden" name="verTodosCapitulos">
                <input type="hidden" name="nextPageCapitulos" value="1">
                <input type="submit" value="Siguiente">
            </form>

            <form action="" method="post" style="display: inline;">
                <input type="hidden" name="verTodosCapitulos">
                <input type="hidden" name="ultimaCapitulos" value="3">
                <input type="submit" value="Ultima">
            </form>
    <?php
        } else {
            echo "No se ha recibido datos.";
        }
    }
    ?>

</body>

</html>