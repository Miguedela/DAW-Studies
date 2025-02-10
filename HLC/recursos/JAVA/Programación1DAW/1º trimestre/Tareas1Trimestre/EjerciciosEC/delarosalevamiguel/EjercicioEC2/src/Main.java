import java.util.Scanner;
public class Main {
    /*2. Ejercicio de switch-case:
    Crea un programa que solicite al usuario un día de la semana (1-7) y muestre el nombre
    del día correspondiente utilizando un switch-case.*/
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Introduce el número del día: ");
        int dia = s.nextInt();

        switch (dia) {
            case 1:
                System.out.println("Lunes");
                break;
            case 2:
                System.out.println("Martes");
                break;
            case 3:
                System.out.println("Miércoles");
                break;
            case 4:
                System.out.println("Jueves");
                break;
            case 5:
                System.out.println("Viernes");
                break;
            case 6:
                System.out.println("Sábado");
                break;
            case 7:
                System.out.println("Domingo");
                break;
            default:
                System.out.println("No existe ningún número que corresponda a ese día.");
                break;
        }
    }
}