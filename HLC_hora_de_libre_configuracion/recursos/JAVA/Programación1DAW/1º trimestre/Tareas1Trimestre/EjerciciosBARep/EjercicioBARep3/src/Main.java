import java.util.Scanner; // importo la utilidad de Scanner
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in); // creo la variable Scanner

        int altura = 0; // inicio las variables

        do {
            System.out.print("Introduce la altura de el botijo: "); // muestro por pantalla que debe de hacer el usuario
            altura = s.nextInt(); // guardo en una variable los datos introducidos por teclado por el usu
        } while (altura % 2 != 0);


        for (int y = 1; y <= altura; y++) {

            for (int x = 1; x <= altura; x++) {

                if ((y == 1) && (x > altura/4) && (x <= altura - altura/4) || (x + y == altura/2+2) || (x-y == altura/2-1) || (y - x == altura/2) || (x + y == altura/2+altura+1)) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }

            }
            System.out.println();
        }

    }
}