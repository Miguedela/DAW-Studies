import java.util.Scanner; // importo la utilidad de Scanner
public class Main {
    /*Muestra los números del 320 al 160, contando de 20 en 20 hacia atrás
    utilizando un bucle for.*/
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in); // creo la variable de Scaner

        for (int i = 360; i >= 160; i=i-20) { // creo un for que por cada vuelta reste 20 a i
            System.out.println(i); // muestro el número cada vez que se repita el bucle
        }
    }
}