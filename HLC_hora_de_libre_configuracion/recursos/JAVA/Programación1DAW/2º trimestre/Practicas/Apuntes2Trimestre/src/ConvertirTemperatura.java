//Importo las utilidades

import java.util.Scanner;
import java.util.InputMismatchException;

public class ConvertirTemperatura {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        while (true) {
            menu();

            //Iniciamos el try(que maneja las excepciones durante la entrada de datos)
            try {
                int opc = s.nextInt();
                switch (opc) {
                    case 1:
                        C2F(s);
                        break;
                    case 2:
                        F2C(s);
                        break;
                    case 3:
                        System.out.println("¡¡Gracias por utilizar mi convertidor de grados!!");
                        s.close();
                        System.exit(0);
                    default:
                        System.out.println("Opción no valida, ¡¡LEÉ BIEN!!");
                }
            } catch (InputMismatchException e) {
                System.out.print("Introduce un número entero:");
                s.nextLine();
            }
        }
    }

    //Creo el metodo del menu
    private static void menu() {
        System.out.println("----CONVERTIDOR DE TEMPERTAURAS----");
        System.out.println("       1) De Cº a Fº               ");
        System.out.println("       2) De Fº a Cº               ");
        System.out.println("       3) Salir                    ");
        System.out.print("Elija una opción (1, 3): ");
    }

    //Creo el metodo de C2F
    private static void C2F(Scanner s) {
        while (true) {
            try {
                System.out.print("Introduce los grados celcius: ");
                double celcius = s.nextDouble();
                double farenheit = (celcius * 9 / 5) + 32;
                System.out.println("La temperatura convertida de 'celcius' " + celcius + "Cº" + " a 'farenheit' es de: " + farenheit + "Fº");
                break;
            } catch (InputMismatchException e) {
                System.out.println("Introduce nuevamente los grados: ");
                s.nextLine();
            }
        }
    }

    //Creo el metodo de F2C
    private static void F2C(Scanner s) {
        try {
            while (true) {
                try {
                    System.out.print("Introduce los grados farenheit: ");
                    double farenheit = s.nextDouble();
                    double celcius = (farenheit - 32) * 5 / 9;
                    System.out.println("La temperatura convertida de 'farenheit' " + farenheit + "Fº" + " a 'celcius' es de: " + celcius + "Cº");
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Introduce nuevamente los grados: ");
                    s.nextLine();
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Introduce nuevamente los grados: ");
            s.nextLine();
        }
    }
}
