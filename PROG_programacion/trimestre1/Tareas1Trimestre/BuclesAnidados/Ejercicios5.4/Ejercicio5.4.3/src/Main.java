import java.util.Scanner; // importo la utilidad de Scanner
public class Main {
    /*Muestra los números múltiplos de 5 de 0 a 100 utilizando un bucle do-while.*/
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in); // creo la variable de Scaner

        int i = 0; // inicio la variable i

        do{ // do que se repite hasta que se cumpla la funcion del while

            i++; // hago que por cada vuelta que realiza el bucle se le sume 1 a la variable i

            if (i % 5 == 0) { // if que calcula si dicho número es multiplo de 5
                System.out.println(i); // muestra por pantalla los números que son multiplos de 5
            }
        } while (i <= 100); // manda cuando debe dejarse de ejercutarse el do
    }
}