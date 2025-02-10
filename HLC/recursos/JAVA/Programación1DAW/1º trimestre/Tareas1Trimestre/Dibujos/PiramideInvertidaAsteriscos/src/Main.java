import java.util.Scanner; // importo la utilidad de Scanner
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in); // creo la variable Scanner

        System.out.print("Introduce la altura de la pirámide invertida: "); // muestro por pantalla que debe de hacer el usuario
        int altura = s.nextInt(); // guardo en una variable los datos introducidos por teclado por el usu

        for (int i = altura; i >= 1; i--) {

            for (int j = 1; j <= altura - i; j++) { // for que imprime los espacios
                System.out.print(" ");
            }

            for (int k = 1; k <= 2 * i - 1; k++) { // for que imprimir asteriscos
                System.out.print("*");
            }

            System.out.println(); // salto de linea
        }

    }
}