<?php
class Animal
{
    protected $nombre;

    public function __construct($nombre)
    {
        $this->nombre = $nombre;
    }

    public function comer()
    {
        return "$this->nombre está comiendo.";
    }

    public function dormir()
    {
        return "$this->nombre está durmiendo.";
    }

    public function mover()
    {
        return "$this->nombre se está moviendo.";
    }
}
