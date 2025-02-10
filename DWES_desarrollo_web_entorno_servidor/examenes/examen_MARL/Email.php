<?php
if (session_status() == PHP_SESSION_NONE) session_start();

if (!isset($_SESSION['importantes'])) {
    $_SESSION['importantes'] = 0;
}
class Email
{
    // ATRIBUTOS DE INSTANCIA
    private $emisor;
    private $receptor;
    private $asunto;
    private $fecha;

    // CONSTRUCTOR
    public function __construct($emisor, $receptor, $asunto, $fecha)
    {
        if (strtolower($emisor) === strtolower($receptor)) {
            $receptor = $receptor . "_bis";
        }
        $this->emisor = $emisor;
        $this->receptor = $receptor;
        $this->asunto = $asunto;
        $this->fecha = $fecha;
    }

    // GETTERS STATICOS
    public static function getImportantes()
    {
        return $_SESSION['importantes'];
    }

    public static function actualizarImportantes()
    {
        $_SESSION['importantes'] = 0;

        foreach ($_SESSION['emails'] as $key => $value) {
            if ($value->comprobarImportante()) {
                $_SESSION['importantes']++;
            }
        }
    }

    // GETTERS
    public function getEmisor()
    {
        return $this->emisor;
    }

    public function getReceptor()
    {
        return $this->receptor;
    }

    public function getAsunto()
    {
        return $this->asunto;
    }

    public function getFecha()
    {
        return $this->fecha;
    }

    // METODOS
    public function destacarAsunto()
    {
        if (!$this->comprobarImportante()) {
            $this->asunto = "IMPORTANTE " . $this->getAsunto();
        }
        return "No se puede detacar el mensaje";
    }

    public function comprobarImportante()
    {
        $partes = explode(" ", $this->getAsunto());

        if (strtolower($partes[0]) == strtolower("IMPORTANTE")) {
            return true;
        } else {
            return false;
        }
    }

    public function retrasarEnvio()
    {
        $fechaEnvio = strtotime($this->getFecha());
        $fechaActual = time();

        if ($fechaEnvio - $fechaActual > 24 * 60 * 60) {
            $fechaEnvio += 24 * 60 * 60;
            $this->fecha = date("d/m/Y", $fechaEnvio);
            return "El envio se ha atrasado un día";
        }
        return "El envio NO se ha podido atrasar";
    }

    public function esRetrasable()
    {
        $fechaEnvio = strtotime($this->getFecha());
        $fechaActual = time();

        if ($fechaEnvio - $fechaActual > 24 * 60 * 60) {
            return true;
        } else {
            return false;
        }
    }
}
