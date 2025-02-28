import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Introduce el primer número para poder realizar la multiplicación");
        double n1 = s.nextDouble();
        System.out.println("Introduce el segundo número para poder realizar la multiplicación");
        double n2 = s.nextDouble();

        double mult = n1 * n2;

        System.out.print("El resultado es: " + mult);
    }
}