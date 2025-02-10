<?php
// Clase Pingüino
class Pinguino extends Ave
{
    public function nadar()
    {
        return "$this->nombre está nadando en el agua.";
    }

    public function deslizarse()
    {
        return "$this->nombre se está deslizando sobre el hielo.";
    }

    public function volar()
    {
        return "$this->nombre no puede volar, pero camina torpemente.";
    }
}
