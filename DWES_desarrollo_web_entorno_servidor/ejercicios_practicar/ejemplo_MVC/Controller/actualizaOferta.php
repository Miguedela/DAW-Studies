<?php
  require_once '../Model/Oferta.php';
  $data['oferta']=Oferta::getOfertaById($_REQUEST['id']);

  // Carga la vista del formulario de alta de oferta
  include '../View/actualizaOferta_view.php';
