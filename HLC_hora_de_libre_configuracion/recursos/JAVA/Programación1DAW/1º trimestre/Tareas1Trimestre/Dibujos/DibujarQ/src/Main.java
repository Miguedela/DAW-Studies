import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int altura = 0;

        System.out.print("Introduzca la altura deseada en la letra T: ");
        altura = s.nextInt();

        for (int y = 1; y <= altura; y++) {

            for (int x = 1; x <= altura; x++) {

                if (y == 1 && x > 2 && x < altura-1 || y == 2 && x == 2 || x == altura-1 && y == 2 ||  x == 1 && y > 2 && y < altura -1 ||  x == altura && y > 2 && y < altura -1 || y == altura && x > 2 && x < altura-1 || y == altura - 1 && x == 2 || y == altura && x == altura || y == altura-1 && x == altura-1 || y == altura-2 && x == altura-2) {
                    System.out.print("*");
                } else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}