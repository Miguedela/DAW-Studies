<?php
require_once '../Model/MantenimientoDB.php';
class Usuario
{
    private $id;
    private $nombre;
    private $perfil;

    function __construct($id = 0, $nombre = "", $perfil = "")
    {
        $this->id = $id;
        $this->nombre = $nombre;
        $this->perfil = $perfil;
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

    // METODOS
    public function insert()
    {
        $conexion = MantenimientoDB::connectDB();
        $insercion = "INSERT INTO usuario (nombre, perfil) VALUES ('$this->nombre', '$this->perfil')";
        $conexion->exec($insercion);
    }

    public static function getUsuarios()
    {
        $conexion = MantenimientoDB::connectDB();
        $seleccion = "SELECT * FROM usuario";
        $consulta = $conexion->query($seleccion);
        $usuarios = [];
        while ($registro = $consulta->fetchObject()) {
            $usuarios[] = new Usuario($registro->id, $registro->nombre, $registro->perfil);
        }
        return $usuarios;
    }
    public static function getUsuarioById($id)
    {
        $conexion = MantenimientoDB::connectDB();
        $seleccion = "SELECT * FROM usuario WHERE id=$id";
        $consulta = $conexion->query($seleccion);
        if ($consulta->rowCount() > 0) {
            $registro = $consulta->fetchObject();
            $usuario = new Usuario($registro->id, $registro->nombre, $registro->perfil);
            return $usuario;
        } else {
            return false;
        }
    }

    public static function getUsuarioByNombre($nombre)
    {
        $conexion = MantenimientoDB::connectDB();
        $consulta = $conexion->query("SELECT * FROM usuario WHERE nombre='$nombre'");

        if ($consulta->rowCount() > 0) {
            $registro = $consulta->fetchObject();
            $usuario = new Usuario($registro->id, $registro->nombre, $registro->perfil);
            return $usuario;
        } else {
            return false;
        }
    }

    public static function comprobarUsuario($nombreUsuario)
    {
        $conexion = MantenimientoDB::connectDB();
        $consulta = $conexion->query("SELECT * FROM usuario WHERE nombre='$nombreUsuario'");

        if ($consulta->rowCount() > 0) {
            return true;
        }

        return false;
    }

    public static function comprobarUsuarioById($idUsuario)
    {
        $conexion = MantenimientoDB::connectDB();
        $consulta = $conexion->query("SELECT * FROM usuario WHERE id='$idUsuario'");

        if ($consulta->rowCount() > 0) {
            return true;
        }

        return false;
    }

    public static function comprobarAdmin($nombreUsuario)
    {
        $conexion = MantenimientoDB::connectDB();
        $consulta = $conexion->query("SELECT * FROM usuario WHERE nombre='$nombreUsuario'");

        if ($consulta->rowCount() > 0) {
            $registro = $consulta->fetchObject();

            if ($registro->perfil == 'admin') {
                return true;
            }
        }

        return false;
    }

    public static function comprobarAdminById($idUsuario)
    {
        $conexion = MantenimientoDB::connectDB();
        $consulta = $conexion->query("SELECT * FROM usuario WHERE id='$idUsuario'");

        if ($consulta->rowCount() > 0) {
            $registro = $consulta->fetchObject();

            if ($registro->perfil == 'admin') {
                return true;
            }
        }

        return false;
    }

    public static function getIdUsuario($nombreUsuario)
    {
        $conexion = MantenimientoDB::connectDB();
        $consulta = $conexion->query("SELECT * FROM usuario WHERE nombre='$nombreUsuario'");

        $registro = $consulta->fetchObject();

        return $registro->id;
    }

    public static function getNombreUsuario($idUsuario)
    {
        $conexion = MantenimientoDB::connectDB();
        $consulta = $conexion->query("SELECT * FROM usuario WHERE id='$idUsuario'");

        $registro = $consulta->fetchObject();

        return $registro->nombre;
    }
}
