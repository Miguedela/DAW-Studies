<?php
require_once 'TiendaTractoresDB.php';

class Tractor
{
    // ATRIBUTOS
    private $codigo;
    private $nombre;
    private $precio;
    private $imagen;
    private $descripcion;
    private $stock;

    // CONSTRUCTOR
    function __construct($codigo = 0, $nombre = "", $precio = "", $imagen = "", $descripcion = "", $stock = "")
    {
        $this->codigo = $codigo;
        $this->nombre = $nombre;
        $this->precio = $precio;
        $this->imagen = $imagen;
        $this->descripcion = $descripcion;
        $this->stock = $stock;
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

    public function getPrecio()
    {
        return $this->precio;
    }

    public function getImagen()
    {
        return $this->imagen;
    }

    public function getDescripcion()
    {
        return $this->descripcion;
    }

    public function getStock()
    {
        return $this->stock;
    }

    // METODOS
    public function insert()
    {
        $conexion = TiendaTractoresDB::connectDB();
        $insercion = "INSERT INTO tractor (nombre, precio, imagen, descripcion, stock) VALUES ('$this->nombre', '$this->precio', '$this->imagen', '$this->descripcion', '$this->stock')";
        $conexion->exec($insercion);
        $conexion = null;
    }

    public function delete()
    {
        $conexion = TiendaTractoresDB::connectDB();
        $borrado = "DELETE FROM tractor WHERE codigo='$this->codigo'";
        $conexion->exec($borrado);
        $conexion = null;
    }

    public function update()
    {
        $conexion = TiendaTractoresDB::connectDB();
        $actualiza = "UPDATE tractor SET nombre='$this->nombre', precio='$this->precio', imagen='$this->imagen', descripcion='$this->descripcion', stock='$this->stock' WHERE codigo='$this->codigo'";
        $conexion->exec($actualiza);
        $conexion = null;
    }

    public function reponer($stock)
    {
        $this->stock += $stock; // Actualizo el stock actual del articulo
        $conexion = TiendaTractoresDB::connectDB();
        $actualiza = "UPDATE tractor SET stock='$this->stock' WHERE codigo='$this->codigo'";
        $conexion->exec($actualiza);
        $conexion = null;
    }

    public function extraer($stock)
    {
        $this->stock -= $stock; // Actualizo el stock actual del articulo
        $conexion = TiendaTractoresDB::connectDB();
        $actualiza = "UPDATE tractor SET stock='$this->stock' WHERE codigo='$this->codigo'";
        $conexion->exec($actualiza);
        $conexion = null;
    }

    // METODOS ESTATICOS
    public static function getArticulos()
    {
        $conexion = TiendaTractoresDB::connectDB();
        $seleccion = "SELECT * FROM tractor ORDER BY precio DESC";
        $consulta = $conexion->query($seleccion);

        $tractores = [];

        while ($tractor = $consulta->fetchObject()) {
            $tractores[$tractor->codigo] = new Tractor(
                $tractor->codigo,
                $tractor->nombre,
                $tractor->precio,
                $tractor->imagen,
                $tractor->descripcion,
                $tractor->stock
            );
        }

        $conexion = null;
        return $tractores;
    }

    public static function getTractor($codigo)
    {
        $conexion = TiendaTractoresDB::connectDB();
        $seleccion = "SELECT * FROM tractor WHERE codigo='$codigo'";
        $consulta = $conexion->query($seleccion);

        if ($consulta->rowCount() == 0) {
            $conexion = null;
            return false;
        } else {
            $registro = $consulta->fetchObject();
            $tractor = new Tractor(
                $registro->codigo,
                $registro->nombre,
                $registro->precio,
                $registro->imagen,
                $registro->descripcion,
                $registro->stock
            );

            $conexion = null;
            return $tractor;
        }
    }
}
