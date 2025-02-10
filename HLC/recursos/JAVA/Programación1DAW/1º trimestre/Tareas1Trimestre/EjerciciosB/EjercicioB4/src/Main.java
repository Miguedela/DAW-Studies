import java.util.Scanner; //Importo la utilidad de Scanner
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in); //Creo la variable de Scanner

        //Introducir por pantalla la altura de la escalera
        System.out.print("¿De qué altura desea la escalera?: ");
        int rep = s.nextInt();

        //for que se encarga de crear la escalera
        for (int i = 1; i <= rep; i++) {

            //for que se encarga de crear los asteriscos
            for (int x = 1; x <= i; x++) {
                System.out.print("*");
            }
            //print encargado de dar salto de linea
            System.out.println();
        }
    }
}