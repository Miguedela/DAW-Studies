import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        //Variables
        double nota1 = 0;
        double nota2 = 0;
        double media = 0;
        //Entradad de datos
        System.out.print("Introduce la nota de tu primer exámen: ");
        nota1 = s.nextDouble();
        System.out.print("Introduce la media que quieres tener en el trimestre: ");
        media = s.nextDouble();
        //Calculo
        nota2 = (media - nota1*0.4)/0.6;
        //Salida por pantalla
        System.out.printf("Para sacar una media de " + media + "necesitas sacar en el segundo exámen una nota de: %.2f", nota2);
    }
}