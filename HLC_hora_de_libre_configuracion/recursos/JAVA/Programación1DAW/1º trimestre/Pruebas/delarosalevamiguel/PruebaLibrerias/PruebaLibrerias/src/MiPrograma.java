import libreria.MetodosImpares;
import java.util.Scanner; // importo la variable Scanner
public class MiPrograma {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int opc = 0;
        int num1 = 0;
        int num2 = 0;

        MetodosImpares.menu(opc);
        opc = s.nextInt();

        if (opc == 1) {
            System.out.print("Ingresa el numero: ");
            num1 = s.nextInt();
            // Metodo 1
            System.out.println(MetodosImpares.esCapicua(num1));
        } else if (opc == 3) {
            System.out.print("Ingresa el numero: ");
            num1 = s.nextInt();
            // Metodo 3
            System.out.println(MetodosImpares.esPrimo(num1) - 1);
        } else if (opc == 5) {
            System.out.print("Ingresa el numero: ");
            num1 = s.nextInt();
            // Metodo 5
            System.out.println(MetodosImpares.digitos(num1));
        } else if (opc == 7) {
            System.out.print("Ingresa el numero: ");
            num1 = s.nextInt();
            System.out.print("Ingresa hasta que posicion desea ir: ");
            num2 = s.nextInt();
            // Metodo 7
            System.out.println(MetodosImpares.digitoN(num1, num2));
        } else if (opc == 9) {
            System.out.print("Ingresa el numero: ");
            num1 = s.nextInt();
            System.out.print("Ingresa el digito que desea quitar al final del número: ");
            num2 = s.nextInt();
            // Metodo 9
            System.out.println(MetodosImpares.quitaPorDetras(num1, num2));
        } else if (opc == 11) {
            System.out.print("Ingresa el numero: ");
            num1 = s.nextInt();
            System.out.print("Ingresa el digito que desea incluir al final del número: ");
            num2 = s.nextInt();
            // Metodo 11
            System.out.println(MetodosImpares.pegaPorDetras(num1, num2));
        } else if (opc == 13) {
            System.out.print("Ingresa el numero: ");
            num1 = s.nextInt();
            // Metodo 13

        }

    }
}