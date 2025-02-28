import java.util.Scanner; // importo la utilidad de Scanner
public class Main {
    /*Escribe un programa que dados dos números, uno real (base) y un entero
    positivo (exponente), saque por pantalla todas las potencias con base el
    numero dado y exponentes entre uno y el exponente introducido. No se deben
    utilizar funciones de exponenciación. Por ejemplo, si introducimos el 2 y el 5,
    se deberán mostrar 21, 22, 23, 24 y 25*/
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in); // creo la variable Scanner

        int base = 0; // inicio las variables
        int exponente = 0;

        System.out.print("Introduce la base: "); // muestro por pantalla lo que se debe de hacer
        base = s.nextInt(); // pido que se introduzca por teclado el número necesario

        System.out.print("Introduce la exponente: "); // muestro por pantalla lo que se debe de hacer
        exponente = s.nextInt(); // pido que se introduzca por teclado el número necesario

        for (int i = 1; i <= exponente; i++) { // bucle que se repite tantas veces como numeros entre el 1 y el exponente hay

            System.out.println(base + "" + "^" + i); // muiestro por pantalla la base y exponente
        }
    }
}