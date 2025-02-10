import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Introduce la base de el rectángulo: ");
        double base = s.nextDouble();
        System.out.print("Introduce la altura de el rectángulo: ");
        double altura = s.nextDouble();

        double area = base * altura;

        System.out.println("El area del rectángulo es: " + area);
    }
}