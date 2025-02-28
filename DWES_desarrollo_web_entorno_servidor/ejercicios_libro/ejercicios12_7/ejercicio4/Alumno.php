<?php
require_once 'CentroEducativo.php';

class Alumno
{
    // ATRIBUTOS
    private $matricula;
    private $nombre;
    private $apellidos;
    private $curso;

    // CONSTRUCTOR
    function __construct($matricula, $nombre = "", $apellidos = "", $curso = "")
    {
        $this->matricula = $matricula;
        $this->nombre = $nombre;
        $this->apellidos = $apellidos;
        $this->curso = $curso;
    }

    // GETTERS
    public function getMatricula()
    {
        return $this->matricula;
    }

    public function getNombre()
    {
        return $this->nombre;
    }

    public function getApellidos()
    {
        return $this->apellidos;
    }

    public function getCurso()
    {
        return $this->curso;
    }

    // METODOS
    public static function getAlumnosGrupo($curso)
    {
        $conexion = CentroEducativo::connectDB();
        $consulta = $conexion->query("SELECT * FROM alumno WHERE curso = '$curso'");

        $alumnos = [];
        while ($alumno = $consulta->fetchObject()) {
            $alumnos[] = $alumno;
        }

        $conexion = null;
        return $alumnos;
    }

    public static function getAlumnosNombre($buscador)
    {
        $conexion = CentroEducativo::connectDB();
        $consulta = $conexion->query("SELECT * FROM alumno WHERE nombre LIKE CONCAT('%', '$buscador', '%')");

        $alumnos = [];
        while ($alumno = $consulta->fetchObject()) {
            $alumnos[] = $alumno;
        }

        $conexion = null;
        return $alumnos;
    }

    public static function cambiarGrupo($matricula, $grupo)
    {
        $conexion = CentroEducativo::connectDB();

        if ($conexion->exec("UPDATE alumno SET grupo = '$grupo' WHERE matricula = '$matricula'") !== false) {
            $conexion = null;
            return true;
        } else {
            $conexion = null;
            return false;
        }
    }

    public static function borrarAlumno($matricula)
    {
        $conexion = CentroEducativo::connectDB();

        if ($conexion->exec("DELETE alumno WHERE matricula = '$matricula'") !== false) {
            $conexion = null;
            return true;
        } else {
            $conexion = null;
            return false;
        }
    }
}
