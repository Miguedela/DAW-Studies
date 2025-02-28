import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Introduce los Kb a convertir: ");
        double kb = s.nextDouble();

        double conv = kb / 1024;

        System.out.println("Tendríamos la cantidad de: " + conv + " Mb.");
    }
}