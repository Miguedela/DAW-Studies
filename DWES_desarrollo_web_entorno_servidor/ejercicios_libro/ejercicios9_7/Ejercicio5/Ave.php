<?php
// Clase Ave
class Ave extends Animal
{
    public function volar()
    {
        return "$this->nombre está volando.";
    }

    public function ponerHuevo()
    {
        return "$this->nombre ha puesto un huevo.";
    }
}
