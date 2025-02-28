<?php
// Clase Perro
class Perro extends Mamifero
{
    public function ladrar()
    {
        return "$this->nombre dice: Guau.";
    }

    public function cavar()
    {
        return "$this->nombre está cavando un hoyo.";
    }

    public function moverCola()
    {
        return "$this->nombre está moviendo la cola.";
    }
}
