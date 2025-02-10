import java.util.Scanner; // importo la utilidad de Scanner
public class Main {
    /*Realiza un programa que nos diga cuántos dígitos tiene un número introducido
    por teclado.*/
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in); // creo la variable Scanner

        int numero = 0; // inicio las variables
        int longitud = 0;

        System.out.print("Ingresa un numero: ");
        numero = s.nextInt();

        do {
            numero = numero/10;

            longitud++;
        } while (numero > 0);

        System.out.println("El número tiene una longitud de: " + longitud);
    }
}