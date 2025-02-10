import java.util.Scanner; // importo la utilidad de Scanner
public class Main {
    /*Escribe un programa que lea una lista de diez números y determine cuántos
    son positivos, y cuántos son negativos.*/
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in); // creo la variable Scanner

        int numeros = 0; // inicio las variables
        int numpos = 0;
        int numneg = 0;
        int numcero= 0;

        for (int i = 0; i <= 9; i++) { // bucle for que se repite 10 veces

            System.out.print("Introduce los números: "); // muestro por pantalla que se debe de hacer
            numeros = s.nextInt(); // pido que lea el número introducido desde el teclado

            if (numeros > 0) { // if que sirve para sumar uno a cada variable dependiendo de que sea positivo, negativo, o 0 ya que no es ni positivo ni negativo
                numpos++;
            } else if (numeros < 0) {
                numneg++;
            } else {
                numcero++;
            }
        }

        System.out.print("Hay " + numpos + " números positivos, " + numneg + " números negativos, y " + numcero + " ceros"); // muestra por pantalla la cantidad de número que hay de cada uno
    }
}