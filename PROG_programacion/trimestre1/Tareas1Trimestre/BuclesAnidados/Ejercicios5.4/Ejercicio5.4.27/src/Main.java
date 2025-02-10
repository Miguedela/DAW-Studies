import java.util.Scanner; // importo la utilidad de Scanner
public class Main {
    /*Escribe un programa que muestre, cuente y sume los múltiplos de 3 que hay
    entre 1 y un número leído por teclado.*/
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in); // creo la variable Scanner

        int numero = 0; // inicio las variables
        int suma = 0;
        int cantidad = 0;

        System.out.print("Introduce la cantidad de números que desea comprobar: "); // muestro por pantalla al usuario lo que debe de hacer
        numero = s.nextInt(); // guardo en una variable lo que se ha introdido por teclado

        for (int i = 0; i <= numero; i++) { // bucle for que se repite tantas veces como pide el usuario

            if (i % 3 == 0) { // if que se realiza solo si es multiplo de 3
                suma += i; // sumo los numeros en una varible acumulativa

                System.out.println(i + " es multiplo de 3"); // muestro los numeros multiplos de 3

                cantidad++; // sumo 1 por cada vez que hay un número multiplo de 3

            }
        }
        System.out.println("La cantidad de números multiplos de 3 es de: " + cantidad); // muestro los resultados
        System.out.println("La suma de todos los números multiplos de 3 es de: " + suma);
    }
}