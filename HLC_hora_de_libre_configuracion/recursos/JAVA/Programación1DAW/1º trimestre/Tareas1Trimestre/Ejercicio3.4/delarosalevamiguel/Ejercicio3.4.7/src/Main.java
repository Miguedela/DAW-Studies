import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Introduce el precio: ");
        double precb = s.nextDouble();

        double precf = precb * 1.21;
        double iva = precb * 0.21;

        System.out.println("El precio total es de: " + precf);
        System.out.println("EL IVA es de: " + iva);
    }
}