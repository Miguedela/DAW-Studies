    import java.util.Scanner; // importo la utilidad de Scanner
    public class Main {
    /*Muestra los números múltiplos de 5 de 0 a 100 utilizando un bucle while.*/
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in); // creo la variable de Scaner

        int i = 0; // inicio la variable i

        while (i <= 100) { // bucle while que se repite hasta que la i se menor o igual a 100

            i++; // hago que por cada vuelta que realiza el bucle se le sume 1 a la variable i

            if (i % 5 == 0) { // if que calcula si dicho número es multiplo de 5
                System.out.println(i); // muestra por pantalla los números que son multiplos de 5
            }
        }
    }
}