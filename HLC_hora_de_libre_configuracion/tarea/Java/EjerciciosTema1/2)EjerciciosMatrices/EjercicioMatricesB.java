import java.util.Scanner;

public class EjercicioMatricesB {
    /*
     * b) Crea 2 matrices de mxm y suma sus valores. Los resultados deben
     * almacenarse en otra matriz distinta. Los valores y la longitud, seran
     * elegidos por el usuario. Finalmente, muestra por pantalla las matrices
     * originales y el resultado, para ello debes crear una función auxiliar que
     * muestre las matrices y se haga la llamada desde la clase Main.
     */

    public static void mostrarMatriz(int matriz[][], int filas, int columnas) {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Tamaño: ");
        int tamano = s.nextInt();

        int matriz1[][] = new int[tamano][tamano];
        int matriz2[][] = new int[tamano][tamano];
        int matrizAux[][] = new int[tamano][tamano];

        for (int i = 0; i < tamano; i++) {
            for (int j = 0; j < tamano; j++) {
                System.out.print("Introduzca el tamaño de la fila " + i + " y la columna " + j + " de la matriz 1: ");
                matriz1[i][j] = s.nextInt();
                System.out.print("Introduzca el tamaño de la fila " + i + " y la columna " + j + " de la matriz 2: ");
                matriz2[i][j] = s.nextInt();
                matrizAux[i][j] = matriz1[i][j] + matriz2[i][j];
            }
        }
        s.close();

        System.out.println("Matriz 1");
        mostrarMatriz(matriz1, tamano, tamano);

        System.out.println("Matriz 2");
        mostrarMatriz(matriz2, tamano, tamano);

        System.out.println("Matriz auxiliar");
        mostrarMatriz(matrizAux, tamano, tamano);
    }
}
