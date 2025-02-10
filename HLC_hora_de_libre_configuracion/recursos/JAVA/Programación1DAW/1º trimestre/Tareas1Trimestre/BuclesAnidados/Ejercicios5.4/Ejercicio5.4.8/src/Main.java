import java.util.Scanner; // importo la utilidad de Scanner
public class Main {
    /*Muestra la tabla de multiplicar de un número introducido por teclado.*/
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in); // creo la variable Scanner

        int num = 0; // inicio las variables
        int mult = 0;

        System.out.print("Introduzca el número del que desea saber su tabla de multiplicación: "); // muestro por pantalla el mensaje de introducir un número a multiplicar
        num = s.nextInt(); // oido que ingrese por teclado el número a multiplicar

        for (int i = 0; i <= 10; i++) { // bucle for que se repite 10 veces para ver las multiplicaciónes
            mult = num * (i); // realizo el calculo del numero introducido por cada número del 0 al 10
            System.out.println(num + " x " + i + " = " + mult); // muestro por pantalla cada resultado
        }
    }
}