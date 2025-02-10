package Ejercicios_foreach;

/*Escribe un programa que verifique si una matriz bidimensional de enteros es simétrica
(es decir, si es igual a su traspuesta). */

public class Ejercicio6 {
    public static void main(String[] args) {
        int[][] matriz = {
                { 1, 2, 3 },
                { 4, 5, 6, 7 },
                { 7, 8, 9 }
        };
        int xCantidad = 0;
        int yCantidad = 0;

        for (int[] x : matriz) {
            xCantidad++;
            for (int y : x) {
                yCantidad++;
            }
        }

        yCantidad /= xCantidad;

        if (xCantidad == yCantidad) {
            System.out.println("La matriz es cuadrada.");
        } else {
            System.out.println("La matriz no es cuadrada.");
        }
    }
}