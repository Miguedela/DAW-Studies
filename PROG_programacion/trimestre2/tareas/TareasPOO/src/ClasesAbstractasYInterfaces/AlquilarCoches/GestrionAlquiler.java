package ClasesAbstractasYInterfaces.AlquilarCoches;

public class GestrionAlquiler {
    public static void main(String[] args) {
        // Crear instancias de un coche y una bicicleta para alquilar
        AlquilarCoche coche1 = new AlquilarCoche("Volkswagen jetta");
        AlquilarBicicleta bicicleta1 = new AlquilarBicicleta("btwin");

        // Alquilar y devolver el coche y la bicicleta en diferentes secuencias
        coche1.alquilar();         // Alquilar el coche
        bicicleta1.alquilar();     // Alquilar la bicicleta
        coche1.alquilar();         // Intentar alquilar el coche nuevamente
        bicicleta1.alquilar();     // Intentar alquilar la bicicleta nuevamente
        coche1.devolver();         // Devolver el coche
        bicicleta1.devolver();     // Devolver la bicicleta
        coche1.devolver();         // Intentar devolver el coche nuevamente
        bicicleta1.devolver();     // Intentar devolver la bicicleta nuevamente
    }
}
