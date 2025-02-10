import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Introduce la altura del cono: ");
        double altura = s.nextDouble();
        System.out.print("Introduce el radio del cono: ");
        double radio = s.nextDouble();

        double volumen = 0.33*3.14*(radio*radio)*altura;

        System.out.println("El volumen del cono será de: " + volumen);
    }
}