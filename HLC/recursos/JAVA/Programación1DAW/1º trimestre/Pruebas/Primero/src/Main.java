import javax.crypto.spec.PSource;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String name;
        int edad;
        
        System.out.println("Buenas bienvenido a tu presentación");
        System.out.print("Para empezar facilitame tu nombre: ");
        name = sc.nextLine();
        System.out.print("¿Que edad tienes?: ");
        edad = sc.nextInt();

        System.out.println(name + " nacio en el año " + (2023-edad));

    }
}