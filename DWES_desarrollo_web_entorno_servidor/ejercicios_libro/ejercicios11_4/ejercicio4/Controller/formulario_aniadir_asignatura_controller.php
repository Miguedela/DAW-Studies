<?php
if (isset($_REQUEST['aniadirAsignatura'])) {
    include '../View/aniadir_asignatura_view.php';
} else {
    header('Location: index_controller.php');
}
