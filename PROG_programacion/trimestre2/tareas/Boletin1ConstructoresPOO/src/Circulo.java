public class Circulo {
    //Creo las variables
    private int radio;

    //Metodo Constructor
    public Circulo(int radio) {
        this.radio = radio;
    }

    public void calcularArea() {
        double areaCirculo = ((radio*radio)*3.14);
        System.out.println("El area del circulo es: " + areaCirculo);
    }
}
