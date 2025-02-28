<?php
require_once 'TiendaTractoresDB.php';
require_once 'Catalogo.php';

class Carrito
{
    // ATRIBUTOS
    private $codigo_producto;
    private $codigo_usuario;
    private $cantidad;

    // CONSTRUCTOR
    public function __construct($codigo_producto = "", $codigo_usuario = "", $cantidad = 0)
    {
        $this->codigo_producto = $codigo_producto;
        $this->codigo_usuario = $codigo_usuario;
        $this->cantidad = $cantidad;
    }

    // GETTERS
    public function getCodigoProducto()
    {
        return $this->codigo_producto;
    }

    public function getCodigoUsuario()
    {
        return $this->codigo_usuario;
    }

    public function getCantidad()
    {
        return $this->cantidad;
    }

    // SETTERS
    public function setCantidad($cantidad)
    {
        $this->cantidad = $cantidad;
    }

    // METODOS
    public function insert()
    {
        $conexion = TiendaTractoresDB::connectDB();

        if ($this->comprobarProductoCarrito()) {
            $consulta = $conexion->query("SELECT cantidad FROM carrito WHERE codigo_producto='$this->codigo_producto' AND codigo_usuario='$this->codigo_usuario'");
            $registro = $consulta->fetchObject();
            $nuevaCantidad = $registro->cantidad + 1;
            $this->setCantidad($nuevaCantidad);
            $this->update();
        } else {
            $insercion = "INSERT INTO carrito (codigo_producto, codigo_usuario, cantidad) VALUES ('$this->codigo_producto', '$this->codigo_usuario', 1)";
            $conexion->exec($insercion);
        }
        $conexion = null;
    }

    public function delete()
    {
        $conexion = TiendaTractoresDB::connectDB();

        $consulta = $conexion->query("SELECT cantidad FROM carrito WHERE codigo_producto='$this->codigo_producto' AND codigo_usuario='$this->codigo_usuario'");
        $registro = $consulta->fetchObject();

        if ($registro->cantidad > 1) {
            $nuevaCantidad = $registro->cantidad - 1;
            $this->setCantidad($nuevaCantidad);
            $this->update();
        } else {
            $borrado = "DELETE FROM carrito WHERE codigo_producto='$this->codigo_producto' AND codigo_usuario='$this->codigo_usuario'";
            $conexion->exec($borrado);
        }
        $conexion = null;
    }

    public function update()
    {
        $conexion = TiendaTractoresDB::connectDB();
        $actualizar = "UPDATE carrito SET cantidad='$this->cantidad' WHERE codigo_producto='$this->codigo_producto' AND codigo_usuario='$this->codigo_usuario'";
        $conexion->exec($actualizar);
        $conexion = null;
    }

    public function comprobarProductoCarrito()
    {
        $conexion = TiendaTractoresDB::connectDB();
        $consulta = $conexion->query("SELECT * FROM carrito WHERE codigo_producto='$this->codigo_producto' AND codigo_usuario='$this->codigo_usuario'");
        $conexion = null;

        return $consulta->rowCount() > 0;
    }

    // Metodos staticos
    public static function getCarritoUsuario($codigo_usuario)
    {
        $conexion = TiendaTractoresDB::connectDB();
        $consulta = $conexion->query("SELECT * FROM carrito WHERE codigo_usuario='$codigo_usuario'");
        $carrito = [];

        while ($registro = $consulta->fetchObject()) {
            $carrito[$registro->codigo_producto] = new Carrito(
                $registro->codigo_producto,
                $registro->codigo_usuario,
                $registro->cantidad
            );
        }

        $conexion = null;
        return $carrito;
    }

    public static function eliminarCarritoUsuario($codigo_usuario)
    {
        $conexion = TiendaTractoresDB::connectDB();
        $borrado = "DELETE FROM carrito WHERE codigo_usuario='$codigo_usuario'";
        $conexion->exec($borrado);
        $conexion = null;
    }

    public static function obtenerPedidoProducto($codigo_producto, $codigo_usuario)
    {
        $conexion = TiendaTractoresDB::connectDB();
        $consulta = $conexion->query("SELECT cantidad FROM carrito WHERE codigo_producto='$codigo_producto' AND codigo_usuario='$codigo_usuario'");
        $registro = $consulta->fetchObject();
        $conexion = null;

        return $registro->cantidad;
    }

    public static function calcularProductosUsuario($codigo_usuario)
    {
        $conexion = TiendaTractoresDB::connectDB();
        $consulta = $conexion->query("SELECT cantidad FROM carrito WHERE codigo_usuario='$codigo_usuario'");
        $totalProductos = 0;

        while ($registro = $consulta->fetchObject()) {
            $totalProductos += $registro->cantidad;
        }

        $conexion = null;
        return $totalProductos;
    }

    public static function calcularPrecioCarrito($codigo_usuario)
    {
        $conexion = TiendaTractoresDB::connectDB();
        $data['catalogo'] = Catalogo::getArticulos();

        $consulta = $conexion->query("SELECT * FROM carrito WHERE codigo_usuario='$codigo_usuario'");
        $precioTotal = 0;

        while ($registro = $consulta->fetchObject()) {
            $precioTotal += $data['catalogo'][$registro->codigo_producto]->getPrecio() * $registro->cantidad;
        }

        $conexion = null;
        return $precioTotal;
    }
}
