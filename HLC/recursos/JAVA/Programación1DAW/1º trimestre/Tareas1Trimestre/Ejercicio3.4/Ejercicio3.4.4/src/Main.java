import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Introduzca el primer número para realizar los calculos: ");
        double n1 = s.nextDouble();
        System.out.print("Introduzca el segundo número para realizar los calculos: ");
        double n2 = s.nextDouble();

        double suma = n1 + n2;
        double resta = n1 - n2;
        double mult = n1 * n2;
        double div = n1 / n2;

        System.out.println("La suma da el resultado de: " + suma);
        System.out.println("La resta da el resultado de: " + resta);
        System.out.println("La multiplicación da el resultado de: " + mult);
        System.out.println("La división da el resultado de: " + div);
    }
}