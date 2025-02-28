<?php
require_once 'FotografiasDB.php';
class Usuario
{
	// VARIABLES
	private $id;
	private $nombre;

	function __construct($id = 0, $nombre = "")
	{
		$this->id = $id;
		$this->nombre = $nombre;
	}

	// GETTERS Y SETTERS
	public function getId()
	{
		return $this->id;
	}

	public function setId($id)
	{
		$this->id = $id;

		return $this;
	}

	public function getNombre()
	{
		return $this->nombre;
	}

	public function setNombre($nombre)
	{
		$this->nombre = $nombre;

		return $this;
	}

	// METODOS
	public function insert()
	{
		$conexion = FotografiasDB::connectDB();
		$insercion = "INSERT INTO usuarios VALUES (null, '$this->nombre')";
		$conexion->exec($insercion);
	}
	public function delete()
	{
		$conexion = FotografiasDB::connectDB();
		$borrado = "DELETE FROM usuarios WHERE id=$this->id";
		$conexion->exec($borrado);
	}
	public function update()
	{
		$conexion = FotografiasDB::connectDB();
		$actualiza = "UPDATE usuarios SET nombre='$this->nombre' WHERE id=$this->id";
		$conexion->exec($actualiza);
	}

	// METODOS ESTÁTICOS
	public static function getUsuarios()
	{
		$conexion = FotografiasDB::connectDB();
		$seleccion = "SELECT * FROM usuarios ORDER BY nombre";
		$consulta = $conexion->query($seleccion);
		$usuarios = [];
		while ($registro = $consulta->fetchObject()) {
			$usuarios[] = new Usuario($registro->id, $registro->nombre);
		}
		return $usuarios;
	}

	public static function getNombreUsuario($idUsuario)
	{
		$conexion = FotografiasDB::connectDB();
		$consulta = $conexion->query("SELECT * FROM usuarios WHERE id='$idUsuario'");

		$registro = $consulta->fetchObject();

		return $registro->nombre;
	}

	public static function getIdUsuario($nombreUsuario)
	{
		$conexion = FotografiasDB::connectDB();
		$consulta = $conexion->query("SELECT * FROM usuarios WHERE nombre='$nombreUsuario'");

		$registro = $consulta->fetchObject();

		return $registro->id;
	}

	public static function comprobarUsuario($nombreUsuario)
	{
		$conexion = FotografiasDB::connectDB();
		$consulta = $conexion->query("SELECT * FROM usuarios WHERE nombre='$nombreUsuario'");

		if ($consulta->rowCount() > 0) {
			return true;
		}

		return false;
	}
}
