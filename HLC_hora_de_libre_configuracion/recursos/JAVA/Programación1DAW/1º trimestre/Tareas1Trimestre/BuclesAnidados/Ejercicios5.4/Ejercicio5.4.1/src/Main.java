import java.util.Scanner; // importo la utilidad de Scanner
public class Main {
    /*Muestra los números múltiplos de 5 de 0 a 100 utilizando un bucle for.*/
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in); // creo la variable de Scaner

        for (int i = 0; i <= 100; i++) { //for que se hace 100 veces
            if (i % 5 == 0) { // if que calcula si dicho número es multiplo de 5
                System.out.println(i); // muestra por pantalla los números que son multiplos de 5
            }
        }
    }
}