package SegundoExamen;

// Ejercicio 1: Diseña una clase llamada Auto que contenga atributos como marca, modelo, y año.
// Incluye métodos para obtener y establecer el valor de cada atributo
// Además de un método que muestre la información completa del auto.

// Clase ejercicio1 (auto)
public class Ejercicio1_Auto {
    // Atributos
    private String marca;
    private String modelo;
    private int ano;

    // Metodo constructor
    public Ejercicio1_Auto(String marca, String modelo, int ano) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
    }

    // Getters and setters
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

    public int getAno() {
        return ano;
    }

    public void setAno(int año) {
        this.ano = año;
    }

    // Metodo toString
    @Override
    public String toString() {
        return "Marca: " + marca + "\nModelo: " + modelo + "\nAño de fabricación: " + ano;
    }
}
