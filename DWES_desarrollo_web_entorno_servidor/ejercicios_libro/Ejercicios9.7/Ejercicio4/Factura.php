<!--
Creamos  la  clase  factura  con  el  atributo  de  clase  IVA  (21)  y  los  atributos  de  instancia  ImporteBase,  fecha, 
estado (pagada o pendiente) y productos (array con todos los productos de la factura, que contiene el nombre, 
precio y cantidad). 

Define los métodos AñadeProducto, ImprimeFactura y los getters  y setters de los atributos ImporteBase (solo 
getter, pues su contenido se actualiza automaticamente), fecha y estado.
-->
<?php
class Factura
{
    // ATRIBUTOS DE CLASE
    const IVA = 21;

    // ATRIBUTOS DE INSTANCIA
    private $ImporteBase;
    private $fecha;
    private $estado;
    private $productos;

    // CONSTRUCTOR
    public function __construct($fecha, $estado = "pendiente")
    {
        $this->fecha = $fecha;
        $this->estado = $estado;
        $this->productos = [];
        $this->ImporteBase = 0.0; // Inicialmente 0
    }

    // GETTERS Y SETTERS
    public function getImporteBase()
    {
        return $this->ImporteBase;
    }

    public function setImporteBase($ImporteBase)
    {
        $this->ImporteBase = $ImporteBase;

        return $this;
    }

    public function getFecha()
    {
        return $this->fecha;
    }

    public function setFecha($fecha)
    {
        $this->fecha = $fecha;

        return $this;
    }

    public function getEstado()
    {
        return $this->estado;
    }

    public function setEstado($estado)
    {
        $this->estado = $estado;

        return $this;
    }

    public function getProductos()
    {
        return $this->productos;
    }

    public function setProductos($productos)
    {
        $this->productos = $productos;

        return $this;
    }

    // METODOS
    // Metodo para añadir un producto a la factura
    public function aniadeProducto($nombre, $precio, $cantidad)
    {
        $this->productos[] = [
            'nombre' => $nombre,
            'precio' => $precio,
            'cantidad' => $cantidad
        ];

        $this->actualizarImporteBase();
    }

    // Metodo para actualizar el importe base
    private function actualizarImporteBase()
    {
        $this->ImporteBase = 0; // Reiniciar ImporteBase
        foreach ($this->productos as $producto) {
            $this->ImporteBase += $producto['precio'] * $producto['cantidad'];
        }
    }

    // Metodo para imprimir la factura
    public function imprimeFactura()
    {
        echo "Fecha: " . $this->fecha . '<br>';
        echo "Estado: " . $this->estado . '<br>';
        echo "Productos:" . PHP_EOL;

        foreach ($this->productos as $producto) {
            echo "- " . $producto['nombre'] . '<br>' . "(Precio: " . $producto['precio'] . ", Cantidad: " . $producto['cantidad'] . ")" . '<br>';
        }

        $IVA = $this->ImporteBase * self::IVA / 100;
        $total = $this->ImporteBase + $IVA;

        echo "Importe Base: " . $this->ImporteBase . '<br>';
        echo "IVA (" . self::IVA . "%): " . $IVA . '<br>';
        echo "Total: " . $total . '<br>';
    }
}

$factura = new Factura('12/12/2024');
$factura->aniadeProducto('Pizza', 15, 3);
$factura->imprimeFactura();
