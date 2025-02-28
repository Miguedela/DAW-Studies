import java.util.Scanner; // importo la utilidad de Scanner
public class Main {
    /*Escribe un programa que muestre por pantalla todos los números enteros
    positivos menores a uno leído por teclado que no sean divisibles entre otro
    también leído de igual forma.*/
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in); // creo la variable Scanner

        int numero = 0; // inicio las variables
        int div = 0;

        System.out.print("Introduce un número: "); // muestro por pantalla lo que se debe de hacer el usuario
        numero = s.nextInt(); // guardo en una variable lo introducido por teclado

        System.out.print("Introduce un número divisor: "); // muestro por pantalla lo que se debe de hacer el usuario
        div = s.nextInt(); // guardo en una variable lo introducido por teclado

        for (int i = 0; i <= numero; i++) { // for que se hace tantas veces se haya introducido

            if (i % div != 0) { // if que comprueba si cada número es divisible entre el que hemos indicado
                System.out.print(i + " ");
            }
        }
    }
}