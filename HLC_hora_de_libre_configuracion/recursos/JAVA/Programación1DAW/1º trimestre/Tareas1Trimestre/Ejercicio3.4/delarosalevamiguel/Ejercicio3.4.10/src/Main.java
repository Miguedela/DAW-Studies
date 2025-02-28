import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Introduce los Mb a convertir: ");
        double mb = s.nextDouble();

        double conv = mb * 1024;

        System.out.println("Tendríamos la cantidad de: " + conv + " Kb.");
    }
}