//Importo la utilidad de Scanner
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        //Declaro la variable "Scanner" como s
        Scanner s = new Scanner(System.in);
        //Pido por pantalla que se me diga la edad del usuario
        System.out.print("Introduce la edad del usuario: ");
        int edad = s.nextInt();
        //Le sumo 1 a la edad actual del usuario (edad que tendra el próximo año)
        int epa = edad+1;
        //Muestro por pantalla la edad que tendra el próximo año
        System.out.print("La edad que tendra el usuario en el proximo año sera: " + epa);
    }
}