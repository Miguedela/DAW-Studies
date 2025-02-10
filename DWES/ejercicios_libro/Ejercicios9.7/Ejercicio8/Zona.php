<?php
session_start();
class Zona
{
    // ATRIBUTOS DE CLASE
    public static $ingresoTotal = 0;

    // ATRIBUTOS
    private $nombre;
    private $capacidad;
    private $precio;
    private $vendidas;

    // CONSTRUCTOR
    public function __construct($nombre, $capacidad, $precio)
    {
        $this->nombre = $nombre;
        $this->capacidad = $capacidad;
        $this->precio = $precio;
        $this->vendidas = 0;

        // Si existe el valor de ingresoTotal en la sesión, lo restauramos
        if (isset($_SESSION['ingresoTotal'])) {
            self::$ingresoTotal = $_SESSION['ingresoTotal'];
        }
    }

    // GETTERS
    public function getNombre()
    {
        return $this->nombre;
    }

    public function getCapacidad()
    {
        return $this->capacidad;
    }

    public function getPrecio()
    {
        return $this->precio;
    }

    public function getVendidas()
    {
        return $this->vendidas;
    }

    // GETTER auxiliar que devuelve las entradas disponible
    public function getDisponibles()
    {
        return $this->capacidad - $this->vendidas;
    }

    // GETTERS Y SETTERS DE LOS ATRIBUTOS STATICOS
    public static function setIngresoTotal($ingresoTotal)
    {
        self::$ingresoTotal = $ingresoTotal;
    }

    public static function getIngresoTotal()
    {
        return self::$ingresoTotal;
    }

    // METODOS
    public function venderEntradas($cantidad)
    {
        if ($cantidad > $this->getDisponibles()) {
            return "No puedes comprar tantas entradas de este tipo";
        }

        $this->vendidas += $cantidad;
        self::$ingresoTotal += $this->getPrecio() * $cantidad;

        return "Compra realizada con exito";
    }
}
