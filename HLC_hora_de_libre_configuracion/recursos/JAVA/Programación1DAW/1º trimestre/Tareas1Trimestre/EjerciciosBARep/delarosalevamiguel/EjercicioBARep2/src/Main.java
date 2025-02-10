import java.util.Scanner; // importo la utilidad de Scanner
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in); // creo la variable Scanner

        int altura = 0; // inicio las variables

        do {
            System.out.print("Introduce la altura de la pirámide: "); // muestro por pantalla que debe de hacer el usuario
            altura = s.nextInt(); // guardo en una variable los datos introducidos por teclado por el usu
        } while (altura % 2 != 0);


        for (int y = 1; y <= altura; y++) {

            for (int x = 1; x <= altura*2-2; x++) {

                if ((y == 1) || (x - y + 2 == 1) || (x + y == altura * 2)) {
                    System.out.print("**");
                } else {
                    System.out.print("  ");
                }

            }
            System.out.println();
        }

    }
}