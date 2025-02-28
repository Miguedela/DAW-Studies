import java.util.Scanner; // importo la utilidad de Scanner
public class Main {
    /*Realiza un programa que pida un número por teclado y que luego muestre ese
    número al revés.*/
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in); // creo la variable Scanner

        int numero = 0; // inicio las variables

        System.out.print("Introduce un número: "); // muestro por pantalla al usuario que se debe de hacer
        numero = s.nextInt(); // digo que lo que intrduzca el usuario lo guarde en una variable


        String numeroComoCadena = Integer.toString(numero); // convierto la variable "int" numero a "String"
        String numeroAlReves = new StringBuilder(numeroComoCadena).reverse().toString(); // le doy la vuelta a la cadena de careacteres

        System.out.println("El número al revés es: " + numeroAlReves); // muestro por pantalla el numero al reves

    }
}