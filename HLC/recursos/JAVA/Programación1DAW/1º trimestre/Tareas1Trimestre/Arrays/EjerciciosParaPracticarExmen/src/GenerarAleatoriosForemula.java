import java.util.Random;

public class GenerarAleatoriosForemula {
    public static void main(String[] args) {
        Random r = new Random();

        int[] numero = new int[20];

        for (int i = 0; i < numero.length; i++) {
            numero[i] = r.nextInt(80 - (-30) + 1) + (-30);
            numero[i] = r.nextInt(-1,1+1);
            System.out.print(numero[i] + "  ");
        }
    }
}
