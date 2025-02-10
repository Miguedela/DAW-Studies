//Importo la utilidad de Scanner
import java.util.Scanner;
public class Main {
    //Enunciado
    /*1. Realizar un programa que permita cargar dos listas de 15 valores cada una.
    Informar con un mensaje cuál de las dos listas tiene un valor acumulado mayor
        ("Lista 1 mayor", "Lista 2 mayor", "Listas iguales")*/
    public static void main(String[] args) {
        //Creo una variable para Scanner
        Scanner s = new Scanner(System.in);

        //Inicio las variables de los resultados
        double res1 = 0;
        double res2 = 0;

        //For que indica que lo que haya dentro se repita dos veces
        for (int i = 1; i <= 2; i++) {

            //For que indica que se debe reoetir la operacion de dentro dos veces
            for (int x = 1; x <=15; x++) {
                System.out.print("Introdice el " + x + "ª número de la primera lista: ");
                double num1 = s.nextDouble();
                //if encargado de sumar el valor de los números de la primera vuelta (primera lista), y de la segunda vuelta (segunda lista)
                if (i == 1) {
                    res1 = (res1 + num1);
                    System.out.printf("El resultado actual de la primera lista es: %.2f\n", res1);
                } else {
                    res2 = (res2 + num1);
                    System.out.printf("El resultado actual de la primera lista es: %.2f\n", res2);
                }
            }
        }

        //if que muestra que lista es la que contiene el valor más alto
        if (res1 > res2) {
            System.out.println("El valor de la primera lista es mayor");
        } else if (res1 < res2) {
            System.out.println("El valor de la segunda lista es mayor");
        } else {
                System.out.println("El valor de las listas es el mismo");
        }
    }
}