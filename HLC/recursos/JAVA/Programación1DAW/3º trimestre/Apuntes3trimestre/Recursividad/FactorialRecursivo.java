package Recursividad;

public class FactorialRecursivo {
    public static int factorial(int n) {
        if (n == 0) { // Caso base
            return 1;
        } else {
            return n * factorial(n - 1); // Llamada recursiva
        }
    }

    public static void main(String[] args) {
        int numero = 6;
        System.out.println("El factorial de " + numero + " es: " + factorial(numero));
    }
}
