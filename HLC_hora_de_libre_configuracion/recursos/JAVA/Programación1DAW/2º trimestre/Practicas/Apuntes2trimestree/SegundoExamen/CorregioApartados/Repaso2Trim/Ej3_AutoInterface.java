package SegundoExamen.CorregioApartados.Repaso2Trim;

interface Ej3_Vehiculo {
    // Método para acelerar
    void acelerar(int incremento);

    // Método para frenar
    void frenar(int decremento);
}

public class Ej3_AutoInterface implements Ej3_Vehiculo {
    // Atributos
    private String marca;
    private String modelo;
    private int año;
    private int velocidad; // Atributo adicional para gestionar la velocidad

    // Constructor
    public Ej3_AutoInterface(String marca, String modelo, int año) {
        this.marca = marca;
        this.modelo = modelo;
        this.año = año;
        this.velocidad = 0; // La velocidad inicial es 0
    }

    // Métodos getter y setter para marca, modelo y año
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    // Método para mostrar la información del auto
    public void mostrarInfo() {
        System.out.println(
                "Marca: " + marca + ", Modelo: " + modelo + ", Año: " + año + ", Velocidad: " + velocidad + " km/h");
    }

    // Implementación de los métodos de la interfaz Vehiculo
    @Override
    public void acelerar(int incremento) {
        velocidad += incremento;
        System.out.println("Acelerando. Velocidad actual: " + velocidad + " km/h.");
    }

    @Override
    public void frenar(int decremento) {
        velocidad -= decremento;
        System.out.println("Frenando. Velocidad actual: " + velocidad + " km/h.");
    }

    // Método principal para probar la clase
    public static void main(String[] args) {
        Ej3_AutoInterface miAuto = new Ej3_AutoInterface("Toyota", "Corolla", 2020);
        miAuto.acelerar(50);
        miAuto.frenar(20);
        miAuto.mostrarInfo();
    }
}
