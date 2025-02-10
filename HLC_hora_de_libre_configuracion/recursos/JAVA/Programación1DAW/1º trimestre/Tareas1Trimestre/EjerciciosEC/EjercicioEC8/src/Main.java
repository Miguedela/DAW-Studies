import java.util.Scanner;
public class Main {
    /*8. Ejercicio con return:
    Crea un método que tome dos números como argumentos y devuelva el mayor de los dos.*/

    //Metodo para buscar el número más grande
    public static double encontrarMayor(double num1, double num2) {
        if (num1 > num2) {
            return num1;
        } else {
            return num2;
        }
    }

    //Programa
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        //Lectura por pantalla
        System.out.print("Introduce el primer número: ");
        double num1 = s.nextDouble();
        System.out.print("Introduce el segundo número: ");
        double num2 = s.nextDouble();
        //Implementación del metodo y muestra por pantalla
        double mayor = encontrarMayor(num1, num2);
        System.out.printf("Él número más grande es: %.2f", mayor);
    }
}