
<?php
class DadoPoker
{
    // Atributos estáticos
    private static $tiradasTotales = 0;
    private static $arrayFiguras = ['As', 'K', 'Q', 'J', '7', '8'];

    private $tirada;

    // Constructor
    public function __construct()
    {
        $this->tirada = [];
    }

    /**
     * Get the value of tiradas
     */
    public function getTirada()
    {
        return $this->tirada;
    }

    public function tira()
    {
        $caraDado = rand(0, 5);
        $this->tirada = $this->nombreFigura($caraDado);
        self::$tiradasTotales++;
    }

    public function nombreFigura($caraDado)
    {
        return self::$arrayFiguras[$caraDado];
    }

    public static function getTiradasTotales()
    {
        return self::$tiradasTotales;
    }
}
