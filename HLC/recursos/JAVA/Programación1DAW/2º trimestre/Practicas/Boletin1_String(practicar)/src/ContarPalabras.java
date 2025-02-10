import java.util.Scanner;

public class ContarPalabras {
    //Contar cuantas palabras tiene una frase teniendo en cuenta que debe acabar por un "."
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Deme una frase y le contare cuantas palabras tiene (es importante que acabe en . matao)");
        String frase = s.nextLine();

        int palabras = contarPalabras(frase);
        System.out.println("La frase tiene un total de " + palabras + " palabras");
    }

    public static int contarPalabras(String mullao) {
        if (!mullao.endsWith(".")) {
            System.out.println("La frase no tiene las caracteristicas necesarias (.)");
            return -1;
        }
        mullao = mullao.substring(0, (mullao.length() - 1));

        String[] locura = mullao.split(" "); //split = dividir (el ingles se enseña mal)
        return locura.length;
    }
}