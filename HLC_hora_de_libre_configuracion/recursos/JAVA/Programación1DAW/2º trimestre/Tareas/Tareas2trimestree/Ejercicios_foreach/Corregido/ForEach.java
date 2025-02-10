package Ejercicios_foreach.Corregido;

import java.util.Arrays;

public class ForEach {
    public static void main(String[] args) {
        // Ejercicio1
        int[] unidimensional = { 1, 2, 8, 4, 5 };
        System.out.println("La suma de los elementos en el array es: " + sumaArray(unidimensional));
        System.out.println();

        // Ejercicio2
        System.out.println("El valor máximo en el array es: " + maximoArray(unidimensional));
        System.out.println();

        // Ejercicio3
        int[][] bidimensional = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };
        System.out.println("Los elementos de la matriz son: ");
        imprimirMatriz(bidimensional);
        System.out.println();

        // Ejercicio4
        System.out.println("La suma de todos las posiciones de la matriz es: " +
                sumarMatriz(bidimensional));
        System.out.println();

        // Ejercicio5
        System.out.println("La suma de los elementos pares del array es: " +
                sumaElementosParesArray(unidimensional));
        System.out.println();

        // Ejercicio6
        int[][] bidimensionalSimetrica = {
                { 1, 2, 3 },
                { 2, 4, 5 },
                { 3, 5, 6 }
        };
        System.out.println("¿Es la matriz1 simetrica?: ");
        simetricaONo(bidimensionalSimetrica);

        if (simetricaONo(bidimensionalSimetrica)) {
            System.out.println("Si es simetrica.");
        } else {
            System.out.println("No lo es.");
        }

        System.out.println("¿Es la matriz2 simetrica?: ");
        simetricaONo(bidimensional);

        if (simetricaONo(bidimensional)) {
            System.out.println("Si es simetrica.");
        } else {
            System.out.println("No lo es.");
        }
        System.out.println();

        // Ejercicio7
        int[] arrayCopiado = copiarMatriz(bidimensional);
        System.out.println("El array copiado es: " + Arrays.toString(arrayCopiado));
    }

    // Metodo de ejercicio1
    public static int sumaArray(int[] unidimensional) {
        int suma = 0;

        for (int i : unidimensional) {
            suma += i;
        }

        return suma;
    }

    // Metodo de ejercicio2
    public static int maximoArray(int[] unidimensional) {
        int maximo = Integer.MIN_VALUE;

        for (int i : unidimensional) {
            if (i > maximo) {
                maximo = i;
            }
        }

        return maximo;
    }

    // Metodo ejercicio3
    public static void imprimirMatriz(int[][] bidimensional) {
        for (int[] x : bidimensional) {
            for (int y : x) {
                System.out.print(y);
            }
            System.out.println();
        }
    }

    // Metodo ejercicio4

    public static int sumarMatriz(int[][] bidimensional) {
        int suma = 0;

        for (int[] x : bidimensional) {
            for (int y : x) {
                suma += y;
            }
        }

        return suma;
    }

    // Metodo de ejercicio5
    public static int sumaElementosParesArray(int[] unidimensional) {
        int suma = 0;

        for (int i : unidimensional) {
            if (i % 2 == 0) {
                suma += i;
            }
        }

        return suma;
    }

    public static boolean simetricaONo(int[][] bidimensional) {
        boolean comparar = true;

        for (int x = 0; x < bidimensional.length; x++) {
            for (int y = 0; y < bidimensional.length; y++) {
                if (bidimensional[x][y] != bidimensional[y][x]) {
                    comparar = false;
                }
            }
        }
        return comparar;
    }

    public static int[] copiarMatriz(int[][] bidimensional) {
        int aux = 0;

        for (int[] x : bidimensional) {
            for (int y : x) {
                aux++;
            }
        }

        //Creo el array unidimensional
        int[] clonacion = new int[aux];
        //Vuelvo a igualar aux a 0 para poder usarla como indice en el for-each
        aux = 0;

        for (int[] x : bidimensional) {
            for (int y : x) {
                clonacion[aux] = y;
                aux++;
            }
        }

        return clonacion;
    }
}
