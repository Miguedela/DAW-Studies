import java.util.Scanner;

public class Ejercicio7_4_2_8 {
    /*Escribe un programa que, dada una posición en un tablero de ajedrez, nos diga
    a qué casillas podría saltar un alfil que se encuentra en esa posición. Como se
    indica en la figura, el alfil se mueve siempre en diagonal. El tablero cuenta con
    64 casillas. Las columnas se indican con las letras de la “a” a la “h” y las filas
    se indican del 1 al 8.*/
    public static void main(String[] args) {

        int [][] matriz = new int[8][8]; // inicio las variables
        String [] letras = {"A","B","C","D","E","F","G","H"};
        int fila = 0;
        int columna = 0;

        Scanner s = new Scanner(System.in);

        System.out.println();

        //Pedir que see introduzca las posiciones por teclado
        do {
            System.out.print("Introduce la fila en la que deseas tener a tu alfil: ");
            fila = s.nextInt();
            System.out.print("Introduce la columna en la que deseas tener a tu alfil: ");
            columna = s.nextInt();
            if (fila > 8 || fila < 1 || columna < 1 || columna > 8) {
                System.out.println("Opción no valida");
            }
        } while (fila > 8 || fila < 1 || columna < 1 || columna > 8);

        fila = fila - 1;
        columna = columna - 1;

        //Bucle for que dibuja el tablero
        for (int x = 0 ; x < 9 ; x++) {
            for (int y = 0 ; y < 9 ; y++) {
                if (x == fila + 1 && y == columna + 1){
                    System.out.print("\t *");
                } else if (x == 0 && y < 8) {
                    System.out.print("\t " + letras[y]);
                } else if (x == 0 && y == 8) {
                }else if (y == 0) {
                    System.out.print(x);
                } else {
                    System.out.print("\t 0");
                }
            }
            System.out.println();
        }

        /*int filarest = fila; // inicio las variables que se sumaran y restaran para hacer el movimiento diagonal
        int columnarest = columna;
        int filasum = fila;
        int columnasum = columna;*/

        int filaaux = 0;
        int columnaaux = 0;
        int filaauxxx = 0;
        int columnaauxxx = 0;

        // Bucle for que hace el cálculo de movimiento
        for (int x = 0 ; x < 8 ; x++) {
            for (int y = 0 ; y < 8 ; y++) {
                /*if (matriz[x][y] == matriz[fila][columna]){*/

                    /*filarest = filarest - 1;
                    columnarest = columnarest - 1;
                    filasum = filasum + 1;
                    columnasum = columnasum + 1;

                    if (filarest >= 0 && filarest < 8 && columnarest >= 0 && columnarest < 8){
                        System.out.print("(" +  (filarest+1) + " / " + (columnarest+1) + ")");
                    }
                    System.out.print("   ");
                    if (filasum >= 0 && filasum < 8 && columnasum >= 0 && columnasum < 8){
                        System.out.print("(" + (filasum+1) + " / " + (columnasum+1) + ")");
                    }
                    System.out.print("   ");
                    if (filasum >= 0 && filasum < 8 && columnarest >= 0 && columnarest < 8){
                        System.out.print("(" + (filasum+1) + " / " + (columnarest+1) + ")");
                    }
                    System.out.print("   ");
                    if (filarest >= 0 && filarest < 8 && columnasum >= 0 && columnasum < 8){
                        System.out.print("(" + (filarest+1) + " / " + (columnasum+1) + ")");
                    }
                    System.out.println();*/

                    filaaux = x - fila;
                    columnaaux = y - columna;


                    if (columnaaux < 0) {
                        columnaaux = columnaaux*-1;
                    }
                    if (filaaux < 0) {
                        filaaux = filaaux*-1;
                    }

                    if (x >= 8 || y >= 8) {
                        break;
                    } else if ((x == fila) || (y == columnaaux)) {
                        continue;
                    }

                    if ((x - filaaux) == (x - columnaaux)) {
                        System.out.println("Se puede mover hacia: " + (x+1) + " , " + (y+1));
                    }

                /*}*/
            }
        }
    }
}