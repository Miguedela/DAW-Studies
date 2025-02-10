import java.util.Scanner;
public class Main {
    /*4. Ejercicio de while:
    Pide al usuario que adivine un número entre 1 y 100. Muestra si la adivinanza es
    demasiado alta o demasiado baja, y continúa pidiendo al usuario que adivine hasta que lo
    adivine correctamente.*/
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int num = 0;

        do {
            System.out.print("Intenta adivinar mi número (1-100): ");
            num = s.nextInt();
            if ((num > 100 ) || (num < 1))
                System.out.println("Número no valido");
        } while (num > 100 || num < 1);
        while (num!=33) {
            System.out.println("Vuelve a intentarlo: ");
            if (num > 33) {
                System.out.println("Demasiado alto");
                num = s.nextInt();
            } else if (num < 33) {
                System.out.println("Demasiado bajo");
                num = s.nextInt();
            }
        }
        System.out.println("¡¡¡Enhorabuena!!!");
    }
}