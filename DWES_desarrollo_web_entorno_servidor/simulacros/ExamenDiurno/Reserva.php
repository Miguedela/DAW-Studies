<?php
if (session_status() == PHP_SESSION_NONE) session_start();

if (!isset($_SESSION['totalPendientes'])) {
    $_SESSION['totalPendientes'] = 0;
}
class Reserva
{
    private $usuario;
    private $fechaHora;
    private $sala;
    private $estado;

    public function __construct($usuario, $fechaHora, $sala)
    {
        $this->usuario = $usuario;
        $this->fechaHora = $this->devolverFecha($fechaHora);
        $this->sala = $sala;
        $this->estado = "PENDIENTE";
    }

    // GETTERS Y SETTERS STATICOS
    public static function getTotalPendientes()
    {
        return $_SESSION['totalPendientes'];
    }

    public static function setTotalPendientes($totalPendientes)
    {
        $_SESSION['totalPendientes'] = $totalPendientes;
    }

    // GETTERS Y SETTERS
    public function getUsuario()
    {
        return $this->usuario;
    }

    // get de la fecha formateada
    public function getFecha()
    {
        return date("d/m/Y", $this->fechaHora);
    }

    // get de la hora formateada
    public function getHora()
    {
        return date("H:i", $this->fechaHora);
    }

    public function getSala()
    {
        return $this->sala;
    }

    public function getEstado()
    {
        return $this->estado;
    }

    // METODOS
    // funcion auxiliar que me devuelve la fecha correcta
    function devolverFecha($fechaHora)
    {
        if ($fechaHora - time() < 24 * 60 * 60) {
            $fechaHora = time() + (24 * 60 * 60);
        }

        return $fechaHora;
    }

    function confirmar()
    {
        $this->estado = "CONFIRMADA";
        self::setTotalPendientes(self::getTotalPendientes() - 1);
        return;
    }

    function cancelar()
    {
        if ($this->fechaHora - time() < 24 * 60 * 60) {
            return "ERROR";
        }

        $this->estado = "CANCELADA";
        self::setTotalPendientes(self::getTotalPendientes() - 1);
        return "OK";
    }
}
