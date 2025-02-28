<?php
require_once 'BlogDB.php';

class Articulo
{
    // ATRIBUTOS
    private $codigo;
    private $titulo;
    private $fechaHora;
    private $contenido;

    // CONSTRUCTOR
    function __construct($codigo = 0, $titulo = "", $fechaHora = "", $contenido = "")
    {
        $this->codigo = $codigo;
        $this->titulo = $titulo;
        $this->fechaHora = $fechaHora;
        $this->contenido = $contenido;
    }

    // GETTERS Y SETTERS
    public function getCodigo()
    {
        return $this->codigo;
    }

    public function getTitulo()
    {
        return $this->titulo;
    }

    public function getFechaHora()
    {
        return $this->fechaHora;
    }

    public function getContenido()
    {
        return $this->contenido;
    }

    public function setCodigo($codigo)
    {
        $this->codigo = $codigo;

        return $this;
    }

    public function setTitulo($titulo)
    {
        $this->titulo = $titulo;

        return $this;
    }

    public function setFechaHora($fechaHora)
    {
        $this->fechaHora = $fechaHora;

        return $this;
    }

    public function setContenido($contenido)
    {
        $this->contenido = $contenido;

        return $this;
    }

    // METODOS
    public function insert()
    {
        $conexion = BlogDB::connectDB();
        $insercion = "INSERT INTO articulo (titulo, fecha_hora, contenido) VALUES ('$this->titulo', now(), '$this->contenido')";
        $conexion->exec($insercion);
        $conexion = null;
    }

    public function delete()
    {
        $conexion = BlogDB::connectDB();
        $borrado = "DELETE FROM articulo WHERE codigo='$this->codigo'";
        $conexion->exec($borrado);
        $conexion = null;
    }

    public function update()
    {
        $conexion = BlogDB::connectDB();
        $actualiza = "UPDATE articulo SET titulo='$this->titulo', fecha_hora=now(), contenido='$this->contenido' WHERE codigo='$this->codigo'";
        $conexion->exec($actualiza);
        $conexion = null;
    }

    // METODOS ESTATICOS
    public static function getArticulos()
    {
        $conexion = BlogDB::connectDB();
        $seleccion = "SELECT * FROM articulo ORDER BY fecha_hora DESC";
        $consulta = $conexion->query($seleccion);

        $articulos = [];

        while ($articulo = $consulta->fetchObject()) {
            $articulos[] = new Articulo($articulo->codigo, $articulo->titulo, $articulo->fecha_hora, $articulo->contenido);
        }

        $conexion = null;
        return $articulos;
    }

    public static function getArticuloById($codigo)
    {
        $conexion = BlogDB::connectDB();
        $seleccion = "SELECT * FROM articulo WHERE codigo='$codigo'";
        $consulta = $conexion->query($seleccion);

        if ($consulta->rowCount() == 0) {
            $conexion = null;
            return false;
        } else {
            $registro = $consulta->fetchObject();
            $articulo = new Articulo(
                $registro->codigo,
                $registro->titulo,
                $registro->fecha_hora,
                $registro->contenido
            );

            $conexion = null;
            return $articulo;
        }
    }
}
