import java.util.Scanner;

public class SumarTabla {
    /*Escribe un programa que pida 20 números enteros. Estos números se deben
    introducir en un array de 4 filas por 5 columnas. El programa mostrará las
    sumas parciales de filas y columnas igual que si de una hoja de cálculo se
    tratara. La suma total debe aparecer en la esquina inferior derecha.*/
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int[][] matriz = new int[4][5]; // creo la matriz de la tabla


        System.out.println("Introduce 20 números para rellenar la tabla: ");

        for (int x = 0; x < 4; x++) { // bucle for para introducir los datos en la tabla
            for (int y = 0; y < 5; y++) {
                matriz[x][y] = s.nextInt();
            }
        }

        int fila = 0; // inicio las variables necesarias
        int columna = 0;
        int total = 0;

        int[] filaaux = new int[4];
        int[] columnaaux = new int[5];

        for (int x = 0; x < 4; x++) { // bucle for que realiza los calculos del total y filas
            fila = 0;
            for (int y = 0; y < 5; y++) {
                fila = fila + matriz[x][y];
                total = total + matriz[x][y];

                if (y == 0) {
                    columna = columna + matriz[x][y];
                }
                columnaaux[y] = columna;
            }
            filaaux[x] = fila;
        }

        for (int x = 0; x < 5; x++) {
            columna = 0;
            for (int y = 0; y < 4; y++) {
                columna = columna + matriz[y][x];
                columnaaux[x] = columna;
            }

        }

        for (int x = 0; x < 4; x++) { // bucle for que muestra la tabla con la suma de las filas
            for (int y = 0; y < 5; y++) {
                System.out.print(matriz[x][y] + "\t");
            }
            System.out.print(filaaux[x]);
            System.out.println();
        }

        for (int x = 0; x < 1; x++) { // bucle for que muestra la suma de las columnas y el total
            for (int y = 0; y < 5; y++) {
                System.out.print(columnaaux[y] + "\t");
            }
            System.out.print(total);
        }
    }
}
