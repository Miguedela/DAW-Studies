import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Introduzca el número de filas de su array: ");

        Scanner s = new Scanner(System.in);

        int filas = s.nextInt();

        int[][] matriz = new int[filas][10];

        int contador = 1;

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < 10; j++) {
                matriz[i][j] = contador;
                contador++;
            }
        }

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
