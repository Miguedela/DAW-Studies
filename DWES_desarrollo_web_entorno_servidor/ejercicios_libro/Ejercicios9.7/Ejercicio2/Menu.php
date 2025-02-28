<!--
Confeccionar  una  clase  Menu,  con  los  atributos  titulo  y  enlace  (ambos  son  arrays).  Crear  los  métodos 
necesarios que permitan añadir elementos al menú. Crear los métodos que permitan mostrar el menú en forma 
horizontal o vertical (según que método llamemos).
-->
<?php
class Menu
{
    protected $titulo;
    protected $enlace;

    public function __construct($titulo, $enlace)
    {
        $this->titulo[] = $titulo;
        $this->enlace[] = $enlace;
    }

    // Metodo para añadir un elemento al nav
    public function aniadirElemento($titulo, $enlace)
    {
        $this->titulo[] = $titulo;
        $this->enlace[] = $enlace;
    }

    // Metodo para ver los elementos del nav en horizontal
    function mostrarHorizontal()
    {
        for ($i = 0; $i < count($this->titulo); $i++) {
            echo ' | Título: ' . $this->titulo[$i] . ', enlace: ' . $this->enlace[$i];
        }
        echo '<br>';
    }

    // Metodo para ver los elementos del nav en vertical
    function mostrarVertical()
    {
        for ($i = 0; $i < count($this->titulo); $i++) {
            echo 'Título: ' . $this->titulo[$i] . ' Enlace: ' . $this->enlace[$i] . '<br>';
        }
    }
}

$menu = new Menu('Sobre nosotros', 'sobrenosotros.php');

$menu->aniadirElemento('Inicio', 'index.php');
$menu->aniadirElemento('Productos', 'productos.php');
$menu->aniadirElemento('Contacto', 'contacto.php');

$menu->mostrarHorizontal();
$menu->mostrarVertical();
