<?php
require_once 'TiendaEjercicio3__12_7.php';

class Cliente
{
    // ATRIBUTOS
    private $nombre;
    private $token;
    private $peticiones;

    // CONSTRUCTOR
    public function __construct(
        $nombre = "",
        $token = "",
        $peticiones = 0
    ) {
        $this->nombre = $nombre;
        $this->token = $token;
        $this->peticiones = $peticiones;
    }

    // GETTERS
    public function getNombre()
    {
        return $this->nombre;
    }

    public function getToken()
    {
        return $this->token;
    }

    public function getPeticiones()
    {
        return $this->peticiones;
    }

    // SETTERS
    public function setPeticiones($cantidad)
    {
        $this->peticiones = $cantidad;
    }

    // METODOS
    public static function validarToken($token)
    {
        $conexion = TiendaEjercicio3__12_7::connectDB();
        $consulta = $conexion->query("SELECT * FROM cliente WHERE token = '$token'");

        if ($consulta->rowCount() > 0) {
            return true;
        }

        return false;
    }

    public static function sumarPeticion($token)
    {
        $conexion = TiendaEjercicio3__12_7::connectDB();
        $consulta = $conexion->query("UPDATE cliente SET peticiones = peticiones + 1 WHERE token = '$token'");
    }
}
