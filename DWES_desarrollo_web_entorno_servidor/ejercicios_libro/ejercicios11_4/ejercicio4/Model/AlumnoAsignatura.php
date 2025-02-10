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
    public function insert()
    {
        $conexion = CentroEducativo::connectDB();
        $insercion = "INSERT INTO alumno_asignatura (matricula_alumno, codigo_asignatura) VALUES ('$this->matricula_alumno', '$this->codigo_asignatura')";
        $conexion->exec($insercion);
        $conexion = null;
    }

    public function delete()
    {
        $conexion = CentroEducativo::connectDB();
        $borrado = "DELETE FROM alumno_asignatura WHERE matricula_alumno='$this->matricula_alumno' AND codigo_asignatura='$this->codigo_asignatura'";
        $conexion->exec($borrado);
        $conexion = null;
    }

    public function deleteAsignatura()
    {
        $conexion = CentroEducativo::connectDB();
        $borrado = "DELETE FROM alumno_asignatura WHERE codigo_asignatura='$this->codigo_asignatura'";
        $conexion->exec($borrado);
        $conexion = null;
    }
    public function deleteAlumno()
    {
        $conexion = CentroEducativo::connectDB();
        $borrado = "DELETE FROM alumno_asignatura WHERE matricula_alumno='$this->matricula_alumno'";
        $conexion->exec($borrado);
        $conexion = null;
    }

    // METODOS ESTATICOS
    public static function getAlumnosByAsignatura($codigo_asignatura)
    {
        $conexion = CentroEducativo::connectDB();
        $seleccion = "SELECT alumno.* FROM alumno_asignatura 
                  JOIN alumno ON alumno_asignatura.matricula_alumno = alumno.matricula 
                  WHERE alumno_asignatura.codigo_asignatura='$codigo_asignatura'";
        $consulta = $conexion->query($seleccion);

        $alumnos = [];
        while ($alumno = $consulta->fetchObject()) {
            $alumnos[$alumno->matricula] = new Alumno(
                $alumno->matricula,
                $alumno->nombre,
                $alumno->apellidos,
                $alumno->curso
            );
        }

        $conexion = null;
        return $alumnos;
    }

    public static function getAsignaturasByAlumno($matricula)
    {
        $conexion = CentroEducativo::connectDB();
        $seleccion = "SELECT asignatura.* FROM alumno_asignatura 
                  JOIN asignatura ON alumno_asignatura.codigo_asignatura = asignatura.codigo 
                  WHERE alumno_asignatura.matricula_alumno='$matricula'";
        $consulta = $conexion->query($seleccion);

        $asignaturas = [];
        while ($asignatura = $consulta->fetchObject()) {
            $asignaturas[$asignatura->codigo] = new Asignatura(
                $asignatura->codigo,
                $asignatura->nombre
            );
        }

        $conexion = null;
        return $asignaturas;
    }

    public static function getAsignaturasLibresByAlumno($matricula)
    {
        $conexion = CentroEducativo::connectDB();
        $seleccion = "SELECT * FROM asignatura WHERE asignatura.codigo NOT IN 
                  (SELECT codigo_asignatura FROM alumno_asignatura WHERE matricula_alumno='$matricula')";
        $consulta = $conexion->query($seleccion);

        $asignaturasLibres = [];
        while ($asignatura = $consulta->fetchObject()) {
            $asignaturasLibres[$asignatura->codigo] = new Asignatura(
                $asignatura->codigo,
                $asignatura->nombre
            );
        }

        $conexion = null;
        return $asignaturasLibres;
    }
}
