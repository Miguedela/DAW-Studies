<?php
require_once 'CentroEducativo.php';

class Asignatura
{
    // ATRIBUTOS
    private $codigo;
    private $nombre;

    // CONSTRUCTOR
    function __construct($codigo = 0, $nombre = "")
    {
        $this->codigo = $codigo;
        $this->nombre = $nombre;
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

    // METODOS
    public function insert()
    {
        $conexion = CentroEducativo::connectDB();
        $insercion = "INSERT INTO asignatura (nombre) VALUES ('$this->nombre')";
        $conexion->exec($insercion);
        $conexion = null;
    }

    public function delete()
    {
        $conexion = CentroEducativo::connectDB();
        $borrado = "DELETE FROM asignatura WHERE codigo='$this->codigo'";
        $conexion->exec($borrado);
        $conexion = null;
    }

    // METODOS ESTATICOS
    public static function getAsignaturas()
    {
        $conexion = CentroEducativo::connectDB();
        $seleccion = "SELECT * FROM asignatura";
        $consulta = $conexion->query($seleccion);

        $asignaturas = [];

        while ($asignatura = $consulta->fetchObject()) {
            $asignaturas[$asignatura->codigo] = new Asignatura(
                $asignatura->codigo,
                $asignatura->nombre,
            );
        }

        $conexion = null;
        return $asignaturas;
    }

    public static function getAsignatura($codigo)
    {
        $conexion = CentroEducativo::connectDB();
        $seleccion = "SELECT * FROM asignatura WHERE codigo='$codigo'";
        $consulta = $conexion->query($seleccion);

        if ($consulta->rowCount() == 0) {
            $conexion = null;
            return false;
        } else {
            $registro = $consulta->fetchObject();
            $asignatura = new Asignatura(
                $registro->codigo,
                $registro->nombre,
            );

            $conexion = null;
            return $asignatura;
        }
    }
}
