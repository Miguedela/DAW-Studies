import java.util.Scanner;
public class Main {
        public static void main(String[] args) {
            Scanner s = new Scanner(System.in);
            //Doy un valor a el dinero(en este caso euros)
            System.out.print("Introduce las pesetas a convertir: ");
            double dinero = s.nextDouble();
            //Realizo el calculo de conversión
            double conversor = dinero / 166.386;
            //Pido que me lo muestre por pantalla
            System.out.println("TIenes %.2f "+conversor);
    }
}