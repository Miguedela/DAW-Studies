<?php
require_once 'TiendaTractoresDB.php';

class Usuario
{
    // ATRIBUTOS
    private $codigo;
    private $nombre;
    private $correo;
    private $telefono;
    private $contrasenia;

    // CONSTRUCTOR
    function __construct($codigo = 0, $nombre = "", $correo = "", $telefono = "", $contrasenia = "")
    {
        $this->codigo = $codigo;
        $this->nombre = $nombre;
        $this->correo = $correo;
        $this->telefono = $telefono;
        $this->contrasenia = $contrasenia;
    }

    // GETTERS
    public function getCodigo()
    {
        return $this->codigo;
    }

    public function getNombre()
    {
        return $this->nombre;
    }

    public function getCorreo()
    {
        return $this->correo;
    }

    public function getTelefono()
    {
        return $this->telefono;
    }

    public function getContrasenia()
    {
        return $this->contrasenia;
    }

    // METODOS
    public function insert()
    {
        $conexion = TiendaTractoresDB::connectDB();
        $insercion = "INSERT INTO usuario (codigo, nombre, correo, telefono, contrasenia) VALUES ('$this->codigo', '$this->nombre', '$this->correo', '$this->telefono', '$this->contrasenia')";
        $conexion->exec($insercion);
        $conexion = null;
    }

    public function delete()
    {
        $conexion = TiendaTractoresDB::connectDB();
        $borrado = "DELETE FROM usuario WHERE codigo = $this->codigo";
        $conexion->exec($borrado);
        $conexion = null;
    }

    public function comprobarUsuario()
    {
        $conexion = TiendaTractoresDB::connectDB();
        $consulta = $conexion->query("SELECT * FROM usuario WHERE nombre = '$this->nombre' AND contrasenia = '$this->contrasenia'");

        if ($consulta->rowCount() > 0) {
            $usuario = $consulta->fetchObject();
            $usuario = new Usuario($usuario->codigo, $usuario->nombre, $usuario->correo, $usuario->telefono, $usuario->contrasenia);
            $conexion = null;
            return $usuario;
        } else {
            $conexion = null;
            return false;
        }
    }
}
