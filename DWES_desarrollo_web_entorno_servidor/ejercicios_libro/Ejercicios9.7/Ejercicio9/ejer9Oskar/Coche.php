<?php
if (session_status() == PHP_SESSION_NONE) session_start();

if (!isset($_SESSION['precioCaro'])) {
    $_SESSION['modeloCaro']= "";
    $_SESSION['precioCaro']= 0;
}

class Coche 
{
    //Atributos de clase
    // public static $modeloCaro;
    // public static $precioCaro;

    //Atributos de instancia
    private $matricula;
    private $modelo;
    private $precio;

    //Metodos
    public function __construct($matri,$mod,$prec)
    {
        $this->matricula = $matri;
        $this->modelo = $mod;
        $this->precio = $prec;

        //Guardamos en el ss el coche mas caro
        if ($prec>$_SESSION['precioCaro']) {
            $_SESSION['precioCaro']=$prec;
            $_SESSION['modeloCaro']=$mod;
        }
    }

    //gettrs y setters
    public function getMatricula()
    {
        return $this->matricula;
    }

    public function setMatricula($matricula)
    {
        $this->matricula = $matricula;
        return $this;
    }

    public function getModelo()
    {
        return $this->modelo;
    }

    public function setModelo($modelo)
    {
        $this->modelo = $modelo;
        return $this;
    }
    

    public function getPrecio()
    {
        return $this->precio;
    }

    public function setPrecio($precio)
    {
        $this->precio = $precio;
        return $this;
        /*Añadir si es el mas caro se actualice el mas caro*/

    }

    public static function masCaro(){
        $masCaro = $_SESSION['modeloCaro']." ". $_SESSION['precioCaro'] . "€";
        return $masCaro;
    }
}

?>