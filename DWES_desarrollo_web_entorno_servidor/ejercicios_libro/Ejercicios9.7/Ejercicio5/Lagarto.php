<?php
// Clase Lagarto
class Lagarto extends Animal
{
    public function tomarSol()
    {
        return "$this->nombre está tomando el sol.";
    }

    public function mudarPiel()
    {
        return "$this->nombre está mudando su piel.";
    }

    public function escalar()
    {
        return "$this->nombre está escalando una roca.";
    }
}
