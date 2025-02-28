package Boletin2;

public class Ejercicio6_Bombillas {
    // Atributos de instancia
    private boolean encendido; // Estado de la bombilla
    private static boolean interruptorGeneral = true; // Interruptor general compartido entre todas las bombillas

    // Constructor que inicializa el estado de la bombilla como apagado
    public Ejercicio6_Bombillas() {
        this.encendido = false;
    }

    // Método para verificar si la bombilla está encendida, considerando el estado del interruptor general
    public boolean estaEncendida() {
        return encendido && interruptorGeneral;
    }

    // Método para encender la bombilla, si el interruptor general está encendido
    public void encender() {
        if (interruptorGeneral) {
            encendido = true;
        } else {
            System.out.println("No se puede encender la bombilla porque el interruptor general está apagado.");
        }
    }

    // Método para apagar la bombilla
    public void apagar() {
        encendido = false;
    }

    // Método estático para reparar el fusible (encender el interruptor general)
    public static void repararFusible() {
        interruptorGeneral = true;
        System.out.println("El fusible ha sido reparado, todas las bombillas están en el estado en el que estaban.");
    }

    // Método estático para apagar el interruptor general y, por lo tanto, todas las bombillas
    public static void desconectarInterruptorGeneral() {
        interruptorGeneral = false;
        System.out.println("El interruptor general ahora está apagado, por lo tanto, todas las bombillas también.");
    }

    // Método estático para imprimir el estado de las bombillas
    public static void estadoBombilla(Ejercicio6_Bombillas bombilla1, Ejercicio6_Bombillas bombilla2) {
        System.out.println("Estado de las bombillas:");
        System.out.println("Bombilla 1: " + (bombilla1.estaEncendida() ? "encendida" : "apagada"));
        System.out.println("Bombilla 2: " + (bombilla2.estaEncendida() ? "encendida" : "apagada"));
    }

    // Método main para probar la clase Ejercicio6_Bombillas
    public static void main(String[] args) {
        // Crear instancias de bombillas
        Ejercicio6_Bombillas bombilla1 = new Ejercicio6_Bombillas();
        Ejercicio6_Bombillas bombilla2 = new Ejercicio6_Bombillas();

        // Encender las bombillas
        System.out.println("Pulsamos interruptor de encendido de las bombillas:");
        bombilla1.encender();
        bombilla2.encender();

        // Mostrar el estado de las bombillas
        estadoBombilla(bombilla1, bombilla2);

        // Apagar el interruptor general y mostrar el estado de las bombillas
        System.out.println("\nDesconecto el interruptor general:");
        desconectarInterruptorGeneral();
        estadoBombilla(bombilla1, bombilla2);

        // Reparar el interruptor general y mostrar el estado de las bombillas
        System.out.println("\nReparo el interruptor general:");
        repararFusible();
        estadoBombilla(bombilla1, bombilla2);

        // Apagar una de las bombillas y mostrar el estado de las bombillas
        System.out.println("\nApago la bombilla 1:");
        bombilla1.apagar();
        estadoBombilla(bombilla1, bombilla2);
    }
}
