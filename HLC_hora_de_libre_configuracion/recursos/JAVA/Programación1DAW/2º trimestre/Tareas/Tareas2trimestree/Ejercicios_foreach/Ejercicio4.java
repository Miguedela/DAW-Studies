package Ejercicios_foreach;

// Escribe un programa que calcule la suma de todos los elementos en una matriz
// bidimensional de enteros.

public class Ejercicio4 {
    public static void main(String[] args) {
        int[][] matriz = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };
        int suma = 0;

        for (int[] x : matriz) {
            for (int y : x) {
                suma += y;
            }
        }

        System.out.println("La suma de todo da: " + suma);
    }
}
