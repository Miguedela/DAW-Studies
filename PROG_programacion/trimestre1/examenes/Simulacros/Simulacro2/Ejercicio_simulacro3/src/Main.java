import  java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("¿Cuántas entradas infantiles vas a querer?: ");
        int nentradai = s.nextInt();

        System.out.print("¿Cuántas entradas adultas vas a querer?: ");
        int nentradaa = s.nextInt();

        double precioi = nentradai * 15.50;
        double precioa = nentradaa * 20.00;

        System.out.printf("El precio es de las entradas infantiles es de: %.2f\n", precioi);

        System.out.printf("El precio es de: %.2f\n", precioa);

        double preciotot = precioa + precioi;

        if (preciotot > 100) {
            double preciototde = preciotot - (preciotot * 0.05);
            System.out.println("Debido a que el total de las entradas es superior a 100, se le aplicara un bono del 5% de descuento");
            System.out.printf("Precio anterior: %.2f\n", preciotot);
            System.out.printf("Precio con el 5 de descuento: %.2f\n", preciototde);
        } else {
            System.out.printf("Precio de todas las entradas: %.2f\n", preciotot);
        }
    }
}