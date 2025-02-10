import java.util.Random; //Importo la utilidad de Random
public class Ejercicio1 {
    public static void main(String[] args) {
        Random r = new Random(); //Creo un objeto para Random

        int N = 0;
        int M = 0;

        //Bucle while que se repite hasta que los números no sean distintos
        while (N == M) {
            N = r.nextInt(16-8+1)+(8);
            M = r.nextInt(16-8+1)+(8);
        }

        int[][] rectangulo = new int[N][M];//Creo la matriz del rectangulo con los valores de N y M

        //Bucle for que rellena la matriz
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < M; y++) {
                rectangulo[x][y] = r.nextInt(42-(-77)+1)+(-77);
            }
        }

        System.out.println("La matriz tiene una altura de: " + N + " y una anchura de: " + M);
        //Bucle for que muestra la matriz
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < M; y++) {
                System.out.print(rectangulo[x][y] + "\t\t\t");
            }
            System.out.println();
        }

        System.out.println();

        //Inicio las variables que voy a necesitar para el calculo de las submatrices
        int[] submatizsum;
        int Naux = M;
        int Maux = 0;
        int aux = 0;
        int suma = -10000;
        int xaux = 0;

        //If necesario para poder realizar la suma de las submatrices
        if (N<M) {
            Maux = N;
            aux = -1;

            submatizsum = new int[M-N]; //Le doy valor al array donde se guardaran las sumas

            //Bucle for que se encarga de calcular el valor de las submatrices
            for (int x = 0; x < N; x++) {
                if (Maux >= M) {
                    break;
                }
                aux++;
                Maux++;
                for (int y = aux; y < Maux; y++) {
                    submatizsum[x] += rectangulo[x][y];
                }
                System.out.println("La suma de la " + (x+1) + " submatriz da un resultado de: " + submatizsum[x]);
                if (submatizsum[x] > suma) {
                    suma = submatizsum[x];
                    xaux = x+1;
                }
            }
        } else {
            submatizsum = new int[N-M]; //Le doy valor al array donde se guardaran las sumas

            //Bucle for que se encarga de calcular el valor de las submatrices
            for (int x = aux; x < Naux; x++) {
                if (Naux >= N) {
                    break;
                }
                aux++;
                Naux++;
                for (int y = 0; y < M; y++) {
                    submatizsum[x] += rectangulo[x][y];
                }
                System.out.println("La suma de la " + (x+1) + " submatriz da un resultado de: " + submatizsum[x]);
                if (submatizsum[x] > suma) {
                    suma = submatizsum[x];
                    xaux = x+1;
                }
            }
        }
        //Muestro por pantalla la submatriz con el valor más grande
        System.out.println();
        System.out.println("La submatriz más grande es la número " + xaux + " con un valor de: " + suma);
    }
}