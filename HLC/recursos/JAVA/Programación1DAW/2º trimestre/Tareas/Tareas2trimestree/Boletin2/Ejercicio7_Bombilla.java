package Boletin2;

public class Ejercicio7_Bombilla {
    // Atributos de instancia
    private String bombilla; // Nombre de la bombilla
    private int consumoKWh; // Consumo de energía en kWh por hora

    // Variable estática para mantener un seguimiento del consumo total de todas las bombillas
    static double consumoTotal;

    // Constructor para inicializar el nombre de la bombilla y su consumo de energía
    public Ejercicio7_Bombilla(String bombilla, int consumoKWh) {
        this.bombilla = bombilla;
        this.consumoKWh = consumoKWh;
    }

    // Método para encender la bombilla y registrar el consumo de energía
    public void encender() {
        consumoTotal += consumoKWh;
        System.out.println("La bombilla de " + bombilla + " está encendida, y llevas consumido un total de " + consumoTotal + " kWh.");
    }

    // Método para apagar la bombilla
    public void apagar() {
        System.out.println("Has apagado la bombilla de " + bombilla + ".");
    }

    // Método main para probar la clase Ejercicio7_Bombilla
    public static void main(String[] args) {
        // Crear instancias de bombillas
        Ejercicio7_Bombilla bombilla1 = new Ejercicio7_Bombilla("Dormitorio", 5);
        Ejercicio7_Bombilla bombilla2 = new Ejercicio7_Bombilla("Baño", 2);

        // Encender y apagar la bombilla1
        bombilla1.encender();
        bombilla1.apagar();
        bombilla1.encender();
        bombilla1.apagar();

        // Encender y apagar la bombilla2
        bombilla2.encender();
        bombilla2.apagar();
        bombilla2.encender();
        bombilla2.apagar();
    }
}
