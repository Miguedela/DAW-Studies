import java.util.Scanner;

public class EjercicioFuncionesA {
    /*
     * a) Función a la que se le pasan dos enteros y muestra todos los números
     * comprendidos entre ellos, ambos incluidos. (Ten en cuenta que el usuario
     * puede poner el valor más pequeño en el 1º número o en el 2º número).
     */
    public static void encontrarNumero(int a, int b) {
        int n1 = 0;
        int n2 = 0;

        if (a <= b) {
            n1 = a;
            n2 = b;
        } else {
            n2 = a;
            n1 = b;
        }

        for (int i = n1; i <= n2; i++) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Introduce dos números");
        int a = s.nextInt();
        int b = s.nextInt();
        s.close();

        encontrarNumero(a, b);
    }
}
