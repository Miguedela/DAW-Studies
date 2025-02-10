package Boletin2;

public class Ejercicio4_Monedero {
    private double dinero; // Variable para almacenar la cantidad de dinero en el monedero

    // Constructor que inicializa el monedero con una cantidad de dinero especificada
    public Ejercicio4_Monedero(double dinero) {
        this.dinero = dinero;
    }

    // Método para ingresar dinero al monedero
    public void ingresarDinero(double dineroParaIngresar) {
        dinero += dineroParaIngresar; // Se suma el dinero ingresado al monedero
    }

    // Método para sacar dinero del monedero
    public void sacarDinero(double dineroParaSacar) {
        if (dineroParaSacar > dinero) { // Verificar si se intenta sacar más dinero del que hay en el monedero
            throw new IllegalArgumentException("No puedes sacar más dinero del que tienes en tu monedero.");
        } else {
            dinero -= dineroParaSacar; // Restar el dinero sacado del monedero
        }
    }

    // Método para mostrar la cantidad de dinero actual en el monedero
    public void verDinero() {
        System.out.printf("Tu cantidad de dinero actual en el monedero es de: %.2f€\n", dinero);
    }

    // Método main para probar la funcionalidad del monedero
    public static void main(String[] args) {
        Ejercicio4_Monedero monederoMigue = new Ejercicio4_Monedero(50); // Crear un monedero con 50€

        monederoMigue.verDinero(); // Mostrar el saldo inicial del monedero
        monederoMigue.sacarDinero(50); // Sacar 50€ del monedero
        monederoMigue.verDinero(); // Mostrar el saldo actual después de sacar dinero
        monederoMigue.ingresarDinero(10); // Ingresar 10€ al monedero
        monederoMigue.verDinero(); // Mostrar el saldo actual después de ingresar dinero
    }
}
