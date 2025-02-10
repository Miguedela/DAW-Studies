import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int salario = 12;
        System.out.print("Introduce las horas que ha trabajado en la semana este trabajador: ");
        double hortra = s.nextDouble();

        double salariosem = salario * hortra;

        System.out.println("El trabajador ha recibido: " + salariosem + "€, debido a que esta semana ha trabajado: " + hortra + " horas");
    }
}