import java.util.Random;
import java.util.Scanner;

public class EjercicioMatricesA {
    /*
     * a) Crea una matriz con 5 filas y n columnas (Valor que debe pedirse al
     * usuario). A continuación, rellénalo con números aleatorios entre 0 y 10. Para
     * ello debes crear una función auxiliar que devuelva el número aleatorio
     * generado y se haga la llamada desde la clase Main.
     */
    public static int pedirNumero() {
        Scanner s = new Scanner(System.in);
        System.out.print("Introduce un número: ");
        int nUsuario = s.nextInt();
        s.close();
        return nUsuario;
    }

    public static void main(String[] args) {
        Random r = new Random();

        int filas = 5;
        int nUsuario = pedirNumero();

        int matriz[][] = new int[filas][nUsuario];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < nUsuario; j++) {
                matriz[i][j] = r.nextInt(0, 11);
            }
        }

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < nUsuario; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
}
