import java.util.Random;
public class NumerosAleatorios {
    public static void main(String[] args) {
        Random r = new Random();
        int numero = 0;

        for (int i = 0; i < 21; i++) {
            numero = r.nextInt(50-(-25)+1)+(-25); //Numeros random desde 50 hasta -25
            System.out.println(numero);
        }
    }
}