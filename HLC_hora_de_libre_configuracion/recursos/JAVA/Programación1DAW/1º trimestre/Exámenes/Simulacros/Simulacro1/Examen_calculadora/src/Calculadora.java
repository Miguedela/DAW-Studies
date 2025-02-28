import java.util.Scanner;
public class Calculadora {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int opc;

        double num1 = 0;
        double num2 = 0;

        do {

            System.out.println("MENÚ DE CALCULADORA EN JAVA");
            System.out.println("1. SUMA");
            System.out.println("2. RESTA");
            System.out.println("3. MULTIPLICACIÓN");
            System.out.println("4. DIVISIÓN");
            System.out.println("5. RESTO");
            System.out.println("6. SALIR");
            System.out.print("Elige una de las siguientes opciones: ");
            opc = s.nextInt();

            //SUMA
            if (opc == 1) {
                System.out.print("Escribe el primer número: ");
                num1 = s.nextDouble();
                System.out.print("Escribe el segundo número: ");
                num2 = s.nextDouble();
                double sum = num1 + num2;
                System.out.printf("El resultado es: %.2f\n", sum);
                //RESTA
            } else if (opc == 2) {
                System.out.print("Escribe el primer número: ");
                num1 = s.nextDouble();
                System.out.print("Escribe el segundo número: ");
                num2 = s.nextDouble();
                double rest = num1 - num2;
                System.out.printf("El resultado es: %.2f\n", rest);
                //MULTIPLICACIÓN
            } else if (opc == 3) {
                System.out.print("Escribe el primer número: ");
                num1 = s.nextDouble();
                System.out.print("Escribe el segundo número: ");
                num2 = s.nextDouble();
                double mult = num1 * num2;
                System.out.printf("El resultado es: %.2f\n", mult);
                //DIVISIÓN
            } else if (opc == 4) {
                System.out.print("Escribe el primer número: ");
                num1 = s.nextDouble();
                System.out.print("Escribe el segundo número: ");
                num2 = s.nextDouble();
                double div = num1 / num2;
                if (num2 == 0) {
                    System.out.println("No se puede dividir entre 0\n");
                } else {
                    System.out.printf("El resultado es: %.2f\n", div);
                }
                //RESTO
            } else if (opc == 5) {
                System.out.print("Escribe el primer número: ");
                num1 = s.nextDouble();
                System.out.print("Escribe el segundo número: ");
                num2 = s.nextDouble();
                double sum = (num1 / 5) + (num2 * 2);
                System.out.printf("El resultado es: %.2f\n", sum);
            }
        } while (opc != 6);
    }
}