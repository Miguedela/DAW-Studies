import java.util.Scanner; // importo la utilidad de Scanner
public class Main {
    /*Escribe un programa que muestre en tres columnas, el cuadrado y el cubo de
    los 5 primeros números enteros a partir de uno que se introduce por teclado.*/
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in); // creo la variable Scanner

        int numprin = 0; // inicio de las variables
        int cuadrado = 0;
        int cubo = 0;

        System.out.print("Introduzca un número: "); // muestro por pantalla que se debe de introducir
        numprin = s.nextInt(); // pido que se ingrese por teclado el número

        for (int i = 0; i < 5; i++) { // bucle for que se repite 5 veces (para 5 números)
            numprin = numprin + 1; // le sumo 1 al numprim por cada vuelta que realice el bucle
            cuadrado = numprin * numprin; // formula del número al cuadrado
            cubo = numprin * numprin * numprin; //formula del número al cubo

            System.out.println("Numero: " + numprin + "   Cuadrado: " + cuadrado + "   Cubo: " + cubo); // pido que muestre por pantalla lo que nos pide el ejercicio
        }
    }
}