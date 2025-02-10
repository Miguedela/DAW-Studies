import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Introduzca la base imponible: ");
        double precio = s.nextDouble();

        //Codigo para consumir el resto de linea usada por Double
        s.nextLine();

        System.out.print("Introduzca el tipo de IVA (general, reducido o superreducido): ");
        String tipoiva = s.nextLine();
        System.out.print("Introduzca el código promocional (nopro, mitad, meno5 o 5porc): ");
        String codprom = s.nextLine();

        //Iniciadores
        double iva = 0;
        double desc = 0;

        //Calculo iva
        if (tipoiva.equals("general")){
            iva = 0.21;
        } else if (tipoiva.equals("reducido")){
            iva = 0.10;
        } else if (tipoiva.equals("superredicido")){
            iva = 0.04;
        } else {
            System.out.println("Esa elección no existe");
        }

        //Calculo código promocional

        if (codprom.equals("nopro")){
            desc = 0.0;
        } else if (codprom.equals("mitad")){
            desc = 0.5;
        } else if (codprom.equals("meno5")){
            desc = 0.05;
        } else {
            System.out.println("Esa elección no existe");
        }

        double piva = precio * iva;
        double preciva = precio * (1 + iva);

        double prom = precio * desc;

        double precfin = preciva - prom;

        System.out.println("El IVA es de: " + piva + "€");
        System.out.println("El precio con IVA es de: " + preciva + "€");
        System.out.println("El código promocional tiene un descuento de: -" + prom + "€");
        System.out.println("El precio final sera: " + precfin + "€");


    }
}