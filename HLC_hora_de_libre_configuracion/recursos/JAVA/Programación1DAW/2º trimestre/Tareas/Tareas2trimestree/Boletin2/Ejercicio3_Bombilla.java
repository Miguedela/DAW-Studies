package Boletin2;

public class Ejercicio3_Bombilla {
    // Variable de instancia para almacenar el estado de la bombilla
    private boolean bombilla;

    // Constructor para inicializar el estado de la bombilla
    public Ejercicio3_Bombilla(boolean bombilla) {
        this.bombilla = bombilla;
    }

    // Método para encender la bombilla
    public void encender() {
        bombilla = true;
        System.out.println("Has encendido la bombilla.");
    }

    // Método para apagar la bombilla
    public void apagar() {
        bombilla = false;
        System.out.println("Has apagado la bombilla.");
    }

    // Método para imprimir el estado de la bombilla
    public void imprimir() {
        if (bombilla) {
            System.out.println("La luz está encendida.");
        } else {
            System.out.println("La luz está apagada.");
        }
    }

    // Método main para probar la clase Ejercicio3_Bombilla
    public static void main(String[] args) {
        // Crear una instancia de Ejercicio3_Bombilla con la bombilla encendida
        Ejercicio3_Bombilla bombilla1 = new Ejercicio3_Bombilla(true);

        // Probar los métodos de la clase Ejercicio3_Bombilla
        System.out.println("Enciendo la bombilla");
        bombilla1.encender();
        bombilla1.imprimir(); // Imprimir el estado de la bombilla después de encenderla
        System.out.println();
        System.out.println("Apago la bombilla");
        bombilla1.apagar();
        bombilla1.imprimir(); // Imprimir el estado de la bombilla después de apagarla
    }
}
