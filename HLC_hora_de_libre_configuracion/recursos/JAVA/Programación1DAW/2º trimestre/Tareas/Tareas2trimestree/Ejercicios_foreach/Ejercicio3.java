package Ejercicios_foreach;

// Escribe un programa que imprima todos los elementos de una matriz bidimensional de
// enteros.

public class Ejercicio3 {
    public static void main(String[] args) {
        int[][] matriz = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };

        for (int[] x : matriz) {
            for (int y : x) {
                System.out.print(y);
            }
            System.out.println();
        }
    }
}
