public class Computadora {
    //Creo las variables
    private String marca;
    private String modelo;

    //Metodo Constructor
    public Computadora(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    public void endender() {
        System.out.println("La computadora: " + marca + " " + modelo + " esta encendida.");
    }
}
