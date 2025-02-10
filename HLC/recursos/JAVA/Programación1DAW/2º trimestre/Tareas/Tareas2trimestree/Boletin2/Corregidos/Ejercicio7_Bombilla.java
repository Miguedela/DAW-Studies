package Boletin2.Corregidos;

public class Ejercicio7_Bombilla {
    private String bombilla;  // Nombre de la bombilla
    private double consumo;   // Consumo de energía de la bombilla
    static double consumoTotal;  // Consumo total de todas las bombillas
    private boolean encendido;  // Estado de la bombilla (encendida o apagada)

    // Método constructor
    public Ejercicio7_Bombilla(String bombilla, double consumo) {
        this.bombilla = bombilla;
        this.consumo = consumo;
        this.encendido = false;  // Inicialmente, la bombilla está apagada
    }

    // Método para encender la bombilla
    public void encender() {
        encendido = true;
        consumoTotal += consumo;  // Aumenta el consumo total
        System.out.println("La luz de " + bombilla + " ahora está encendida. El consumo instantáneo es de " + consumoTotal + " kWh.");
    }

    // Método para apagar la bombilla
    public void apagar() {
        if (encendido) {
            encendido = false;
            consumoTotal -= consumo;  // Reduce el consumo total
            System.out.println("La luz de " + bombilla + " ahora está apagada. El consumo instantáneo es de " + consumoTotal + " kWh.");
        } else {
            System.out.println("La bombilla de " + bombilla + " ya está apagada.");
        }
    }

    // Método principal (main) para probar la clase
    public static void main(String[] args) {
        // Crear tres instancias de la clase Ejercicio7_Bombilla
        Ejercicio7_Bombilla bombilla1 = new Ejercicio7_Bombilla("a", 2.3);
        Ejercicio7_Bombilla bombilla2 = new Ejercicio7_Bombilla("b", 2.3);
        Ejercicio7_Bombilla bombilla3 = new Ejercicio7_Bombilla("c", 2.3);

        // Encender las bombillas
        bombilla1.encender();
        bombilla2.encender();
        bombilla3.encender();

        // Apagar las bombillas
        bombilla1.apagar();
        bombilla2.apagar();
        bombilla3.apagar();
    }
}