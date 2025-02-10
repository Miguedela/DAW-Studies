public class FormatoNumeroIncorrecto {
    public static void main(String[] args) {
        try {
            int numero = Integer.parseInt("CYZ");
            System.out.println(numero);
        } catch (NumberFormatException e) {
            System.out.println("Formato de número incorrecto: " + e.getMessage());
        }
    }
}