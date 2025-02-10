import java.util.Scanner; // importo la utilidad de Scanner
public class Main {
    /*Escribe un programa que permita ir introduciendo una serie indeterminada
    de números mientras su suma no supere el valor 10000. Cuando esto último
    ocurra, se debe mostrar el total acumulado, el contador de los números
    introducidos y la media.*/
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in); // creo la variable Scanner

        int numero = 0; // inicio las variables
        int numerosintro = 0;

        do { // bucle do que se repite hasta que se deje de cumplir la condicion del while

            System.out.print("Introduce un número: "); // muestro por pantalla que debe de hacer el usuario
            numero += s.nextInt(); // guardo en una variable acumulatiba lo que va introduciendo el usuario

            numerosintro++; // cada vuelta que da se suma 1 en la variable para saber el número de números introducidos

        } while (numero <= 10000); // condicion del while

        System.out.println("Has acumulado un número de: " + numero); // muestro por pantalla los resultados
        System.out.println("Has acumulado un número de: " + numerosintro);
        System.out.println("Has acumulado un número de: " + (numero/2));

    }
}