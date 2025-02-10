<?php
if (session_status() == PHP_SESSION_NONE) session_start();
// Creo los atributos estaticos de clase en sessiones
if (!isset($_SESSION['potenciaTotalConsumida'])) {
    $_SESSION['potenciaTotalConsumida'] = 0;
    $_SESSION['interruptorGeneral'] = true;
}
class Bombilla
{
    // ATRIBUTOS de instacia
    private $ubicacionBombilla;
    private $potenciaBombilla;
    private $interruptorBombilla;

    // CONSTRUCTOR
    public function __construct($ubicacionBombilla, $potenciaBombilla)
    {
        $this->ubicacionBombilla = $ubicacionBombilla;
        $this->potenciaBombilla = $potenciaBombilla;
        $this->interruptorBombilla = false;
    }

    // GETTERS de atributos de clase (sessiones)
    public static function setInterruptorGeneral($interruptorGeneral)
    {
        $_SESSION['interruptorGeneral'] = $interruptorGeneral;
    }
    public static function getInterruptorGeneral()
    {
        return $_SESSION['interruptorGeneral'];
    }
    public static function getPotenciaTotalConsumida()
    {
        if ($_SESSION['interruptorGeneral']) {
            return $_SESSION['potenciaTotalConsumida'];
        } else {
            return 0;
        }
    }

    // GETTERS de instancia
    public function getUbicacionBombilla()
    {
        return $this->ubicacionBombilla;
    }
    public function setUbicacionBombilla($ubicacionBombilla)
    {
        $this->ubicacionBombilla = $ubicacionBombilla;

        return $this;
    }
    public function getPotenciaBombilla()
    {
        return $this->potenciaBombilla;
    }
    public function setPotenciaBombilla($potenciaBombilla)
    {
        $this->potenciaBombilla = $potenciaBombilla;

        return $this;
    }
    public function getInterruptorBombilla()
    {
        return $this->interruptorBombilla;
    }
    public function setInterruptorBombilla($interruptorBombilla)
    {
        $this->interruptorBombilla = $interruptorBombilla;

        return $this;
    }

    // METODOS
    // metodo de encender la bombilla
    public function encenderBobmilla()
    {
        if ($this->getInterruptorBombilla()) {
            return;
        }
        $this->interruptorBombilla = true;
        $_SESSION['potenciaTotalConsumida'] += $this->potenciaBombilla;
    }

    // metodo de apagar la bombilla
    public function apagarBobmilla()
    {
        if (!$this->getInterruptorBombilla()) {
            return;
        }
        $this->interruptorBombilla = false;
        $_SESSION['potenciaTotalConsumida'] -= $this->potenciaBombilla;
    }

    // metodo que devuelve el estado de la bombilla
    public function estadoBombilla()
    {
        if ($_SESSION['interruptorGeneral'] && $this->interruptorBombilla) {
            return '<img src="img/encendida.jpg" alt="bombillaEncendidaImg">';
        } else {
            return '<img src="img/apagada.jpg" alt="bombillaEncendidaImg">';
        }
    }
}
