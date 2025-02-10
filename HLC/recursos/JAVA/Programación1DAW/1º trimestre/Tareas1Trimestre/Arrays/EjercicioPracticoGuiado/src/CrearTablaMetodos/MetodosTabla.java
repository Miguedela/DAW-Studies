package CrearTablaMetodos;
import java.util.Random; // importo la variable Random
public class MetodosTabla {

    public static int[][] relleno(int[][] tabla) {
        Random r = new Random(); // creo el objeto random

        // Relleno la tabla
        for (int x = 0; x < 6; x++) {
            for (int y = 0; y < 10; y++) {
                tabla[x][y] = r.nextInt(1001);

            }
        }

        return tabla;
    }

    public static void sacar(int[][] tabla) {
        // Saco la tabla
        for (int x = 0; x < 6; x++) {
            for (int y = 0; y < 10; y++) {
                System.out.print(tabla[x][y] + "\t");
            }
            System.out.println();
        }
    }

    public static int[] max(int[][] tabla, int maxValue, int[] posicionmax) {
        // Maximo
        for (int x = 0; x < 6; x++) {
            for (int y = 0; y < 10; y++) {
                if(tabla[x][y] > maxValue) {
                    maxValue = tabla[x][y];
                    posicionmax[0] = x+1;
                    posicionmax[1] = y+1;
                }
            }
        }

        return posicionmax;
    }

    public static int[] min(int[][] tabla, int minValue, int[] posicionmin) {
        // Minimo
        for (int x = 0; x < 6; x++) {
            for (int y = 0; y < 10; y++) {
                if(tabla[x][y] < minValue) {
                    minValue = tabla[x][y];
                    posicionmin[0] = x+1;
                    posicionmin[1] = y+1;
                }
            }
        }

        return posicionmin;
    }
}
