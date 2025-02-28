<?php
include_once 'Vehiculo.php';
class Coche extends Vehiculo
{
    public function quemarRueda()
    {
        return "Estás quemando rueda con el coche";
    }
}
