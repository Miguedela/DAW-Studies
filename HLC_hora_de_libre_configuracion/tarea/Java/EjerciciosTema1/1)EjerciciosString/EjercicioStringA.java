import java.util.Scanner;

public class EjercicioStringA {
    /*
     * a) Crea una función que reciba dos cadenas como parámetro (str1, str2) e
     * imprima otras dos cadenas como salida (out1, out2).
     */

    public static void caracteresRepetidos(String str1, String str2) {
        String out1 = "";
        String out2 = "";

        // Bucle para rellenar out1
        for (char a : str1.toCharArray()) {
            boolean contener = false;
            for (char b : str2.toCharArray()) {
                if (a == b) {
                    contener = true;
                }
            }
            if (!contener) {
                out1 = out1 + a;
            }
        }

        // Bucle para rellenar out2
        for (char b : str2.toCharArray()) {
            Boolean contener = false;
            for (char a : str1.toCharArray()) {
                if (b == a) {
                    contener = true;
                }
            }
            if (!contener) {
                out2 = out2 + b;
            }
        }

        // Mostrar por pantalla los dos out
        System.out.println("out1: " + out1);
        System.out.println("out2: " + out2);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Introduce una cadena caracteres: ");
        String str1 = s.nextLine();
        System.out.print("Introduce una cadena caracteres: ");
        String str2 = s.nextLine();
        s.close();

        caracteresRepetidos(str1, str2);
    }
}
