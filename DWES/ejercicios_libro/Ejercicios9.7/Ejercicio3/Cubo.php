<?php
class Cubo
{
    // VARBIABLES
    protected $capacidad;
    protected $contenidoActual;

    // CONTRUCTOR
    public function __construct($capacidad, $contenidoActual)
    {
        $this->capacidad = $capacidad;
        $this->contenidoActual = $contenidoActual;
    }

    // Metodo para obtener la capacidad del cubo
    public function capacidad()
    {
        return $this->capacidad;
    }

    // Metodo para obtener el contenido actual del cubo
    public function contenidoActual()
    {
        return $this->contenidoActual;
    }

    // Metodo para verter contenido de este cubo a otro cubo
    public function verterContenido(Cubo $otroCubo)
    {
        $espacioDisponible = $otroCubo->capacidad - $otroCubo->contenidoActual;

        if ($this->contenidoActual <= $espacioDisponible) {
            $otroCubo->contenidoActual += $this->contenidoActual;
            $this->contenidoActual = 0;
        } else {
            $otroCubo->contenidoActual += $espacioDisponible;
            $this->contenidoActual -= $espacioDisponible;
        }
    }
}

$cubo1 = new Cubo(10, 7); // Cubo con capacidad 10 litros y contenido actual 7 litros
$cubo2 = new Cubo(5, 2);  // Cubo con capacidad 5 litros y contenido actual 2 litros

echo "Contenido inicial del cubo 1: " . $cubo1->contenidoActual() . " litros<br>";
echo "Contenido inicial del cubo 2: " . $cubo2->contenidoActual() . " litros<br>";

$cubo1->verterContenido($cubo2);

echo "Contenido final del cubo 1: " . $cubo1->contenidoActual() . " litros<br>";
echo "Contenido final del cubo 2: " . $cubo2->contenidoActual() . " litros<br>";
