package Ejercicios_foreach;

// Escribe un programa que encuentre el valor máximo en un array unidimensional de
// enteros.

public class Ejercicio2 {
    public static void main(String[] args) {
        int[] numeros = { 1, 2, 6, 4, 5 };
        int numeroMax = Integer.MIN_VALUE;

        for (int numero : numeros) {
            if (numero > numeroMax) {
                numeroMax = numero;
            }
        }

        System.out.println("El número mas grande del array es: " + numeroMax);
    }
}
