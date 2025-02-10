package Recursividad;

public class BusquedaBinariaRecursiva {
    public static int busquedaBinaria(int[] array, int elemento, int bajo, int alto) {
        if (bajo > alto) {
            return -1; // Caso base, el elemento no se encontró
        }

        int medio = bajo + (alto - bajo) / 2;

        if (array[medio] == elemento) {
            return medio; // Elemento encontrado
        } else if (array[medio] > elemento) {
            return busquedaBinaria(array, elemento, bajo, medio - 1); // Buscar en la mitad izquierda
        } else {
            return busquedaBinaria(array, elemento, medio + 1, alto); // Buscar en la mitad derecha
        }
    }

    public static void main(String[] args) {
        int[] array = { 1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21 };
        int elementoABuscar = 13;
        int resultado = busquedaBinaria(array, elementoABuscar, 0, array.length - 1);

        if (resultado == -1) {
            System.out.println("Elemento no encontrado en el array.");
        } else {
            System.out.println("Elemento encontrado en el índice: " + resultado);
        }
    }
}