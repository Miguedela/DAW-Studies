package Boletin2;

public class Ejercicio5_EmisorasFM {
    // Variable de instancia para almacenar la frecuencia actual
    private double frecuencia;

    // Constructor que inicializa la frecuencia a 80 (valor inicial)
    public Ejercicio5_EmisorasFM() {
        this.frecuencia = 80;
    }

    // Método para subir la frecuencia
    public void subir() {
        frecuencia += 0.5;
        // Verificar si la frecuencia supera el límite superior (108)
        if (frecuencia > 108) {
            System.out.println("Sintonización no permitida, has sobrepasado el límite (80-108)");
            frecuencia = 80; // Reiniciar la frecuencia al límite inferior (80)
        }
        System.out.println("Emisora actual: " + frecuencia);
    }

    // Método para bajar la frecuencia
    public void bajar() {
        frecuencia -= 0.5;
        // Verificar si la frecuencia cae por debajo del límite inferior (80)
        if (frecuencia < 80) {
            System.out.println("Sintonización no permitida, has sobrepasado el límite (80-108)");
            frecuencia = 108; // Reiniciar la frecuencia al límite superior (108)
        }
        System.out.println("Emisora actual: " + frecuencia);
    }

    // Método main para probar la clase Ejercicio5_EmisorasFM
    public static void main(String[] args) {
        // Crear una instancia de Ejercicio5_EmisorasFM
        Ejercicio5_EmisorasFM emisoras1 = new Ejercicio5_EmisorasFM();

        // Probar los métodos subir() y bajar() para cambiar la frecuencia
        emisoras1.subir();
        emisoras1.subir();
        emisoras1.subir();
        emisoras1.subir();
        emisoras1.subir();
        emisoras1.bajar();
    }
}
