import java.util.Scanner; // importo la clase Scanner
public class Potencias {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in); // creo la variable Scanner

        System.out.print("Introduzca la base: ");
        int base = s.nextInt();
        System.out.print("Introduzca el exponente: ");
        int exponente = s.nextInt();

        System.out.println(base + "^" + exponente + " = " + potencia(base, exponente));
    }

    static int potencia(int base, int exponente) {
        int potenciar = base;

        for (int i = 1; i < exponente; i++) {
            potenciar = potenciar * base;
        }
        return potenciar;
    }
}