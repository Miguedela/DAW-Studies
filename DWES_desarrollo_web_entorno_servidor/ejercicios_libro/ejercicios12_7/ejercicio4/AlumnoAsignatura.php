<?php
require_once 'CentroEducativo.php';
require_once 'Alumno.php';
require_once 'Asignatura.php';

class AlumnoAsignatura
{
    // ATRIBUTOS
    private $matricula_alumno;
    private $codigo_asignatura;

    // CONSTRUCTOR
    function __construct($matricula_alumno = "", $codigo_asignatura = "")
    {
        $this->matricula_alumno = $matricula_alumno;
        $this->codigo_asignatura = $codigo_asignatura;
    }

    // GETTERS
    public function getMatriculaAlumno()
    {
        return $this->matricula_alumno;
    }

    public function getCodigoAsignatura()
    {
        return $this->codigo_asignatura;
    }

    // METODOS
    public static function getAsignaturasByAlumno($matricula)
    {
        $conexion = CentroEducativo::connectDB();
        $seleccion = "SELECT asignatura.* FROM alumno_asignatura 
                  JOIN asignatura ON alumno_asignatura.codigo_asignatura = asignatura.codigo 
                  WHERE alumno_asignatura.matricula_alumno='$matricula'";
        $consulta = $conexion->query($seleccion);

        $asignaturas = [];
        while ($asignatura = $consulta->fetchObject()) {
            $asignaturas[] = $asignatura;
        }

        $conexion = null;
        return $asignaturas;
    }

    public static function matricularAlumno($matricula_alumno, $codigo_asignatura)
    {
        $conexion = CentroEducativo::connectDB();

        if ($conexion->exec("INSERT INTO alumno_asignatura (matricula_alumno, codigo_asignatura) VALUES ('$matricula_alumno', '$codigo_asignatura')") !== false) {
            $conexion = null;
            return true;
        } else {
            $conexion = null;
            return false;
        }
    }
}
