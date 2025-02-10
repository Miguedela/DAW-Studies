<!--
Confeccionar una clase Empleado con los atributos nombre y sueldo. 
Definir un método “asigna” que reciba como dato el nombre y sueldo y actualice los atributos (debe comprobar 
que el nombre recibido coincide con el atributo nombre y si es así actualiza el atributo sueldo con el sueldo 
recibido).
Plantear un segundo método que imprima el nombre y un mensaje si debe o no pagar impuestos (si el sueldo 
supera a 3000 paga impuestos)
-->
<?php
class Empleado
{
    protected $nombre;
    protected $sueldo;

    public function __construct($nombre, $sueldo)
    {
        $this->nombre = $nombre;
        $this->sueldo = $sueldo;
    }

    // Método para asignar el nombre y sueldo
    public function asigna($nombre, $sueldo)
    {
        // Verificamos si el nombre recibido coincide con el nombre actual del empleado
        if ($this->nombre === $nombre) {
            $this->sueldo = $sueldo;  // Actualizamos el sueldo
        } else {
            echo "El nombre proporcionado no coincide con el registrado.\n";
        }
    }

    // Método para imprimir el nombre y si debe o no pagar impuestos
    public function pagaImpuestos()
    {
        // Comprobamos si el sueldo supera los 3000
        if ($this->sueldo > 3000) {
            echo $this->nombre . " debe pagar impuestos.\n";
        } else {
            echo $this->nombre . " no debe pagar impuestos.\n";
        }
    }
}

$empleado1 = new Empleado("Juan", 2500);

$empleado1->asigna("Juan", 3500);
$empleado1->asigna("Pedro", 4000);

$empleado1->pagaImpuestos();
?>