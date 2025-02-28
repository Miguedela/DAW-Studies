<?php

include_once 'Coche.php';
if (session_status() == PHP_SESSION_NONE) session_start();

if (!isset($_SESSION['precioCaro'])) {
    $_SESSION['modeloCaro']= "";
    $_SESSION['precioCaro']= 0;
}

class CocheLujo extends Coche
{
    //Atributo de instancia
    private $suplemento;

    //Metodos
    public function __construct($matr,$mod,$prec,$supl)
    {
        parent::__construct($matr,$mod,$prec);
        $this->suplemento = $supl;
    }

    public function getPrecio() {
        return parent::getPrecio() + $this->suplemento;
    }

    public function getSuplemento() {
        return $this->suplemento;
    }

    public function setSuplemento($suplemento) {
        $this->suplemento = $suplemento;
    }
}

?>