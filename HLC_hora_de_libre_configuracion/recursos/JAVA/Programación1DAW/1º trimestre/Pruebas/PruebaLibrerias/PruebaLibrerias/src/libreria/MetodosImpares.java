package libreria;
import java.util.Scanner; // importo la utilidad de Scanner
public class MetodosImpares {

    // Metodo menu
    public static void menu(int opc) {
        Scanner s = new Scanner(System.in); // creo un objeto Scanner

        System.out.println("Elige una opción");
        System.out.println("1. Capicúa");
        System.out.println("3. Siguiente Primo");
        System.out.println("5. Cantidad de digitos");
        System.out.println("7. Enseñar cantidad de digitos");
        System.out.println("9. Eliminar cantidad de digitos");
        System.out.println("11. Incluir un digito por detras");
        System.out.println("13. Devolver el fragmento de un numero");
        System.out.print("Ingresa una opción: ");
    }

    // Metodo 1 (capicúa)
     public static String esCapicua(int numero) {
         String candenaNum = Integer.toString(numero);

         int i = 0;
         int j = candenaNum.length() -1;

         while (i < j) {
            if (candenaNum.charAt(i) != candenaNum.charAt(j)) {
                return numero + " no es capicúa.";
            }
            i++;
            j--;
         }
         return numero + " es capicúa.";
    }

    // Metodo 3 (siguiente primo)
    public static int esPrimo(int numero) {
         boolean auxiliar;

        do {
            auxiliar = true;
            numero++;

            for (int i = 2; i <= Math.sqrt(numero); i++) {
                if (numero % i == 0) {
                    auxiliar = false;
                }
            }
        } while (auxiliar == true);

        return numero;
    }

    // Metodo 5 (sumar un digito)
    public static int digitos(int numero) {
        int numeroDeDigitos = 0;

        while (numero>0) {
            numero = numero / 10;
            numeroDeDigitos++;
        }
        return numeroDeDigitos;
    }

    // Metodo 7 (sumar un digito) falta corregir
    public static int digitoN(int numero1, int numero2) {
        int i = 1;

        while (i<=numero2) {
            i++;
            numero1 = numero1 / 10;
        }
        return numero1;
    }

    // Metodo 9 (sumar un digito)
    public static int quitaPorDetras(int numero1, int numero2) {
        int i = 1;

        while (i<=numero2) {
            i++;
            numero1 = numero1 / 10;
        }
        return numero1;
    }

    // Metodo 11 (sumar un digito)
    public static int pegaPorDetras(int numero1, int numero2) {
        numero1 = (numero1 * 10) + numero2;
        return numero1;
    }

    // Metodo 13 (sumar un digito)
    /*public static int trozoDeNumero(int numero1, int numero2) {

    }*/
}
