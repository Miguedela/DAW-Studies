package Ejercicios_foreach;

/*Escribe un programa que copie todos los elementos de una matriz bidimensional de
enteros a un array unidimensional. */

public class Ejercicio7 {
    public static void main(String[] args) {
        int[][] matriz = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };
        int[] coln;

        for (int[] x : matriz) {
            System.out.println(x);
        }
    }
}
