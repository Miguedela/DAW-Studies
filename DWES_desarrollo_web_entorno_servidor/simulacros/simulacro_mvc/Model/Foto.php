<?php
require_once 'FotografiasDB.php';
require_once 'Like.php';
require_once 'Usuario.php';
class Foto
{
	// VARIABLES
	private $id;
	private $imagen;
	private $id_usuario;

	// CONSTRUCTOR
	function __construct($id = 0, $imagen = "", $id_usuario = 0)
	{
		$this->id = $id;
		$this->imagen = $imagen;
		$this->id_usuario = $id_usuario;
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
	public function getImagen()
	{
		return $this->imagen;
	}
	public function setImagen($imagen)
	{
		$this->imagen = $imagen;
		return $this;
	}
	public function getId_usuario()
	{
		return $this->id_usuario;
	}
	public function setId_usuario($id)
	{
		$this->id_usuario = $id;
		return $this;
	}

	// METODOS
	public function insert()
	{
		$conexion = FotografiasDB::connectDB();
		$insercion = "INSERT INTO fotos VALUES (null, '$this->imagen', $this->id_usuario)";
		$conexion->exec($insercion);
	}
	public function delete()
	{
		$conexion = FotografiasDB::connectDB();
		$borrado = "DELETE FROM fotos WHERE id=$this->id";
		$conexion->exec($borrado);
	}
	public function update()
	{
		$conexion = FotografiasDB::connectDB();
		$actualiza = "UPDATE fotos SET id_usuario=$this->id_usuario WHERE id=$this->id";
		$conexion->exec($actualiza);
	}
	public static function getFotos()
	{
		$conexion = FotografiasDB::connectDB();
		$seleccion = "SELECT * FROM fotos ORDER BY imagen";
		$consulta = $conexion->query($seleccion);
		$fotos = [];
		while ($registro = $consulta->fetchObject()) {
			$fotos[] = new Foto($registro->id, $registro->imagen, $registro->id_usuario);
		}
		return $fotos;
	}

	public static function getFotosUsuario($id_usuario)
	{
		$conexion = FotografiasDB::connectDB();
		$seleccion = "SELECT * FROM fotos WHERE id_usuario='$id_usuario'";
		$consulta = $conexion->query($seleccion);
		$fotos = [];
		while ($registro = $consulta->fetchObject()) {
			$fotos[] = new Foto($registro->id, $registro->imagen, $registro->id_usuario);
		}
		return $fotos;
	}

	public static function getFotosPorId($idFoto)
	{
		$conexion = FotografiasDB::connectDB();
		$seleccion = "SELECT * FROM fotos WHERE id='$idFoto'";
		$consulta = $conexion->query($seleccion);

		$registro = $consulta->fetchObject();
		$foto = new Foto($registro->id, $registro->imagen, $registro->id_usuario);

		return $foto;
	}

	// API
	public static function getFotosUsuarioByNombre($nombreUsuario)
	{
		$id = Usuario::getIdUsuario($nombreUsuario);
		$fotos = Foto::getFotosUsuario($id);

		return $fotos;
	}

	public static function updateAutorImagen($id_foto, $id_usuario)
	{
		$conexion = FotografiasDB::connectDB();

		if ($conexion->exec("UPDATE fotos SET id_usuario = '$id_usuario' WHERE id = '$id_foto'") !== false) {
			$conexion = null;
			return true;
		} else {
			$conexion = null;
			return false;
		}
	}
}
