import java.util.Scanner; // importo la clase Scanner
public class Capicua {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in); // creo la variable Scanner

        System.out.print("Introduzca el número: ");
        int num = s.nextInt();

        if (esCapicua(num)) {
            System.out.println(num + " es capicúa.");
        } else {
            System.out.println(num + " no es capicúa.");
        }
    }

    static boolean esCapicua(int numero) {
        String candenaNum = Integer.toString(numero);

        int i = 0;
        int j = candenaNum.length() -1;

        while (i < j) {
            if (candenaNum.charAt(i) != candenaNum.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}