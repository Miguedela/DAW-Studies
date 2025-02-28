public class Coche {
    //Creo las variables
    private String marca;
    private String modelo;

    //Metodo Constructor
    public Coche(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    public void arranca() {
        System.out.println("El coche: " + marca + " " + modelo + " esta arrancado.");
    }
}
