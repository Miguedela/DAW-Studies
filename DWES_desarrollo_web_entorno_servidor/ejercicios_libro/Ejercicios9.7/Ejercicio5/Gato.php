<?php
// Clase Gato
class Gato extends Mamifero
{
    public function maullar()
    {
        return "$this->nombre dice: Miau.";
    }

    public function trepar()
    {
        return "$this->nombre está trepando a un árbol.";
    }

    public function ronronear()
    {
        return "$this->nombre está ronroneando.";
    }
}
