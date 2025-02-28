<?php
  require_once '../Model/Oferta.php';
  $ofertaAux = new Oferta($_REQUEST['id']);
  $ofertaAux->delete();
  header("Location: ../Controller/index.php");