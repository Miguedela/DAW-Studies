<?php
if (session_status() == PHP_SESSION_NONE) session_start();

if (!isset($_SESSION['ultima'])) {
    $_SESSION['ultima'] = 'No se han creado notas en esta sesión';
}
if (!isset($_SESSION['fecha'])) {
    $_SESSION['fecha'] = 0;
}
class Nota
{
    // ATRIBUTOS de instacia
    private $título;
    private $texto;
    private $fechaHora;

    // CONSTRUCTOR
    public function __construct($título, $texto)
    {
        $this->título = $título;
        $this->texto = $texto;
        $this->fechaHora = time();
        $_SESSION['ultima'] = $título;
        $_SESSION['fecha'] = $this->fechaHora;
    }

    // GETTERS Y SETTERS
    public function getTítulo()
    {
        return $this->título;
    }

    public function setTítulo($título)
    {
        $this->título = $título;

        return $this;
    }

    public function getTexto()
    {
        return $this->texto;
    }

    public function setTexto($texto)
    {
        $this->texto = $texto;

        return $this;
    }

    public function getFechaHora()
    {
        return $this->fechaHora;
    }
    public function setFechaHora($fechaHora)
    {
        $this->fechaHora = $fechaHora;

        return $this;
    }

    // GETTERS STATICOS
    public static function getUltimaNota()
    {
        return $_SESSION['ultima'];
    }

    public static function getFechaUltimaNota()
    {
        return $_SESSION['fecha'];
    }
}
