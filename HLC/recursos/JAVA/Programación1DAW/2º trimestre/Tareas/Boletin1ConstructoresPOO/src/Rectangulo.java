public class Rectangulo {
    //Creo las variables
    private int ancho;
    private int alto;

    //Metodo Constructor
    public Rectangulo(int ancho, int alto) {
        this.ancho = ancho;
        this.alto = alto;
    }

    public void calcularArea() {
        int areaRectangulo = (ancho * alto);
        System.out.println("El area del rectangulo es: " + areaRectangulo);
    }
}
