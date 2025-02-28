import java.util.Map;
import java.util.Scanner;

public class Ejercicio7_4_8 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int grados[] = new int[12];
        int ano;
        String meses[] = {"Enero","Febrero","Marzo","Abrl","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};

        System.out.print("¿De qué año desea ingresar las temperaturas medias?: ");
        ano = s.nextInt();

        for (int i = 0; i < 12; i++) {
            System.out.print("Ingresa la temperatura media que hizo en el mes de " + meses[i] + ": ");
            grados[i] =  s.nextInt();
        }

        System.out.println();

        for (int x = 0; x < 12; x++) {
            if(x == 0) {
                System.out.println("En el año " + ano + ", hizo una media de ºC mensuales de: ");
                System.out.println();
            }
            for (int y = 0; y < 1; y++) {
                if (x == 8 || x == 10 || x == 11) {
                    System.out.print(meses[x] + "\t\t");
                } else {
                    System.out.print(meses[x] + "\t\t\t");
                }
                for (int i = 0; i < grados[x]; i++) {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }
}