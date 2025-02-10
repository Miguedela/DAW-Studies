import java.util.Scanner; // importo la utilidad de Scanner
public class Main {
    /*Muestra los números del 320 al 160, contando de 20 en 20 hacia atrás
    utilizando un bucle while.*/
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in); // creo la variable de Scaner

        int i = 360; // inicio la variable i con un valor asignado

        do { // creo el do-bucle
            i=i - 20; // ordeno que por cada vuelta del bucle a i se le reste 20
            System.out.println(i); // muestro por pantalla el valor de i en cada vuelta
        } while (i > 160); // while con la orden de cuando debe parar de ejecutarse
    }
}