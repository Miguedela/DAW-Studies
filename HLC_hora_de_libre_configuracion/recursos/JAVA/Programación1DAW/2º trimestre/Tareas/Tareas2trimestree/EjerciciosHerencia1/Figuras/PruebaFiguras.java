package EjerciciosHerencia1.Figuras;

public class PruebaFiguras {
    public static void main(String[] args) {
        Rectangulo rectangulo1 = new Rectangulo(0, 5, 6);
        Circulo circulo1 = new Circulo(4.6);

        System.out.println(rectangulo1.calcularArea());
        System.out.println(rectangulo1.calcularPerimetro());
        System.out.println(circulo1.calcularArea());
        System.out.println(circulo1.calcularPerimetro());
    }
}
