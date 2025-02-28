<?php
require_once '../Model/MantenimientoDB.php';
class Usuario {
    private $id;
    private $nombre;
    private $perfil;

    function __construct($id=0, $nombre="", $perfil="") {
        $this->id = $id;	
        $this->nombre = $nombre;
        $this->perfil = $perfil;
    }

    public function insert() {
        $conexion = MantenimientoDB::connectDB();
        $insercion = "INSERT INTO usuario (nombre, perfil) VALUES ('$this->nombre', '$this->perfil')";
        $conexion->exec($insercion);
    }
    
    public static function getUsuarios() {
        $conexion = MantenimientoDB::connectDB();
        $seleccion = "SELECT * FROM usuario";
        $consulta = $conexion->query($seleccion);
        $usuarios = [];
        while ($registro = $consulta->fetchObject()) {
            $usuarios[] = new Usuario($registro->id, $registro->nombre, $registro->perfil);
        }
        return $usuarios;
    }
    public static function getUsuarioById($id) {
        $conexion = MantenimientoDB::connectDB();
        $seleccion = "SELECT * FROM usuario WHERE id=$id";
        $consulta = $conexion->query($seleccion);
        if ($consulta->rowCount()>0) {
            $registro = $consulta->fetchObject();
            $usuario = new Usuario($registro->id, $registro->nombre, $registro->perfil);
            return $usuario;
        }else{
            return false;
        }
    }

    public function getId()
    {
        return $this->id;
    }
    public function getNombre()
    {
        return $this->nombre;
    }

    public function getPerfil()
    {
        return $this->perfil;
    }
}