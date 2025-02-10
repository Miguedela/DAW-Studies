import java.util.Random; // importo la utilidad Random
import java.util.random.RandomGenerator; // importo la utilidad Scanner
public class Main {
    /*Crea una programa en java donde en el main se cree un array de 100 enteros. Dentro de
    la función main, se tiene que llamar a un método que se llame “rellenaArray”, y este
    rellene todas las posiciones del array con números (los que queráis). Una vez tengamos la
    tabla rellena, llamar a otro método para mostrar por pantalla todos los valores del array
    “verArray”.*/
    public static void main(String[] args) {
        int[] tabla = new int [100]; // creo la variable de tabla

        rellenaArray(tabla); // llamo al metodo de rellenarArray

        muestraArray(tabla); // llamo al metodo de muestraArray
    }
    public static void rellenaArray(int[] array) { // creo el metodo de rellenarArray
        Random r = new Random();

        for (int i = 0; i < array.length; i++) { // este for es lo mismo que el de la línea 23
            array[i] = r.nextInt(100) + 1;
        }
    }
    public static void muestraArray(int[] array) { // creo el metodo de muestraArray
        System.out.println("Valores del array:");

        for (int valor : array) {
            System.out.print(valor + " "); // este for es lo mismo que el de la línea 19
        }

        System.out.println();
    }
}