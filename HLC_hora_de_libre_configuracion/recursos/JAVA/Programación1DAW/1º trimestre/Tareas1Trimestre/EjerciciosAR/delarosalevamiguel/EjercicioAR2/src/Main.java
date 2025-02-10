import java.util.Scanner; //Importo la utilidad de Scanner;
public class Main {
    /*2- Conteo de elementos pares e impares
    Desarrolla un programa en Java que declare un array de enteros de tamaño 7 y le
    asignes valores. Luego, cuenta y muestra en pantalla la cantidad de elementos pares e
    impares en el array.*/
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in); //Creo la variable Scanner;

        int[] numeros = new int[7]; //Inicializo el array de 7 posiciónes

        //for que se repite tantas veces como espacio tenga el array (7)
        for (int i = 0; i < numeros.length; i++) {

            System.out.print("Introduce el " + (i+1) + " número: "); //Pide que introduzcamos el valor de cada posición del array
            numeros[i] = s.nextInt();

            if (numeros[i] % 2 == 0) { //Hace el cálculo para determinar si el número es par o inpar
                System.out.println("El número: " + numeros[i] + " es par");
            } else {
                System.out.println("El número: " + numeros[i] + " es inpar");
            }
        }

    }
}