<?php
require_once 'TiendaEjercicio3__12_7.php';

class Producto
{
    // ATRIBUTOS
    private $nombre;
    private $precio;
    private $imagen_url;

    // CONSTRUCTOR
    public function __construct(
        $nombre = "",
        $precio = "",
        $imagen_url = "https://res.cloudinary.com/dimees8ao/image/upload/v1738326546/tractor2_tzgldl.jpg"
    ) {
        $this->nombre = $nombre;
        $this->precio = $precio;
        $this->imagen_url = $imagen_url;
    }

    // GETTERS
    public function getNombre()
    {
        return $this->nombre;
    }

    public function getPrecio()
    {
        return $this->precio;
    }

    public function getImagen_url()
    {
        return $this->imagen_url;
    }

    // METODOS
    // Método para obtener productos filtrados por precio (puede devolver varios productos)
    public static function getProductosFiltroPrecio($min, $max)
    {
        $conexion = TiendaEjercicio3__12_7::connectDB();
        $consulta = $conexion->query("SELECT * FROM producto WHERE precio BETWEEN '$min' AND '$max'");

        $productos = [];
        while ($fila = $consulta->fetchObject()) {
            $productos[] = $fila;
        }

        return $productos;
    }

    // Método para obtener un solo producto por nombre
    public static function getProductosFiltroNombre($nombre)
    {
        $conexion = TiendaEjercicio3__12_7::connectDB();
        $consulta = $conexion->query("SELECT * FROM producto WHERE nombre LIKE '$nombre'");

        return $consulta->fetchObject() ?: null;
    }
}
