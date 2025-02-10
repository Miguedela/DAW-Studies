import java.util.Scanner;
public class Main {
    /*5. Ejercicio de do-while:
    Crea un programa que solicite al usuario que ingrese un número positivo. Si el número es
    negativo, sigue pidiendo al usuario que ingrese un número hasta que ingrese un número
    positivo.*/
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        double num = 0;

        do {
            System.out.print("Ingrese un número positivo!!: ");
            num = s.nextDouble();
        } while (num <= 0);
        System.out.println("Gracias.");

    }
}