<?php
class Vehiculo
{
    // Atributos estáticos
    private static $vehiculosCreados = 0;
    private static $kmTotales = 0;

    // Atributos de instancia
    private $kmRecorridos = 0;

    // Constructor
    public function __construct()
    {
        self::$vehiculosCreados++;
    }

    // Métodos estáticos
    public static function getVehiculosCreados()
    {
        return self::$vehiculosCreados;
    }

    public static function getKmTotales()
    {
        return self::$kmTotales;
    }

    // Métodos de instancia
    public function getKmRecorridos()
    {
        return $this->kmRecorridos;
    }

    public function andar($km)
    {
        if ($km > 0) {
            $this->kmRecorridos += $km;
            self::$kmTotales += $km;
        }
    }
}
