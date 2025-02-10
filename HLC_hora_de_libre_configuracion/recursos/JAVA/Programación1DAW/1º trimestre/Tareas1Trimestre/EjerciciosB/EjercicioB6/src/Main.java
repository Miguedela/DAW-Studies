import java.util.Scanner; //Importo la utilidad de Scanner
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in); //Creo la variable de Scanner

        int suma = 0; //Inicio la variable

        //Introducir por pantalla la altura de la escalera
        System.out.print("¿De qué altura desea la escalera?: ");
        int rep = s.nextInt();

        //for que se encarga de crear la escalera
        for (int i = 1; i <= rep; i++) {

            suma = 0; //Reestablezco el valor de suma a 0

            //for que se encarga de crear la suma de los numeros segun las veces que se rehaga el bucle
            for (int x = 1; x <= i; x++) {
                System.out.print(suma = suma + 1);
            }

            //print encargado de dar salto de linea
            System.out.println();
        }
    }
}