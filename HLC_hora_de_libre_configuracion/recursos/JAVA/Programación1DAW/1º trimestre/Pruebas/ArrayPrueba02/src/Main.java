import java.util.Scanner; //Importo la utilidad de Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in); //Creo la variable Scanner;

        System.out.print("¿Cuántas letras vas a querer introducir?: ");
        int nletras = s.nextInt();

        String[] letras = new String[nletras]; //Inicio el array
        int i;


        for (i = 0; i < letras.length; i++) {
            System.out.print("Introduce la " + (i+1) + "º letra: ");
            letras[i] = s.next();
        }

        for (i = 0; i < letras.length; i++) {
            System.out.println("Introduce la " + (i+1) + "º letra es: " + letras[i]);
        }
    }
}