import java.util.Scanner;

public class EjercicioFuncionesD {
    /* d) Crea una aplicación que muestre en binario un número entre 0 y 255. */
    public static void pasarABinario(int a) {
        if (a < 0 || a > 255) {
            System.out.println("Número no valido");
        } else {
            String binario = "";
            while (a > 0) {
                int residuo = a % 2;
                binario = residuo + binario;

                a = a / 2; // actualizo el valor de a
            }

            System.out.println(binario);
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Introduce el número a traducir: ");
        int a = s.nextInt();
        s.close();

        pasarABinario(a);
    }
}
