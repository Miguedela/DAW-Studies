class Coched {
    // Atributos
    String marca;
    String modelo;

    // Método constructor
    public Coched(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    // Método para obtener información del coche
    public String obtenerInformacion() {
        return "Coche: " + marca + " " + modelo;
    }
}

// Ejemplo de uso
public class EjemploCoche {
    public static void main(String[] args) {
// Crear instancias de la clase Coche
        Coched coche1 = new Coched("Toyota", "Corolla");
        Coched coche2 = new Coched("Ford", "Mustang");
// Acceder a los métodos y atributos de los objetos
        System.out.println(coche1.obtenerInformacion());
        System.out.println(coche2.obtenerInformacion());
    }
}