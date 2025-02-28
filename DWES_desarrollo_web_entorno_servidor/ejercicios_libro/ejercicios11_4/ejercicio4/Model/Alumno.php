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
    public function insert()
    {
        $conexion = CentroEducativo::connectDB();
        $insercion = "INSERT INTO alumno (matricula, nombre, apellidos, curso) VALUES ('$this->matricula', '$this->nombre', '$this->apellidos', '$this->curso')";
        $conexion->exec($insercion);
        $conexion = null;
    }

    public function delete()
    {
        $conexion = CentroEducativo::connectDB();
        $borrado = "DELETE FROM alumno WHERE matricula='$this->matricula'";
        $conexion->exec($borrado);
        $conexion = null;
    }

    public function update()
    {
        $conexion = CentroEducativo::connectDB();
        $modificacion = "UPDATE alumno SET nombre='$this->nombre', apellidos='$this->apellidos', curso='$this->curso' WHERE matricula='$this->matricula'";
        $conexion->exec($modificacion);
        $conexion = null;
    }

    // METODOS ESTATICOS
    public static function getAlumnos()
    {
        $conexion = CentroEducativo::connectDB();
        $seleccion = "SELECT * FROM alumno";
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

    public static function getAlumno($matricula)
    {
        $conexion = CentroEducativo::connectDB();
        $seleccion = "SELECT * FROM alumno WHERE matricula='$matricula'";
        $consulta = $conexion->query($seleccion);

        if ($consulta->rowCount() == 0) {
            $conexion = null;
            return false;
        } else {
            $registro = $consulta->fetchObject();
            $alumno = new Alumno(
                $registro->matricula,
                $registro->nombre,
                $registro->apellidos,
                $registro->curso
            );

            $conexion = null;
            return $alumno;
        }
    }
}
