import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Introduce la base del triangulo: ");
        double base = s.nextDouble();
        System.out.print("Introduce la altura del triangulo: ");
        double altura = s.nextDouble();

        double area = (base * altura)/2;

        System.out.println("El area del triangulo es: " + area);
    }
}