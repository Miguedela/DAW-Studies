package Recursividad;

public class FibonacciRecursivo {
    public static int fibonacci(int n) {
        if (n <= 1) {
            return n; // Casos base
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2); // Llamada recursiva
        }
    }

    public static void main(String[] args) {
        int n = 9;
        System.out.println("El número de Fibonacci en la posición " + n + " es: " + fibonacci(n));
    }
}