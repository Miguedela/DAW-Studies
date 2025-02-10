package CrearTabla;

import java.util.Random; // importo la variable Random
public class CrearTabla {
    public static void main(String[] args) {
        Random r = new Random(); // creo el objeto random

        int[][] tabla = new int[6][10];

        // Relleno la tabla
        for (int x = 0; x < 6; x++) {
            for (int y = 0; y < 10; y++) {
                tabla[x][y] = r.nextInt(1001);
            }
        }

        // Saco la tabla por pantalla
        for (int x = 0; x < 6; x++) {
            for (int y = 0; y < 10; y++) {
                System.out.print(tabla[x][y] + "\t");
            }
            System.out.println();
        }

        int maxValue = Integer.MIN_VALUE;
        int minValue = Integer.MAX_VALUE;

        int[] posicionmax = new int[2];
        int[] posicionmin = new int[2];

        // Saco la tabla por pantalla
        for (int x = 0; x < 6; x++) {
            for (int y = 0; y < 10; y++) {
                if(tabla[x][y] > maxValue) {
                    maxValue = tabla[x][y];
                    posicionmax[0] = x+1;
                    posicionmax[1] = y+1;
                }
                if(tabla[x][y] < minValue) {
                    minValue = tabla[x][y];
                    posicionmin[0] = x+1;
                    posicionmin[1] = y+1;
                }
            }
        }

        System.out.println();
        System.out.println("El número más grande se encuentra en las cooredenadas: " + "X" + posicionmax[0] + " Y" + posicionmax[1]);
        System.out.println("El número más gpequeño se encuentra en las cooredenadas: " + "X" + posicionmin[0] + " Y" + posicionmin[1]);


    }
}