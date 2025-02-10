package ClasesAbstractasYInterfaces.AlquilarCoches;
/*1) Pueden obtener campos, variables y metodos con o sin implementacion
* 2) Las clases pueden tener constructores para instanciar objetos
* 3) Permite herencias mediante la palabra clave extend
* 4)
* 5)
* 6)
* INTERFACES:
* 1) Las interfaces solo pueden contener metodos abstractos sin implementar, y variables finales estaticas
* 2) Las interfaces no pueden tener constructores ya que no puede ser instanciadas directamente
* 3) Si permiten la implementacion multimple, lo que significa que una clase puede implementar multiples interfaces
* */

// Definición de la interfaz Alquilable
public interface Alquilable {
    // Métodos abstractos para alquilar y devolver
    void alquilar();
    void devolver();
}

// Clase que implementa la interfaz Alquilable para un coche
class AlquilarCoche implements Alquilable {
    private String modelo;
    private boolean alquilado;

    // Constructor para inicializar el modelo del coche y el estado de alquiler
    public AlquilarCoche(String modelo) {
        this.modelo = modelo;
        this.alquilado = false;
    }

    // Implementación del método alquilar para un coche
    @Override
    public void alquilar() {
        if (!alquilado) {
            System.out.println("Se ha alquilado el coche " + modelo + ".");
            alquilado = true;
        } else {
            System.out.println("El coche " + modelo + " ya está alquilado.");
        }
    }

    // Implementación del método devolver para un coche
    @Override
    public void devolver() {
        if (alquilado) {
            System.out.println("El coche " + modelo + " se ha devuelto.");
            alquilado = false;
        } else {
            System.out.println("El coche " + modelo + " no está alquilado.");
        }
    }
}

// Clase que implementa la interfaz Alquilable para una bicicleta
class AlquilarBicicleta implements Alquilable {
    private String marca;
    private boolean alquilado;

    // Constructor para inicializar la marca de la bicicleta y el estado de alquiler
    public AlquilarBicicleta(String marca) {
        this.marca = marca;
        this.alquilado = false;
    }

    // Implementación del método alquilar para una bicicleta
    @Override
    public void alquilar() {
        if (!alquilado) {
            System.out.println("Se ha alquilado la bicicleta " + marca + ".");
            alquilado = true;
        } else {
            System.out.println("La bicicleta " + marca + " ya está alquilada.");
        }
    }

    // Implementación del método devolver para una bicicleta
    @Override
    public void devolver() {
        if (alquilado) {
            System.out.println("La bicicleta " + marca + " se ha devuelto.");
            alquilado = false;
        } else {
            System.out.println("La bicicleta " + marca + " no está alquilada.");
        }
    }
}
