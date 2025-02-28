import java.util.Scanner; // importo la utilidad de Scanner
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in); // creo la variable Scanner

        int filas = 0; // inicio las variables


        System.out.print("Introduce la altura de la pirámide: "); // muestro por pantalla que debe de hacer el usuario
        filas = s.nextInt(); // guardo en una variable los datos introducidos por teclado por el usuario

        int contador = filas*10;

        int[][] matriz = new int[filas][10]; // creo el array con la cantidad de filas introducidos por el usuario y las columnas predefinidas

        for (int i = 0; i < filas; i++) { // for que da valor a cada posicion de la matriz
            for (int j = 0; j < 10; j++) {
                matriz[i][j] = contador;
                System.out.print(contador + "\t");
                contador--;
            }
            System.out.println();
        }

        System.out.println();

        for (int i = 0; i < filas; i++) { // for que se encarga de mostrar en pantalla cada posicion de la matriz
            for (int j = 0; j < 10; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }

    }
}