import java.util.Scanner; //Importo la utilidad de Scanner
public class Main {
    /*Ejercicio 1 - Desarrolla un programa en Java que te saque por pantalla los N primeros
    números primos. Tendremos que pedir por teclado la cantidad de números primos que
    queremos.*/
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in); //Creo la variable de Scanner

        //Pide que introduzcamos el número limite a comprobar
        System.out.println("¿Introduce el limite de numer?");
        int can = s.nextInt();

        //for que se repite tantas veces como hayamos establecido
        for (int i = 1; i <= can ; i++) {

            //Genero el bollean (true por defecto)
            boolean primo = true;

            //if que hace la comprobación de si es un número primo o no
            if (i >= 2) {
                for (int x = 2; x <= Math.sqrt(i); x++) {
                    if (i % x == 0) {
                        primo = false;
                        break;
                    }
                }
            }

            //iff que muestra por pantalla el resultado del boolean
            if (primo) {
                System.out.println(i + " es primo.");
            } else {
                System.out.println(i + " no es primo.");
            }
        }
    }
}