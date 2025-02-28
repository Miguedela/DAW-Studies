<?php
// Clase Canario
class Canario extends Ave
{
    public function cantar()
    {
        return "$this->nombre está cantando una melodía.";
    }

    public function saltar()
    {
        return "$this->nombre está saltando de una rama.";
    }
}
