public class Main {
    public static void main(String[] args) {
        //Doy un valor a el dinero(en este caso pesetas)
        double dinero = 20000;
        //Realizo el calculo de conversión
        double conversor = dinero / 166.386;
        //Pido que me lo muestre por pantalla
        System.out.printf("Tendriamos: %.2f ",conversor);
    }
}