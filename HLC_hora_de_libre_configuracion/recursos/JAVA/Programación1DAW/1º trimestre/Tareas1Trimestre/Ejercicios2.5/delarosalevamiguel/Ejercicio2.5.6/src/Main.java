public class Main {
    public static void main(String[] args) {
        //Le doy valor al objeto (sin IVA)
        double precio = 30;
        //Realizo la operación para sumarle al objeto el IVA (21%)
        double IVA = precio * 1.21;
        //Pido que me muestre por pantalla el resultado
        System.out.println("El precio con el IVA, es de: "+IVA+" euros.");
    }
}