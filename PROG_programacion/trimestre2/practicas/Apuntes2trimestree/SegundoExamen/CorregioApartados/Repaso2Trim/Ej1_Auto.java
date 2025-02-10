package SegundoExamen.CorregioApartados.Repaso2Trim;

public class Ej1_Auto {
    // Atributos
    private String marca;
    private String modelo;
    private int año;

    // Constructor
    public Ej1_Auto(String marca, String modelo, int año) {
        this.marca = marca;
        this.modelo = modelo;
        this.año = año;
    }

    // Métodos para obtener los valores de los atributos
    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAño() {
        return año;
    }

    // Métodos para establecer los valores de los atributos
    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setAño(int año) {
        this.año = año;
    }

    // Método para mostrar la información completa del auto
    public void mostrarInfo() {
        System.out.println("Marca: " + marca + ", Modelo: " + modelo + ", Año: " + año);
    }

    // Método principal para probar la clase
    public static void main(String[] args) {
        Ej1_Auto miAuto = new Ej1_Auto("Toyota", "Corolla", 2020);
        miAuto.mostrarInfo();
    }
}
