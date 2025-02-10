
package SegundoExamen.CorregioApartados.Repaso2Trim;

// Ejercicio 7: Modifica la clase Auto para incluir una propiedad estática llamada cantidadAutos, la
// cual llevará la cuenta del número total de instancias creadas de la clase Auto. Añade un método
// estático getCantidadAutos() que permita acceder al valor de cantidadAutos. Asegúrate de
// incrementar cantidadAutos cada vez que se cree un nuevo Auto.

public class Ej7_Auto {
    private String marca;
    private String modelo;
    private int año;
    private static int cantidadAutos = 0; // Propiedad estática para contar las instancias de Auto

    // Constructor
    public Ej7_Auto(String marca, String modelo, int año) {
        this.marca = marca;
        this.modelo = modelo;
        this.año = año;
        cantidadAutos++; // Incrementar el contador estático cada vez que se crea un Auto
    }

    // Métodos getter y setter
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

    // Método estático para obtener la cantidad de Autos creados
    public static int getCantidadAutos() {
        return cantidadAutos;
    }

    // Método para mostrar la información del auto
    public void mostrarInfo() {
        System.out.println("Marca: " + marca + ", Modelo: " + modelo + ", Año: " + año);
    }

    // Método principal para probar la clase
    public static void main(String[] args) {
        Ej7_Auto auto1 = new Ej7_Auto("Toyota", "Corolla", 2020);
        Ej7_Auto auto2 = new Ej7_Auto("Honda", "Civic", 2018);

        System.out.println("Información de auto1:");
        auto1.mostrarInfo();

        System.out.println("Información de auto2:");
        auto2.mostrarInfo();

        System.out.println("Cantidad total de autos: " + getCantidadAutos());
    }
}
