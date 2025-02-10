//He importado la utilidad "Scanner"
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        //Para llamar a "Scanner" le he asignado la variable s
        Scanner s = new Scanner(System.in);
        //Pido por pantalla que me diga la primera nota
        System.out.print("Introduzca la primera nota: ");
        int n1 = s.nextInt();
        //Pido por pantalla que me diga la segunda nota
        System.out.print("Introduzca la segunda nota: ");
        int n2 = s.nextInt();
        //Pido por pantalla que me diga la tercera nota
        System.out.print("Introduzca la tercera nota: ");
        int n3 = s.nextInt();

        //Realizo el calculo de la media arismetica
        double ma = (n1+n2+n3)/3;

        //Muestro por pantalla la media arismetica
        System.out.print("La media arismetica es: "+ma);
    }
}