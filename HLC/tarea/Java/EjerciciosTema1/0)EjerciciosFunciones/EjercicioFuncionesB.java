import java.util.Scanner;

public class EjercicioFuncionesB {
    /*
     * b) Escriba una función que sume los n primeros números impares de un valor
     * elegido por el usuario
     */
    public static void sumarImpares(int a) {
        int sumaTotal = 0;

        for (int i = 1; i <= a; i++) {
            if (i % 2 != 0) {
                sumaTotal += i;
            }
        }

        System.out.println(sumaTotal);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Introduce un número");
        int a = s.nextInt();
        s.close();

        sumarImpares(a);
    }
}
