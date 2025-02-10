import java.util.Scanner;
public class Main {
    /*1. Ejercicio de if-else:
    Escribe un programa que determine si un número ingresado por el usuario es positivo,
    negativo o igual a cero.*/
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Escribe el número a continuación: ");
        double num = s.nextDouble();

        if (num>0) {
            System.out.println("Este número es positivo");
        } else if (num<0) {
            System.out.println("Este número es negativo");
        } else {
            System.out.println("Este número es '0'");
        }
    }
}