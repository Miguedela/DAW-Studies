import java.util.Scanner;

public class EjercicioMatricesD {
    public static void mostrarMatriz(int matriz[]) {
        for (int i = 0; i < matriz.length; i++) {
            System.out.print(matriz[i] + ", ");
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int[] tabla = new int[10];
        int nUsuario = 0;

        for (int i = 0; i < 5; i++) {
            if (i == 0) {
                System.out.println("Introduce un número");
                nUsuario = s.nextInt();
                tabla[i] = nUsuario;
            } else {
                System.out.println("Introduce un número más grande que el anterior.");
                nUsuario = s.nextInt();
                while (nUsuario <= tabla[i - 1]) {
                    System.out.println("Recuerda que tu número anterior era " + tabla[i - 1]
                            + ", por favor introduce un número más grande.");
                    nUsuario = s.nextInt();
                }
                tabla[i] = nUsuario;
            }
        }

        System.out.println("Matriz inicial");
        mostrarMatriz(tabla);
        System.out.println();

        System.out.print("Introduce un número: ");
        nUsuario = s.nextInt();

        s.close();

        int posicionInsercion = 5;
        for (int i = 0; i < 5; i++) {
            if (nUsuario < tabla[i]) {
                posicionInsercion = i;
                break;
            }
        }

        for (int i = 9; i > posicionInsercion; i--) {
            tabla[i] = tabla[i - 1];
        }
        
        System.out.println("Matriz antes de insertar el número:");
        mostrarMatriz(tabla);

        tabla[posicionInsercion] = nUsuario;

        System.out.println("Matriz después de insertar el número:");
        mostrarMatriz(tabla);
    }
}
