import java.util.Scanner; //Importo la utilidad de Scanner;
public class Main {
    /*3- Multiplicación de elementos en un array
    Desarrolla un programa en Java que cree un array de 6 números enteros.
    Multiplica cada elemento del array por un número ingresado por el usuario y muestra el
    array resultante en pantalla.*/
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in); //Creo la variable Scanner;

        int[] numeros = {14, 52, 32, 44, 35, 54}; //Inicio el array de 6 posiciones con números ya asignados previamente

        for (int i = 0; i < numeros.length; i++) {

            System.out.print("Introduce el número multiplicador de la ecuación: "); //Pido que introduzca por teclado el número multiplicador
            double numero = s.nextDouble();

            double calc = numeros[i] * numero; //Realiza el calculo
            System.out.println("El calculo de : " + numeros[i] + " x " + numero + " = " + calc); //Mostrar cálculo por pantalla detalladamente
        }

    }
}